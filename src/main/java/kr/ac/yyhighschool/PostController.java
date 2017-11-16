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

import kr.ac.yyhighschool.dao.PostDAO;
import kr.ac.yyhighschool.vo.PostVO;

@Controller
@RequestMapping("/api")
public class PostController {

	@Autowired
	private PostDAO postDAO;

	private static final Logger logger = LoggerFactory.getLogger(PostController.class);

	@RequestMapping(value = "/postlist.json", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody List<PostVO> postList(@RequestParam List<PostVO> reqList) {
		List<PostVO> result = new ArrayList<PostVO>();

		result = postDAO.getPostList();

		logger.info(result.toString());

		return result;
	}

	@RequestMapping(value = "/post.json", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody List<PostVO> post(@RequestParam int id) {
		PostVO postVO = new PostVO();
		List<PostVO> result = new ArrayList<PostVO>();

		postDAO.viewCount(id);
		postVO = postDAO.getPost(id);

		result.add(postVO);

		logger.info(result.toString());
		
		return result;
	}

	@RequestMapping(value = "/writepost.json", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody HashMap<String, String> writePost(@RequestParam HashMap<String, Object> reqMap) {
		HashMap<String, String> success = new HashMap<String, String>();

		logger.info(reqMap.toString());
		
		try {
			postDAO.writePost(reqMap);
			postDAO.seqCount(reqMap);

			success.put("CODE", "00");
			success.put("MESSAGE", "SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();

			success.put("CODE", "01");
			success.put("MESSAGE", "ERROR");
		}
		return success;
	}

	@RequestMapping(value = "/mofitypost.json", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody HashMap<String, String> modifyPost(@RequestParam HashMap<String, Object> reqMap) {
		HashMap<String, String> success = new HashMap<String, String>();

		logger.info(reqMap.toString());
		
		try {
			postDAO.modifyPost(reqMap);

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
