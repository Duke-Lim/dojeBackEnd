package kr.ac.yyhighschool.service;

import java.util.HashMap;
import java.util.List;

import kr.ac.yyhighschool.vo.UserVO;

public interface UserService {
	public List<UserVO> getUserList();
	public UserVO getUser(String id);
	public int modifyUser(HashMap<String, Object> reqMap);
	public int joinUser(HashMap<String, Object> reqMap);
}
