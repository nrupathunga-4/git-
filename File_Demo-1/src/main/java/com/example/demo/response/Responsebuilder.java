package com.example.demo.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Responsebuilder {

	public static ResponseEntity<Object> responseHandler(String status,HttpStatus statusCode,String data)
	{
        Map<String, Object> map=new HashMap<>();
        map.put("status", status);
        map.put("statusCode", statusCode.value());
        map.put("data", data);
		return new ResponseEntity<>(map,statusCode);
	}
	
}
