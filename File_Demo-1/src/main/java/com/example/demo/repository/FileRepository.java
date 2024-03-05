package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.FileData;

public interface FileRepository extends JpaRepository<FileData, Long> {

		Optional<FileData> findByName(String name);
}
