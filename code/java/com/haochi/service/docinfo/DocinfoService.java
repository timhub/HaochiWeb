package com.haochi.service.docinfo;

import java.util.List;

import com.haochi.platform.persistence.dao.doctorinfo.Doctorinfo;
import com.haochi.platform.persistence.dao.doctorinfo.DoctorinfoDAO;

public class DocinfoService {
	
	private static DoctorinfoDAO docDao;
	
	public DocinfoService() {
		docDao = new DoctorinfoDAO();
	}
	
	/**
	 * Process the DAO output result and return to the backing bean.
	 * @return
	 */
	public Doctorinfo[] getAllDoctorinfo() {
		List queryList = docDao.findAll();
		if (queryList.size() > 0) {
			Doctorinfo[] resultList = new Doctorinfo[queryList.size()];
			for (int i = 0; i < queryList.size(); i++) {
				resultList[i] = (Doctorinfo) queryList.get(i);
			}
			return resultList;
		} else {
			return null;
		}

	}
	
	/**
	 * Find the doc information by doc id.
	 * @return
	 */
	public static String getDocNameById(int docid) {
		Doctorinfo result = null;
		result = docDao.findById(docid);
		
		return result.getDocname();
	}
}
