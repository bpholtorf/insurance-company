<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>Insurance System</title>

    <!-- Bootstrap core CSS -->
    <link href="/InsuranceSystem/pages/assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="/InsuranceSystem/pages/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        
    <!-- Custom styles for this template -->
    <link href="/InsuranceSystem/pages/assets/css/style.css" rel="stylesheet">
    <link href="/InsuranceSystem/pages/assets/css/style-responsive.css" rel="stylesheet">

  
  <style type="text/css">
  .alert{
  
  }
  </style>  
  </head>

  <body>

      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->

	  <div id="login-page">
	  	<div class="container">
	  	
		      <form class="form-login" action="reset" method="post">
		        <h2 class="form-login-heading">Reset Password</h2>
		        <div class="login-wrap">
		            <input name="username" type="text" class="form-control" placeholder="Username" autofocus>
		            <br>
		            <input name="password" type="password" class="form-control" placeholder="New Password">
		            <br>
		            <input name="password1" type="password" class="form-control" placeholder="Confirm Password">
                    <br>
		            <button class="btn btn-theme btn-block"  type="submit"><i class="fa fa-lock"></i>Submit</button>
		            <hr>
		            
		       <c:if test="${error}">   
		       <label style="color:red">Reset password failed.The passwords you entered must be the same</label>
		        </c:if>
		         <c:if test="${error1}">   
		       <label style="color:red">Username does not exist</label>
		        </c:if>
		        </div>
		
		         
		
		      </form>	  	
	  	
	  	</div>
	  </div>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="/InsuranceSystem/pages/assets/js/jquery.js"></script>
    <script src="/InsuranceSystem/pages/assets/js/bootstrap.min.js"></script>
 <script src="/InsuranceSystem/pages/assets/js/bootbox.js"></script>
  


  </body>
</html>
