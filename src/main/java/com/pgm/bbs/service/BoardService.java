package com.pgm.bbs.service;

import java.util.List;

import com.pgm.bbs.dto.BoardVO;
import com.pgm.bbs.dto.Criteria;

public interface BoardService {
	public List<BoardVO> selectAll();
	public void insert(BoardVO board);
	public BoardVO selectOne(int bno);
	public void update(BoardVO board);
	public void delete(int bno);
	public List<BoardVO> selectAll(Criteria cri);
	public int totalCount(Criteria cri);
}
