package kr.ac.yyhighschool.serviceImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.yyhighschool.dao.UserDAO;
import kr.ac.yyhighschool.service.UserService;
import kr.ac.yyhighschool.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public List<UserVO> getUserList() {
		return userDAO.getUserList();
	}

	@Override
	public UserVO getUser(String id) {
		return userDAO.getUser(id);
	}

	@Override
	public int joinUser(HashMap<String, Object> reqMap) {
		return userDAO.joinUser(reqMap);
	}

	@Override
	public int modifyUser(HashMap<String, Object> reqMap) {
		return userDAO.modifyUser(reqMap);
	}

}
