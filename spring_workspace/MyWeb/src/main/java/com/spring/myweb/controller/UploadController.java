package com.spring.myweb.controller;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/fileupload")
public class UploadController {
	@GetMapping("/upload")
	public void form() {}
	
	@PostMapping("/upload_ok")	
	public String upload(@RequestParam("file") MultipartFile file) {
		
		try {
			String fileRealname = file.getOriginalFilename(); // 파일정보
			Long size = file.getSize(); //파일 사이즈
			
			System.out.println("파일명:"+fileRealname);
			System.out.println("사이즈:"+size);
			
			UUID uuid = UUID.randomUUID();
			String[] uuids = uuid.toString().split("-");
			String uniqueName = uuids[0];
			
			//서버에서 저장할 파일 이름
			String fileExtension = fileRealname.substring(fileRealname.lastIndexOf("."),fileRealname.length());
			String uploadFolder = "C:\\test\\upload";
			
//			File savefile = new File(uploadFolder + "\\"+ fileRealname);
			File savefile = new File(uploadFolder + "\\"+ uniqueName+fileExtension);
			file.transferTo(savefile); // 실제 파일 저장 메서드(fileWriter 작업을 손쉽게 처리해줍니다.)
			
			System.out.println("생성된 고유 문자열 : "+uuids[0]);
			System.out.println("확장자:"+fileExtension);
		} catch (Exception e) {
			System.out.println("업로드 중 문제 발생!: "+e.getMessage());
		}
		
		
		
		
		
		return "fileupload/upload_ok";
	}
}
