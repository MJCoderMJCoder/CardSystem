package service;

import java.util.List;

import po.Card;
import po.History;
import exception.MyException;

public interface Service
{
	//管理员登陆
	public int adminLogin(String username, String password) throws MyException;
	//学生登陆
	public int studentLogin(String number, String password) throws MyException;
	//根据卡号获得卡
	public Card getCardByNumber(String number) throws MyException;
	//创建卡
	public int createCard(Card card) throws MyException;
	//挂失卡
	public int lock(String number) throws MyException;
	//解除挂失
	public int unlock(String number) throws MyException;
	//注销卡
	public int deleteCard(String number) throws MyException;
	//消费
	public int consume(String number, double money) throws MyException;
	//充值
	public int recharge(String number, double money) throws MyException;
	//获得交易记录页数
	public int getHistoryPageCount(String number) throws MyException;
	//按页获取交易记录
	public List<History> getHistoryByPage(String number, int pageNo) throws MyException;
	//修改密码
	public int changePassword(String number, String password) throws MyException;
	//修改卡信息
	public int changeCardInfo(Card card) throws MyException;
	//获得卡页数
	public int getCardPageCount() throws MyException;
	//按页获取卡
	public List<Card> getCardByPage(int pageNo) throws MyException;
}
