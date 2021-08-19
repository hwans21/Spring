package com.spring.myweb.util.interceptor;

public class BoardAuthHandler {
	// 화면에서 수정, 삭제가 일어날 때, writer값을 넘겨주도록 처리
	// 게시글 수정, 삭제에 대한 권한 처리 핸들러
	// 세션값과 writer(작성자) 정보가 같다면 컨트롤러를 실행,
	// 그렇지 않다면 '권한이 없습니다.' 출력
	// 권한이 없습니다 경고창은 jsp에서 했었던 PrintWriter 객체를 이용하시면 됩니다.
	// PrintWriter 객체는 response 객체에게 받아옵니다.
}
