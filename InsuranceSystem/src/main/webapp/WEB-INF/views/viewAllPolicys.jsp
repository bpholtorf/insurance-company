<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link href="/InsuranceSystem/pages/assets/css/bootstrap.css"
	rel="stylesheet">
<!--external css-->
<link
	href="/InsuranceSystem/pages/assets/font-awesome/css/font-awesome.css"
	rel="stylesheet" />

<!-- Custom styles for this template -->
<link href="/InsuranceSystem/pages/assets/css/style.css"
	rel="stylesheet">
<link href="/InsuranceSystem/pages/assets/css/style-responsive.css"
	rel="stylesheet">
<style>
form {
	display: inline;
}
</style>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<section id="container">
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


					<li class="sub-menu"><a  href="javascript:;">
							<i class="fa fa-desktop"></i> <span>Staff</span>
					</a>
						<ul class="sub">
							<li><a href="<c:url value='/staff/viewAll' />">Staff List</a></li>
							<li><a href="<c:url value='/requestAdd' />">Add Staff</a></li>

						</ul></li>

					<li class="sub-menu"><a  href="javascript:;"> <i
							class="fa fa-user"></i> <span>Customer</span>
					</a>
						<ul class="sub">
							<li  ><a href="<c:url value='/customer/viewAll' />">Customer List</a></li>
							<li><a href="<c:url value='/requestAddCustomer' />">Add Customer</a></li>

						</ul></li>

						
					<li class="sub-menu"><a  href="javascript:;"> <i
							class="fa fa-bars"></i> <span>Insurance Policy</span>
					</a>
						
						<ul class="sub">
							<li ><a href="<c:url value='/insurancePolicy/viewAll' />">Insurance Policy List</a></li>

							<li ><a href="<c:url value='/requestAddInsurancePolicy' />">Add Insurance Policy</a></li>

						</ul></li>
					<li class="sub-menu"><a class="active" href="javascript:;"> <i
							class="fa fa-book"></i> <span>Customer Policy</span>
					</a>
						<ul class="sub">
							<li  class="active"><a href="<c:url value='/customer/viewAllPolicys' />">Customer Policys List</a></li>
							
						</ul></li>

					 <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-book"></i>
                          <span>Insurance Claim</span>
                      </a>
                      <ul class="sub">
							<li ><a href="<c:url value='/requestAddClaim' />">Add Claim from Customer</a></li>
							<li><a href="<c:url value='/claim/viewAll' />">View Claim</a></li>
							 <li><a href="<c:url value='/drug/view' />">View Drug</a></li>
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


				<div class="row mt">
					<div class="col-md-12">
						<div class="content-panel">
							
								<table class="table table-striped table-advance table-hover"
									style="font-size: 13px">
									<h4>
										<i class="fa fa-angle-right"></i> Customer Policys List
										<div class="col-sm-3 col-md-3 pull-right" style="margin-top:-10px">
											<form class="navbar-form" role="search" action="searchPolicy" onsubmit="return checkKeyword()">
												<div class="input-group" style="margin-top:-15px">
													<input type="text" class="form-control"
														placeholder="Customer SSN" name="keyword" value="${keyword }">
													<div class="input-group-btn">
														<button class="btn btn-default" type="submit" style="padding:9">
															<i class="glyphicon glyphicon-search"></i>
														</button>
													</div>
												</div>
											</form>
										</div>
									</h4>
									<hr>
									<c:choose>
										<c:when test="${!empty allPolicys }">
									<thead>
										<tr>
											<th>Customer SSN</th>
											<th>Participant Name</th>
											<th >Policy Number</th>
											<th >Policy Type</th>
											<th>Date From</th>
											<th>Date To</th>
											<th>Premium</th>
											<th>Pharmacyamount Left</th>
											<th>Hostipalamount Left</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										  <c:forEach items="${allPolicys }" var="customerPolicys">
											<tr>
												<td>${customerPolicys.SSN }</td>
												<td>${customerPolicys.cname }</td>
												<td >${customerPolicys.policyNumber }</td>
												<td >${customerPolicys.planType }</td>
												<fmt:formatDate value="${customerPolicys.dateFrom }" type="date"
								pattern="MM/dd/yyyy" var="theFormattedDate" />
												<td >${theFormattedDate}</td>
												<fmt:formatDate value="${customerPolicys.dateTo }" type="date"
								pattern="MM/dd/yyyy" var="theFormattedDate" />
												<td>${theFormattedDate }</td>
												<td>${customerPolicys.premium }</td>
												<td>${customerPolicys.pamountLeft }</td>
												<td>${customerPolicys.hamountLeft }</td>	
												<!-- <td><form method="post" action="">
														<button class="btn btn-danger btn-xs">
															<i class="fa fa-trash-o "></i>
														</button>
													</form>
													
												</td> -->
											</tr>
										</c:forEach> 
									</tbody>
									</c:when>
										<c:otherwise>
										 no result found
										</c:otherwise>
									</c:choose>
								</table>
							
						</div>
						<!-- /content-panel -->
					</div>
					<!-- /col-md-12 -->
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
	<script src="/InsuranceSystem/pages/assets/js/jquery.nicescroll.js"
		type="text/javascript"></script>


	<!--common script for all pages-->
	<script src="/InsuranceSystem/pages/assets/js/common-scripts.js"></script>

	<!--script for this page-->

	<script>
	 function checkKeyword(){
   	  var keyword=$("input[name='keyword']").val();
   	  if(keyword.length === 9 &&!isNaN(keyword))
   	   {
   		  console.log('true');
   		
   		  return true;
   		  
   	   }
   	  else
   		  {
   		  console.log('false');
   		  bootbox.alert("Please input a valid SSN!", function() {
    			 
 			});
   		  return false;
   		  }
   	  
     }

	</script>

</body>
</html>
