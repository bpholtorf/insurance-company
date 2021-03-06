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
                      <a class="active" href="javascript:;" >
                          <i class="fa fa-user"></i>
                          <span>Customer</span>
                      </a>
                      <ul class="sub">
							<li class="active"><a href="<c:url value='/customer/viewAll' />">Customer List</a></li>
							<li><a href="<c:url value='/requestAddCustomer' />">Add Customer</a></li>
                          
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
												<button class="btn btn-theme" id="submit" type="submit" style="margin-left:320px;margin-top:-34px">Submit</button>
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
                                  <th class="numeric">Pharmacy Amount</th>
                                  <th class="numeric">Hostipal Amount</th>
                                  <th class="numeric">Premium Percentage</th>
                                  <th class="numeric">Status</th>
                              </tr>
                              </thead>
                              <tbody>
                               <c:forEach items="${policyInfo }" var="policyInfo" varStatus="loop">
                                <form action="viewPolicys" method="post"> 
                               <input id="pid" style="display:none" value="${policyInfo.id }" name="policyId"/>
                              <tr>
                                  <td class="numeric" >${policyInfo.policyName }</td>
                                  <td class="numeric" >${policyInfo.policyNumber }</td>
                                  <td class="numeric" >${policyInfo.planType }</td>
                                  <td class="numeric" >${policyInfo.payPeriod } months</td>
                                  <td class="numeric" >${policyInfo.pamount }</td>
                                  <td class="numeric" >${policyInfo.hamount }</td>
                                  <td class="numeric" >${policyInfo.premiumPercent }</td>
                                  <c:choose>
                                  <c:when test="${policyInfo.check == 'added' }">
                                  <td><button class="btn btn-theme"  type="button" style="font-size:12px;height:25px" id="addPolicy" disabled="disabled">Added</button></td>
                                  </c:when>
                                  <c:when test="${policyInfo.check == 'unadded'  && policyInfo.planType=='Individual' }">
                                   <td><a href="viewPolicys?policyId=${policyInfo.id }&name1=&name2=&name3=&name4=&ssn1=&ssn2=&ssn3=&ssn4=" class="btn btn-info"  style="font-size:12px;height:25px" id="addPolicy">Add</a></td>
                                  </c:when>
                                  <c:when test="${policyInfo.check == 'unadded'  && policyInfo.planType=='Employee-sponsored-individual' }">
                                   <td><a href="viewPolicys?policyId=${policyInfo.id }&name1=&name2=&name3=&name4=&ssn1=&ssn2=&ssn3=&ssn4=" class="btn btn-info"  style="font-size:12px;height:25px" id="addPolicy">Add</a></td>
                                  </c:when>
                                  <c:when test="${policyInfo.check == 'unadded'  && policyInfo.planType=='Employee-sponsored-family' }">
                                   <td><a href="viewPolicys?policyId=${policyInfo.id }&name1=&name2=&name3=&name4=&ssn1=&ssn2=&ssn3=&ssn4=" class="btn btn-info"  style="font-size:12px;height:25px" id="addPolicy">Add</a></td>
                                  </c:when>
                                   <c:when test="${policyInfo.check == 'unadded'  && policyInfo.planType=='Family' }">
                                   <td><a href="viewPolicys" class="btn btn-theme"  style="font-size:12px;height:25px" id="addPolicy">Add</a></td>
                                  </c:when>
                                  <%--  <c:when test="${policyInfo.check == 'unadded'  && policyInfo.planType=='Employ-sponsored-family' }">
                                   <td><a href="viewPolicys" class="btn btn-theme"  style="font-size:12px;height:25px" id="addPolicy">Add</a></td>
                                  </c:when> --%>
                                 
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


	<script>
	$("a[class='btn btn-theme']").click(function(e) {
	    e.preventDefault();
	    var location = $(this).attr('href');
	    
	     bootbox.dialog({
            title: "Input Family Members Name.",
            message: '<div class="row">  ' +
                '<div class="col-md-12"> ' +
                '<form class="form-horizontal"> ' +
                '<div class="form-group" style="height:180px"> ' +
                '<label class="col-md-4 control-label" for="name">Member Name</label> ' +
                '<label class="col-md-4 control-label" for="name">Member SSN</label> ' +
                '<br>'+
                '<input id="name1" name="name" type="text" placeholder="Name" class="form-control input-md" style="width:150px;position:absolute;top:30px;left:15px"> ' +
                '<input id="ssn1" name="ssn1" type="text" placeholder="eg:000000000" class="form-control input-md" style="width:150px;position:absolute;top:30px;left:215px"> ' +
                '<br>'+
                '<input id="name2" name="name" type="text" placeholder="Name" class="form-control input-md" style="width:150px;position:absolute;top:70px;left:15px"> ' +
                '<input id="ssn2" name="name" type="text" placeholder="eg:000000000" class="form-control input-md" style="width:150px;position:absolute;top:70px;left:215px"> ' +
                '<br>'+
                '<input id="name3" name="name" type="text" placeholder="Name" class="form-control input-md" style="width:150px;position:absolute;top:110px;left:15px"> ' +
                '<input id="ssn3" name="name" type="text" placeholder="eg:000000000" class="form-control input-md" style="width:150px;position:absolute;top:110px;left:215px"> ' +
                '<br>'+
                '<input id="name4" name="name" type="text" placeholder="Name" class="form-control input-md" style="width:150px;position:absolute;top:150px;left:15px"> ' +
                '<input id="ssn4" name="name" type="text" placeholder="eg:000000000" class="form-control input-md" style="width:150px;position:absolute;top:150px;left:215px"> ' +
                '<br>'+
                '<label id="aa" style="color: red;visibility: hidden;">Please input at least one name and SSN</label> ' +
                '</div> ' +
                '</form> </div>  </div>',
            buttons: {
                success: {
                    label: "Save",
                    className: "btn-success",
                    callback: function () {
                        var name1 = $('#name1').val();
                        var name2 = $('#name2').val();
                        var name3 = $('#name3').val();
                        var name4 = $('#name4').val();
                        var ssn1=$('#ssn1').val();
                        var ssn2=$('#ssn2').val();
                        var ssn3=$('#ssn3').val();
                        var ssn4=$('#ssn4').val();
                        var pid=$('#pid').val();
                        if(name1=='' && name2=='' && name3=='' && name4=='' && ssn1=='' && ssn2=='' && ssn3=='' && ssn4==''){
                        	showName(location);
                        }else if((name1=='' && ssn1!='') || (name1!='' && ssn1=='')){
                        	showName(location);
                        }else if((name2=='' && ssn2!='') || (name2!='' && ssn2=='')){
                        	showName(location);
                        }else if((name3=='' && ssn3!='') || (name3!='' && ssn3=='')){
                        	showName(location);
                        }else if((name4=='' && ssn4!='') || (name4!='' && ssn4=='')){
                        	showName(location);
                        }else if(!ssn1.length === 9 || isNaN(ssn1)){
                        	correctSSN(location);
                        	
                        }else if(!ssn2.length === 9 || isNaN(ssn2)){
                        	correctSSN(location);
                        }else if(!ssn3.length === 9 || isNaN(ssn3)){
                        	correctSSN(location);
                        }else if(!ssn4.length === 9 || isNaN(ssn4)){
                        	correctSSN(location);
                        }
                        else{
                        	
                        	 if((ssn1!='') && (ssn1.length === 9 && !isNaN(ssn1))){
                        		 var location1=location+"?"+"policyId="+pid+"&name1="+name1+"&name2="+name2+"&name3="+name3+"&name4="+name4+"&ssn1="+ssn1+"&ssn2="+ssn2+"&ssn3="+ssn3+"&ssn4="+ssn4;
                                 window.location.replace(location1);
                            	
                            } if((ssn2!='') && (ssn2.length === 9 || !isNaN(ssn2))){
                            	var location1=location+"?"+"policyId="+pid+"&name1="+name1+"&name2="+name2+"&name3="+name3+"&name4="+name4+"&ssn1="+ssn1+"&ssn2="+ssn2+"&ssn3="+ssn3+"&ssn4="+ssn4;
                                window.location.replace(location1);
                            } if((ssn3!='') && (ssn3.length === 9 || !isNaN(ssn3))){
                            	var location1=location+"?"+"policyId="+pid+"&name1="+name1+"&name2="+name2+"&name3="+name3+"&name4="+name4+"&ssn1="+ssn1+"&ssn2="+ssn2+"&ssn3="+ssn3+"&ssn4="+ssn4;
                                window.location.replace(location1);
                            } if((ssn4!='') && (ssn4.length === 9 || !isNaN(ssn4))){
                            	var location1=location+"?"+"policyId="+pid+"&name1="+name1+"&name2="+name2+"&name3="+name3+"&name4="+name4+"&ssn1="+ssn1+"&ssn2="+ssn2+"&ssn3="+ssn3+"&ssn4="+ssn4;
                                window.location.replace(location1);
                            }else{
                        correctSSN(location);
                            }
                        }
                    }
                }
            }
        });
           
	});      
	  
	function showName(loc){
		
		 var location = loc;
		    
	     bootbox.dialog({
            title: "Input Family Members Name.",
            message: '<div class="row">  ' +
            '<div class="col-md-12"> ' +
            '<form class="form-horizontal"> ' +
            '<div class="form-group" style="height:180px"> ' +
            '<label class="col-md-4 control-label" for="name">Member Name</label> ' +
            '<label class="col-md-4 control-label" for="name">Member SSN</label> ' +
            '<br>'+
            '<input id="name1" name="name" type="text" placeholder="Name" class="form-control input-md" style="width:150px;position:absolute;top:30px;left:15px"> ' +
            '<input id="ssn1" name="name" type="text" placeholder="eg:000000000" class="form-control input-md" style="width:150px;position:absolute;top:30px;left:215px"> ' +
            '<br>'+
            '<input id="name2" name="name" type="text" placeholder="Name" class="form-control input-md" style="width:150px;position:absolute;top:70px;left:15px"> ' +
            '<input id="ssn2" name="name" type="text" placeholder="eg:000000000" class="form-control input-md" style="width:150px;position:absolute;top:70px;left:215px"> ' +
            '<br>'+
            '<input id="name3" name="name" type="text" placeholder="Name" class="form-control input-md" style="width:150px;position:absolute;top:110px;left:15px"> ' +
            '<input id="ssn3" name="name" type="text" placeholder="eg:000000000" class="form-control input-md" style="width:150px;position:absolute;top:110px;left:215px"> ' +
            '<br>'+
            '<input id="name4" name="name" type="text" placeholder="Name" class="form-control input-md" style="width:150px;position:absolute;top:150px;left:15px"> ' +
            '<input id="ssn4" name="name" type="text" placeholder="eg:000000000" class="form-control input-md" style="width:150px;position:absolute;top:150px;left:215px"> ' +
            '<br>'+
            '<label id="aa" style="color: red;padding-left:15px;padding-top:100px">Please input at least one name and corresponding ssn</label> ' +
                '</div> ' +
                '</form> </div>  </div>',
                buttons: {
                    success: {
                        label: "Save",
                        className: "btn-success",
                        callback: function () {
                            var name1 = $('#name1').val();
                            var name2 = $('#name2').val();
                            var name3 = $('#name3').val();
                            var name4 = $('#name4').val();
                            var ssn1=$('#ssn1').val();
                            var ssn2=$('#ssn2').val();
                            var ssn3=$('#ssn3').val();
                            var ssn4=$('#ssn4').val();
                            var pid=$('#pid').val();
                            if(name1=='' && name2=='' && name3=='' && name4=='' && ssn1=='' && ssn2=='' && ssn3=='' && ssn4==''){
                            	showName(location);
                            }else if((name1=='' && ssn1!='') || (name1!='' && ssn1=='')){
                            	showName(location);
                            }else if((name2=='' && ssn2!='') || (name2!='' && ssn2=='')){
                            	showName(location);
                            }else if((name3=='' && ssn3!='') || (name3!='' && ssn3=='')){
                            	showName(location);
                            }
                            else if((name4=='' && ssn4!='') || (name4!='' && ssn4=='')){
                            	showName(location);
                            } else{
                            	
                           	 if((ssn1!='') && (ssn1.length === 9 && !isNaN(ssn1))){
                           		 var location1=location+"?"+"policyId="+pid+"&name1="+name1+"&name2="+name2+"&name3="+name3+"&name4="+name4+"&ssn1="+ssn1+"&ssn2="+ssn2+"&ssn3="+ssn3+"&ssn4="+ssn4;
                                    window.location.replace(location1);
                               	
                               } if((ssn2!='') && (ssn2.length === 9 || !isNaN(ssn2))){
                               	var location1=location+"?"+"policyId="+pid+"&name1="+name1+"&name2="+name2+"&name3="+name3+"&name4="+name4+"&ssn1="+ssn1+"&ssn2="+ssn2+"&ssn3="+ssn3+"&ssn4="+ssn4;
                                   window.location.replace(location1);
                               } if((ssn3!='') && (ssn3.length === 9 || !isNaN(ssn3))){
                               	var location1=location+"?"+"policyId="+pid+"&name1="+name1+"&name2="+name2+"&name3="+name3+"&name4="+name4+"&ssn1="+ssn1+"&ssn2="+ssn2+"&ssn3="+ssn3+"&ssn4="+ssn4;
                                   window.location.replace(location1);
                               } if((ssn4!='') && (ssn4.length === 9 || !isNaN(ssn4))){
                               	var location1=location+"?"+"policyId="+pid+"&name1="+name1+"&name2="+name2+"&name3="+name3+"&name4="+name4+"&ssn1="+ssn1+"&ssn2="+ssn2+"&ssn3="+ssn3+"&ssn4="+ssn4;
                                   window.location.replace(location1);
                               }else{
                           correctSSN(location);
                               }
                          }
                        }
                    }
                }
            });
     	}
	function correctSSN(loc){
		
		 var location = loc;
		    
	     bootbox.dialog({
           title: "Input Family Members Name.",
           message: '<div class="row">  ' +
           '<div class="col-md-12"> ' +
           '<form class="form-horizontal"> ' +
           '<div class="form-group" style="height:180px"> ' +
           '<label class="col-md-4 control-label" for="name">Member Name</label> ' +
           '<label class="col-md-4 control-label" for="name">Member SSN</label> ' +
           '<br>'+
           '<input id="name1" name="name" type="text" placeholder="Name" class="form-control input-md" style="width:150px;position:absolute;top:30px;left:15px"> ' +
           '<input id="ssn1" name="name" type="text" placeholder="eg:000000000" class="form-control input-md" style="width:150px;position:absolute;top:30px;left:215px"> ' +
           '<br>'+
           '<input id="name2" name="name" type="text" placeholder="Name" class="form-control input-md" style="width:150px;position:absolute;top:70px;left:15px"> ' +
           '<input id="ssn2" name="name" type="text" placeholder="eg:000000000" class="form-control input-md" style="width:150px;position:absolute;top:70px;left:215px"> ' +
           '<br>'+
           '<input id="name3" name="name" type="text" placeholder="Name" class="form-control input-md" style="width:150px;position:absolute;top:110px;left:15px"> ' +
           '<input id="ssn3" name="name" type="text" placeholder="eg:000000000" class="form-control input-md" style="width:150px;position:absolute;top:110px;left:215px"> ' +
           '<br>'+
           '<input id="name4" name="name" type="text" placeholder="Name" class="form-control input-md" style="width:150px;position:absolute;top:150px;left:15px"> ' +
           '<input id="ssn4" name="name" type="text" placeholder="eg:000000000" class="form-control input-md" style="width:150px;position:absolute;top:150px;left:215px"> ' +
           '<br>'+
           '<label id="aa" style="color: red;padding-left:15px;padding-top:100px">Please Input valid SSN</label> ' +
               '</div> ' +
               '</form> </div>  </div>',
           buttons: {
               success: {
                   label: "Save",
                   className: "btn-success",
                   callback: function () {
                       var name1 = $('#name1').val();
                       var name2 = $('#name2').val();
                       var name3 = $('#name3').val();
                       var name4 = $('#name4').val();
                       var ssn1=$('#ssn1').val();
                       var ssn2=$('#ssn2').val();
                       var ssn3=$('#ssn3').val();
                       var ssn4=$('#ssn4').val();
                       var pid=$('#pid').val();
                       if(name1=='' && name2=='' && name3=='' && name4=='' && ssn1=='' && ssn2=='' && ssn3=='' && ssn4==''){
                       	showName(location);
                       }else if((name1=='' && ssn1!='') || (name1!='' && ssn1=='')){
                       	showName(location);
                       }else if((name2=='' && ssn2!='') || (name2!='' && ssn2=='')){
                       	showName(location);
                       }else if((name3=='' && ssn3!='') || (name3!='' && ssn3=='')){
                       	showName(location);
                       }
                       else if((name4=='' && ssn4!='') || (name4!='' && ssn4=='')){
                       	showName(location);
                       } else{
                       	
                      	 if((ssn1!='') && (ssn1.length === 9 && !isNaN(ssn1))){
                      		 var location1=location+"?"+"policyId="+pid+"&name1="+name1+"&name2="+name2+"&name3="+name3+"&name4="+name4+"&ssn1="+ssn1+"&ssn2="+ssn2+"&ssn3="+ssn3+"&ssn4="+ssn4;
                               window.location.replace(location1);
                          	
                          } if((ssn2!='') && (ssn2.length === 9 || !isNaN(ssn2))){
                          	var location1=location+"?"+"policyId="+pid+"&name1="+name1+"&name2="+name2+"&name3="+name3+"&name4="+name4+"&ssn1="+ssn1+"&ssn2="+ssn2+"&ssn3="+ssn3+"&ssn4="+ssn4;
                              window.location.replace(location1);
                          } if((ssn3!='') && (ssn3.length === 9 || !isNaN(ssn3))){
                          	var location1=location+"?"+"policyId="+pid+"&name1="+name1+"&name2="+name2+"&name3="+name3+"&name4="+name4+"&ssn1="+ssn1+"&ssn2="+ssn2+"&ssn3="+ssn3+"&ssn4="+ssn4;
                              window.location.replace(location1);
                          } if((ssn4!='') && (ssn4.length === 9 || !isNaN(ssn4))){
                          	var location1=location+"?"+"policyId="+pid+"&name1="+name1+"&name2="+name2+"&name3="+name3+"&name4="+name4+"&ssn1="+ssn1+"&ssn2="+ssn2+"&ssn3="+ssn3+"&ssn4="+ssn4;
                              window.location.replace(location1);
                          }else{
                      correctSSN(location);
                          }
                     }
                   }
               }
           }
       });
	}
	</script>
      

    

  </body>
</html>
