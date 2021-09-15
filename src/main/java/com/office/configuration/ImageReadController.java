package com.office.configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImageReadController {
	String uploadProductDirectory = System.getProperty("user.dir") + "/uploads/documents/";
	//String uploadBannerDirectory = System.getProperty("user.dir") + "/uploads/banner/";

	@RequestMapping("/uploads/documents/{documentFile}")
	public String geBooktProductImage(@PathVariable("documentFile") String documentFile, HttpServletResponse response) {
		try {
			byte b[] = Files.readAllBytes(Paths.get(uploadProductDirectory + documentFile));
			response.setContentLength(b.length);
			response.setContentType("application/pdf");
			ServletOutputStream os = response.getOutputStream();
			os.write(b);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	/*
	 * @RequestMapping("/uploads/banner/{bannerImage}") public String
	 * getBannerImage(@PathVariable("bannerImage") String bannerImage,
	 * HttpServletResponse response) { try { byte b[] =
	 * Files.readAllBytes(Paths.get(uploadBannerDirectory + bannerImage));
	 * response.setContentLength(b.length); response.setContentType("image/jpg");
	 * ServletOutputStream os = response.getOutputStream(); os.write(b); os.flush();
	 * } catch (IOException e) { e.printStackTrace(); } return null;
	 * 
	 * }
	 */
}
