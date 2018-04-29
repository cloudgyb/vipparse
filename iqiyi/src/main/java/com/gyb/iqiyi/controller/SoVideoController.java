package com.gyb.iqiyi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gyb.iqiyi.pojo.SoRespModel;
import com.gyb.iqiyi.service.IVideoSoService;

@RestController
@RequestMapping("/api")
public class SoVideoController {
	@Autowired
	private IVideoSoService videoSoService;
	
	@RequestMapping("/so")
	public SoRespModel soVideo(String kw) {
		SoRespModel searchVideo = videoSoService.searchVideo(kw);
		
		return searchVideo;
	}
}
