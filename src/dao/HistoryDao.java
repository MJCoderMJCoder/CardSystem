package dao;

import java.util.List;

import po.History;

public interface HistoryDao
{
	//通过ID获得交易记录
	public History get(Integer id);
	//保存交易记录
	public void save(History history);
	//更新交易记录
	public void update(History history);
	//通过卡号删除卡
	public void delete(String number);
	//通过ID删除卡
	public void delete(Integer id);
	//按页查找交易记录
	public List<History> findAllByPage(String number, int pageNo, int pageSize);
	//获得所有交易记录
	public List<History> findAll(String number);
}
