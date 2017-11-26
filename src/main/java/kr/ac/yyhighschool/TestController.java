package kr.ac.yyhighschool;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.yyhighschool.dao.CommentDAO;
import kr.ac.yyhighschool.dao.FileDAO;
import kr.ac.yyhighschool.dao.PostDAO;
import kr.ac.yyhighschool.dao.UserDAO;
import kr.ac.yyhighschool.util.FileUpload;
import kr.ac.yyhighschool.vo.CommentVO;
import kr.ac.yyhighschool.vo.FileVO;
import kr.ac.yyhighschool.vo.PostVO;
import kr.ac.yyhighschool.vo.UserVO;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private PostDAO postDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private CommentDAO commentDAO;
	
	@Autowired
	private FileDAO fileDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping(value = "/postList.do")
	public String postList(Model model) {
		List<PostVO> result = new ArrayList<PostVO>();
		
		result = postDAO.getPostList();
		
		logger.info(result.toString());
		
		model.addAttribute("result", result);
		
		return "home";
	}
	
	@RequestMapping(value = "/post.do")
	public String post(Model model, @RequestParam int id) {
		PostVO postVO = new PostVO();
		List<PostVO> result = new ArrayList<PostVO>();
		
		postDAO.viewCount(id);
		postVO = postDAO.getPost(id);
		
		result.add(postVO);
		
		model.addAttribute("result", result);
		
		return "home";
	}
	
	@RequestMapping(value = "/writePost.do")
	public String writePost(Model model, @RequestParam HashMap<String, Object> reqMap) {	
		
		logger.info(reqMap.toString());
				
		postDAO.writePost(reqMap);
		postDAO.seqCount(reqMap);
		
		model.addAttribute("result", reqMap);
		
		return "redirect:postList.do";
	}
	
	@RequestMapping(value = "/modifyPost.do")
	public String modifyPost(Model model, @RequestParam HashMap<String, Object> reqMap) {
		postDAO.modifyPost(reqMap);
		
		return "redirect:postList.do";
	}
		
	@RequestMapping(value = "/userList.do")
	public String userList(Model model) {
		List<UserVO> result = new ArrayList<UserVO>();
		
		result = userDAO.getUserList();
		
		model.addAttribute("result", result);
		
		return "user";
	}
	
	@RequestMapping(value = "/user.do")
	public String user(@RequestParam String id, Model model) {
		UserVO userVO = new UserVO();
		List<UserVO> result = new ArrayList<UserVO>();
		
		userVO = userDAO.getUser(id);
		result.add(userVO);
		
		model.addAttribute("result", result);
		
		return "user";
	}
	
	@RequestMapping(value = "/joinUser.do")
	public String joinUser(@RequestParam HashMap<String, Object> reqMap, Model model) {
		userDAO.joinUser(reqMap);
		
		return "redirect:userList.do";
	}
	
	@RequestMapping(value = "/commentList.do")
	public String commentList(@RequestParam int id, Model model) {
		List<CommentVO> result = new ArrayList<CommentVO>();
		
		result = commentDAO.commentList(id);
		
		model.addAttribute("result", result);
		
		return "comment";
	}
	
	@RequestMapping(value = "/modifyComment.do")
	public String modifyComment(@RequestParam HashMap<String, Object> reqMap, Model model) {
		commentDAO.modifyComment(reqMap);
		
		return "redirect:commentList.do";
	}
	
	@RequestMapping(value = "/allfile.do")
	public String allfile(Model model) {
		List<FileVO> list = new ArrayList<FileVO>();
		
		list = fileDAO.fileList();
		
		model.addAttribute("result", list);
		
		return "file";
	}
	
	@RequestMapping(value = "/fileupload.do", method = RequestMethod.POST)
	public String fileupload(MultipartHttpServletRequest request, Model model) {
		FileUpload fileUtil = new FileUpload();
		
		List<HashMap<String, Object>> list = fileUtil.fileSave(request);
		
		for (HashMap<String, Object> hashMap : list) {
			fileDAO.fileSave(hashMap);
		}
		
		model.addAttribute("result", list);
		
		return "file";
	}
	
	@RequestMapping(value = "/filedownload.do")
	public ModelAndView filedownload(@RequestParam String filename) {
		
		File downloadFile = new File(FileUpload.filePath + filename);
		
		
		return new ModelAndView("fileDownloadView", "downloadFile", downloadFile);
	}
}
