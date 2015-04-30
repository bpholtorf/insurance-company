<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insurance System</title>
<link href="/InsuranceSystem/pages/assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="/InsuranceSystem/pages/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        
    <!-- Custom styles for this template -->
    <link href="/InsuranceSystem/pages/assets/css/style.css" rel="stylesheet">
    <link href="/InsuranceSystem/pages/assets/css/style-responsive.css" rel="stylesheet">
    
     
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
                    
                  <li class="mt">
                      <a href="index.html">
                          <i class="fa fa-dashboard"></i>
                          <span>Dashboard</span>
                      </a>
                  </li>

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
                          <span>Insurance Claim</span>
                      </a>
                      <ul class="sub">
							<li class="active"><a href="<c:url value='/requestAddClaim' />">Add Claim from Customer</a></li>
							<li ><a href="<c:url value='/claim/viewAll' />">View Claim</a></li>
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
          	<h3><i class="fa fa-angle-right"></i> Customer SSN: ${ssn }</h3>
          	<c:url var="updateAction" value="/claim/addClaim" ></c:url>
				<form action="${updateAction }" method="GET">
				<input type="hidden" name="cid" value="${cid }">
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
				<input type="hidden" name="memberName" value="${c.firstName } ${c.lastName}">
				<c:forEach items="${policy }" var="policy">
					<div class="row">
						<div class="col-md-12 mt">
							<div class="content-panel">

								<h4 class="accordion" id="accordion2">
									<input type="radio" value="${policy.pid}" name="pid">
									
									${policy.policyNumber}
								</h4>
								<hr>
								<table class="table">
									<tbody>
										<tr>
											<td>Policy Number:</td>
											<td>${policy.policyNumber}</td>
											<td>Date From:</td>
											<fmt:formatDate value="${policy.dateFrom }" type="date"
												pattern="MM/dd/yyyy" var="theFormattedDate" />
											<td>${theFormattedDate}</td>
										</tr>
										<tr>
											<td>Date To:</td>
											<fmt:formatDate value="${policy.dateTo }" type="date"
												pattern="MM/dd/yyyy" var="theFormattedDate2" />
											<td>${theFormattedDate2}</td>
											<td>Premium:</td>
											<td>${policy.premium }</td>
										</tr>
										<tr>
											<td>Pharmacy Amount Left:</td>
											<td>${policy.pamountLeft }</td>

											<td>Hosipital Amount Left:</td>
											<td>${policy.hamountLeft }</td>
										</tr>


									</tbody>
								</table>
							</div>
							<! --/content-panel -->
						</div>
						<!-- /col-md-12 -->
					</div>
				</c:forEach>
				<a class="btn btn-primary"
					style="margin-left: 460px; margin-top: 20px"
					onClick="postRequest()">Next</a>
				   </form>
			</section>
			<! --/wrapper -->
		</section>
		<!-- /MAIN CONTENT -->
		<script src="/InsuranceSystem/pages/assets/js/jquery.js"></script>
		<script src="/InsuranceSystem/pages/assets/js/bootstrap.min.js"></script>
		<script class="include" type="text/javascript"
			src="/InsuranceSystem/pages/assets/js/jquery.dcjqaccordion.2.7.js"></script>
		<script src="/InsuranceSystem/pages/assets/js/jquery.scrollTo.min.js"></script>
		<script src="/InsuranceSystem/pages/assets/js/jquery.nicescroll.js"
			type="text/javascript"></script>
		<script src="/InsuranceSystem/pages/assets/js/bootbox.js"></script>

		<!--common script for all pages-->
		<script src="/InsuranceSystem/pages/assets/js/common-scripts.js"></script>

		<!--script for this page-->

		<script>
			$(document).ready(function() {
				$("td").css("border-top", "0px");

				var radioInput = $("input[type='radio']");
				if (radioInput.size() > 0) {
					radioInput.first().prop('checked', true);
				}

			});
			$(':checkbox').change(function() {
				$(':checkbox').prop('checked', false);
				$(this).prop('checked', true);

			});
			function getFamily(cid, pid) {
				var family = $.ajax({
					url : "/InsuranceSystem/claim/getFamily",
					async : false,
					data : 'pid=' + pid + '&cid=' + cid,
				}).responseText;

				return family;
			}
			function postRequest() {
				
				var pid = $('input[name="pid"]:checked').val();
				var cid = ${cid};
				
				var planType = $.ajax({
					url : "/InsuranceSystem/claim/getPolicyByPid",
					data : 'pid=' + pid,
					async : false,
				}).responseText;

				if (planType.toUpperCase() ==="family".toUpperCase()||planType.toUpperCase() ==="Employee-sponsored-family".toUpperCase()) {
					var family = getFamily(cid, pid);
					var obj = eval('{' + family + '}');
					var key, count = 0;
					
					var html = '<div class="row">  '
						+ '<div class="col-md-12"> '
						+ '<form class="form-horizontal" id="myForm2"> '
						+ '<div class="form-group"> '
						+ '<div class="col-md-4"> ';
						
				   for (var i=0;i<obj.length;i++)
						{
					   if(i==0)
						  {
						   html+='<div class="radio"> <label for="awesomeness-1"> '
								+ '<input type="radio" checked = "true" name="awesomeness" id="awesomeness-1" value="'+obj[i]+'"> '+obj[i]+' </label> '
								+ '</div> ';
						  }
					   else{
						html+='<div class="radio"> <label for="awesomeness-1"> '
						+ '<input type="radio" name="awesomeness" id="awesomeness-1" value="'+obj[i]+'"> '+obj[i]+' </label> '
						+ '</div> ';
					   }
						}
				   
				   html+= '</div> </div>'
						+ '</form> </div>  </div>';
				   bootbox.dialog({
						title : "Choose a family member.",
						message : html,
						buttons : {
							success : {
								label : "Save",
								className : "btn-success",
								callback : function() {
									
									var memberName=$('input[name="awesomeness"]:checked').val();
									$('input[name="memberName"]').val(memberName);
									console.log("input memberName:"+memberName)
									$('#myForm').submit();
								}
							}
						}
					});
				  
				} 
				else
					$('#myForm').submit();
          
			}
		</script>
