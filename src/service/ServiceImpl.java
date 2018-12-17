package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import po.Card;
import po.History;
import dao.CardDao;
import dao.HistoryDao;
import exception.MyException;

public class ServiceImpl implements Service
{
	public static final int PAGESIZE = 5;
	private CardDao cardDao;
	private HistoryDao historyDao;
	public CardDao getCardDao()
	{
		return cardDao;
	}

	public void setCardDao(CardDao cardDao)
	{
		this.cardDao = cardDao;
	}

	public HistoryDao getHistoryDao()
	{
		return historyDao;
	}

	public void setHistoryDao(HistoryDao historyDao)
	{
		this.historyDao = historyDao;
	}

	@Override
	public int adminLogin(String username, String password) throws MyException
	{
		try
		{
			if(username == null || username.equals("") || password == null || password.equals(""))
				return 0;
			if(username.equals("admin") && password.equals("123456"))
				return 1;
			return 0;
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new MyException("管理员登陆出错");
		}
	}

	@Override
	public int studentLogin(String number, String password) throws MyException
	{
		try
		{
			if(number == null || number.equals(""))
				return 0;
			if(!cardDao.get(number).getPassword().equals(password))
				return 0;
			return 1;
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new MyException("学生登陆出错");
		}
	}

	@Override
	public Card getCardByNumber(String number) throws MyException
	{
		try
		{
			if(number == null || number.equals(""))
				return null;
			Card card = cardDao.get(number);
			return card;
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new MyException("通过卡号获取卡失败");
		}
	}

	@Override
	public int createCard(Card card) throws MyException
	{
		try
		{
			if(getCardByNumber(card.getNumber()) != null)
				return 0;
			card.setIslock("false");
			card.setPassword("123456");
			card.setMoney(0);
			cardDao.save(card);
			return 1;
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new MyException("创建卡失败");
		}
	}

	@Override
	public int lock(String number) throws MyException
	{
		try
		{
			Card card = getCardByNumber(number);
			if(card == null)
				return 0;
			card.setIslock("true");
			cardDao.update(card);
			return 1;
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new MyException("锁卡失败");
		}
	}

	@Override
	public int unlock(String number) throws MyException
	{
		try
		{
			Card card = getCardByNumber(number);
			if(card == null)
				return 0;
			card.setIslock("false");
			cardDao.update(card);
			return 1;
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new MyException("解锁失败");
		}
	}

	@Override
	public int deleteCard(String number) throws MyException
	{
		try
		{
			Card card = getCardByNumber(number);
			if(card == null)
				return 0;
			cardDao.delete(card);
			historyDao.delete(card.getNumber());
			return 1;
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new MyException("删除卡失败");
		}
	}

	@Override
	public int consume(String number, double money) throws MyException
	{
		try
		{
			Card card = getCardByNumber(number);
			if(card == null)
				return 0;
			if(card.getMoney() < money)
				return 0;
			card.setMoney(card.getMoney() - money);
			cardDao.update(card);
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			History history = new History(card.getNumber(),"XF",money,sf.format(new Date()));
			historyDao.save(history);
			return 1;
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new MyException("消费失败");
		}
	}

	@Override
	public int recharge(String number, double money) throws MyException
	{
		try
		{
			Card card = getCardByNumber(number);
			if(card == null)
				return 0;
			card.setMoney(card.getMoney() + money);
			cardDao.update(card);
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			History history = new History(card.getNumber(),"CZ",money,sf.format(new Date()));
			historyDao.save(history);
			return 1;
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new MyException("充值失败");
		}
	}

	@Override
	public int getHistoryPageCount(String number) throws MyException
	{
		try
		{
			Card card = getCardByNumber(number);
			if(card == null)
				return 0;
			List<History> list = historyDao.findAll(card.getNumber());
			int count = list.size();
			return (count + PAGESIZE - 1) / PAGESIZE;
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new MyException("获取卡历史页数失败");
		}
	}

	@Override
	public List<History> getHistoryByPage(String number, int pageNo)
			throws MyException
	{
		try
		{
			Card card = getCardByNumber(number);
			if(card == null)
				return null;
			return historyDao.findAllByPage(card.getNumber(), pageNo, PAGESIZE);
		}catch(Exception e)
		{	
			e.printStackTrace();
			throw new MyException("查询卡历史失败");
		}
	}

	@Override
	public int changePassword(String number, String password)
			throws MyException
	{
		try
		{
			Card card = getCardByNumber(number);
			if(card == null)
				return 0;
			if(password == null || password.equals(""))
				return 0;
			card.setPassword(password);
			cardDao.update(card);
			return 1;
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new MyException("修改密码失败");
		}
	}

	@Override
	public int changeCardInfo(Card card) throws MyException
	{
		try
		{
			Card c = getCardByNumber(card.getNumber());
			if(c == null)
				return 0;
			if(card.getCollege() != null && !card.getCollege().equals(""))
				c.setCollege(card.getCollege());
			if(card.getIdentity() != null && !card.getIdentity().equals(""))
				c.setIdentity(card.getIdentity());
			if(card.getName() != null && !card.getName().equals(""))
				c.setName(card.getName());
			if(card.getPhone() != null && !card.getPhone().equals(""))
				c.setPhone(card.getPhone());
			if(card.getSex() != null && !card.getSex().equals(""))
				c.setSex(card.getSex());
			cardDao.update(c);
			return 1;
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new MyException("修改卡信息失败");
		}
	}

	@Override
	public int getCardPageCount() throws MyException
	{
		try
		{
			List<Card> list = cardDao.findAll();
			int count = list.size();
			return (count + PAGESIZE - 1) / PAGESIZE;
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new MyException("获取卡历史页数失败");
		}
	}

	@Override
	public List<Card> getCardByPage(int pageNo) throws MyException
	{
		try
		{
			return cardDao.findAllByPage(pageNo, PAGESIZE);
		}catch(Exception e)
		{	
			e.printStackTrace();
			throw new MyException("查询卡历史失败");
		}
	}

}
