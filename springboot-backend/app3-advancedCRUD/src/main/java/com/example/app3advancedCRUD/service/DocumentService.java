package com.example.app3advancedCRUD.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.coyote.Response;
import org.hibernate.engine.jdbc.ClobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.app3advancedCRUD.models.Document;
import com.example.app3advancedCRUD.models.Employee;
import com.example.app3advancedCRUD.repository.DocumentRepository;
import com.example.app3advancedCRUD.repository.EmployeeRepository;

@Service
public class DocumentService {

	@Autowired
	private DocumentRepository documentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	public ResponseEntity<Employee> addDocuments(long id, List<MultipartFile> files) throws Exception {
		Employee employee = new Employee();
		employee = employeeRepository.findById(id).get();
		ArrayList<Document> doc = new ArrayList<>();
		doc.addAll(employee.getDocuments());
		for (MultipartFile file : files) {
			String name = employee.getId() + "-" + file.getOriginalFilename();
			Document document = new Document();
			document.setName(name);
			byte[] bytes = file.getBytes();
			FileOutputStream fout = new FileOutputStream("src\\main\\resources\\uploads\\" + name);
			fout.write(bytes);
//			documentRepository.save(document);
			doc.add(document);
		}
		documentRepository.saveAll(doc);
		employee.setDocuments(doc);
		employeeRepository.save(employee);
		return ResponseEntity.ok(employee);
	}

}