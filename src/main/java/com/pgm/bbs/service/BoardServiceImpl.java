package com.pgm.bbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pgm.bbs.dto.BoardVO;
import com.pgm.bbs.dto.Criteria;
import com.pgm.bbs.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	private BoardMapper mapper;

	@Override
	public List<BoardVO> selectAll() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}

	@Override
	public void insert(BoardVO board) {
		// TODO Auto-generated method stub
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO selectOne(int bno) {
		// TODO Auto-generated method stub
		mapper.updateReadCount(bno);
		return mapper.read(bno);
	}

	@Override
	public void update(BoardVO board) {
		// TODO Auto-generated method stub
		mapper.update(board);
	}

	@Override
	public void delete(int bno) {
		// TODO Auto-generated method stub
		mapper.delete(bno);
	}

	@Override
	public List<BoardVO> selectAll(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.oraListPaging(cri);
	}

	@Override
	public int totalCount(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.totalCount(cri);
	}

}
