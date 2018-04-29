package com.gyb.iqiyi.pojo;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
public class SoRespModel {
	private String code;
	private SoVideoData[] data;

	public SoRespModel() {
	}

	public SoRespModel(String code, SoVideoData[] data) {
		super();
		this.code = code;
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public SoVideoData[] getData() {
		return data;
	}

	public void setData(SoVideoData[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "SoRespModel [code=" + code + ", data=" + Arrays.toString(data) + "]";
	}
	
}
