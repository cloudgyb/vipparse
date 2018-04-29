package com.gyb.iqiyi;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.catalina.util.URLEncoder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gyb.iqiyi.pojo.SoRespModel;
import com.gyb.iqiyi.service.VideoSoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IqiyiApplicationTests {

	/*@Test
	public void contextLoads() {
		new VideoService().getVideoDetail("733555300");
	}
	*/
	
	@Test
	public void soTest() {
		URL url;
		try {
			URLEncoder urlEncoder = new URLEncoder();
			@SuppressWarnings("deprecation")
			String encode = urlEncoder.encode("唐人街探案");
			url = new URL("http://suggest.video.iqiyi.com/?key="+encode);
			InputStream is = url.openStream();
			int n = 0; byte[] b = new byte[512];
			while((n=is.read(b))!=-1) {
				System.out.println(new String(b,0,n));
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void soTest1() {
		 SoRespModel searchVideo = new VideoSoService().searchVideo("唐人街探案");
		 System.out.println(searchVideo);
	}
}
