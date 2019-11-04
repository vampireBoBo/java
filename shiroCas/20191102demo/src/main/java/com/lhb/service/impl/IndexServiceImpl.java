package com.lhb.service.impl;


import org.springframework.stereotype.Service;

import com.lhb.service.IndexService;
import lombok.extern.slf4j.Slf4j;
@Service("indexSer")
@Slf4j
public class IndexServiceImpl implements IndexService {

	public String getView() {
		String path = IndexServiceImpl.class.getClassLoader().getResource("/").getPath();
		log.info("service获取项目的根路径==="+path);
		return path;
	}

}
