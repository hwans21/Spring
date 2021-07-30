<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp" %>
<style>
header.masthead {
	background-image: url('/img/introduce/introduce.jpg');
}	
.intro-table {
	background-color:#FFFFFF;
	width: 100%;
	border: 2px solid #23C293;
}
.intro-tr {
	width: 100%;
	border: .8px solid gray;	
}
td > span {
	padding: 1px 3px;
}
</style>
<!-- Member Grid -->
<div class="container">
  <section class="bg-light" id="portfolio" style="padding-top: 90px; padding-bottom: 0;">
    <div class="container">
      
	  
      <div class="row">
        <div class="col-md-4 col-sm-6 portfolio-item">
          <a class="portfolio-link" data-toggle="modal" href="#KwonEunBi">
            <div class="portfolio-hover">
              <div class="portfolio-hover-content">
              </div>
            </div>
            <img class="img-thumbnail img-fluid" src="<c:url value='/img/introduce/keb.jpg'/>" alt="">
          </a>
          <div class="portfolio-caption">
            <h4>권은비</h4>
            <p class="text-muted">리더, 리드보컬, 메인댄서</p>
          </div>
        </div>
        <div class="col-md-4 col-sm-6 portfolio-item">
          <a class="portfolio-link" data-toggle="modal" href="#sakura">            
          <div class="portfolio-hover">
              <div class="portfolio-hover-content">
              </div>
           </div>
            <img class="img-thumbnail img-fluid" src="<c:url value='/img/introduce/sakura.jpg'/>" alt="">
          </a>
          <div class="portfolio-caption">
            <h4>미야와키 사쿠라</h4>
            <p class="text-muted">서브보컬</p>
          </div>
        </div>
        <div class="col-md-4 col-sm-6 portfolio-item">
          <a class="portfolio-link" data-toggle="modal" href="#KangHyeWon">   
            <div class="portfolio-hover">
              <div class="portfolio-hover-content">
              </div>
            </div>         
            <img class="img-thumbnail img-fluid" src="<c:url value='/img/introduce/khw.jpg'/>" alt="">
          </a>
          <div class="portfolio-caption">
            <h4>강혜원</h4>
            <p class="text-muted">리드래퍼, 서브보컬</p>
          </div>
        </div>
        <div class="col-md-4 col-sm-6 portfolio-item">
          <a class="portfolio-link" data-toggle="modal" href="#ChoiYeNa">  
            <div class="portfolio-hover">
              <div class="portfolio-hover-content">
              </div>
            </div>          
            <img class="img-thumbnail img-fluid" src="<c:url value='/img/introduce/cyn.jpg'/>" alt="">
          </a>
          <div class="portfolio-caption">
            <h4>최예나</h4>
            <p class="text-muted">메인래퍼, 리드보컬, 리드댄서</p>
          </div>
        </div>
        <div class="col-md-4 col-sm-6 portfolio-item">
          <a class="portfolio-link" data-toggle="modal" href="#LeeChaeYeon"> 
            <div class="portfolio-hover">
              <div class="portfolio-hover-content">
              </div>
            </div>           
            <img class="img-thumbnail img-fluid" src="<c:url value='/img/introduce/lcy.jpg'/>" alt="">
          </a>
          <div class="portfolio-caption">
            <h4>이채연</h4>
            <p class="text-muted">리드보컬 메인댄서</p>
          </div>
        </div>
        <div class="col-md-4 col-sm-6 portfolio-item">
          <a class="portfolio-link" data-toggle="modal" href="#KimChaeWon">     
            <div class="portfolio-hover">
              <div class="portfolio-hover-content">
              </div>
            </div>      
            <img class="img-thumbnail img-fluid" src="<c:url value='/img/introduce/kcw.jpg'/>" alt="">
          </a>
          <div class="portfolio-caption">
            <h4>김채원</h4>
            <p class="text-muted">리드보컬</p>
          </div>
        </div>
        <div class="col-md-4 col-sm-6 portfolio-item">
          <a class="portfolio-link" data-toggle="modal" href="#KimMinJu"> 
            <div class="portfolio-hover">
              <div class="portfolio-hover-content">
              </div>
            </div>           
            <img class="img-thumbnail img-fluid" src="<c:url value='/img/introduce/kmj.jpg'/>" alt="">
          </a>
          <div class="portfolio-caption">
            <h4>김민주</h4>
            <p class="text-muted">서브보컬, 서브래퍼</p>
          </div>
        </div>
        <div class="col-md-4 col-sm-6 portfolio-item">
          <a class="portfolio-link" data-toggle="modal" href="#nako">   
            <div class="portfolio-hover">
              <div class="portfolio-hover-content">
              </div>
            </div>         
            <img class="img-thumbnail img-fluid" src="<c:url value='/img/introduce/nako.jpg'/>" alt="">
          </a>
          <div class="portfolio-caption">
            <h4>야부키 나코</h4>
            <p class="text-muted">서브보컬</p>
          </div>
        </div>
        <div class="col-md-4 col-sm-6 portfolio-item">
          <a class="portfolio-link" data-toggle="modal" href="#hitomi">
            <div class="portfolio-hover">
              <div class="portfolio-hover-content">
              </div>
            </div>            
            <img class="img-thumbnail img-fluid" src="<c:url value='/img/introduce/hitomi.jpg'/>" alt="">
          </a>
          <div class="portfolio-caption">
            <h4>혼다 히토미</h4>
            <p class="text-muted">서브보컬</p>
          </div>
        </div>
        <div class="col-md-4 col-sm-6 portfolio-item">
          <a class="portfolio-link" data-toggle="modal" href="#ChoYuRi">  
            <div class="portfolio-hover">
              <div class="portfolio-hover-content">
              </div>
            </div>          
            <img class="img-thumbnail img-fluid" src="<c:url value='/img/introduce/jyr.jpg'/>" alt="">
          </a>
          <div class="portfolio-caption">
            <h4>조유리</h4>
            <p class="text-muted">메인보컬</p>
          </div>
        </div>
        <div class="col-md-4 col-sm-6 portfolio-item">
          <a class="portfolio-link" data-toggle="modal" href="#AhnYuJin">
            <div class="portfolio-hover">
              <div class="portfolio-hover-content">
              </div>
            </div>            
            <img class="img-thumbnail img-fluid" src="<c:url value='/img/introduce/ayj.jpg'/>" alt="">
          </a>
          <div class="portfolio-caption">
            <h4>안유진</h4>
            <p class="text-muted">리드보컬</p>
          </div>
        </div>
        <div class="col-md-4 col-sm-6 portfolio-item">
          <a class="portfolio-link" data-toggle="modal" href="#JangWonYoung"> 
            <div class="portfolio-hover">
              <div class="portfolio-hover-content">
              </div>
            </div>           
            <img class="img-thumbnail img-fluid" src="<c:url value='/img/introduce/jwy.jpg'/>" alt="">
          </a>
          <div class="portfolio-caption">
            <h4>장원영</h4>
            <p class="text-muted">센터, 서브보컬</p>
          </div>
        </div>
      </div>
    </div>
  </section>

