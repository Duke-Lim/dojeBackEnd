package kr.ac.yyhighschool.service;

import java.util.HashMap;
import java.util.List;

import kr.ac.yyhighschool.vo.FileVO;

public interface FileService {
	public int fileSave(HashMap<String, Object> reqMap);
	public List<FileVO> fileList();
}
