<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Sign up  | OnlineBabysitter</title>
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
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%=request.getContextPath()%>/resources/images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%=request.getContextPath()%>/resources/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%=request.getContextPath()%>/resources/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="<%=request.getContextPath()%>/resources/images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->

<body>
	<header id="header">  
            <a class="navbar-brand" href="">
                    	<h1><img src="<%=request.getContextPath()%>/resources/images/logo.png" alt="logo"></h1>
                    </a>
        <div class="container">
            <div class="row">
                <div class="col-sm-12 overflow">
                   <div class="social-icons pull-right">
                        <ul class="nav nav-pills">
                            <li><a href=""><i class="fa fa-facebook"></i></a></li>
                            <li><a href=""><i class="fa fa-twitter"></i></a></li>
                            <li><a href=""><i class="fa fa-google-plus"></i></a></li>
                          
                        </ul>
                    </div> 
                </div>
             </div>
        </div>
     
    </header>
    <!--/#header-->

 


    

    


    <footer id="footer">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 text-center bottom-separator">
                    <img src="<%=request.getContextPath()%>/resources/images/home/under.png" class="img-responsive inline" alt="">
                </div>
                <div class="col-md-4 col-sm-12"></div>
                <div class="col-md-3 col-sm-6">
                    <div class="contact-info bottom">
                        <h2>Contacts</h2>
                        <address>
                        E-mail: <a href="mailto:mariem15r@gmail.com">mariem15r@gmail.com</a> <br> 
                        Phone: +216  20002425 <br> 
                        
                        </address>

                        <h2>Address</h2>
                        <address>
                        Le bardo <br> 
                        Tunis, <br> 
                        
                        </address>
                    </div>
                </div>
                <div class="testimonial bottom">
                    <div class="media">
                            <div class="pull-left">
                               
                            </div>
                            <div class="media-body">
                                <
                            </div>
                         </div>
                </div>
                <div class="col-md-4 col-sm-12"></div>
                <div class="col-md-4 col-sm-12">
                    <div class="contact-form bottom">
                        <h2>Signing up as a BabySitter</h2>
                      
<f:form modelAttribute="babysitter" action="/inscrit_babysitter" method="post" enctype="multipart/form-data">
<!-- multiapart.. : pour l upload de la photo -->
 <div class="slide-text">
                 <div class="form-group">
             
          Last name : <f:input path="nom" class="form-control"  type="text" size="12"/>
 <p> <f:errors path="nom"></f:errors></p>
   </div>
            </div>
  <div class="form-group">
  First name
 <f:input path="prenom" class="form-control" type="text" size="12"/>
 <p> <f:errors path="prenom"></f:errors></p>
 </div>
<div class="form-group">
   Age
 <f:input path="age" class="form-control"  type="text" size="12"/>
 <p> <f:errors path="age"></f:errors></p>
 </div>
 
  
<div class="form-group">
Adress
 <f:input path="adresse"  class="form-control"  type="text" size="12"/>
 <p> <f:errors path="adresse" ></f:errors></p>
 </div>
 <div class="form-group">
   Age max
 <f:input path="age_max" class="form-control"  type="text" size="12"/>
 <p> <f:errors path="age_max"></f:errors></p> 
 </div>
  <div class="form-group">
 Age min
 <f:input path="age_min" class="form-control"  type="text" size="12"/>
 <p> <f:errors path="age_min"></f:errors></p>
 </div>
  <div class="form-group">
  Email
 <f:input path="email" class="form-control"  type="text" size="12"/>
 <p> <f:errors path="email"></f:errors></p>
 </div>
 
  <div class="form-group">
  Login
 <f:input path="userName" class="form-control"  type="text" size="12"/>
 <p> <f:errors path="userName"></f:errors></p>
 </div>
 
   <div class="form-group">
Password
 <f:input path="password" class="form-control"  type="password" size="12"/>
 <p> <f:errors path="password"></f:errors></p>
 </div>
    <div class="form-group">
Salary per hour
 <f:input path="salaire" class="form-control"  type="text" size="12"/>
 <p> <f:errors path="salaire"></f:errors></p>
 </div>
    <div class="form-group">
Sex
 <f:input path="sexe"  class="form-control"  type="text" size="12"/>
 <p> <f:errors path="sexe"></f:errors></p> 
 </div>
     <div class="form-group">
Phone number
 <f:input path="tel" class="form-control"  type="text" size="12"/>
 <p> <f:errors path="tel"></f:errors></p>
 </div>
 <div class="form-group">
  <p>Description</p>
 <f:textarea path="description" class="form-control"  type="text" size="12"/>
 <p> <f:errors path="description"></f:errors></p>
 </div>
 
 <div class="form-group">
Picture
 		<c:if test="${babysitter.idUser!=null}">
		<f:input type="hidden" path="photo"/>
		</c:if>
		<input type="file" name="file">
 <p> <f:errors path="photo"></f:errors></p>
 </div>


 
 <input type="submit" class="btn btn-common"  align="center"  value="Send"/>
</f:form>
<a href="/pu/EspaceBabysitter">login</a>
  </div> </div>
       <!--   <c:out value="${errors}"></c:out>--> 
            </div>
        </div>
    </footer>
    <!--/#footer-->

    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/lightbox.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/wow.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/main.js"></script>   
</body>
</html>
