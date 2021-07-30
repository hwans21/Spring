<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>spring project</title>

  <!-- Bootstrap core CSS -->
  <link rel="stylesheet" href="<c:url value='/vendor/bootstrap/css/bootstrap.min.css'/>">

  <!-- Custom fonts for this template -->
  <link rel="stylesheet" type="text/css" href="<c:url value='/vendor/fontawesome-free/css/all.min.css'/>" >
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

  <!-- Custom styles for this template -->
  <link rel="stylesheet" href="<c:url value='/css/agency.min.css'/>" >
  
  <!-- Bootstrap core JavaScript -->
  <script src="<c:url value='/vendor/jquery/jquery.min.js'/>"></script>
  <script src="<c:url value='/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
	
	
  <!-- Plugin JavaScript -->
  <script src="<c:url value='/vendor/jquery-easing/jquery.easing.min.js'/>"></script>
  <script type="text/javascript" src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>

  <!-- Contact form JavaScript -->
  <script src="<c:url value='/js/jqBootstrapValidation.js'/>"></script>
  


<style>

.music-menu {
	background-color: #643691;
	border: 1px solid #fffe2e;
	
}
.music-tap {
	color: white;
}
.music-tap:hover {
    background-color: #643691;
    color: #F7FE2E;
    text-shadow: 5px 2px 2px black;
}

.dropdown:hover > .dropdown-menu { 
    display: block;  
}
</style>


</head>

<body id="page-top">

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand" href="/">
      	<img class="img-fluid" src="<c:url value='/img/logo.PNG'/>" alt="" style="width:200px; height:80px;" />
      </a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive">
        메뉴
        <i class="fas fa-bars"></i>
      </button>
      
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav text-uppercase ml-auto">
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="/">HOME</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="<c:url value='/introduce'/>">INTRODUCE</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link js-scroll-trigger dropdown-toggle" data-toggle="dropdown">MUSIC</a>
            <div class="dropdown-menu music-menu"> 
            
              <div class="dropdown dropright">            
		        <a class="dropdown-item dropdown-toggle music-tap" data-toggle="dropdown" style="color:white;">COLOR*IZ</a>
			    <div class="dropdown-menu music-menu"> 
			      <a class="dropdown-item music-tap" data-toggle="modal" href="#lavieenrose">La Vie En Rose MV</a>
			      <a class="dropdown-item music-tap" data-toggle="modal" href="#lavieenrose-2">La Vie En Rose 교차편집</a>
			    </div>
		      </div>
		      
		      <div class="dropdown dropright">            
		        <a class="dropdown-item dropdown-toggle music-tap" data-toggle="dropdown" style="color:white;">HEART*IZ</a>
			    <div class="dropdown-menu music-menu"> 
			      <a class="dropdown-item music-tap" data-toggle="modal" href="#violeta">Violeta MV</a>
			      <a class="dropdown-item music-tap" data-toggle="modal" href="#violeta-2">Violeta 교차편집</a>	
			    </div>
		      </div>
		      
		      <div class="dropdown dropright">            
		        <a class="dropdown-item dropdown-toggle music-tap" data-toggle="dropdown" style="color:white;">BLOOM*IZ</a>
			    <div class="dropdown-menu music-menu"> 
			      <a class="dropdown-item music-tap" data-toggle="modal" href="#fiesta">Fiesta MV</a>
			      <a class="dropdown-item music-tap" data-toggle="modal" href="#fiesta-2">Fiesta 교차편집</a>	
			    </div>
		      </div>
		      
		      <div class="dropdown dropright">            
		        <a class="dropdown-item dropdown-toggle music-tap" data-toggle="dropdown" style="color:white;">ONEIRIC DIARY</a>
			    <div class="dropdown-menu music-menu"> 
			      <a class="dropdown-item music-tap" data-toggle="modal" href="#swan">환상동화 MV</a>
			      <a class="dropdown-item music-tap" data-toggle="modal" href="#swan-2">환상동화 교차편집</a>	
			    </div>
		      </div>
		      	   
		    </div>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#">BOARD</a>
          </li>
          
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" data-toggle="modal" data-target="#log-in">LOGIN</a>
          </li>
          
        </ul>
      </div>
    </div>
  </nav><br><br><br>

  <!-- Header -->
  <header class="masthead">
    <div class="container">
      <div class="intro-text">        
    
        <button class="btn btn-chu btn-xl text-uppercase js-scroll-trigger" data-toggle="modal" data-target="#log-in">안녕~</button>
    
    
      </div>
    </div>
  </header>
  
<%@ include file="../users/login_modal.jsp" %>  
  

