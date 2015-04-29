<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

<title>Insurance System</title>

<!-- Bootstrap core CSS -->
<link href="/InsuranceSystem/pages/assets/css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="/InsuranceSystem/pages/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="/InsuranceSystem/pages/assets/js/bootstrap-datepicker/css/datepicker.css" />
<link rel="stylesheet" type="text/css"
	href="/InsuranceSystem/pages/assets/js/bootstrap-daterangepicker/daterangepicker.css" />

<!-- Custom styles for this template -->
<link href="/InsuranceSystem/pages/assets/css/style.css" rel="stylesheet">
<link href="/InsuranceSystem/pages/assets/css/style-responsive.css" rel="stylesheet">
 <style type="text/css">
       .error{
        color:#a94442;
        padding-top:7px;

       }
    </style>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<section id="container" style="overflow:auto">
		<!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
		<!--header start-->
		<header class="header black-bg">
			<div class="sidebar-toggle-box">
				<div class="fa fa-bars tooltips" data-placement="right"
					data-original-title="Toggle Navigation"></div>
			</div>
			<!--logo start-->
			<a href="index.html" class="logo"><b>Insurance System</b></a>
			<!--logo end-->
			<div class="nav notify-row" id="top_menu">
			</div>
			<div class="top-menu">
				<ul class="nav pull-right top-menu">
					<li><a class="logout" href="/InsuranceSystem">Logout</a></li>
				</ul>
			</div>
		</header>
		<!--header end-->

		<!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
		<!--sidebar start-->
		<aside>
			<div id="sidebar" class="nav-collapse ">
				<!-- sidebar menu start-->
				<ul class="sidebar-menu" id="nav-accordion">

					<p class="centered">
						<a href="profile.html"><img
							src="/InsuranceSystem/pages/assets/img/ui-sam.jpg"
							class="img-circle" width="60"></a>
					</p>
					<h5 class="centered">${user }</h5>

			
					<li class="sub-menu"><a class="active" href="javascript:;">
							<i class="fa fa-desktop"></i> <span>Staff</span>
					</a>
						<ul class="sub">
							<li ><a href="<c:url value='/staff/viewAll' />">Staff List</a></li>
							<li class="active"><a href="<c:url value='/requestAdd' />">Add Staff</a></li>

						</ul></li>

					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-user"></i> <span>Customer</span>
					</a>
						<ul class="sub">
							<li><a href="<c:url value='/customer/viewAll' />">Customer List</a></li>
							<li><a href="<c:url value='/requestAddCustomer' />">Add Customer</a></li>

						</ul></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-bars"></i> <span>Insurance Policy</span>
					</a>
						<ul class="sub">
							<li ><a href="<c:url value='/insurancePolicy/viewAll' />">Insurance Policy List</a></li>
							<li ><a href="<c:url value='/requestAddInsurancePolicy' />">Add Insurance Policy</a></li>

						</ul></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-book"></i> <span>Customer Policy</span>
					</a>
						<ul class="sub">
							<li ><a href="<c:url value='/customer/viewAllPolicys' />">Customer Policys List</a></li>
						</ul></li>

					 <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-book"></i>
                          <span>Insurance Claim</span>
                      </a>
                      <ul class="sub">
							<li ><a href="<c:url value='/requestAddClaim' />">Add Claim from Customer</a></li>
							<li><a href="<c:url value='/claim/viewAll' />">View Claim</a></li>
						</ul>
                  </li>

				</ul>
				<!-- sidebar menu end-->
			</div>
		</aside>
		<!--sidebar end-->

		<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<h3>
					<i class="fa fa-angle-right"></i> Create a staff
				</h3>

				<!-- INPUT MESSAGES -->
				<div class="row mt">
					<div class="col-lg-12">
						<div class="form-panel">
							<h4 class="mb">
								<i class="fa fa-angle-right"></i> Staff Information 
								<label style="font-size: 14px; color: #a94442">(All fields are required)</label>
							</h4>
							<c:url var="addAction" value="/staff/add"></c:url>
							<form:form action="${addAction}" name="myForm"
								class="form-horizontal tasi-form" method="POST"
								modelAttribute="staffDB" onsubmit="return validatePassword()">
								<div class="form-group">
									<label class="col-sm-2 control-label col-lg-2">Username</label>
									<div class="col-lg-5">
										<form:input type="text" class="form-control" path="username" />
										<form:errors path="username" class="error"></form:errors>
									</div>
								</div>
								 <div class="form-group">
									<label class="col-sm-2 control-label col-lg-2">Password</label>
									<div class="col-lg-5">
										<form:input type="password" class="form-control"
											path="password" />
										<form:errors path="password" class="error"> </form:errors>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label col-lg-2">Confirm
										Password</label>
									<div class="col-lg-5">
										<input type="password" class="form-control" name="confirm-password">
										<label class="error" style="display:none" id="errorMessage">Your passwords do not match!</label>
									</div>
								</div> 
								<div class="form-group">
									<label class="col-sm-2 control-label col-lg-2">Name</label>
									<div class="col-lg-5 form-inline">
										<form:input type="text" class="form-control" path="firstName"
											placeholder="First name" />
									    <form:errors path="firstName" class="error"></form:errors>
										<form:input type="text" class="form-control" path="lastName"
											placeholder="Last name" />
										<form:errors path="lastName" class="error"></form:errors>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label col-lg-2">Gender</label>
									<div class="col-lg-5">
										<form:radiobutton path="gender" id="optionsRadios2"
											value="male" /> Male 
									    <form:radiobutton 
											path="gender" id="optionsRadios1" value="female" checked="checked"/> Female
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label col-lg-2">SSN</label>
									<div class="col-lg-5">
										<form:input type="text" class="form-control" path="SSN" placeholder="000000000"/>
										<form:errors path="SSN" class="error"></form:errors>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label col-lg-2">Address</label>
									<div class="col-lg-5">
										<form:input type="text" class="form-control" path="address" />
										<form:errors path="address" class="error"></form:errors>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label col-lg-2">Phone
										Number</label>
									<div class="col-lg-5">
										<form:input type="text" class="form-control"
											path="phoneNumber" data-validate="required,number" placeholder="0000000000"/>
									    <form:errors path="phoneNumber" class="error"></form:errors>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label col-lg-2">Email</label>
									<div class="col-lg-5">
										<form:input type="text" class="form-control" path="email" placeholder="contact@example.com"/>
										<form:errors path="email" class="error"></form:errors>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label col-lg-2">Date of
										Birth</label>
									<div class="col-lg-5">
									<fmt:formatDate value="${birthDate}" type="date"
								pattern="MM/dd/yyyy" var="theFormattedDate" />
						
										<form:input class="form-control" id="datepicker"
											path="dateOfBirth" type="text" value="${theFormattedDate }"/>
											<label class="error" style="display:none" id="errorMessage1" >Please input a date!</label>
											<form:errors path="dateOfBirth" class="error"></form:errors>
									</div>
								</div>
								<div class="form-group">
									<button type="submit" class="btn btn-theme"
										style="left: 300px; position: relative">Submit</button>
								</div>
								<!-- /showback -->
							</form:form>
						</div>
						<!-- /form-panel -->
					</div>
					<!-- /col-lg-12 -->
				</div>
				<!-- /row -->





			</section>
			<! --/wrapper -->
		</section>
		<!-- /MAIN CONTENT -->

		<!--main content end-->
		<!--footer start-->
		<!--footer end-->
	</section>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="/InsuranceSystem/pages/assets/js/jquery.js"></script>
	<script src="/InsuranceSystem/pages/assets/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="/InsuranceSystem/pages/assets/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="/InsuranceSystem/pages/assets/js/jquery.scrollTo.min.js"></script>
	<script src="/InsuranceSystem/pages/assets/js/jquery.nicescroll.js" type="text/javascript"></script>


	<!--common script for all pages-->
	<script src="/InsuranceSystem/pages/assets/js/common-scripts.js"></script>

	<!--script for this page-->
	<script src="/InsuranceSystem/pages/assets/js/jquery-ui-1.9.2.custom.min.js"></script>

	<!--custom switch-->
	<script src="/InsuranceSystem/pages/assets/js/bootstrap-switch.js"></script>

	<!--custom tagsinput-->
	<script src="/InsuranceSystem/pages/assets/js/jquery.tagsinput.js"></script>

	<!--custom checkbox & radio-->
	<script type="text/javascript" src="/InsuranceSystem/pages/assets/js/bootstrap.js"></script>
	<script type="text/javascript"
		src="/InsuranceSystem/pages/assets/js/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript"
		src="/InsuranceSystem/pages/assets/js/bootstrap-daterangepicker/date.js"></script>

	<script type="text/javascript"
		src="/InsuranceSystem/pages/assets/js/bootstrap-daterangepicker/daterangepicker.js"></script>

	<script type="text/javascript"
		src="/InsuranceSystem/pages/assets/js/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>

    <script src="/InsuranceSystem/pages/assets/js/validate.js"></script>
	<script src="/InsuranceSystem/pages/assets/js/form-component.js"></script>


	<script>
		//custom select box

		$(function() {
			$("#datepicker").datepicker();
			if($("#datepicker").val()=='')
				$("#datepicker").val('02/24/2015');
			
		});
		function validatePassword(){
			var password=document.forms["myForm"]["password"].value;
			var comfirm=document.forms["myForm"]["confirm-password"].value;
			console.log(password+"&&&"+comfirm);
			if(password!=comfirm)
			{
				console.log("false");
				$("#errorMessage").css("display","inline");
			    return false;
				}
				
		}
		
		
	</script>

</body>
</html>
