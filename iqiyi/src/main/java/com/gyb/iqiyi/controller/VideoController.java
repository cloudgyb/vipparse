package com.gyb.iqiyi.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gyb.iqiyi.pojo.PageInfo;
import com.gyb.iqiyi.pojo.RespModel;
import com.gyb.iqiyi.pojo.VideoItem;
import com.gyb.iqiyi.service.IVideoService;

@RestController
@RequestMapping("/api")
public class VideoController {
	@Autowired
	private IVideoService videoService;
	
	@RequestMapping("/video/list")
	public List<VideoItem> getVideoList(){
		try {
			return videoService.getVideoItemList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/video/list/{pageSize}/{pageNum}")
	public PageInfo<VideoItem> getVideItemListByPage(@PathVariable int pageNum,@PathVariable int pageSize){
		return videoService.getVideoItemList(pageNum, pageSize);
	}
	
	@RequestMapping("/video/detail/{vid}")
	public RespModel getVideoDetail(@PathVariable int vid) {
		
		return videoService.getVideoDetail(vid);
	}
	
	
}
