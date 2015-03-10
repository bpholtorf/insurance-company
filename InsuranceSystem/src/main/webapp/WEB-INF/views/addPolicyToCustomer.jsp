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

    <title>DASHGUM - Bootstrap Admin Template</title>

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
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
            <!--logo start-->
            <a href="index.html" class="logo"><b>DASHGUM FREE</b></a>
            <!--logo end-->
            <div class="nav notify-row" id="top_menu">
                <!--  notification start -->
                <ul class="nav top-menu">
                    <!-- settings start -->
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                            <i class="fa fa-tasks"></i>
                            <span class="badge bg-theme">4</span>
                        </a>
                        <ul class="dropdown-menu extended tasks-bar">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green">You have 4 pending tasks</p>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">DashGum Admin Panel</div>
                                        <div class="percent">40%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                            <span class="sr-only">40% Complete (success)</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">Database Update</div>
                                        <div class="percent">60%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (warning)</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">Product Development</div>
                                        <div class="percent">80%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                            <span class="sr-only">80% Complete</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">Payments Sent</div>
                                        <div class="percent">70%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width: 70%">
                                            <span class="sr-only">70% Complete (Important)</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="external">
                                <a href="#">See All Tasks</a>
                            </li>
                        </ul>
                    </li>
                    <!-- settings end -->
                    <!-- inbox dropdown start-->
                    <li id="header_inbox_bar" class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                            <i class="fa fa-envelope-o"></i>
                            <span class="badge bg-theme">5</span>
                        </a>
                        <ul class="dropdown-menu extended inbox">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green">You have 5 new messages</p>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img alt="avatar" src="/InsuranceSystem/pages/assets/img/ui-zac.jpg"></span>
                                    <span class="subject">
                                    <span class="from">Zac Snider</span>
                                    <span class="time">Just now</span>
                                    </span>
                                    <span class="message">
                                        Hi mate, how is everything?
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img alt="avatar" src="/InsuranceSystem/pages/assets/img/ui-divya.jpg"></span>
                                    <span class="subject">
                                    <span class="from">Divya Manian</span>
                                    <span class="time">40 mins.</span>
                                    </span>
                                    <span class="message">
                                     Hi, I need your help with this.
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img alt="avatar" src="/InsuranceSystem/pages/assets/img/ui-danro.jpg"></span>
                                    <span class="subject">
                                    <span class="from">Dan Rogers</span>
                                    <span class="time">2 hrs.</span>
                                    </span>
                                    <span class="message">
                                        Love your new Dashboard.
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img alt="avatar" src="/InsuranceSystem/pages/assets/img/ui-sherman.jpg"></span>
                                    <span class="subject">
                                    <span class="from">Dj Sherman</span>
                                    <span class="time">4 hrs.</span>
                                    </span>
                                    <span class="message">
                                        Please, answer asap.
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">See all messages</a>
                            </li>
                        </ul>
                    </li>
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
                      <a class="active" href="javascript:;" >
                          <i class="fa fa-cogs"></i>
                          <span>Customer</span>
                      </a>
                      <ul class="sub">
							<li><a href="<c:url value='/customer/viewAll' />">Customer List</a></li>
							<li><a href="<c:url value='/requestAddCustomer' />">Add Customer</a></li>
							<li class="active"><a  href="<c:url value='/requestAddCustomer' />">Edit Customer</a></li>
                          
                      </ul>
                  </li>
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
                      <a href="javascript:;" >
                          <i class="fa fa-th"></i>
                          <span>Insurance</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="basic_table.html">Basic Table</a></li>
                          <li><a  href="responsive_table.html">Responsive Table</a></li>
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
          	<h3><i class="fa fa-angle-right"></i> Add Policy To Customer</h3>
		  		<div class="row mt">
			  		<div class="col-lg-12">
                      <div class="content-panel">
							<form action="searchPolicy" method="post"> 
						<label id="cid" style="display:none" >${customer.id } </label>
                       <div>Customer Name: ${customer.firstName } ${customer.lastName } </div>
                       <div style="width: 20%; margin-left: 350px; margin-top:-17px;">Policy Name:
                    <select class="form-control" id="sel1"
													 name="policyName" style="margin-left:100px;margin-top:-28px">
													      <option selected="selected"></option>  
														  <c:forEach items="${policys }" var="policy">
                          									<option value="${policy.policyName}">${policy.policyName}</option>
													      </c:forEach>
													     
												</select>
												<button class="btn btn-theme" id="submit" type="submit" style="margin-left:300px;margin-top:-34px">Submit</button>
												</div>
					</form> 
                      <br>
                      <c:if test="${!empty policyInfo }">
                      <h4><i class="fa fa-angle-right"></i>Policy Information</h4>
                          <section id="unseen">
                            <table class="table table-bordered table-striped table-condensed">
                              <thead>
                             
                              <tr>
                                  <th class="numeric">Policy Name</th>
                                  <th class="numeric">Policy Number</th>
                                  <th class="numeric">Plan Type</th>
                                  <th class="numeric">Pay Period</th>
                                  <th class="numeric">Amount</th>
                                  <th class="numeric">Deductible</th>
                                  <th class="numeric">Premium Percentage</th>
                                  <th></th>
                              </tr>
                              </thead>
                              <tbody>
                               <c:forEach items="${policyInfo }" var="policyInfo" varStatus="loop">
                                <form action="viewPolicys" method="post"> 
                               <input id="pid" style="display:none" value="${policyInfo.id }" name="policyId"/>
                              <tr>
                                  <td class="numeric" >${policyInfo.policyName }</td>
                                  <td class="numeric" ><a>${policyInfo.policyNumber }</a></td>
                                  <td class="numeric" >${policyInfo.planType }</td>
                                  <td class="numeric" >${policyInfo.payPeriod } months</td>
                                  <td class="numeric" >${policyInfo.amount }</td>
                                  <td class="numeric" >${policyInfo.deductible }</td>
                                  <td class="numeric" >${policyInfo.premiumPercent }</td>
                                  <c:choose>
                                  <c:when test="${policyInfo.check == 'added' }">
                                  <td><button class="btn btn-theme" type="button" style="font-size:12px;height:25px" id="addPolicy" disabled="disabled">Added</button></td>
                                  </c:when>
                                  <c:when test="${policyInfo.check == 'unadded' }">
                                   <td><button class="btn btn-theme" type="submit" style="font-size:12px;height:25px" id="addPolicy">Add</button></td>
                                  </c:when>
                                  </c:choose>
                              </tr>
                             </form>
                         </c:forEach>
                  <c:if test="${error }">          
		       <label style="color:red;display:none" id="mess">The customer has already added this insurance policy.</label>
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
      <footer class="site-footer">
          <div class="text-center">
              2014 - Alvarez.is
              <a href="form_component.html#" class="go-top">
                  <i class="fa fa-angle-up"></i>
              </a>
          </div>
      </footer>
      <!--footer end-->
  </section>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="/InsuranceSystem/pages/assets/js/jquery.js"></script>
    <script src="/InsuranceSystem/pages/assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="/InsuranceSystem/pages/assets/js/jquery.dcjqaccordion.2.7.js"></script>
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
	<script type="text/javascript" src="/InsuranceSystem/pages/assets/js/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="/InsuranceSystem/pages/assets/js/bootstrap-daterangepicker/date.js"></script>

	<script type="text/javascript" src="/InsuranceSystem/pages/assets/js/bootstrap-daterangepicker/daterangepicker.js"></script>
	
	<script type="text/javascript" src="/InsuranceSystem/pages/assets/js/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
	
	
	<script src="/InsuranceSystem/pages/assets/js/form-component.js"></script>    
	
   <!--  <script type="text/javascript">
      //custom select box
 $(document).ready(function() {
				var i;
				for (i = 0; i <= 1; i++) {
					$("#a" + i).click(function() {
								var pid=$("#pid").text();
								var num=$("#num").text();
						    	console.log(num);
						    	 dataToPost="policyId="+pid;
						    	 $.ajax({
						             url: "check",
						             type: "GET",
						             data: dataToPost, 
						             success: function (response) {
						            	
						            	 if(response=="true"){
						            		 var m=document.getElementById('mess');
						                	 $(m).css({
						                         'display':'block'
						                       });
						            	 }else{
						            		 console.log(response);
						            		 addSuccess(pid);
						            	 }
						             },
						   	     
						         });  
							});
				
				}
			});
      </script>  -->
<!--  <script type="text/javascript"> -->
      
<!--  document.getElementById('addPolicy').onclick = function() {

    	var pid=$("#pid").text();
    	console.log(pid);
    	 dataToPost="policyId="+pid;
    	 $.ajax({
             url: "check",
             type: "GET",
             data: dataToPost, 
             success: function (response) {
            	
            	 if(response=="true"){
            		 var m=document.getElementById('mess');
                	 $(m).css({
                         'display':'block'
                       });
            	 }else{
            		 console.log(response);
            		 addSuccess(pid);
            	 }
             },
   	     
         });  
    }; 

    function addSuccess(pid){
    	var cid=$("#cid").text();
    	 dataToPost="policyId="+pid;
    	 console.log(pid);
    	 $.ajax({
             url: "viewPolicys",
             type: "GET",
             data: dataToPost, 
             success: function (response) {
            	 window.location.href="/InsuranceSystem/customer/viewPolicys/{cid}";  

             },
             dataType: "html",
         });  
    };
 -->
    
      

    

  </body>
</html>
