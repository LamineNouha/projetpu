<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div >
<a href="<c:url value="/j_spring_security_logout" />" > Logout</a>Espace Admin
</div>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Home | OnlineBabysitter</title>
    <link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/animate.min.css" rel="stylesheet"> 
    <link href="<%=request.getContextPath()%>/resources/css/lightbox.css" rel="stylesheet"> 
	<link href="<%=request.getContextPath()%>/resources/css/main.css" rel="stylesheet">
	<link href="<%=request.getContextPath()%>/resources/css/responsive.css" rel="stylesheet">

    <!--[if lt IE 9]>
	    <script src="<%=request.getContextPath()%>/resources/js/html5shiv.js"></script>
	    <script src="<%=request.getContextPath()%>/resources/js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%=request.getContextPath()%>/resources/images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%=request.getContextPath()%>/resources/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%=request.getContextPath()%>/resources/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="<%=request.getContextPath()%>/resources/images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->

<body>
	<header id="header">      
      
        <div class="navbar navbar-inverse" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>

                    <a class="navbar-brand" href="/pu/admin">
                    	<img src="<%=request.getContextPath()%>/resources/images/logo.png" alt="logo">
                    	<a href="/pu/admin" class="btn btn-common"> Gestion Compte</a>
                    	<a href="/pu/admin/BBs" class="btn btn-common"> supprimer un Babysitter</a>
                        <a href="/pu/admin/Parents" class="btn btn-common"> supprimer un Parent</a>
                    </a>
                    
                </div>
                
               
            </div>
        </div>
    </header>
    <!--/#header-->
        <section id="page-breadcrumb">
        <div class="vertical-center sun">
             <div class="container">
                <div class="row">
                    <div class="action">
                        <div class="col-sm-12">
                            <h1 class="title">Bienvenu</h1>
                            <h2>${current.userName}</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
   </section>

    <section id="home-slider">
        <div class="container">
            <div class="row">
                <div class="main-slider">
                    <div class="slide-text">
                        <h1>Modifier Votre Compte</h1>
                        
                        
                        <h1>Vérification de mot de passe :</h1>
                      
                        
                      
                      
                      
  <f:form action="/admin/edit?id=${current.idUser}" method="post">

<tr>
<td>Password</td>
<td><input type="password" name="password" value="${password}"></td>
</tr>
<tr>
<td><input type="submit" value="Edit"></td>
</tr>
</f:form>
<f:form action="delete?id=${current.idUser}" method="post">
<td><input type="submit" value="Désactiver Compte"></td>
</f:form>               
                             
                   
                    </div>
                    
                </div>
            </div>
        </div>
        <div class="preloader"><i class="fa fa-sun-o fa-spin"></i></div>
    </section>
    <!--/#home-slider-->

    

    
    

    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/lightbox.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/wow.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/main.js"></script>   
</body>
</html>