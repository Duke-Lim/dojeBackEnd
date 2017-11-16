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

import kr.ac.yyhighschool.dao.CommentDAO;
import kr.ac.yyhighschool.vo.CommentVO;

@Controller
@RequestMapping("/api")
public class CommentController {

	@Autowired
	private CommentDAO commentDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
	
	@RequestMapping(value = "/comlist.json", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody List<CommentVO> commentList(@RequestParam int id) {
		List<CommentVO> result = new ArrayList<CommentVO>();
		
		result = commentDAO.commentList(id);
		
		logger.info(result.toString());
		
		return result;
	}
	
	@RequestMapping(value = "/com.json", produces = "applicatin/json", method = RequestMethod.POST) 
	public @ResponseBody HashMap<String, String> writeComment(@RequestParam HashMap<String, Object> reqMap) {
		HashMap<String, String> success = new HashMap<String, String>();
		
		try {
			commentDAO.writeComment(reqMap);
			
			success.put("CODE", "00");
			success.put("MESSAGE", "SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
			
			success.put("CODE", "01");
			success.put("MESSAGE", "ERROR");
		}
		
		return success;
	}
	
	@RequestMapping(value = "/modifycom.json", produces = "application/json", method = RequestMethod.POST)
	public @ResponseBody HashMap<String, String> modifyComment(@RequestParam HashMap<String, Object> reqMap) {
		HashMap<String, String> success = new HashMap<String, String>();
		
		logger.info(reqMap.toString());
		
		try {
			commentDAO.modifyComment(reqMap);
			
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
