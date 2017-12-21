package kr.ac.yyhighschool.serviceImpl;

import java.util.HashMap;
import java.util.List;

<<<<<<< HEAD
import javax.inject.Inject;

=======
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 47ecb6a7fbb8fa9dd05c71f03e881aee003435b0
import org.springframework.stereotype.Service;

import kr.ac.yyhighschool.dao.FileDAO;
import kr.ac.yyhighschool.service.FileService;
import kr.ac.yyhighschool.vo.FileVO;

@Service("fileService")
public class FileServiceImpl implements FileService {

<<<<<<< HEAD
	@Inject
=======
	@Autowired
>>>>>>> 47ecb6a7fbb8fa9dd05c71f03e881aee003435b0
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
<<<<<<< HEAD
	public FileVO getFile(int file_id) {
		return fileDAO.getFile(file_id);
	}
=======
	public FileVO getFile(String name) {
		return fileDAO.getFile(name);
	}

>>>>>>> 47ecb6a7fbb8fa9dd05c71f03e881aee003435b0
}