=======
>>>>>>> Stashed changes
				 <c:forEach items="${policy }" var="policy">
				 <div class="row">
	                  <div class="col-md-12 mt">
	                  	  <div class="content-panel">
	                  	      
	                  	  	  <h4 class="accordion" id="accordion2"><input type="radio" value="${policy.pid}" name="pid">
	                  	  	  <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" data-target="#collapseOne"> 
	                  	  	  ${policy.policyNumber}
	                  	  	  </a>
	                  	  	  </h4>
	                  	  	  <hr>
		                     <table class="table" id="collapseOne" class="accordion-body collapse">
                    <tbody>
                      <tr>
                        <td >Policy Number:</td>
                        <td >${policy.policyNumber}</td>          
                        <td >Date From:</td>
                        <fmt:formatDate value="${policy.dateFrom }" type="date"
								pattern="MM/dd/yyyy" var="theFormattedDate" />
                        <td >${theFormattedDate}</td>
                      </tr>
                      <tr>
                        <td >Date To:</td>
                         <fmt:formatDate value="${policy.dateTo }" type="date"
								pattern="MM/dd/yyyy" var="theFormattedDate2" />
                        <td >${theFormattedDate2}</td>
                        <td >Premium:</td>
                        <td >${policy.premium }</td>
                      </tr>
                      <tr>
                        <td >Pharmacy Amount Left:</td>
                        <td >${policy.pamountLeft }</td>
                     
                        <td >Hosipital Amount Left:</td>
                        <td >${policy.hamountLeft }</td>
                      </tr>
                      
                     
                    </tbody>
                  </table>
	                  	  </div><! --/content-panel -->
	                  </div><!-- /col-md-12 -->
	                  </div>
                  </c:forEach>
	                  <button class="btn btn-primary" style="margin-left:460px; margin-top:20px" type="submit">Next</button>
	                  </form>
		</section><! --/wrapper -->
      </section><!-- /MAIN CONTENT -->
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
	$( document ).ready(function() {
	    $("td").css("border-top","0px");
	   
	   	 var radioInput=$("input[type='radio']");
	   	 if(radioInput.size()>0)
	     {
	   		radioInput.first().prop('checked',true); 
	   	 }
	   
	});
	$(':checkbox').change(function(){
		$(':checkbox').prop('checked',false);
		$(this).prop('checked',true);
			
		
	});
 
	</script>
<<<<<<< Updated upstream
=======
>>>>>>> origin/master
>>>>>>> Stashed changes
</body>
</html>