package com.haochi.platform.persistence.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Treathistory entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.haochi.platform.persistence.dao.Treathistory
 * @author MyEclipse Persistence Tools
 */
public class TreathistoryDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TreathistoryDAO.class);
	// property constants
	public static final String TREATUSERID = "treatuserid";
	public static final String TREATDOCID = "treatdocid";
	public static final String TREATCONTENT = "treatcontent";
	public static final String TREATDATE = "treatdate";

	public void save(Treathistory transientInstance) {
		log.debug("saving Treathistory instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Treathistory persistentInstance) {
		log.debug("deleting Treathistory instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Treathistory findById(java.lang.Integer id) {
		log.debug("getting Treathistory instance with id: " + id);
		try {
			Treathistory instance = (Treathistory) getSession().get(
					"com.haochi.platform.persistence.dao.Treathistory", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Treathistory instance) {
		log.debug("finding Treathistory instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"com.haochi.platform.persistence.dao.Treathistory")
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
		log.debug("finding Treathistory instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Treathistory as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTreatuserid(Object treatuserid) {
		return findByProperty(TREATUSERID, treatuserid);
	}

	public List findByTreatdocid(Object treatdocid) {
		return findByProperty(TREATDOCID, treatdocid);
	}

	public List findByTreatcontent(Object treatcontent) {
		return findByProperty(TREATCONTENT, treatcontent);
	}

	public List findByTreatdate(Object treatdate) {
		return findByProperty(TREATDATE, treatdate);
	}

	public List findAll() {
		log.debug("finding all Treathistory instances");
		try {
			String queryString = "from Treathistory";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Treathistory merge(Treathistory detachedInstance) {
		log.debug("merging Treathistory instance");
		try {
			Treathistory result = (Treathistory) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Treathistory instance) {
		log.debug("attaching dirty Treathistory instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Treathistory instance) {
		log.debug("attaching clean Treathistory instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}