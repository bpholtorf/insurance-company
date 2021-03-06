<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
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
<link rel="stylesheet"
	href="/InsuranceSystem/pages/assets/css/to-do.css">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
 <style>
 .panel-heading
 {
   border-top:0px;
 }
 </style>
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
                      <a href="javascript:;" >
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
							<li class="active"><a href="<c:url value='/requestAddClaim' />">Add Claim from Customer</a></li>
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
				<h3>
					<i class="fa fa-angle-right"></i> Pharmacy bills
				</h3>
				<c:url var="updateAction" value="/claim/generateClaim"></c:url>
				<form action="${updateAction }" method="GET">

					<input type="hidden" name="cid" value="${cid }"> <input
						type="hidden" name="pid" value="${pid }">
						<c:choose>
  											<c:when test="${!empty pharBills }">
					<div class="row mt">
						<div class="col-md-12">
							<div class="white-panel" style="color:#280909">

								<div class="custom-check goleft mt">
								
									<table id="todo" class="table custom-check">
										<tbody>
  											
											<c:forEach items="${pharBills }" var="bill">

												<tr id="aa">
													<td class="panel-heading" style="border-top:0px"><span class="check" ><input
															type="radio" value="${bill.billNumber}"
															class="checked" name="bNumber"></span><span style="margin-right:30px"> Bill ID: ${bill.billNumber }</span>
														<fmt:formatDate value="${bill.date}" type="date"
							                         	pattern="MM/dd/yyyy" var="theFormattedDate" />
                      
														<span>Date:${theFormattedDate }</span> <span
														class="pull-right clickable panel-collapsed"><i
															class="glyphicon glyphicon-chevron-down"></i></span></td>
												</tr>
												<tr id="bb">
													<td>

														<div class="panel-body" id="cc">
															<table class="table table-hover">

																<thead>
																	<tr>
																		<th>Drug Name</th>
																		<th>Drug Type</th>
																		
																		<th>QTY</th>
																		<th>Charge</th>
																	</tr>
																</thead>
																<tbody>
																	<c:forEach items="${bill.infoDBs }" var="billInfo">
																		<tr>
																			<td>${billInfo.name }</td>
																			<td>${billInfo.type }</td>
																			
																			<td>${billInfo.quantity }</td>
																			<td>${billInfo.totalCharge }</td>
																		</tr>
																	</c:forEach>
                                                                      <tr>
                                                                           <td class="highrow"></td>
                                                                           <td class="highrow"></td>
                                                                           <td class="highrow">Total</td>
                                                                           <td class="highrow">${bill.totalCharge }</td>
                                                                      </tr>

																</tbody>

																

															</table>
														</div>
														<!--/content-panel -->


													</td>

												</tr>
											</c:forEach>
											
										</tbody>
									</table>
								</div>
								<!-- /table-responsive -->
							</div>
							<!--/ White-panel -->
						</div>
						<!--/col-md-12 -->
					</div>
					<!-- row -->
					</c:when>
											
											 <c:otherwise>
							  No pharmacy bills for the customer currently
							</c:otherwise>
							</c:choose>

					<h3>
						<i class="fa fa-angle-right"></i> Hospital bills
					</h3>
                   <c:choose>	
											<c:when test="${!empty hosBills }">
					<!-- SIMPLE TO DO LIST -->
					<div class="row mt">
						<div class="col-md-12">
							<div class="white-panel" style="color:#280909">

								<div class="custom-check goleft mt">
									<table id="todo" class="table custom-check">
										<tbody>
											
											<c:forEach items="${hosBills }" var="bill">

												<tr id="aa">
													<td class="panel-heading"><span class="check"><input
															type="radio" value="${bill.billNumber}"
															 name="bNumber"></span> <span style="margin-right:30px">Bill ID:${bill.billNumber }</span>
															<fmt:formatDate value="${bill.date}" type="date"
							                         	pattern="MM/dd/yyyy" var="theFormattedDate" />
														<span>Date:${theFormattedDate}</span> 
														<span
														class="pull-right clickable panel-collapsed"><i
															class="glyphicon glyphicon-chevron-down"></i></span></td>
												</tr>
												<tr id="bb">
													<td>

														<div class="panel-body" id="cc">
															<table class="table table-hover">

								

																
																	<thead>
																		<tr>
																			<th>Item Name</th>
																			<th>Item Type</th>
																			<th>Operator Title</th>
																			<th>Price</th>
																			
																		</tr>
																	</thead>
																	<tbody>
																		<c:forEach items="${bill.infoDBs }" var="billInfo">
																			<tr>
																				<td>${billInfo.itemName }</td>
																				<td>${billInfo.itemType }</td>
																				<td>${billInfo.operatorTitle }</td>
																				<td>${billInfo.price }</td>
																				
																			</tr>
																		</c:forEach>
             															 <tr>
                                                                           <td class="highrow"></td>
                                                                           <td class="highrow"></td>
                                                                           <td class="highrow">Total</td>
                                                                           <td class="highrow">${bill.totalCharge }</td>
                                                                      </tr>

																	</tbody>
																


															</table>
														</div>
														<!--/content-panel -->


													</td>

												</tr>
											</c:forEach>
											
												
												
										</tbody>
									</table>
								</div>
								<!-- /table-responsive -->
							</div>
							<!--/ White-panel -->
						</div>
						<!--/col-md-12 -->
					</div>
					<!-- row -->
					 </c:when>
											   <c:otherwise>
							 No hospital bills for the customer currently
							</c:otherwise>
												</c:choose>
					<div class="row mt">
					<c:choose>
					<c:when test="${empty hosBills &&empty pharBills}">
					
					</c:when>
					<c:otherwise>
					<button type="submit" class="btn btn-primary"
						style="margin-left: 280px">Submit</button>
					</c:otherwise>
					</c:choose>
					</div>
				</form>
              
			</section>
			<!--/wrapper -->
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
	<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
	<script src="/InsuranceSystem/pages/assets/js/tasks.js"
		type="text/javascript"></script>

	<script>
		jQuery(document).ready(function() {
			TaskList.initTaskWidget();
		});

		$(function() {
			$("#sortable").sortable();
			$("#sortable").disableSelection();
		});
	</script>


	<script>
		//custom select box

		jQuery(function($) {
			
			   
			   
			   	 var radioInput=$("input[type='radio']");
			   	 if(radioInput.size()>0)
			     {
			   		radioInput.first().prop('checked',true); 
			   	 }
			
			
			$('.panel-body').hide();
			$('.panel-heading span.clickable').on(
					"click",
					function(e) {
						if ($(this).hasClass('panel-collapsed')) {
							// expand the panel
							console
									.log($(this).closest('tr').next()
											.attr('id'));
							$(this).closest('tr').next().children("td")
									.children(".panel-body").slideDown();
							$(this).removeClass('panel-collapsed');
							$(this).find('i').removeClass(
									'glyphicon-chevron-down').addClass(
									'glyphicon-chevron-up');
						} else {
							// collapse the panel
							$(this).closest('tr').next().children("td")
									.children(".panel-body").slideUp();
							$(this).addClass('panel-collapsed');
							$(this).find('i').removeClass(
									'glyphicon-chevron-up').addClass(
									'glyphicon-chevron-down');
						}
					});
		});
	</script>

</body>
</html>
