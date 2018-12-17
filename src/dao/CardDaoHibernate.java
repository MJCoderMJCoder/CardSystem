package dao;

import java.util.List;

import po.Card;

public class CardDaoHibernate extends MyHibernateDaoSupport implements CardDao
{

	@Override
	public Card get(Integer id)
	{
		return getHibernateTemplate().get(Card.class, id);
	}

	@Override
	public Card get(String number)
	{
		@SuppressWarnings("unchecked")
		List<Card> list = getHibernateTemplate().find("from Card as c where c.number=?", number);
		if(list.size() < 1)
			return null;
		return list.get(0);
	}

	@Override
	public void save(Card card)
	{
		getHibernateTemplate().save(card);
	}

	@Override
	public void update(Card card)
	{
		getHibernateTemplate().update(card);
	}

	@Override
	public void delete(Card card)
	{
		getHibernateTemplate().delete(card);
	}

	@Override
	public void delete(String number)
	{
		getHibernateTemplate().delete(get(number));
	}

	@Override
	public void delete(Integer id)
	{
		getHibernateTemplate().delete(get(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Card> findAllByPage(int pageNo, int pageSize)
	{
		if(pageNo < 1)
			return null;
		int offset = (pageNo - 1) * pageSize;
		return (List<Card>) findByPage("from Card",offset,pageSize);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Card> findAll()
	{
		// TODO Auto-generated method stub
		return (List<Card>)getHibernateTemplate().find("from Card");
	}

}
