package com.pgm.bbs.service;

import java.util.List;

import com.pgm.bbs.dto.RepleVO;

public interface RepleService {
	public void register(RepleVO reple);
	public List<RepleVO> getList(int bno);
	public void remove(int rno);

}
