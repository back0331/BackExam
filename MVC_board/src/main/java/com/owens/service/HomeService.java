package com.owens.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owens.dao.HomeDAO;
import com.owens.vo.HomeVO;

public class HomeService {
	Logger log = Logger.getLogger(this.getClass());
	
	private HomeDAO dao;

	public void setDao(HomeDAO dao) {
		this.dao = dao;
	}

	public List<HomeVO> selectBoardList() {
		// TODO Auto-generated method stub
		return dao.selectBoardList();
	}

}
