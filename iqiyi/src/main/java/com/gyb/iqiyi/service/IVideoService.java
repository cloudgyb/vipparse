package com.gyb.iqiyi.service;

import java.io.IOException;
import java.util.List;

import com.gyb.iqiyi.pojo.PageInfo;
import com.gyb.iqiyi.pojo.RespModel;
import com.gyb.iqiyi.pojo.VideoItem;

public interface IVideoService {
	
	public List<VideoItem> getVideoItemList() throws IOException;
	public PageInfo<VideoItem> getVideoItemList(int pageNum,int PageSize);
	
	public String getVideoDetail(String vid);
	public RespModel getVideoDetail(int vid);

}
