package com.haochi.platform.persistence.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Leaveapplication entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.haochi.platform.persistence.dao.Leaveapplication
 * @author MyEclipse Persistence Tools
 */
public class LeaveapplicationDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(LeaveapplicationDAO.class);
	// property constants
	public static final String LEAVEDATE = "leavedate";
	public static final String LEAVESTARTTIME = "leavestarttime";
	public static final String LEAVEENDTIME = "leaveendtime";

	public void save(Leaveapplication transientInstance) {
		log.debug("saving Leaveapplication instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Leaveapplication persistentInstance) {
		log.debug("deleting Leaveapplication instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Leaveapplication findById(java.lang.Integer id) {
		log.debug("getting Leaveapplication instance with id: " + id);
		try {
			Leaveapplication instance = (Leaveapplication) getSession().get(
					"com.haochi.platform.persistence.dao.Leaveapplication", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Leaveapplication instance) {
		log.debug("finding Leaveapplication instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"com.haochi.platform.persistence.dao.Leaveapplication")
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
		log.debug("finding Leaveapplication instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Leaveapplication as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByLeavedate(Object leavedate) {
		return findByProperty(LEAVEDATE, leavedate);
	}

	public List findByLeavestarttime(Object leavestarttime) {
		return findByProperty(LEAVESTARTTIME, leavestarttime);
	}

	public List findByLeaveendtime(Object leaveendtime) {
		return findByProperty(LEAVEENDTIME, leaveendtime);
	}

	public List findAll() {
		log.debug("finding all Leaveapplication instances");
		try {
			String queryString = "from Leaveapplication";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Leaveapplication merge(Leaveapplication detachedInstance) {
		log.debug("merging Leaveapplication instance");
		try {
			Leaveapplication result = (Leaveapplication) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Leaveapplication instance) {
		log.debug("attaching dirty Leaveapplication instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Leaveapplication instance) {
		log.debug("attaching clean Leaveapplication instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}