package com.future.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class test {

	private static final Logger logger=LoggerFactory.getLogger(test.class);
	public static void main(String[] args) {
		String seconds="1470278082980";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		System.out.println(sdf.format(new Date(Long.valueOf(seconds))));
	}


}
