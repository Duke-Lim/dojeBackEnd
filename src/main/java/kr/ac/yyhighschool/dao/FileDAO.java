package kr.ac.yyhighschool.dao;

import java.util.HashMap;
import java.util.List;

import kr.ac.yyhighschool.vo.FileVO;

public interface FileDAO {
	public int fileSave(HashMap<String, Object> reqMap);
	public List<FileVO> fileList(int post_id);
	public FileVO getFile(String name);
}
