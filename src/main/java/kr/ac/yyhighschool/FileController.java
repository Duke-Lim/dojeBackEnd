package kr.ac.yyhighschool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

<<<<<<< HEAD
import javax.inject.Inject;
=======
>>>>>>> 47ecb6a7fbb8fa9dd05c71f03e881aee003435b0
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
<<<<<<< HEAD
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
>>>>>>> 47ecb6a7fbb8fa9dd05c71f03e881aee003435b0
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.ac.yyhighschool.dao.FileDAO;
<<<<<<< HEAD
import kr.ac.yyhighschool.util.Utils;
=======
import kr.ac.yyhighschool.util.FileUtil;
>>>>>>> 47ecb6a7fbb8fa9dd05c71f03e881aee003435b0
import kr.ac.yyhighschool.vo.FileVO;

@Controller
@RequestMapping("/api")
public class FileController {
	
<<<<<<< HEAD
	@Inject
=======
	@Autowired
>>>>>>> 47ecb6a7fbb8fa9dd05c71f03e881aee003435b0
	private FileDAO fileDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

<<<<<<< HEAD
	@RequestMapping(value = "/file/{post_id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<FileVO> fileList(@PathVariable int post_id) {
=======
	@RequestMapping(value = "/fileList.json", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody List<FileVO> fileList(@RequestParam int post_id) {
>>>>>>> 47ecb6a7fbb8fa9dd05c71f03e881aee003435b0
		List<FileVO> list = fileDAO.fileList(post_id);
		
		logger.info(list.toString());
		
		return list;
	}
	
<<<<<<< HEAD
	@RequestMapping(value = "/file", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Map<String, Object> fileupload(MultipartHttpServletRequest request) {
		Map<String, Object> success = new HashMap<String, Object>();
		Utils utils = new Utils();
		
		try {
			List<HashMap<String, Object>> list = utils.fileSave(request);
			
			for (HashMap<String, Object> hashMap : list) {
				fileDAO.fileSave(hashMap);
			}
=======
	@RequestMapping(value = "/fileupload.json", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Map<String, Object> fileupload(MultipartHttpServletRequest request) {
		Map<String, Object> success = new HashMap<String, Object>();
		FileUtil fileUtil = new FileUtil();
		
		try {
			fileUtil.fileSave(request);
>>>>>>> 47ecb6a7fbb8fa9dd05c71f03e881aee003435b0
			
			success.put("CODE", "00");
			success.put("MESSAGE", "SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
			
			success.put("CODE", "01");
			success.put("MESSAGE", "ERROR");
		}
		return success;
	}
	
<<<<<<< HEAD
	@RequestMapping(value = "/file", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Map<String, Object> filedownload(@RequestParam int file_id, HttpServletResponse response) {
		Utils fileUtil = new Utils();
		FileVO fileVO = fileDAO.getFile(file_id);
		
		return fileUtil.fileDownload(file_id, fileVO, response);
=======
	@RequestMapping(value = "/filedownload.json", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Map<String, Object> filedownload(@RequestParam String name, HttpServletResponse response) {
		FileUtil fileUtil = new FileUtil();
		
		return fileUtil.fileDownload(name, response);
>>>>>>> 47ecb6a7fbb8fa9dd05c71f03e881aee003435b0
	}
	
}
