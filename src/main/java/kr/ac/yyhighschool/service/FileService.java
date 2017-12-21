package kr.ac.yyhighschool.service;

import java.util.HashMap;
import java.util.List;

import kr.ac.yyhighschool.vo.FileVO;

public interface FileService {
	public int fileSave(HashMap<String, Object> reqMap);
	public List<FileVO> fileList(int post_id);
<<<<<<< HEAD
	public FileVO getFile(int file_id);
=======
	public FileVO getFile(String name);
>>>>>>> 47ecb6a7fbb8fa9dd05c71f03e881aee003435b0
}
