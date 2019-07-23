package com.skcc.backend.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.backend.model.CommonCodesDto;
import com.skcc.backend.service.MainService;

@RestController
public class MainController {

	@Autowired
	MainService mainService;
	

	@Autowired
	AuthenticationManager authenticationManager;
	
	private Logger logger = LoggerFactory.getLogger(MainController.class);

	/**
	*MainTemplate
	*
	* @return
	*/
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ResponseEntity<String> getHome() {

		logger.info("logback example - info level");
		logger.debug("logback example - debug level");

		return new ResponseEntity<String>("Hello World!-MainController-main", HttpStatus.OK);
	}

	/**
	* MyBatisTemplate
	*
	* @return Map<String, Object>
	* @throws Exception
	*/
	@RequestMapping(value = "/dataget", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> selectCode() throws Exception{
		logger.info("Hello World!-getTemplate-data-req_MariaDB");

		ArrayList<Map<String, Object>> resultIt = (ArrayList<Map<String, Object>>) mainService.getCommonCode(); //service call
		Map<String, Object> resultMap = new HashMap<String, Object>();

		try {
			resultMap.put("rows", resultIt);
		} catch (Exception e) {
			logger.error("=======> ERROR ON CONTROLLER");
			throw new Exception("ERROR ON CONTROLLER");
		}

		return resultMap;
	}
	
	@RequestMapping(value = "/datapost", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> insertCode(@RequestParam String groupId, @RequestParam String codeName,
	 										 @RequestParam String codeValue, @RequestParam Integer codeOrder,
											 @RequestParam String createUserId, @RequestParam String updateUserId
											) throws Exception{
		
		
		
		try {
				CommonCodesDto getDto = CommonCodesDto.builder() //받아온 파라미터들을 set 한다
											.groupId(groupId)
											.codeName(codeName)
											.codeValue(codeValue)
											.codeOrder(codeOrder)
											.createUserId(createUserId)
											.updateUserId(updateUserId)
											.build();
			mainService.createCommonCode(getDto); //service call
			logger.info("POST. INSERT CONTROLLER");
		} catch (Exception e) {
			logger.error("=======> ERROR ON POST CONTROLLER");
			throw new Exception("ERROR ON POST CONTROLLER");
		}

		return new ResponseEntity<String>("insert successfully", HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/dataput", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<String> modifyCode(@RequestParam String groupId, @RequestParam String codeName,
	 										 @RequestParam String codeValue, @RequestParam String updateUserId
											) throws Exception{
		
		try {
			CommonCodesDto putDto = CommonCodesDto.builder() //받아온 파라미터들을 set 한다
											.groupId(groupId)
											.codeName(codeName)
											.codeValue(codeValue)
											.updateUserId(updateUserId)
											.build();
			mainService.updateCommonCode(putDto); //service call
			logger.info("PuT. UPDATE CONTROLLER");
		} catch (Exception e) {
			logger.error("=======> ERROR ON PUT CONTROLLER");
			throw new Exception("ERROR ON PUT CONTROLLER");
		}

		return new ResponseEntity<String>("update successfully", HttpStatus.OK);
	}
	

	/**
	* ExceptionTemplate
	*
	*@throws Exception
	*/
	@RequestMapping("/exception")
	public void getTemplateException() throws Exception {
		logger.error(">>>>>>>>>>>>>>>>>Exception Test Error");
		throw new Exception("Exception Test Error!");
	}

}
	