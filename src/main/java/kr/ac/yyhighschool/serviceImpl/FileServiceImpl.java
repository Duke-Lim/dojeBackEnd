package kr.ac.yyhighschool.serviceImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.yyhighschool.dao.FileDAO;
import kr.ac.yyhighschool.service.FileService;
import kr.ac.yyhighschool.vo.FileVO;

@Service("fileService")
public class FileServiceImpl implements FileService {

	@Autowired
	private FileDAO fileDAO;
	
	@Override
	public int fileSave(HashMap<String, Object> reqMap) {
		return fileDAO.fileSave(reqMap);
	}

	@Override
	public List<FileVO> fileList() {
		return fileDAO.fileList();
	}

}
