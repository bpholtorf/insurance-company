<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
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
			
			<div class="top-menu">
				<ul class="nav pull-right top-menu">
					<li><a class="logout" href="login.html">Logout</a></li>
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


					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-desktop"></i> <span>Staff</span>
					</a>
						<ul class="sub">
							<li><a href="<c:url value='/staff/viewAll' />">Staff
									List</a></li>
							<li><a href="<c:url value='/requestAdd' />">Add Staff</a></li>

						</ul></li>

					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-cogs"></i> <span>Customer</span>
					</a>
						<ul class="sub">
							<li><a href="<c:url value='/customer/viewAll' />">Customer
									List</a></li>
							<li><a href="<c:url value='/requestAddCustomer' />">Add
									Customer</a></li>
							<li><a href="<c:url value='/requestAddCustomer' />">Edit
									Customer</a></li>

						</ul></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-cogs"></i> <span>Insurance Policy</span>
					</a>
						<ul class="sub">
							<li><a href="<c:url value='/insurancePolicy/viewAll' />">Insurance
									Policy List</a></li>
							<li><a href="<c:url value='/requestAddInsurancePolicy' />">Add
									Insurance Policy</a></li>

						</ul></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-book"></i> <span>Policy</span>
					</a>
						<ul class="sub">
							<li><a href="<c:url value='/customer/viewAllPolicys' />">Customer
									Policys List</a></li>
						</ul></li>

					<li class="sub-menu"><a href="javascript:;" class="active">
							<i class="fa fa-th"></i> <span>Insurance Claim</span>
					</a>
						<ul class="sub">
							<li><a href="<c:url value='/requestAddClaim' />">Add
									Claim from Customer</a></li>
							<li class="active"><a
								href="<c:url value='/claim/viewAll' />">View Claim</a></li>
								 <li><a href="<c:url value='/drug/view' />">View Drug</a></li>
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

				<h3>
					<i class="fa fa-angle-right"></i> Insurance Claim List
					<div class="col-sm-3 col-md-4 pull-right" style="margin-top: -10px">
						<form class="navbar-form" role="search" action="searchClaim"
							onsubmit="return checkKeyword()">


							<div class="input-group" style="">
								<input type="text" class="form-control" placeholder="Search"
									name="keyword" placeholder="Input SSN(000000000)"
									value="${keyword }">

								<div class="input-group-btn">
									<button class="btn btn-default" type="submit"
										style="padding: 9">
										<i class="glyphicon glyphicon-search"></i>
									</button>
								</div>
							</div>

						</form>
					</div>
				</h3>
				<div class="row mt">
					<div class="col-md-12">
						<div class="content-panel">
							<table class="table table-striped table-advance table-hover">
								<h4>
									<i class="fa fa-angle-right"></i>Pharmacy Claims
								</h4>
								<hr>
								<c:choose>
									<c:when test="${!empty pharClaims }">
										<thead>
											<tr>
											    <th>Bill Number</th>
												<th>Claim Number</th>
												<th class="hidden-phone">Insurred Date</th>
												<th>SSN</th>
												<th>Total Charge</th>
												<th>Total Coverage</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${pharClaims}" var="pc">
												<tr>
												    <td>${pc.billNumber }</td>
													<td>${pc.claimNumber }</td>
													<fmt:formatDate value="${pc.date}" type="date"
														pattern="MM/dd/yyyy" var="theFormattedDate" />
													<td class="hidden-phone">${theFormattedDate }</td>
													<td>${pc.ssn }</td>
													<td>${pc.totalCharge }</td>
													<td>${pc.totalCoverage }</td>
													<td>
														<form action="view/${pc.billNumber }" method="post">
															<button type="submit" class="btn btn-success btn-xs">View</button>
														</form>
													</td>
													<td><c:choose>
															<c:when test="${pc.status == 1}">
                                                                <a onClick="sendReport('${pc.billNumber}')"
																class="btn btn-success btn-xs" id="${ pc.billNumber}">Send
																Report</a>
             												</c:when>
															
															<c:otherwise>
       																<a onClick="sendReport('${pc.billNumber}')"
																class="btn btn-success btn-xs" id="${ pc.billNumber}">Resend
																Report</a>
    														</c:otherwise>
														</c:choose> 
											</c:forEach>
										</tbody>
									</c:when>

									<c:otherwise>
							 No result found for Pharmacy Insurance Claims
							</c:otherwise>
								</c:choose>
							</table>
						</div>
						<!-- /content-panel -->
					</div>
					<!-- /col-md-12 -->
				</div>
				<!-- /row -->

				<div class="row mt">
					<div class="col-md-12">
						<div class="content-panel">
							<table class="table table-striped table-advance table-hover">
								<h4>
									<i class="fa fa-angle-right"></i>Hospital Claims
								</h4>
								<hr>
								<c:choose>
									<c:when test="${!empty hosClaims }">
										<thead>

											<tr>
											    <th>Bill Number</th>
												<th>Claim Number</th>
												<th class="hidden-phone">Insured Date</th>
												<th>SSN</th>
												<th>Total Charge</th>
												<th>Total Coverage</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${hosClaims}" var="hc">
												<tr>
												    <td>${hc.billNumber }</td>
													<td>${hc.claimNumber }</td>
													<fmt:formatDate value="${hc.date}" type="date"
														pattern="MM/dd/yyyy" var="theFormattedDate" />
													<td class="hidden-phone">${theFormattedDate }</td>
													<td>${hc.ssn }</td>
													<td>${hc.totalCharge }</td>
													<td>${hc.totalCoverage }</td>
													<td>

														<form action="view/${hc.billNumber }" method="post">
															<button type="submit" class="btn btn-success btn-xs">View</button>
														</form>
													</td>
													<td><c:choose>
															<c:when test="${hc.status == 1}">
                                                                <a onClick="sendReport('${hc.billNumber}')"
																class="btn btn-success btn-xs" id="${ hc.billNumber}">Send
																Report</a>
             												</c:when>
															
															<c:otherwise>
       																<a onClick="sendReport('${hc.billNumber}')"
																class="btn btn-success btn-xs" id="${ hc.billNumber}">Resend
																Report</a>
    														</c:otherwise>
														</c:choose> 
															
														</td>
												</tr>
											</c:forEach>
										</tbody>
									</c:when>
									<c:otherwise>
							 No result found for Hospital Insurance Claims
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
		<footer class="site-footer"
			style="position: absolute; left: 210px; top: 800px; width: 1000px">
			<div class="text-center">
				2014 - Alvarez.is <a href="basic_table.html#" class="go-top"> <i
					class="fa fa-angle-up"></i>
				</a>
			</div>
		</footer>
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
	<script src="/InsuranceSystem/pages/assets/js/bootbox.js"></script>
	<!--script for this page-->

	<script>
		//custom select box

		function checkKeyword() {
			var keyword = $("input[name='keyword']").val();
			if (!isNaN(keyword)) {
				console.log('true');

				return true;

			} else {
				console.log('false');
				bootbox.alert("Please input numbers only!", function() {

				});
				return false;
			}

		}
		function sendReport(billNumber) {
			console.log("billNumber:" + billNumber);
			$
					.ajax({
						type : "get",
						url : "/InsuranceSystem/bill/sendReport",
						data : 'billId=' + billNumber,
						success : function(response) {

							console.log(response);

							document.getElementById(billNumber).innerHTML = 'Resend Report';
							bootbox.alert("Send report successfully!");
						},
						error : function(jqXHR, textStatus, errorThrown) {

							console.log('####' + textStatus, errorThrown);
						}
					});
		}
	</script>

</body>
</html>