</div> 
<!-- Modal Kwon Eun-Bi -->
  <div class="modal fade" id="KwonEunBi">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">권은비(Kwon Eun-bi)</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <div class="table-center">
        	<table class="intro-table">
        		<tr class="intro-tr">
        			<td colspan="2">
        				<img class="img-fluid" src="<c:url value='/img/introduce/keb_modal.jpg'/>" alt="" width="100%">
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">이름</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>권은비 (Kwon Eun-Bi, 權恩妃, クォン・ウンビ)</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">출생</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>1995년 9월 27일(24세)</span><br>
        				<span>서울특별시 금천구 시흥동</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">국적</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>대한민국</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">소속사</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>울림엔터테인먼트</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">포지션</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>리더, 리드보컬, 메인댄서</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">데뷔</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>2014년 예아(Ye-A) 싱글 앨범 1집 <National Treasure></span>
        			</td>
        		</tr>
        	</table>
        </div>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
      </div>
     </div>
    </div>
   </div>

  <!-- Modal Miyawaki Sakura -->
  <div class="modal fade" id="sakura">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">미야와키 사쿠라(Miyawaki Sakura)</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <div class="table-center">
        	<table class="intro-table">
        		<tr class="intro-tr">
        			<td colspan="2">
        				<img class="img-fluid" src="<c:url value='/img/introduce/sakura_modal.jpg'/>" alt="" width="100%">
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">이름</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span><ruby><rb>宮脇</rb><rt>みやわき</rt></ruby><ruby>&nbsp;<rb>咲良</rb><rt>さくら</rt></ruby> (미야와키 사쿠라, Miyawaki Sakura)</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">출생</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>1998년 3월 19일 (22세)</span><br>
        				<span>일본 가고시마현 가고시마시</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">국적</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>일본</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">소속사</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>AKS</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">포지션</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>서브보컬</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">데뷔</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>2011년 HKT48 공연 &lt;손을 잡으며&gt;</span>
        			</td>
        		</tr>
        	</table>
        </div>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
      </div>
     </div>
    </div>
   </div>

  <!-- Modal Kang Hye-won -->
  <div class="modal fade" id="KangHyeWon">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">강혜원 (Kang Hye Won)</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <div class="table-center">
        	<table class="intro-table">
        		<tr class="intro-tr">
        			<td colspan="2">
        				<img class="img-fluid" src="<c:url value='/img/introduce/hyewon_modal.jpg'/>" alt="" width="100%">
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">이름</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>강혜원 (Kang Hye Won, 姜惠元, カン・へウォン)</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">출생</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>1999년 7월 5일 (20세)</span><br>
        				<span>경상남도 양산시</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">국적</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>대한민국</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">소속사</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>에잇디 크리에이티브</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">포지션</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>리드래퍼, 서브보컬</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">데뷔</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>2018년 IZ*ONE 미니 앨범 1집 &lt;COLOR*IZ&gt;</span>
        			</td>
        		</tr>
        	</table>
        </div>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
      </div>
     </div>
    </div>
   </div>
	
  <!-- Modal Choi Ye-na -->
  <div class="modal fade" id="ChoiYeNa">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">최예나 (Choi Ye Na)</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <div class="table-center">
        	<table class="intro-table">
        		<tr class="intro-tr">
        			<td colspan="2">
        				<img class="img-fluid" src="<c:url value='/img/introduce/yena_modal.jpg'/>" alt="" width="100%">
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">이름</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>최예나 (Choi Ye Na, 崔叡娜, チェ・イェナ)</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">출생</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>1999년 9월 29일 (20세)</span><br>
        				<span>서울특별시 강동구 길동</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">국적</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>대한민국</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">소속사</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>위에화엔터테인먼트</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">포지션</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>메인래퍼, 리드보컬, 리드댄서</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">데뷔</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>2018년 IZ*ONE 미니 앨범 1집 &lt;COLOR*IZ&gt;</span>
        			</td>
        		</tr>
        	</table>
        </div>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
      </div>
     </div>
    </div>
   </div>
   
   <!-- Modal Lee Chae-Yeon -->
  <div class="modal fade" id="LeeChaeYeon">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">이채연 (Lee Chae Yeon)</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <div class="table-center">
        	<table class="intro-table">
        		<tr class="intro-tr">
        			<td colspan="2">
        				<img class="img-fluid" src="<c:url value='/img/introduce/chaeyeon_modal.jpg'/>" alt="" width="100%">
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">이름</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>이채연 (Lee Chae Yeon, 李彩讌, イ・チェヨン)</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">출생</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>2000년 1월 11일 (20세)</span><br>
        				<span>경기도 용인시 기흥구 서천동</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">국적</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>대한민국</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">소속사</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>WM엔터테인먼트</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">포지션</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>리드보컬, 메인댄서</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">데뷔</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>2018년 IZ*ONE 미니 앨범 1집 &lt;COLOR*IZ&gt;</span>
        			</td>
        		</tr>
        	</table>
        </div>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
      </div>
     </div>
    </div>
   </div>
   
   <!-- Modal Kim Chae-Won -->
  <div class="modal fade" id="KimChaeWon">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">김채원 (Kim Chae-Won)</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <div class="table-center">
        	<table class="intro-table">
        		<tr class="intro-tr">
        			<td colspan="2">
        				<img class="img-fluid" src="<c:url value='/img/introduce/chaewon_modal.jpg'/>" alt="" width="100%">
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">이름</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>김채원 (Kim Chae-Won, 金采源, キム・チェウォン)</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">출생</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>2000년 8월 1일 (19세)</span><br>
        				<span>서울특별시 강남구 개포동</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">국적</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>대한민국</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">소속사</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>울림엔터테인먼트</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">포지션</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>리드보컬</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">데뷔</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>2018년 IZ*ONE 미니 앨범 1집 &lt;COLOR*IZ&gt;</span>
        			</td>
        		</tr>
        	</table>
        </div>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
      </div>
     </div>
    </div>
   </div>
   
   <!-- Modal Kim Min-ju -->
  <div class="modal fade" id="KimMinJu">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">김민주 (Kim Min Ju)</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <div class="table-center">
        	<table class="intro-table">
        		<tr class="intro-tr">
        			<td colspan="2">
        				<img class="img-fluid" src="<c:url value='/img/introduce/minju_modal.jpg'/>" alt="" width="100%">
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">이름</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>김민주 (Kim Min Ju, 金珉周, キム・ミンジュ)</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">출생</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>2001년 2월 5일 (19세)</span><br>
        				<span>서울특별시 관악구 미성동</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">국적</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>대한민국</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">소속사</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>얼반웍스이엔티</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">포지션</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>서브보컬, 서브래퍼</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">데뷔</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>2018년 IZ*ONE 미니 앨범 1집 &lt;COLOR*IZ&gt;</span>
        			</td>
        		</tr>
        	</table>
        </div>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
      </div>
     </div>
    </div>
   </div>
   
   <!-- Modal Nako -->
  <div class="modal fade" id="nako">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">야부키 나코(Yabuki Nako)</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <div class="table-center">
        	<table class="intro-table">
        		<tr class="intro-tr">
        			<td colspan="2">
        				<img class="img-fluid" src="<c:url value='/img/introduce/nako_modal.jpg'/>" alt="" width="100%">
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">이름</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span><ruby><rb>矢吹</rb><rt>やぶき</rt></ruby><ruby>&nbsp;<rb>奈子</rb><rt>なこ</rt></ruby> (야부키 나코, Yabuki Nako)</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">출생</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>2001년 6월 18일(18세)</span><br>
        				<span>일본 도쿄도</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">국적</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>일본</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">소속사</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>AKS</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">포지션</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>서브보컬</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">데뷔</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>2013년 HKT48 연구생 공연 &lt;뇌내 파라다이스&gt;</span>
        			</td>
        		</tr>
        	</table>
        </div>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
      </div>
     </div>
    </div>
   </div>
   
   <!-- Modal Hitomi -->
  <div class="modal fade" id="hitomi">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">혼다 히토미(Honda Hitomi)</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <div class="table-center">
        	<table class="intro-table">
        		<tr class="intro-tr">
        			<td colspan="2">
        				<img class="img-fluid" src="<c:url value='/img/introduce/hitomi_modal.jpg'/>" alt="" width="100%">
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">이름</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span><ruby>本田<rp>(</rp><rt>ほんだ</rt><rp>)</rp></ruby><ruby>&nbsp;<rb>仁美</rb><rt>ひとみ</rt></ruby> (혼다 히토미, Honda Hitomi)</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">출생</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>2001년 10월 6일 (18세)</span><br>
        				<span>일본 도치기현</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">국적</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>일본</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">소속사</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>AKS</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">포지션</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>서브보컬</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">데뷔</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>2014년 AKB48 팀 8 공연 &lt;PARTY가 시작돼요&gt;</span>
        			</td>
        		</tr>
        	</table>
        </div>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
      </div>
     </div>
    </div>
   </div>
   
   <!-- Modal yuri -->
  <div class="modal fade" id="ChoYuRi">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">조유리 (Jo Yu Ri)</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <div class="table-center">
        	<table class="intro-table">
        		<tr class="intro-tr">
        			<td colspan="2">
        				<img class="img-fluid" src="<c:url value='/img/introduce/yuri_modal.jpg'/>" alt="" width="100%">
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">이름</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>조유리 (Jo Yu Ri, 曺柔理, チョ・ユリ)</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">출생</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>2001년 10월 22일 (18세)</span><br>
        				<span>부산광역시 남구 대연동</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">국적</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>대한민국</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">소속사</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>스톤뮤직엔터테인먼트</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">포지션</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>메인보컬</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">데뷔</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>2018년 IZ*ONE 미니 앨범 1집 &lt;COLOR*IZ&gt;</span>
        			</td>
        		</tr>
        	</table>
        </div>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
      </div>
     </div>
    </div>
   </div>
   
   <!-- Modal Yujin -->
  <div class="modal fade" id="AhnYuJin">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">안유진 (An Yu Jin)</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <div class="table-center">
        	<table class="intro-table">
        		<tr class="intro-tr">
        			<td colspan="2">
        				<img class="img-fluid" src="<c:url value='/img/introduce/yujin_modal.jpg'/>" alt="" width="100%">
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">이름</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>안유진 (An Yu Jin, 安兪眞, アン・ユジン)</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">출생</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>2003년 9월 1일 (17세)</span><br>
        				<span>충청북도 청주시 서원구</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">국적</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>대한민국</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">소속사</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>스타쉽엔터테인먼트</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">포지션</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>리드보컬</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">데뷔</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>2018년 IZ*ONE 미니 앨범 1집 &lt;COLOR*IZ&gt;</span>
        			</td>
        		</tr>
        	</table>
        </div>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
      </div>
     </div>
    </div>
   </div>
   
   <!-- Modal Won-Young -->
  <div class="modal fade" id="JangWonYoung">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">장원영 (Jang Won Young)</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <div class="table-center">
        	<table class="intro-table">
        		<tr class="intro-tr">
        			<td colspan="2">
        				<img class="img-fluid" src="<c:url value='/img/introduce/wonyoung_modal.jpg'/>" alt="" width="100%">
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">이름</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>장원영 (Jang Won Young, 張員瑛, チャン・ウォニョン)</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">출생</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>2004년 8월 31일 (16세)</span><br>
        				<span>서울특별시 용산구 이촌1동</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">국적</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>대한민국</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">소속사</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>스타쉽엔터테인먼트</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">포지션</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>센터, 서브보컬</span>
        			</td>
        		</tr>
        		<tr class="intro-tr">
        			<td style="background-color:#23C293; width:100px; text-align:center;">
        				<strong><span style="color: white;">데뷔</span></strong>
        			</td>
        			<td style="text-align:left;">
        				<span>2018년 IZ*ONE 미니 앨범 1집 &lt;COLOR*IZ&gt;</span>
        			</td>
        		</tr>
        	</table>
        </div>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
      </div>
     </div>
    </div>
   </div>

<%@ include file="../include/footer.jsp" %>