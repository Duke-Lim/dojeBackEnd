package kr.ac.yyhighschool.serviceImpl;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.ac.yyhighschool.dao.FileDAO;
import kr.ac.yyhighschool.service.FileService;
import kr.ac.yyhighschool.vo.FileVO;

@Service("fileService")
public class FileServiceImpl implements FileService {

	@Inject
	private FileDAO fileDAO;
	
	@Override
	public int fileSave(HashMap<String, Object> reqMap) {
		return fileDAO.fileSave(reqMap);
	}

	@Override
	public List<FileVO> fileList(int post_id) {
		return fileDAO.fileList(post_id);
	}

	@Override
	public FileVO getFile(int file_id) {
		return fileDAO.getFile(file_id);
	}
}
