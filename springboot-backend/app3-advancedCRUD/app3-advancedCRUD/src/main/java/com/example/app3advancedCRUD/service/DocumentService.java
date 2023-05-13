package com.example.app3advancedCRUD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app3advancedCRUD.repository.DocRepository;

@Service
public class DocumentService {
	
	@Autowired
	private DocRepository docRepository;
	
}
