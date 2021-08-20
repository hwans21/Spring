package com.spring.myweb.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.myweb.command.MultiUploadVO;
import com.spring.myweb.command.UploadVO;

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
			
			//파일 업로드 시 파일명이 동일한 파일이 존재할 수도 있고,
			//사용자가 업로드 하는 파일명이 한글인 경우도 있습니다.
			//한글들 지원하지 않는 환경일 수도 있잖아요.(리눅스)
			//고유한 랜덤 문자를 통해 DB와 서버에 저장할 파일명을 새로 만들어 줍니다.
			
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
	
	@PostMapping("/upload_ok2")
	public String upload2(MultipartHttpServletRequest files) {
		String uploadFolder = "C:\\test\\upload";
		
		try {
			List<MultipartFile> list = files.getFiles("files");
//			for(int i=0;i<list.size();i++) {
//				String fileRealname = list.get(i).getOriginalFilename();
//				Long size = list.get(i).getSize(); //파일 사이즈
//				
//				System.out.println("파일명:"+fileRealname);
//				System.out.println("사이즈:"+size);
//				
//				File saveFile = new File(uploadFolder + "\\" + fileRealname);
//				list.get(i).transferTo(saveFile);
//			}
			for(MultipartFile m : list) {
				String fileRealname = m.getOriginalFilename();
				Long size = m.getSize(); //파일 사이즈
				
				System.out.println("파일명:"+fileRealname);
				System.out.println("사이즈:"+size);
				
				File saveFile = new File(uploadFolder + "\\" + fileRealname);
				m.transferTo(saveFile);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("업로드 중 문제 발생!: "+e.getMessage());
		}
		
		
		return "fileupload/upload_ok";
	}
	
	@PostMapping("/upload_ok3")
	public String upload3(@RequestParam("file") List<MultipartFile> list) {
		String uploadFolder = "C:\\test\\upload";
		
		try {
//			for(int i=0;i<list.size();i++) {
//				String fileRealname = list.get(i).getOriginalFilename();
//				Long size = list.get(i).getSize(); //파일 사이즈
//				
//				System.out.println("파일명:"+fileRealname);
//				System.out.println("사이즈:"+size);
//				
//				File saveFile = new File(uploadFolder + "\\" + fileRealname);
//				list.get(i).transferTo(saveFile);
//			}
			for(MultipartFile m : list) {
				String fileRealname = m.getOriginalFilename();
				Long size = m.getSize(); //파일 사이즈
				
				System.out.println("파일명:"+fileRealname);
				System.out.println("사이즈:"+size);
				
				File saveFile = new File(uploadFolder + "\\" + fileRealname);
				m.transferTo(saveFile);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("업로드 중 문제 발생!: "+e.getMessage());
		}
		
		return "fileupload/upload_ok";
	}
	
	@PostMapping("/upload_ok4")
	public String upload4(MultiUploadVO vo) {
		System.out.println(vo);
		String uploadFolder = "C:\\test\\upload";
		List<UploadVO> list = vo.getList();
		try {
			for(UploadVO up : list) {
				System.out.println(up.getFile().getName());
				System.out.println(up.getFile().getSize());
				
				String fileRealname = up.getFile().getOriginalFilename();
				Long size = up.getFile().getSize(); //파일 사이즈
				
				System.out.println("파일명:"+fileRealname);
				System.out.println("사이즈:"+size);
				
				File saveFile = new File(uploadFolder + "\\" + fileRealname);
				up.getFile().transferTo(saveFile);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return "fileupload/upload_ok";
	}
	
	
}
