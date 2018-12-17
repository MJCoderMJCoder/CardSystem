package dao;

import java.util.List;

import po.Card;

public interface CardDao
{
	//通过ID获得卡
	public Card get(Integer id);
	//通过卡号获得卡
	public Card get(String number);
	//保存
	public void save(Card card);
	//更新
	public void update(Card card);
	//删除
	public void delete(Card card);
	//根据卡号删除卡
	public void delete(String number);
	//根据ID删除卡
	public void delete(Integer id);
	//按页查找卡
	public List<Card> findAllByPage(int pageNo, int pageSize);
	//查看所有卡
	public List<Card> findAll();
}
