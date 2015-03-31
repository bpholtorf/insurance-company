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

<title>DASHGUM - Bootstrap Admin Template</title>

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
			<a href="index.html" class="logo"><b>DASHGUM FREE</b></a>
			<!--logo end-->
			<div class="nav notify-row" id="top_menu">
				<!--  notification start -->
				<ul class="nav top-menu">
					<!-- settings start -->
					<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle" href="index.html#"> <i
							class="fa fa-tasks"></i> <span class="badge bg-theme">4</span>
					</a>
						<ul class="dropdown-menu extended tasks-bar">
							<div class="notify-arrow notify-arrow-green"></div>
							<li>
								<p class="green">You have 4 pending tasks</p>
							</li>
							<li><a href="index.html#">
									<div class="task-info">
										<div class="desc">DashGum Admin Panel</div>
										<div class="percent">40%</div>
									</div>
									<div class="progress progress-striped">
										<div class="progress-bar progress-bar-success"
											role="progressbar" aria-valuenow="40" aria-valuemin="0"
											aria-valuemax="100" style="width: 40%">
											<span class="sr-only">40% Complete (success)</span>
										</div>
									</div>
							</a></li>
							<li><a href="index.html#">
									<div class="task-info">
										<div class="desc">Database Update</div>
										<div class="percent">60%</div>
									</div>
									<div class="progress progress-striped">
										<div class="progress-bar progress-bar-warning"
											role="progressbar" aria-valuenow="60" aria-valuemin="0"
											aria-valuemax="100" style="width: 60%">
											<span class="sr-only">60% Complete (warning)</span>
										</div>
									</div>
							</a></li>
							<li><a href="index.html#">
									<div class="task-info">
										<div class="desc">Product Development</div>
										<div class="percent">80%</div>
									</div>
									<div class="progress progress-striped">
										<div class="progress-bar progress-bar-info" role="progressbar"
											aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"
											style="width: 80%">
											<span class="sr-only">80% Complete</span>
										</div>
									</div>
							</a></li>
							<li><a href="index.html#">
									<div class="task-info">
										<div class="desc">Payments Sent</div>
										<div class="percent">70%</div>
									</div>
									<div class="progress progress-striped">
										<div class="progress-bar progress-bar-danger"
											role="progressbar" aria-valuenow="70" aria-valuemin="0"
											aria-valuemax="100" style="width: 70%">
											<span class="sr-only">70% Complete (Important)</span>
										</div>
									</div>
							</a></li>
							<li class="external"><a href="#">See All Tasks</a></li>
						</ul></li>
					<!-- settings end -->
					<!-- inbox dropdown start-->
					<li id="header_inbox_bar" class="dropdown"><a
						data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
							<i class="fa fa-envelope-o"></i> <span class="badge bg-theme">5</span>
					</a>
						<ul class="dropdown-menu extended inbox">
							<div class="notify-arrow notify-arrow-green"></div>
							<li>
								<p class="green">You have 5 new messages</p>
							</li>
							<li><a href="index.html#"> <span class="photo"><img
										alt="avatar"
										src="/InsuranceSystem/pages/assets/img/ui-zac.jpg"></span> <span
									class="subject"> <span class="from">Zac Snider</span> <span
										class="time">Just now</span>
								</span> <span class="message"> Hi mate, how is everything? </span>
							</a></li>
							<li><a href="index.html#"> <span class="photo"><img
										alt="avatar"
										src="/InsuranceSystem/pages/assets/img/ui-divya.jpg"></span> <span
									class="subject"> <span class="from">Divya Manian</span>
										<span class="time">40 mins.</span>
								</span> <span class="message"> Hi, I need your help with this. </span>
							</a></li>
							<li><a href="index.html#"> <span class="photo"><img
										alt="avatar"
										src="/InsuranceSystem/pages/assets/img/ui-danro.jpg"></span> <span
									class="subject"> <span class="from">Dan Rogers</span> <span
										class="time">2 hrs.</span>
								</span> <span class="message"> Love your new Dashboard. </span>
							</a></li>
							<li><a href="index.html#"> <span class="photo"><img
										alt="avatar"
										src="/InsuranceSystem/pages/assets/img/ui-sherman.jpg"></span>
									<span class="subject"> <span class="from">Dj
											Sherman</span> <span class="time">4 hrs.</span>
								</span> <span class="message"> Please, answer asap. </span>
							</a></li>
							<li><a href="index.html#">See all messages</a></li>
						</ul></li>
					<!-- inbox dropdown end -->
				</ul>
				<!--  notification end -->
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

					<li class="sub-menu"><a class="active" href="javascript:;"> <i
							class="fa fa-user"></i> <span>Customer</span>
					</a>
						<ul class="sub">
							<li  class="active"><a  href="<c:url value='/customer/viewAll' />">Customer List</a></li>
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

					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-th"></i> <span>Claim</span>
					</a>
						<ul class="sub">
							<li><a href="">Add Claim</a></li>
							<li><a href="">Search Claim</a></li>
						</ul></li>

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
							<table class="table table-striped table-advance table-hover" style="font-size: 13px">
								<h4>
									<i class="fa fa-angle-right"></i> Customer List
									<div class="col-sm-3 col-md-4 pull-right" style="margin-top: -10px">
											<form class="navbar-form" role="search" action="searchCustomer">
											
												<div class="input-group" style="margin-top: -15px">
												<select class="form-control" id="sel1" style="width: 40%; margin-right: 14px" name="type" onchange="myFunction()">
													<c:choose>
															<c:when test="${type == 'Date of Birth'}">
	                          									<option>SSN</option>
														       <option>Name</option>
														       <option selected="selected">Date of Birth</option>
	                                                        </c:when>
	                                                        <c:when test="${type == 'Name'}">
	                          									<option>SSN</option>
														        <option selected="selected">Name</option>
														        <option>Date of Birth</option>
	                                                        </c:when>
															<c:otherwise>
	       													  <option selected="selected">SSN</option>
														       <option>Name</option>
														       <option >Date of Birth</option> 
	                                                        </c:otherwise>
														</c:choose>
												</select>
												<c:choose>
												<c:when test="${empty keyword1 && empty keyword}"> 
												<input id="1" type="text" class="form-control"
													placeholder="Search" name="keyword" style="width: 55%;display:block"
													value="${keyword }" />
													<fmt:formatDate  value="${keyword1 }" type="date" 
								pattern="MM/dd/yyyy" var="theFormattedDate" />
										<input class="form-control" id="datepicker"
											 name="keyword" style="width: 55%;display:none"
													value="${theFormattedDate}" type="text"  disabled/> 
												</c:when>
												
												 <c:when test="${empty keyword1 && not empty keyword}">	
												<input id="1" type="text" class="form-control"
													placeholder="Search" name="keyword" style="width: 55%;display:block"
													value="${keyword }" />
												<fmt:formatDate  value="${keyword1 }" type="date" 
								pattern="MM/dd/yyyy" var="theFormattedDate" />
										<input class="form-control" id="datepicker"
											 name="keyword" style="width: 55%;display:none"
													value="${theFormattedDate}" type="text" disabled/> 	
													</c:when>
												<c:when test="${empty keyword && not empty keyword1}">
												<input id="1" type="text" class="form-control"
													placeholder="Search" name="keyword" style="width: 55%;display:none"
													value="${keyword }" disabled/>		
												 <fmt:formatDate  value="${keyword1 }" type="date" 
								pattern="MM/dd/yyyy" var="theFormattedDate" />
										<input class="form-control" id="datepicker"
											 name="keyword" style="width: 55%;display:block"
													value="${theFormattedDate}" type="text" /> 
												</c:when>
												</c:choose>	 
												<div class="input-group-btn">
													<button class="btn btn-default" type="submit"
														style="padding: 9">
														<i class="glyphicon glyphicon-search"></i>
													</button>
												</div>
											</div>

										</form>
										</div>
									</h4>
									<hr>
									<c:choose>
										<c:when test="${!empty customers }">
											<thead>
												<tr>
													<th>Id</th>
													<th>Name</th>
													<th>Date of Birth</th>
													<th>Sex</th>
													<th>SSN</th>
													<th></th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${customers }" var="customer">
													<tr>
														<td>${customer.id }</td>
														<td>${customer.firstName }
															${customer.lastName }</td>
															<fmt:formatDate value="${customer.dateOfBirth}" type="date"
																pattern="MM/dd/yyyy" var="theFormattedDate" />
														<td>${theFormattedDate }</td>
														<td><span class="label label-info label-mini">${customer.gender }</span></td>
														<td>${customer.SSN }</span></td>
														<td>
															<form method="post" action="view/${customer.id }">
																<button class="btn btn-success btn-xs" title="View Customer">
																	<i class="fa fa-eye"></i>
																</button>
															</form>
															<form method="post" action="edit/${customer.id }">
																<button class="btn btn-primary btn-xs" title="Edit Customer">
																	<i class="fa fa-pencil"></i>
																</button>
															</form>
															<form method="post" action="delete/${customer.id }">
																<a href="delete/${customer.id }" id="confirm" title="Delete Customer" class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></a>
															</form>
															<form method="post" action="addPolicy/${customer.id }">
																<button class="btn btn-info btn-xs" title="Add Policy to Customer">
																	<i class="fa fa-plus"></i>
																</button>
															</form>
															<form method="post" action="viewPolicys/${customer.id }">
																<button class="btn btn-info btn-xs" title="View Customer's Policies">
																	<i class="fa fa-eye"></i>
																</button>
															</form>
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</c:when>
										<c:otherwise>
										 no result found
										</c:otherwise>
									</c:choose>
								</table>
									<!--<div class="text-center bg-danger">
										<label>Cannot delete a customer with an insurance policy.</label>
									</div>-->
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
	<script src="/InsuranceSystem/pages/assets/js/bootbox.js"></script>
	
	<script>

	$("a[class='btn btn-danger btn-xs']").click(function(e) {
	    e.preventDefault();
	    var location = $(this).attr('href');
	    
	    bootbox.confirm("Are you sure?", function(result) {
	    	if(result)
	    		window.location.replace(location);
	    	}); 
	});      
		//custom select box
function myFunction(){
	$("#1").val("");
	$("#datepicker").val("");
			if($("#sel1").val()=='Date of Birth'){
				console.log($("#sel1").val());
				$("#datepicker").css({
	                'display':'block'
	            });
				$("#datepicker").prop('disabled',false);
				$("#datepicker").datepicker();
				$("#1").css({
                    'display':'none'
                });
				$("#1").prop('disabled',true);
			
			}
			else{
				$("#datepicker").prop('disabled',true);
				$("#1").css({
                    'display':'block'
                });
				$("#1").prop('disabled',false);
			$("#datepicker").css({
                'display':'none'
            });
			
			
			}
			
		}
		
$(function() {
	$("#datepicker").datepicker();
	
	
});
	</script>

</body>
</html>
