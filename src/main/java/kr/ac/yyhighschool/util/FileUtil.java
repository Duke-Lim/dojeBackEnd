package kr.ac.yyhighschool.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.ac.yyhighschool.dao.FileDAO;
import kr.ac.yyhighschool.vo.FileVO;

@Component("fileUtil")
public class FileUtil {

	@Autowired
	private FileDAO fileDAO;
	
	public static final String filePath = "/Users/LimDongGuk/Documents/FileStorage/";
	
	public List<HashMap<String, Object>> fileSave(MultipartHttpServletRequest request) {
		Iterator<String> iterator = request.getFileNames();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		MultipartFile multipartFile = null;
		String file_name = null;
		String fake_file_name = null;
		String extension = null;
		String user_id = request.getParameter("user_id");
		int post_id = Integer.parseInt(request.getParameter("post_id"));
		
		File file = new File(filePath);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		while (iterator.hasNext()) {
			multipartFile = request.getFile(iterator.next());
			file_name = multipartFile.getOriginalFilename();
			HashMap<String, Object> map = new HashMap<String, Object>();
			UUID uuid = UUID.randomUUID();
			
			extension = file_name.substring(file_name.lastIndexOf(".")+1, file_name.length());
			fake_file_name = uuid.toString() +"."+ extension;
			
			file = new File(filePath + fake_file_name);
			try {
				multipartFile.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			map.put("POST_ID", post_id);
			map.put("USER_ID", user_id);
			map.put("FILE_NAME", file_name);
			map.put("FAKE_FILE_NAME", fake_file_name);
			map.put("FILE_SIZE", multipartFile.getSize());
			
			fileDAO.fileSave(map);
			list.add(map);
		}
		
		return list;
	}
	
	public Map<String, Object> fileDownload(String name, HttpServletResponse response) {
		Map<String, Object> success = new HashMap<String, Object>();
		
		FileVO fileVO = fileDAO.getFile(name);
		
		try {
			byte fileByte[] = FileUtils.readFileToByteArray(new File(filePath + name));
			
			response.setContentType("application/cotet-stream");
			response.setContentLength(fileByte.length);
			response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(fileVO.getFile_name(), "UTF-8")+"\";");
			response.getOutputStream().write(fileByte);
			
			success.put("CODE", "00");
			success.put("MESSAGE", "SUCCESS");
		} catch (IOException e) {
			e.printStackTrace();
			
			success.put("CODE", "01");
			success.put("MESSAGE", "ERROR");
		} finally {
			try {
				response.getOutputStream().flush();
				response.getOutputStream().close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return success;
	}
	
}
