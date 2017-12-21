package kr.ac.yyhighschool.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Component("fileUpload")
public class FileUpload {

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
			
			list.add(map);
		}
		
		return list;
	}
	
	
}
