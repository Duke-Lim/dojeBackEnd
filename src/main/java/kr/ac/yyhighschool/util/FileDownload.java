package kr.ac.yyhighschool.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class FileDownload extends AbstractView {

	public FileDownload() {
		this.setContentType("apllication/download; charset=UTF-8");
	}
	
	
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> reqMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		File file = (File) reqMap.get("downloadFile");

		response.setContentType(this.getContentType());
		response.setContentLength((int) file.length());
		response.setHeader("Content-Disposition", "attachment; filename=\"" + java.net.URLEncoder.encode(file.getName(), "UTF-8") + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");

		OutputStream outputStream = response.getOutputStream();
		FileInputStream inputStream = null;
		
		try {
			inputStream = new FileInputStream(file);
			FileCopyUtils.copy(inputStream, outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
		outputStream.flush();
	}

}
