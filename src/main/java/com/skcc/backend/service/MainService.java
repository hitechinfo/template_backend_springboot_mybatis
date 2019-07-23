package com.skcc.backend.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skcc.backend.dao.MainDao;
import com.skcc.backend.model.CommonCodesDto;

@Service("mainService")
public class MainService {

	private Logger logger = LoggerFactory.getLogger(MainService.class);

	@Autowired
	MainDao mainDao;


	/**
	* getTemplate
	*
	* @return
	* @throws Exception
	*/
	
	public List<Map<String, Object>> getCommonCode() throws Exception {
		try {
			return mainDao.getCommonCode(); //dao call
		} catch (Exception e) {
		  logger.error(">>>>>>>>>>>>>>>>>>> GET ERROR IN SERVICE");
		  logger.error(e.getMessage());
		  throw new Exception("GET ERROR IN SERVICE");
		}
	}

	
	public void createCommonCode(CommonCodesDto getDto) throws Exception {
		try {
			mainDao.saveCommonCode(getDto); //dao call
		} catch (Exception e) {
		  logger.error(">>>>>>>>>>>>>>>>>>> POST ERROR IN SERVICE");
		  logger.error(e.getMessage());
		  throw new Exception("POST ERROR IN SERVICE");
		}
	}
	
	
	public void updateCommonCode(CommonCodesDto putDto) throws Exception {
		try {
			mainDao.modifyCommonCode(putDto); //dao call
		} catch (Exception e) {
		  logger.error(">>>>>>>>>>>>>>>>>>> PUT ERROR IN SERVICE");
		  logger.error(e.getMessage());
		  throw new Exception("PUT ERROR IN SERVICE");
		}
	}



	
}
