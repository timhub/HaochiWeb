package com.haochi.platform.persistence.dao.doctorinfo;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.haochi.platform.persistence.dao.BaseHibernateDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * Doctorinfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.haochi.platform.persistence.dao.doctorinfo.Doctorinfo
 * @author MyEclipse Persistence Tools
 */
public class DoctorinfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DoctorinfoDAO.class);
	// property constants
	public static final String DOCUSERID = "docuserid";
	public static final String DOCNAME = "docname";
	public static final String DOCINTRO = "docintro";
	public static final String DOCABILITY = "docability";

	public void save(Doctorinfo transientInstance) {
		log.debug("saving Doctorinfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Doctorinfo persistentInstance) {
		log.debug("deleting Doctorinfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Doctorinfo findById(java.lang.Integer id) {
		log.debug("getting Doctorinfo instance with id: " + id);
		try {
			Doctorinfo instance = (Doctorinfo) getSession().get(
					"com.haochi.platform.persistence.dao.Doctorinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Doctorinfo instance) {
		log.debug("finding Doctorinfo instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"com.haochi.platform.persistence.dao.Doctorinfo")
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
		log.debug("finding Doctorinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Doctorinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDocuserid(Object docuserid) {
		return findByProperty(DOCUSERID, docuserid);
	}

	public List findByDocname(Object docname) {
		return findByProperty(DOCNAME, docname);
	}

	public List findByDocintro(Object docintro) {
		return findByProperty(DOCINTRO, docintro);
	}

	public List findByDocability(Object docability) {
		return findByProperty(DOCABILITY, docability);
	}

	public List findAll() {
		log.debug("finding all Doctorinfo instances");
		try {
			String queryString = "from Doctorinfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Doctorinfo merge(Doctorinfo detachedInstance) {
		log.debug("merging Doctorinfo instance");
		try {
			Doctorinfo result = (Doctorinfo) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Doctorinfo instance) {
		log.debug("attaching dirty Doctorinfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Doctorinfo instance) {
		log.debug("attaching clean Doctorinfo instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}