package com.pgm.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pgm.bbs.dto.BoardVO;
import com.pgm.bbs.dto.Criteria;

public interface BoardMapper {
	public List<BoardVO> getList();
	public void insert(BoardVO board);
	public void insertSelectKey(BoardVO board);
	public BoardVO read(int bno);
	public void delete(int bno);
	public int update(BoardVO board);
	public void updateReadCount(int bno);
	public List<BoardVO> oraListPaging(Criteria cri);
	public int totalCount(Criteria cri);
	public void updateRepleCount(@Param("amount") int amount, @Param("bno") int bno);
}
