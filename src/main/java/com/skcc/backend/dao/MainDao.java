package com.skcc.backend.dao;

import java.util.ArrayList;

/**
 * This is automatically generated by sprout plug-in.
 */

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skcc.backend.controller.MainController;
import com.skcc.backend.model.CommonCodesDto;

@Repository("mainDao")
public class MainDao {

	private Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	

	/**
	*getTemplate
	*
	*@return
	*throws Exception
	*/
	public List<Map<String, Object>> getCommonCode() throws Exception {
		try {
			
			List<Map<String, Object>> test = new ArrayList<>();
			test = sqlSessionTemplate.selectList("template.daoQueryId");
			System.out.println(test);
			return test;
		} catch (Exception e) {
			logger.error(">>>>>>>>>>> GET ERROR IN DAO");
			throw new Exception("GET ERROR IN DAO");
		}
	}
	
	public void saveCommonCode(CommonCodesDto getDto) throws Exception {
		try {
			sqlSessionTemplate.insert("template.daoInsert", getDto);
		} catch (Exception e) {
			logger.error(">>>>>>>>>>> POST ERROR IN Dao");
			System.out.println(e);
			throw new Exception("POST ERROR IN Dao");
		}
	}
	
	public void modifyCommonCode(CommonCodesDto putDto) throws Exception {
		try {
			sqlSessionTemplate.update("template.daoUpdate", putDto);
		} catch (Exception e) {
			logger.error(">>>>>>>>>>> PUT ERROR IN Dao");
			System.out.println(e);
			throw new Exception("PUT ERROR IN Dao");
		}
	}
	
	
	
	
}