package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.FileData;
import com.example.demo.repository.FileRepository;

@Service
public class FileDataService {

	@Autowired
	private FileRepository fileRepository;
	
	private final String FOLDER_PATH="C:\\Users\\Nrupathunga\\Desktop\\My Files\\";
	
	public String uploadImage(MultipartFile file) throws IllegalStateException, IOException
	{
		String files=FOLDER_PATH+file.getOriginalFilename();
		FileData fileData=fileRepository.save(FileData.builder()
				.name(file.getOriginalFilename())
				 .type(file.getContentType())
				 .filePath(files).build());
		
		file.transferTo(new File(files));
		
		if(fileData!=null)
		{
			return "File Uploaded SuccessFully  "+fileData;
		}
		return null;
	}
	
	
	public byte[] downloadImage(String name) throws IOException
	{
		Optional<FileData> findByName = fileRepository.findByName(name);
		String filePath=findByName.get().getFilePath();
		byte [] images=Files.readAllBytes(new File(filePath).toPath());
		return images;
	}
	
}
