package com.haochi.platform.persistence.dao.order;

import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.converters.SqlDateConverter;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.hibernate.internal.util.compare.CalendarComparator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.haochi.platform.persistence.dao.BaseHibernateDAO;

/**
 * A data access object (DAO) providing persistence and search support for Order
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.haochi.platform.persistence.dao.order.Order
 * @author MyEclipse Persistence Tools
 */
public class OrderDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(OrderDAO.class);
	// property constants
	public static final String ORDERUSERID = "orderuserid";
	public static final String ORDERDOCID = "orderdocid";
	public static final String ORDERDATE = "orderdate";
	public static final String ORDERSTARTBLOCK = "orderstartblock";
	public static final String ORDERTREATMENTID = "ordertreatmentid";
	
	private SqlDateConverter converter = new SqlDateConverter();
	
	public OrderDAO() {
		converter.setPattern("YYYY-MM-DD");
	}

	public void save(Order transientInstance) {
		log.debug("saving Order instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Order persistentInstance) {
		log.debug("deleting Order instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Order findById(java.lang.Integer id) {
		log.debug("getting Order instance with id: " + id);
		try {
			Order instance = (Order) getSession().get(
					"com.haochi.platform.persistence.dao.Order", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Order instance) {
		log.debug("finding Order instance by example");
		try {
			List results = getSession()
					.createCriteria("com.haochi.platform.persistence.dao.Order")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Order instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Order as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	/**
	 * Select all the orders within a time period.
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public List findByMonthView(String startTime, String endTime, Integer docId) {
		log.debug("finding all the orders between " + startTime + ", " + endTime);
		try {
			String queryString = "from Order as model where "
					+ "model.orderdate >= :startTime and model.orderdate <= :endTime "
					+ "and  model.orderdocid = :docId";
			Query queryObject = getSession().createQuery(queryString)
					.setString("startTime", startTime)
					.setString("endTime", endTime)
					.setInteger("docId", docId);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find orders by time period failed", re);
			throw re;
		}
	}

	public List findByOrderuserid(Object orderuserid) {
		return findByProperty(ORDERUSERID, orderuserid);
	}

	public List findByOrderdocid(Object orderdocid) {
		return findByProperty(ORDERDOCID, orderdocid);
	}

	public List findByOrderdate(Object orderdate) {
		return findByProperty(ORDERDATE, orderdate);
	}

	public List findByOrderstartblock(Object orderstartblock) {
		return findByProperty(ORDERSTARTBLOCK, orderstartblock);
	}

	public List findByOrdertreatmentid(Object ordertreatmentid) {
		return findByProperty(ORDERTREATMENTID, ordertreatmentid);
	}

	public List findAll() {
		log.debug("finding all Order instances");
		try {
			String queryString = "from Order";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Order merge(Order detachedInstance) {
		log.debug("merging Order instance");
		try {
			Order result = (Order) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Order instance) {
		log.debug("attaching dirty Order instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Order instance) {
		log.debug("attaching clean Order instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}