package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.response.Responsebuilder;
import com.example.demo.service.FileDataService;

@RestController
@RequestMapping("/file")
public class FileController {

	@Autowired
	private FileDataService service;

	@PostMapping
	public ResponseEntity<Object> uploadImage(@RequestParam("image") MultipartFile file) throws IOException
	{
		String image = service.uploadImage(file);
		return Responsebuilder.responseHandler("Success", HttpStatus.OK, image);
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<?> downloadImage(@PathVariable String name) throws IOException
	{
		byte[] image = service.downloadImage(name);
		return ResponseEntity.status(HttpStatus.OK.value())
				.contentType(MediaType.valueOf("image/png"))
				.body(image);
	}
	
}
