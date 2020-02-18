package com.pgm.bbs.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pgm.bbs.dto.RepleVO;
import com.pgm.bbs.service.RepleService;

@RestController
@RequestMapping("/reply/*")
public class RepleController {
	@Inject
	RepleService service;
	
	@ResponseBody
	@PostMapping(value="/insert.do")
	public ResponseEntity<String> inset(@RequestBody RepleVO reple) {
		ResponseEntity<String> entity=null;
		System.out.println(reple);
		try {
			service.register(reple);
			entity=new ResponseEntity<String>("success", HttpStatus.OK);
			
			System.out.println("AAAAAAAAAAAA");
		}catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<String>(
					e.getMessage(),HttpStatus.BAD_REQUEST);
			System.out.println("BBBBBBBBBBBBBBB");
		}
		System.out.println(entity);
		return entity;
	}
	
	@GetMapping("list.do")
	public List<RepleVO> listJson(@RequestParam("bno") int bno){
		List<RepleVO> list=service.getList(bno);
		return list;
	}
	
	@DeleteMapping("delete.do")
	public ResponseEntity<String> delete(@RequestParam("rno") int rno) {
		ResponseEntity<String> entity=null;
		try {
			service.remove(rno);
			entity=new ResponseEntity<String>("success", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<String>(
					e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	

}
