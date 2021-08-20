package com.spring.myweb.controller;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.myweb.command.SnsBoardVO;
import com.spring.myweb.command.UserVO;
import com.spring.myweb.snsboard.service.ISnsBoardService;

@Controller
@RequestMapping("/snsBoard")
public class SnsBoardController {
	
	@Autowired
	private ISnsBoardService service;
	
	@GetMapping("/snsList")
	public void snsList() {
		
	}
	
	@PostMapping("/upload")
	@ResponseBody
	public String upload(@RequestParam("file") MultipartFile file, 
			@RequestParam("content") String content,
			HttpSession session) {
		try {
			String writer = ((UserVO) session.getAttribute("login")).getUserId();
			
			//날짜별로 폴더를 생성해서 파일을 관리.
			SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");
			Date date = new Date();
			String fileLoca = sdf.format(date);
			
			//저장할 폴더 경로
			String uploadPath = "C:\\Users\\hwans\\Desktop\\upload\\"+fileLoca;
			
			File folder = new File(uploadPath);
			if(!folder.exists()) {
				folder.mkdir(); //폴더가 존재하지 않는다면 생성해라.
			}
			
			//서버에서 저장할 파일 이름
			String fileRealName = file.getOriginalFilename();
			long size = file.getSize();
			
			//파일명을 고유한 랜덤문자로 작성
			UUID uuid = UUID.randomUUID();
			String uuids = uuid.toString().replace("-", "");
			
			//확장자
			String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());			
			System.out.println("저장할 폴더: "+uploadPath);
			System.out.println("실제 파일명: "+fileRealName);
			System.out.println("사이즈: "+size);
			System.out.println("폴더명d: "+fileLoca);
			System.out.println("uuid: "+fileExtension);
			System.out.println("uuid: "+uuids);
			
			String fileName = uuids + fileExtension;
			System.out.println("변경해서 저장할 파일명: "+fileName);
			
			//업로드한 파일을 서버 컴퓨터의 지정한 경로 내에 실제로 저장
			File saveFile = new File(uploadPath+"\\"+fileName);
			file.transferTo(saveFile);
			
			//DB에 insert작업을 진행
			SnsBoardVO snsVO = new SnsBoardVO(0,writer,uploadPath,fileLoca,fileName,fileRealName, content, null);
			service.insert(snsVO);
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("업로드 중 에러 발생 : "+e.getMessage());
			
			return "fail"; // 에러가 났을 시 실패 키워드를 반환
		}
		
	}
	
	@GetMapping("/getList")
	@ResponseBody
	public List<SnsBoardVO> getList(){
		return service.getList();
	}
	
	//ResponseEntity: 응답으로 변환될 정보를 모두 담은 요소들을 객체로 만들어서 반환해줍니다.
	
	@GetMapping("/display")
	public ResponseEntity<byte[]> getFile(@RequestParam("fileLoca") String fileLoca,
										@RequestParam("fileName") String fileName){
		System.out.println("fileName: "+fileName);
		System.out.println("fileLoca: "+fileLoca);
		File file = new File("C:\\Users\\hwans\\Desktop\\upload\\"+fileLoca+"\\"+fileName);
		
		System.out.println(file);
		
		ResponseEntity<byte[]> result = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			//probeContentType: 파라미터로 전달받은 파일의 타입을 문자열로 반환해 주는 메서드
			//사용자에게 보여주고자 하는 데이터가 어떤 파일인지를 검사해서 응답상태 코드를 다르게 리턴할 수도 있습니다.
			headers.add("Content-Type", Files.probeContentType(file.toPath()));
			//ResponseEntity<>(바디에 담을내용, 헤더에 담을 내용, 상태메세지)
			//FileCopyUtils: 파일 및 스트림 복사를 위한 간단한 유틸리티 메서드의 집합체
			//file객체 안에 있는 내용을 복사해서 byte배열 형태로 바디에 담아서 전달.
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.OK);
					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	//상세보기 처리
	@GetMapping("/getDetail/{bno}")
	@ResponseBody
	public SnsBoardVO getDetail(@PathVariable int bno) {
		return service.getDetail(bno);
	}
}
