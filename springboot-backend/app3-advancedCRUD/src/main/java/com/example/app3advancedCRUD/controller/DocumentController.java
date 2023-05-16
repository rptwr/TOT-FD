package com.example.app3advancedCRUD.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.app3advancedCRUD.models.Employee;
import com.example.app3advancedCRUD.service.DocumentService;


@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/api/v1/employees")
public class DocumentController {
	@Autowired
	private DocumentService documentService;
	private ResponseEntity<Employee> addDocuments;

	/**
	 * http://localhost:9090/api/v1/employees/documents/add-documents/8
	 * @param id
	 * @param files
	 * @return
	 */
	@PostMapping("/documents/add-documents/{id}")
	public ResponseEntity<Employee> addDocuments( @RequestBody List<MultipartFile> files, @PathVariable Long id) {
		try {
			addDocuments = documentService.addDocuments(id, files);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
		return addDocuments;
	}
}
