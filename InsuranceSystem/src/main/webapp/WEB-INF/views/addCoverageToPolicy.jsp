<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    <link rel="stylesheet" type="text/css" href="/InsuranceSystem/pages/assets/js/bootstrap-datepicker/css/datepicker.css" />
    <link rel="stylesheet" type="text/css" href="/InsuranceSystem/pages/assets/js/bootstrap-daterangepicker/daterangepicker.css" />
        
    <!-- Custom styles for this template -->
    <link href="/InsuranceSystem/pages/assets/css/style.css" rel="stylesheet">
    <link href="/InsuranceSystem/pages/assets/css/style-responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

  <section id="container" >
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
                          <i class="fa fa-user"></i>
                          <span>Customer</span>
                      </a>
                      <ul class="sub">
							<li ><a href="<c:url value='/customer/viewAll' />">Customer List</a></li>
							<li><a href="<c:url value='/requestAddCustomer' />">Add Customer</a></li>
                          
                      </ul>
                  </li>

                  <li class="sub-menu"><a  class="active"  href="javascript:;"> <i
							class="fa fa-cogs"></i> <span>Insurance Policy</span>

					</a>
						<ul class="sub">
							<li ><a href="<c:url value='/insurancePolicy/viewAll' />">Insurance Policy List</a></li>
							<li ><a href="<c:url value='/requestAddInsurancePolicy' />">Add Insurance Policy</a></li>
							<li class="active"><a href="<c:url value='' />">Edit Coverage</a></li>

						</ul></li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-book"></i>
                          <span>Customer Policy</span>
                      </a>
                      <ul class="sub">
                          <li ><a href="<c:url value='/customer/viewAllPolicys' />">Customer Policys List</a></li>
                      </ul>
                  </li>
                 
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
          	<h3><i class="fa fa-angle-right"></i> Edit Policy Coverage</h3>
		  		<div class="row mt">
			  		<div class="col-lg-12">
                      <div class="content-panel">
							<form action="viewCoverage/{id}" method="post"> 
						<label id="pid" style="display:none" >${insurancePolicy.id } </label>
                       <div>Policy Name: ${insurancePolicy.policyName} </div>
					</form> 
                      <br>
                      <c:if test="${!empty coverageInfo }">
                      <h4><i class="fa fa-angle-right"></i>Coverage Information</h4>
                          <section id="unseen">
                            <table class="table table-bordered table-striped table-condensed">
                              <thead>
                             
                              <tr>
                                  <th class="numeric">Id</th>
                                  <th class="numeric">Item Name</th>
                                  <th class="numeric">Policy Type</th>
                                  <th></th>
                              </tr>
                              </thead>
                              <tbody>
                               <c:forEach items="${coverageInfo }" var="coverageInfo" varStatus="loop">
                                <form action="viewCoverages" method="post"> 
                               <input id="pid" style="display:none" value="${coverageInfo.id }" name="policyId"/>
                              <tr>
                                  <td class="numeric" >${coverageInfo.id }</td>
                                  <td class="numeric" >${coverageInfo.itemName }</td>
                                  <td class="numeric" >${coverageInfo.policyType }</td>
                                  <c:choose>
                                  <c:when test="${coverageInfo.check == 'added' }">
                                   		<td><a href="deleteCoverage/${coverageInfo.itemName}" title="Remove Coverage" class="btn btn-danger">Remove</a></td>
                                  </c:when>
                                  <c:when test="${coverageInfo.check == 'unadded' }">
                                  		<td><a href="addCoverage/${coverageInfo.itemName }" title="Add Coverage" class="btn btn-theme">Add</a></td>
                                  </c:when>
                                  </c:choose>
                              </tr>
                             </form>
                         </c:forEach>
                  <c:if test="${error }">          
		       <label style="color:red;display:none" id="mess">The insurance policy already has this coverage.</label>
                 </c:if>
                              </tbody>
                          </table>
                          </section>
                          </c:if>
                  </div><!-- /content-panel -->
               </div><!-- /col-lg-4 -->			
		  	</div><!-- /row -->
		  	
		  	
		</section><! --/wrapper -->
      </section><!-- /MAIN CONTENT -->

      <!--main content end-->
      <!--footer start-->
      <!--footer end-->
  </section>
<!-- 
    js placed at the end of the document so the pages load faster
    <script src="/InsuranceSystem/pages/assets/js/jquery.js"></script>
    <script src="/InsuranceSystem/pages/assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="/InsuranceSystem/pages/assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="/InsuranceSystem/pages/assets/js/jquery.scrollTo.min.js"></script>
    <script src="/InsuranceSystem/pages/assets/js/jquery.nicescroll.js" type="text/javascript"></script>


    common script for all pages
    <script src="/InsuranceSystem/pages/assets/js/common-scripts.js"></script>

    script for this page
    <script src="/InsuranceSystem/pages/assets/js/jquery-ui-1.9.2.custom.min.js"></script>

	custom switch
	<script src="/InsuranceSystem/pages/assets/js/bootstrap-switch.js"></script>
	
	custom tagsinput
	<script src="/InsuranceSystem/pages/assets/js/jquery.tagsinput.js"></script>
	
	custom checkbox & radio
	<script type="text/javascript" src="/InsuranceSystem/pages/assets/js/bootstrap.js"></script>
	<script type="text/javascript" src="/InsuranceSystem/pages/assets/js/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="/InsuranceSystem/pages/assets/js/bootstrap-daterangepicker/date.js"></script>

	<script type="text/javascript" src="/InsuranceSystem/pages/assets/js/bootstrap-daterangepicker/daterangepicker.js"></script>
	
	<script type="text/javascript" src="/InsuranceSystem/pages/assets/js/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
	
	
	<script src="/InsuranceSystem/pages/assets/js/form-component.js"></script>    
	
     <script src="/InsuranceSystem/pages/assets/js/bootbox.js"></script> -->
	<!--script for this page-->

<!-- js placed at the end of the document so the pages load faster -->
	<script src="/InsuranceSystem/pages/assets/js/jquery.js"></script>
	<script src="/InsuranceSystem/pages/assets/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="/InsuranceSystem/pages/assets/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="/InsuranceSystem/pages/assets/js/jquery.scrollTo.min.js"></script>
	<script src="/InsuranceSystem/pages/assets/js/jquery.nicescroll.js"
		type="text/javascript"></script>
	<script src="/InsuranceSystem/pages/assets/js/validate.js"></script>


	<!--common script for all pages-->
	<script src="/InsuranceSystem/pages/assets/js/common-scripts.js"></script>
    <script src="/InsuranceSystem/pages/assets/js/bootbox.js"></script>
	<!--script for this page-->


    

  </body>
</html>
