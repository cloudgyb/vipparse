package com.gyb.iqiyi.service;

import com.gyb.iqiyi.pojo.SoRespModel;

public interface IVideoSoService {
	public String seachVideo(String keyword);
	public SoRespModel searchVideo(String keyword);
}
