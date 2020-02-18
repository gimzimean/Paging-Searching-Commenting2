package com.pgm.bbs.service;

import java.util.List;
import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pgm.bbs.dto.RepleVO;
import com.pgm.bbs.mapper.BoardMapper;
import com.pgm.bbs.mapper.RepleMapper;

@Service
public class RepleServiceImpl implements RepleService {
	@Inject
	private RepleMapper repleMapper;
	@Inject
	private BoardMapper boardMapper;
	
	@Transactional
	@Override
	public void register(RepleVO reple) {
		// TODO Auto-generated method stub
		System.out.println("service"+reple);
		boardMapper.updateRepleCount(1, reple.getBno());
		repleMapper.insert(reple);
	}

	@Override
	public List<RepleVO> getList(int bno) {
		// TODO Auto-generated method stub
		return repleMapper.getList(bno);
	}
	
	@Transactional
	@Override
	public void remove(int rno) {
		// TODO Auto-generated method stub
		RepleVO reple=repleMapper.getReple(rno);
		boardMapper.updateRepleCount(-1, reple.getBno());
		repleMapper.delete(rno);

	}

}
