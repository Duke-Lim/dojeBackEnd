package kr.ac.yyhighschool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.yyhighschool.dao.UserDAO;
import kr.ac.yyhighschool.vo.UserVO;

@Controller
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserDAO userDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/userlist.json", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody List<UserVO> userList(@RequestParam List<UserVO> reqList) {
		List<UserVO> result = new ArrayList<UserVO>();
		
		result = userDAO.getUserList();
		
		logger.info(result.toString());
		
		return result;
	}
	
	@RequestMapping(value = "/user.json", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody UserVO user(@RequestParam String id) {
		UserVO userVO = new UserVO();
		
		userVO = userDAO.getUser(id);
		
		logger.info(userVO.toString());
		
		return userVO;
	}
	
	@RequestMapping(value = "/joinuser.json", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody HashMap<String, String> joinUser(@RequestParam HashMap<String, Object> reqMap) {
		HashMap<String, String> success = new HashMap<String, String>();
		
		logger.info(reqMap.toString());
		
		try {
			userDAO.joinUser(reqMap);
			
			success.put("CODE", "00");
			success.put("MESSAGE", "SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
			
			success.put("CODE", "01");
			success.put("MESSAGE", "ERROR");
		}
		
		return success;
	}
	
	@RequestMapping(value = "/modifyuser.json", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody HashMap<String, String> modifyuser(@RequestParam HashMap<String, Object> reqMap) {
		HashMap<String, String> success = new HashMap<String, String>();
		
		logger.info(reqMap.toString());
		
		try {
			userDAO.modifyUser(reqMap);
			
			success.put("CODE", "00");
			success.put("MESSAGE", "SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
			
			success.put("CODE", "01");
			success.put("MESSAGE", "ERROR");
		}
		
		return success;
	}

}
