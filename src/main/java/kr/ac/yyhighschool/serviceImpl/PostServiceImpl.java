package kr.ac.yyhighschool.serviceImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.yyhighschool.dao.PostDAO;
import kr.ac.yyhighschool.service.PostService;
import kr.ac.yyhighschool.vo.PostVO;

@Service("postService")
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDAO postDAO;
	
	@Override
	public List<PostVO> getPostList() {
		return postDAO.getPostList();
	}

	@Override
	public PostVO getPost(int id) {
		return postDAO.getPost(id);
	}

	@Override
	public int writePost(HashMap<String, Object> reqMap) {
		return postDAO.writePost(reqMap);
	}

	@Override
	public int seqCount(HashMap<String, Object> reqMap) {
		return postDAO.seqCount(reqMap);
	}

	@Override
	public int modifyPost(HashMap<String, Object> reqMap) {
		return postDAO.modifyPost(reqMap);
	}

	@Override
	public int viewCount(int seq) {
		return postDAO.viewCount(seq);
	}

}
