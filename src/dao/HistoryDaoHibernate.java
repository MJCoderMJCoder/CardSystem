package dao;

import java.util.List;

import po.History;

public class HistoryDaoHibernate extends MyHibernateDaoSupport implements
		HistoryDao
{
	@Override
	public History get(Integer id)
	{
		return getHibernateTemplate().get(History.class, id);
	}
	
	@Override
	public void save(History history)
	{
		getHibernateTemplate().save(history);
	}

	@Override
	public void update(History history)
	{
		getHibernateTemplate().update(history);
	}

	@Override
	public void delete(String number)
	{
		List<History> list = findAll(number);
		for(int i = 0; i < list.size(); i++)
		{
			getHibernateTemplate().delete(list.get(i));
		}
	}

	@Override
	public void delete(Integer id)
	{
		getHibernateTemplate().delete(get(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<History> findAllByPage(String number, int pageNo, int pageSize)
	{
		if(pageNo < 1)
			return null;
		int offset = (pageNo - 1) * pageSize;
		return (List<History>) findByPage("from History as h where h.number=?",number,offset,pageSize);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<History> findAll(String number)
	{
		return (List<History>)getHibernateTemplate().find("from History as h where h.number=?", number);
	}

}
