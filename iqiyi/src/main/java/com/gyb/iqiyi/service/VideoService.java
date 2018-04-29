package com.gyb.iqiyi.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gyb.iqiyi.pojo.PageInfo;
import com.gyb.iqiyi.pojo.RespModel;
import com.gyb.iqiyi.pojo.VideoItem;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;
@Service
public class VideoService implements IVideoService {

	@Override
	public List<VideoItem> getVideoItemList() throws IOException {
		
		ArrayList<VideoItem> vlist = new ArrayList<VideoItem>();
		URL url = new URL("https://vip.iqiyi.com");
		Source source = new Source(url);
		List<Element> elements = source.getAllElementsByClass("site-piclist");
		System.out.println(elements.size());
		
		
		for (Element element : elements) {
			List<Element> liEle = element.getAllElements("li");
			for (Element lie : liEle) {
				VideoItem videoItem = new VideoItem();
				String tvid = lie.getAttributeValue("tvid");
				videoItem.setVid(tvid);
				List<Element> a_e = lie.getAllElementsByClass("site-piclist_pic_link");
				if(a_e.get(0)!=null) {
					String v_href = a_e.get(0).getAttributeValue("href");
					String v_name = a_e.get(0).getAttributeValue("title");
					Element v_img_e = a_e.get(0).getFirstElement("img");
					String v_img =v_img_e.getAttributeValue("data-src");
					videoItem.setHref(v_href);
					videoItem.setImg(v_img);
					videoItem.setName(v_name);
				}
				List<Element> score_e = lie.getAllElementsByClass("score");
				Element s_e = score_e.get(0);
				if(s_e!=null) {
					Element num_e = s_e.getFirstElementByClass("num");
					if(num_e!=null) {
						String num_gewei = num_e.getContent().toString();
						videoItem.setScore_unit(num_gewei);
					}
					String num_xiaoshu = s_e.getTextExtractor().toString();
					videoItem.setScore_decimal(num_xiaoshu);
				}
				Element desc_e = lie.getFirstElementByClass("site-piclist_info_describe");
				if(desc_e!=null) {
					String v_desc = desc_e.getContent().toString();
					videoItem.setDesc(v_desc);
				}
				vlist.add(videoItem);
			}
			System.out.println(liEle.size());
		}
		for (VideoItem list : vlist) {
			System.out.println(list);
		}
		/*if(vlist.get(0)!=null) {
			VideoItem vi = vlist.get(0);
			String img = vi.getImg();
			String newImg = img.replaceAll("480_270","180_236");
			vi.setImg(newImg);
		}*/
		return vlist;
	}

	@Override
	public String getVideoDetail(String vid) {
		String apiurl = "http://pcw-api.iqiyi.com/video/video/videoinfowithuser/";
		try {
			URL url = new URL(apiurl+vid);
			InputStream is = url.openStream();
			byte[] b = new byte[512]; int n;
			while((n = is.read(b))!=-1) {
				System.err.println(new String(b,0,n));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public RespModel getVideoDetail(int vid) {
		String apiurl = "http://pcw-api.iqiyi.com/video/video/videoinfowithuser/";
		try {
			URL url = new URL(apiurl+vid);
			InputStream is = url.openStream();
			ObjectMapper mapper = new ObjectMapper();
			RespModel VD = mapper.readValue(is, RespModel.class);
			return VD;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PageInfo<VideoItem> getVideoItemList(int pageNum, int pageSize) {
		try {
			List<VideoItem> vlist = getVideoItemList();
			PageInfo<VideoItem> pageInfo = new PageInfo<VideoItem>();
			pageInfo.setCurrPageNum(pageNum);
			pageInfo.setPageSize(pageSize);
			pageInfo.setTotal(vlist.size());
			pageInfo.setTotalPage((int)(Math.ceil((double)vlist.size()/pageSize)));
			if(pageNum>pageInfo.getTotalPage()) {
				pageNum = 1;
				pageInfo.setCurrPageNum(pageNum);
			}
			int fromIndex = (pageNum-1)*pageSize;
			int toIndex = pageNum*pageSize;
			if(pageSize>=vlist.size()||pageNum*pageSize>vlist.size())
				toIndex = vlist.size();
				
			pageInfo.setData(vlist.subList(fromIndex,toIndex ));
			return pageInfo;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
