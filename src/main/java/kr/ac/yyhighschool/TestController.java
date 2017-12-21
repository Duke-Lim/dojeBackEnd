package kr.ac.yyhighschool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

<<<<<<< HEAD
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
=======
import javax.servlet.http.HttpServletResponse;
>>>>>>> 47ecb6a7fbb8fa9dd05c71f03e881aee003435b0

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.ac.yyhighschool.dao.CommentDAO;
import kr.ac.yyhighschool.dao.FileDAO;
import kr.ac.yyhighschool.dao.PostDAO;
import kr.ac.yyhighschool.dao.UserDAO;
<<<<<<< HEAD
import kr.ac.yyhighschool.util.Utils;
=======
import kr.ac.yyhighschool.util.FileUtil;
>>>>>>> 47ecb6a7fbb8fa9dd05c71f03e881aee003435b0
import kr.ac.yyhighschool.vo.CommentVO;
import kr.ac.yyhighschool.vo.FileVO;
import kr.ac.yyhighschool.vo.PostVO;
import kr.ac.yyhighschool.vo.UserVO;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Inject
	private PostDAO postDAO;
	
	@Inject
	private UserDAO userDAO;
	
	@Inject
	private CommentDAO commentDAO;
	
<<<<<<< HEAD
	@Inject
	private FileDAO fileDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	@RequestMapping(value = "/{board_title}/post", method = RequestMethod.GET)
	public String postList(Model model, @PathVariable("board_title") String board_title) {
=======
	@Autowired
	private FileDAO fileDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping(value = "/postList.do")
	public String postList(Model model) {
>>>>>>> 47ecb6a7fbb8fa9dd05c71f03e881aee003435b0
		List<PostVO> result = new ArrayList<PostVO>();
		
		//result = postDAO.getPostList(board_id);
		
		model.addAttribute("result", result);
		
		return "home";
	}
	
<<<<<<< HEAD
	@RequestMapping(value = "/post/{post_id}", method = RequestMethod.GET)
	public String post(Model model, @PathVariable int post_id) {
=======
	@RequestMapping(value = "/post.do")
	public String post(Model model, @RequestParam int id) {
>>>>>>> 47ecb6a7fbb8fa9dd05c71f03e881aee003435b0
		PostVO postVO = new PostVO();
		List<PostVO> result = new ArrayList<PostVO>();
		
		postVO = postDAO.getPost(post_id);
		
		result.add(postVO);
		
		model.addAttribute("result", result);
		
		return "home";
	}
	
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String writePost(Model model, @RequestParam HashMap<String, Object> reqMap) {	
		
		logger.info(reqMap.toString());
				
		postDAO.writePost(reqMap);
		
		model.addAttribute("result", reqMap);
		
		return "redirect:/test/post";
	}
	
	@RequestMapping(value = "/post", method = RequestMethod.PUT)
	public String modifyPost(Model model, @RequestParam HashMap<String, Object> reqMap) {
		postDAO.modifyPost(reqMap);
		
		return "redirect:/test/post";
	}
		
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userList(Model model) {
		List<UserVO> result = new ArrayList<UserVO>();
		
		
		model.addAttribute("result", result);
		
		return "user";
	}
	
	@RequestMapping(value = "/user/{user_id}", method = RequestMethod.GET)
	public String user(@PathVariable int user_id, Model model) {
		UserVO userVO = new UserVO();
		List<UserVO> result = new ArrayList<UserVO>();
		
		result.add(userVO);
		
		model.addAttribute("result", result);
		
		return "user";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String joinUser(@RequestParam HashMap<String, Object> reqMap, Model model) {
		logger.info(reqMap.toString());
		userDAO.joinUser(reqMap);
		
		return "redirect:/test/user";
	}
	
	@RequestMapping(value = "/com", method = RequestMethod.GET)
	public String commentList(@RequestParam int id, Model model) {
		List<CommentVO> result = new ArrayList<CommentVO>();
		
		result = commentDAO.commentList(id);
		
		model.addAttribute("result", result);
		
		return "comment";
	}
	
	@RequestMapping(value = "/com", method = RequestMethod.PUT)
	public String modifyComment(@RequestParam HashMap<String, Object> reqMap, Model model) {
		
		return "redirect:/user/com";
	}

	@RequestMapping(value = "/file", method = RequestMethod.POST)
	public String fileupload(MultipartHttpServletRequest request, Model model) {
		Utils fileUtil = new Utils();
		List<HashMap<String, Object>> list = fileUtil.fileSave(request);
		
		for (HashMap<String, Object> hashMap : list) {
			fileDAO.fileSave(hashMap);
		}
		
		model.addAttribute("result", list);
		
		return "file";
	}
	
	@RequestMapping(value = "/file", method = RequestMethod.GET)
	public void filedownload(@RequestParam int file_id, HttpServletResponse response) {
		Utils fileUtil = new Utils();
		FileVO fileVO = fileDAO.getFile(file_id);
		
		fileUtil.fileDownload(file_id, fileVO, response);
	}
	
	@RequestMapping(value = "/file/{post_id}", method = RequestMethod.GET)
	public String allFile(@PathVariable int post_id, Model model) {
		List<FileVO> list = fileDAO.fileList(post_id);

		model.addAttribute("result", list);
		
		return "file";
	}

	@RequestMapping(value = "/fileupload.do", method = RequestMethod.POST)
	public String fileupload(MultipartHttpServletRequest request, Model model) {
		FileUtil fileUtil = new FileUtil();
		
		List<HashMap<String, Object>> list = fileUtil.fileSave(request);
		
		model.addAttribute("result", list);
		
		return "file";
	}
	
	@RequestMapping(value = "/filedownload.do")
	public void filedownload(@RequestParam String name, HttpServletResponse response) {
		FileUtil fileUtil = new FileUtil();
		
		fileUtil.fileDownload(name, response);
	}
	
	@RequestMapping(value = "/fileList.do")
	public String allFile(@RequestParam int post_id, Model model) {
		List<FileVO> list = fileDAO.fileList(post_id);

		model.addAttribute("result", list);
		
		return "file";
	}
}
