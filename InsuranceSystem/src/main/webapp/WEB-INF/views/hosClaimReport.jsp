<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Simple Invoice Template | PrepBootstrap</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="stylesheet" type="text/css"
	href="/InsuranceSystem/pages/assets/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="/InsuranceSystem/pages/assets/font-awesome/css/font-awesome.css" />
<link href="/InsuranceSystem/pages/assets/css/style.css"
	rel="stylesheet">
<link href="/InsuranceSystem/pages/assets/css/style-responsive.css"
	rel="stylesheet">


</head>
<body>
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
									alt="avatar" src="/InsuranceSystem/pages/assets/img/ui-zac.jpg"></span>
								<span class="subject"> <span class="from">Zac
										Snider</span> <span class="time">Just now</span>
							</span> <span class="message"> Hi mate, how is everything? </span>
						</a></li>
						<li><a href="index.html#"> <span class="photo"><img
									alt="avatar"
									src="/InsuranceSystem/pages/assets/img/ui-divya.jpg"></span> <span
								class="subject"> <span class="from">Divya Manian</span> <span
									class="time">40 mins.</span>
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
									src="/InsuranceSystem/pages/assets/img/ui-sherman.jpg"></span> <span
								class="subject"> <span class="from">Dj Sherman</span> <span
									class="time">4 hrs.</span>
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
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              
              	  <p class="centered"><a href="profile.html"><img src="/InsuranceSystem/pages/assets/img/ui-sam.jpg" class="img-circle" width="60"></a></p>
              	 <h5 class="centered">${user }</h5>
                    
                 

                  <li class="sub-menu">
                      <a  href="javascript:;" >
                          <i class="fa fa-desktop"></i>
                          <span>Staff</span>
                      </a>
                      <ul class="sub">
                          <li ><a href="<c:url value='/staff/viewAll' />">Staff List</a></li>
                          <li><a  href="<c:url value='/requestAdd' />">Add Staff</a></li>
                          
                      </ul>
                  </li>

                  <li class="sub-menu">
                      <a  href="javascript:;" >
                          <i class="fa fa-cogs"></i>
                          <span>Customer</span>
                      </a>
                      <ul class="sub">
							<li><a href="<c:url value='/customer/viewAll' />">Customer List</a></li>
							<li><a href="<c:url value='/requestAddCustomer' />">Add Customer</a></li>
							<li><a  href="<c:url value='/requestAddCustomer' />">Edit Customer</a></li>
                          
                      </ul>
                  </li>
                  <li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-cogs"></i> <span>Insurance Policy</span>
					</a>
						<ul class="sub">
							<li ><a href="<c:url value='/insurancePolicy/viewAll' />">Insurance Policy List</a></li>
							<li ><a href="<c:url value='/requestAddInsurancePolicy' />">Add Insurance Policy</a></li>

						</ul></li>
                  <li class="sub-menu">
                      <a  href="javascript:;" >
                          <i class="fa fa-book"></i>
                          <span>Policy</span>
                      </a>
                      <ul class="sub">
                          <li ><a href="<c:url value='/customer/viewAllPolicys' />">Customer Policys List</a></li>
                      </ul>
                  </li>
                 
                  <li class="sub-menu">
                      <a href="javascript:;" class="active">
                          <i class="fa fa-th"></i>
                          <span>Insurance</span>
                      </a>
                      <ul class="sub">
							<li><a href="<c:url value='/requestAddClaim' />">Add Claim from Customer</a></li>
							<li class="active"><a href="<c:url value='/claim/viewAll' />">View Claim</a></li>
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
			<!-- Simple Invoice - START -->
			<div class="container">
				<div class="row">

					<div class="text-center">

						<h2>Claim for Bill #33221</h2>
					</div>
					<hr>
					<div class="row">
						<div class="col-xs-12 col-md-5 col-lg-4">
							<div class="panel panel-default height">
								<div class="panel-heading">Claim Information</div>
								<div class="panel-body">
									<strong>Claim ID:</strong> ${bill.claimNumber}<br> <strong>Insured:</strong>
									${cus.firstName } ${cus.lastName }<br> <strong>Insured
										ID:</strong> ${cus.id }<br> <strong>SSN:</strong> ${cus.SSN }<br>
										<fmt:formatDate value="${bill.date}" type="date"
								pattern="MM/dd/yyyy" var="theFormattedDate" />
									<strong>Incurred:</strong> ${theFormattedDate}<br>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-md-5 col-lg-4">
							<div class="panel panel-default height">
								<div class="panel-heading">Policy Information</div>
								<div class="panel-body">
							<strong>Policy Name:</strong> ${policy.policyName}<br>
                            <strong>Policy Number:</strong> ${policy.policyNumber }<br>
                            <strong>Policy Type:</strong> ${policy.planType}<br>
							<strong>Pharmacy Amount Left:</strong> ${cusPo.pamountLeft }<br> 
							<strong>Hospital Amount Left:</strong> ${cusPo.hamountLeft }<br>

								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="text-center">
										<strong>Claim Report</strong>
									</h3>
								</div>
								<div class="panel-body">
									<div class="table-responsive">
										<table class="table table-condensed">
											<thead>
												<tr>
													<td><strong>Item Name</strong></td>
													<td class="text-center"><strong>item Type</strong></td>
													<td class="text-center"><strong>operatorTitle</strong></td>
													<td class="text-center"><strong>Price</strong></td>
													<td class="text-center"><strong>Covered or
															not</strong></td>
													<td class="text-right"><strong>Covered Amount</strong></td>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${bill.infoDBs}" var="infoDB">
													<tr>

														<td>${infoDB.itemName }</td>
														<td class="text-center">${infoDB.itemType }</td>
														<td class="text-center">${infoDB.operatorTitle }</td>

														<td class="text-center">${infoDB.price }</td>
														<c:choose>
															<c:when test="${not infoDB.covered}">
                                                             <td class="text-center">NO</td>
                                                            </c:when>
															
															<c:otherwise>
        														<td class="text-center">YES</td>
    														</c:otherwise>
														</c:choose>
														<td class="text-right">${infoDB.coverage }</td>
													</tr>
												</c:forEach>


												<tr>
													<td class="highrow"></td>
													<td class="highrow"></td>
													<td class="highrow"></td>
													<td class="highrow"></td>
													<td class="highrow text-center"><strong>Total</strong></td>
													<td class="highrow text-right">${bill.totalCharge}</td>
												</tr>
												<tr>
													<td class="emptyrow text-center"></td>
													<td class="emptyrow text-center"></td>
													<td class="emptyrow text-center"></td>
													<td class="emptyrow text-center"></td>
													<td class="emptyrow text-center"><strong>Total
															Covered Amount</strong></td>
													<td class="emptyrow text-right">${bill.totalCoverage }</td>
												</tr>
												<tr>
													<td class="emptyrow"></td>
													<td class="emptyrow"></td>
													<td class="emptyrow"></td>
													<td class="emptyrow"></td>
													<td class="emptyrow text-center"><strong>Customer
															Responsibility</strong></td>
													<td class="emptyrow text-right">${bill.customerPay }</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
		</section>
	</section>
	<style>
.height {
	min-height: 200px;
}

.icon {
	font-size: 47px;
	color: #5CB85C;
}

.iconbig {
	font-size: 77px;
	color: #5CB85C;
}

.table>tbody>tr>.emptyrow {
	border-top: none;
}

.table>thead>tr>.emptyrow {
	border-bottom: none;
}

.table>tbody>tr>.highrow {
	border-top: 3px solid;
}
</style>

	<!-- Simple Invoice - END -->

	</div>
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
	<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
	<script src="/InsuranceSystem/pages/assets/js/tasks.js"
		type="text/javascript"></script>
</body>
</html>