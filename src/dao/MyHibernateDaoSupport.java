package dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
//在hibernateDaoSupport基础上实现了分页
public class MyHibernateDaoSupport extends HibernateDaoSupport
{
	public List<?> findByPage(final String hql,final int offset,final int pageSize)
	{
		List<?> list = getHibernateTemplate().executeFind(new HibernateCallback<Object>()
		{
			@Override
			public Object doInHibernate(org.hibernate.Session session)
					throws HibernateException, SQLException
			{
				List<?> result = session.createQuery(hql).setFirstResult(offset).setMaxResults(pageSize).list();
				return result;
			}
		});
		return list;
	}
	
	public List<?> findByPage(final String hql,final Object value,final int offset,final int pageSize)
	{
		List<?> list = getHibernateTemplate().executeFind(new HibernateCallback<Object>()
		{
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException
			{
				List<?> result = session.createQuery(hql).setParameter(0, value).setFirstResult(offset).setMaxResults(pageSize).list();
				return result;
			}
		});
		return list;
	}
	
	public List<?> findByPage(final String hql,final Object[] values,final int offset,final int pageSize)
	{
		List<?> list = getHibernateTemplate().executeFind(new HibernateCallback<Object>()
		{
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException
			{
				Query query = session.createQuery(hql);
				for(int i = 0; i < values.length; i++)
				{
					query.setParameter(i, values[i]);
				}
				List<?> result = query.setFirstResult(offset).setMaxResults(pageSize).list();
				return result;
			}
		});
		return list;
	}	
}
