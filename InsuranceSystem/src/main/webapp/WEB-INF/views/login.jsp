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

    <title>DASHGUM - Bootstrap Admin Template</title>

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
	  	
		      <form class="form-login" action="validate" method="post">
		        <h2 class="form-login-heading">sign in now</h2>
		        <div class="login-wrap">
		            <input name="j_username" type="text" class="form-control" placeholder="Username" autofocus>
		            <br>
		            <input name="j_password" type="password" class="form-control" placeholder="Password">
		            
		          
		            
		            <label class="checkbox">
		                <span class="pull-right">
		                <!--  href="login.html#myModal"-->
		                    <a data-toggle="modal" href="login.html#myModal"> Forgot Password?</a>
		
		                </span>
		            </label>
		            <button class="btn btn-theme btn-block"  type="submit"><i class="fa fa-lock"></i> SIGN IN</button>
		            <hr>
		            
		        <c:if test="${error}">   
		       <label style="color:red">Login failed! Invalid username and password.</label>
		        </c:if>
		        </div>
		
		          <!-- Modal -->
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
		              <div class="modal-dialog">
		                  <div class="modal-content">
		                      <div class="modal-header">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h4 class="modal-title">Forgot Password ?</h4>
		                      </div>
		                      <div class="modal-body">
		                          <p>Enter your social security number below to reset your password.</p>
		                          <input type="text" id="ssn" placeholder="SSN" autocomplete="off" class="form-control placeholder-no-fix">
		
		                      </div>
		                      <label id="mess" style="color:red;display:none;padding-left:18px" >SSN does not exist.</label>
		                      <div class="modal-footer">
		                      
		                          <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
		                          <button class="btn btn-theme" id="reset" type="button">Submit</button>
		                      </div>
		                  </div>
		              </div>
		          </div>
		          <!-- modal -->
		
		      </form>	  	
	  	
	  	</div>
	  </div>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="/InsuranceSystem/pages/assets/js/jquery.js"></script>
    <script src="/InsuranceSystem/pages/assets/js/bootstrap.min.js"></script>
 <script src="/InsuranceSystem/pages/assets/js/bootbox.js"></script>
<script type="text/javascript">
      //custom select box

     document.getElementById('reset').onclick = function() {
    	 var ss=document.getElementById("ssn");
    	 var s=ss.value;
    	
    	 dataToPost="ssn="+s;
    	 $.ajax({

             url: "resetPass",
             type: "GET",
             data: dataToPost, 
             success: function (response) {
            	 if(response=="true"){
            	 window.location.href="/InsuranceSystem/resetPassword";     
                 }else{
                	 $(ss).val("");
                	 var m=document.getElementById('mess');
                	 $(m).css({
                         'display':'block'
                       });
                	
                 }
             },
   	     dataType: "html",
         });
     }


    
      
  </script>
   


  </body>
</html>
