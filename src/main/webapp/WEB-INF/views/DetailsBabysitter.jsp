
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div>
<a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
Espace Babysitter
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

                    <a class="navbar-brand" href="/pu/EspaceParent">
                    	<img src="<%=request.getContextPath()%>/resources/images/logo.png" alt="logo">
                    	
                    		
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
                            <h1 class="title">Bienvenu </h1>
                            <h2>${current.userName}</h2> 
<f:form action="/EspaceParent/babysittersParsexe" method="post">
<select name="sexe"> 
<option value="homme">homme</option>
<option value="femme">femme</option>
</select>
<td><input type="submit" value="Rechercher Par sexe"></td>
</f:form>

<f:form action="/EspaceParent/babysittersParAge" method="post">
<select name="ageMin"> 
<%
for(int j=16; j <=60; j++ )
{ %>
<option value=<%= j %>><%= j %></option>
	<%
	}
%>
</select>
<select name="ageMax"> 
<%
for(int i=16; i <=60; i++ )
{ %>
<option value=<%= i %>><%= i %></option>
	<%
	}
%>
</select>
<td><input type="submit" value="Rechercher Par Age"></td>
</f:form>
<f:form action="/EspaceParent/chercherBabysitters" method="post">
<tr><td><input type="text" name="mc" value="${mc}"></td></tr>
<tr><td><input type="submit" value="Chercher"></td></tr>
</f:form>
<f:form action="/EspaceParent/babysittersParAdresse" method="post">
<tr><td><input type="text" name="adresse" value="${adresse}"></td></tr>
<tr><td><input type="submit" value="Chercher Par Adresse"></td></tr>
</f:form>   
                        </div>
                    </div>
                </div>
            </div>
        </div>
   </section>
   <div class="portfolio-items">
                    <div class="col-xs-6 col-sm-4 col-md-3 portfolio-item branded logos">
                        <div class="portfolio-wrapper">
                            <div class="portfolio-single">
                                <div class="portfolio-thumb">
                                <img src="/pu/EspaceParent/photo?idJ=${p.idUser}">
                            	 </div>
                                
                            </div>
                            <div class="portfolio-info ">
                                <h2>Nom : ${p.nom}</>
                                <h2>Prenom : ${p.prenom}</h2>
                                <h2>Email : ${p.email}</h2>
                                <h2>Adresse : ${p.adresse}</h2>
                                <h2>Telephone : ${p.tel}</h2>
                                <h2>Sexe : ${p.sexe}</h2>
                                <h2>Age : ${p.age}</h2>
                                <h2>Salaire : ${p.salaire} par heure</h2>
                                <h2>Age Max d'enfant à garder : ${p.age_max}</h2>
                                <h2>Age Min d'enfant à garder : ${p.age_min}</h2>
                                <h2>Description : ${p.description}</h2>
                                


                            </div>
                        </div>
                    </div>
            
    </div>
    

    
    

    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/lightbox.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/wow.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/main.js"></script>   
</body>
</html>