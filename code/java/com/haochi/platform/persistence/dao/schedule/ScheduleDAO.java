package com.haochi.platform.persistence.dao.schedule;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.haochi.platform.persistence.dao.BaseHibernateDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * Schedule entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.haochi.platform.persistence.dao.schedule.Schedule
 * @author MyEclipse Persistence Tools
 */
public class ScheduleDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ScheduleDAO.class);
	// property constants
	public static final String SCHEDULERESTDAYINDEX = "schedulerestdayindex";

	public void save(Schedule transientInstance) {
		log.debug("saving Schedule instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Schedule persistentInstance) {
		log.debug("deleting Schedule instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Schedule findById(java.lang.Integer id) {
		log.debug("getting Schedule instance with id: " + id);
		try {
			Schedule instance = (Schedule) getSession().get(
					"com.haochi.platform.persistence.dao.Schedule", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Schedule instance) {
		log.debug("finding Schedule instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"com.haochi.platform.persistence.dao.Schedule")
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
		log.debug("finding Schedule instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Schedule as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySchedulerestdayindex(Object schedulerestdayindex) {
		return findByProperty(SCHEDULERESTDAYINDEX, schedulerestdayindex);
	}

	public List findAll() {
		log.debug("finding all Schedule instances");
		try {
			String queryString = "from Schedule";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Schedule merge(Schedule detachedInstance) {
		log.debug("merging Schedule instance");
		try {
			Schedule result = (Schedule) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Schedule instance) {
		log.debug("attaching dirty Schedule instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Schedule instance) {
		log.debug("attaching clean Schedule instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}