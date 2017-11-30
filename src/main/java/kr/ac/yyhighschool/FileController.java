package kr.ac.yyhighschool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.ac.yyhighschool.dao.FileDAO;
import kr.ac.yyhighschool.util.FileUtil;
import kr.ac.yyhighschool.vo.FileVO;

@Controller
@RequestMapping("/api")
public class FileController {
	
	@Autowired
	private FileDAO fileDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

	@RequestMapping(value = "/fileList.json", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody List<FileVO> fileList(@RequestParam int post_id) {
		List<FileVO> list = fileDAO.fileList(post_id);
		
		logger.info(list.toString());
		
		return list;
	}
	
	@RequestMapping(value = "/fileupload.json", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Map<String, Object> fileupload(MultipartHttpServletRequest request) {
		Map<String, Object> success = new HashMap<String, Object>();
		FileUtil fileUtil = new FileUtil();
		
		try {
			fileUtil.fileSave(request);
			
			success.put("CODE", "00");
			success.put("MESSAGE", "SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
			
			success.put("CODE", "01");
			success.put("MESSAGE", "ERROR");
		}
		return success;
	}
	
	@RequestMapping(value = "/filedownload.json", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Map<String, Object> filedownload(@RequestParam String name, HttpServletResponse response) {
		FileUtil fileUtil = new FileUtil();
		
		return fileUtil.fileDownload(name, response);
	}
	
}
