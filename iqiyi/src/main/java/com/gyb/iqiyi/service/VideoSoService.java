package com.gyb.iqiyi.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

import org.apache.catalina.util.URLEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gyb.iqiyi.pojo.SoRespModel;
import com.gyb.iqiyi.pojo.SoVideoData;

@Service
public class VideoSoService implements IVideoSoService {
	private static String SO_API = "http://suggest.video.iqiyi.com/?key=";
	
	@Override
	public String seachVideo(String keyword) {
		URL url;
		StringBuilder sb = new StringBuilder();
		try {
			URLEncoder urlEncoder = new URLEncoder();
			String encode = urlEncoder.encode(keyword,Charset.forName("utf-8"));
			url = new URL(SO_API+encode);
			InputStream is = url.openStream();
			int n = 0; byte[] b = new byte[512];
			while((n=is.read(b))!=-1) {
				sb.append(new String(b,0,n));
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	@Override
	public SoRespModel searchVideo(String keyword) {
		URL url;
		SoRespModel soRespModel = null;
		try {
			URLEncoder urlEncoder = new URLEncoder();
			String encode = urlEncoder.encode(keyword,Charset.forName("utf-8"));
			url = new URL(SO_API+encode);
			InputStream is = url.openStream();
			ObjectMapper objectMapper = new ObjectMapper();
			soRespModel = objectMapper.readValue(is, SoRespModel.class);
			SoVideoData[] data = soRespModel.getData();
			ArrayList<SoVideoData> list = new ArrayList<SoVideoData>();
			for (SoVideoData soVideoData : data) { //去除无效数据
				if(soVideoData.getAid()!=0)
					list.add(soVideoData);
			}
			soRespModel.setData(list.toArray(new SoVideoData[list.size()]));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return soRespModel;
	}
	
	
}
