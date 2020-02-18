package com.pgm.bbs.mapper;

import java.util.List;

import com.pgm.bbs.dto.RepleVO;

public interface RepleMapper {
	public List<RepleVO> getList(int bno);
	public void insert(RepleVO reple);
	public void delete(int rno);
	public RepleVO getReple(int rno);
}
