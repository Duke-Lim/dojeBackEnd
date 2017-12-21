package kr.ac.yyhighschool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.ac.yyhighschool.dao.FileDAO;
import kr.ac.yyhighschool.util.Utils;
import kr.ac.yyhighschool.vo.FileVO;

@Controller
@RequestMapping("/api")
public class FileController {
	
	@Inject
	private FileDAO fileDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

	@RequestMapping(value = "/file/{post_id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<FileVO> fileList(@PathVariable int post_id) {
		List<FileVO> list = fileDAO.fileList(post_id);
		
		logger.info(list.toString());
		
		return list;
	}
	
	@RequestMapping(value = "/file", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Map<String, Object> fileupload(MultipartHttpServletRequest request) {
		Map<String, Object> success = new HashMap<String, Object>();
		Utils utils = new Utils();
		
		try {
			List<HashMap<String, Object>> list = utils.fileSave(request);
			
			for (HashMap<String, Object> hashMap : list) {
				fileDAO.fileSave(hashMap);
			}
			
			success.put("CODE", "00");
			success.put("MESSAGE", "SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
			
			success.put("CODE", "01");
			success.put("MESSAGE", "ERROR");
		}
		return success;
	}
	
	@RequestMapping(value = "/file", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Map<String, Object> filedownload(@RequestParam int file_id, HttpServletResponse response) {
		Utils fileUtil = new Utils();
		FileVO fileVO = fileDAO.getFile(file_id);
		
		return fileUtil.fileDownload(file_id, fileVO, response);
	}
	
}
