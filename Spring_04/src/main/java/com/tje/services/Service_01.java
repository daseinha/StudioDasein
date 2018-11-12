package com.tje.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tje.repository.*;

@Service
public class Service_01 {
	
	@Autowired
	private DAO_01 dao;

	public Object service() {
		String result = dao.select();
		return result;
	}
	
}
