<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>DASHGUM - Bootstrap Admin Template</title>

    <!-- Bootstrap core CSS -->
    <link href="../assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="../assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    
    <!-- Custom styles for this template -->
    <link href="../assets/css/style.css" rel="stylesheet">
    <link href="../assets/css/style-responsive.css" rel="stylesheet">
    <link rel="stylesheet" href="../assets/css/to-do.css">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    
    
  </head>

  <body >

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
                                    <span class="photo"><img alt="avatar" src="assets/img/ui-zac.jpg"></span>
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
                                    <span class="photo"><img alt="avatar" src="assets/img/ui-divya.jpg"></span>
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
                                    <span class="photo"><img alt="avatar" src="assets/img/ui-danro.jpg"></span>
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
                                    <span class="photo"><img alt="avatar" src="assets/img/ui-sherman.jpg"></span>
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
                    <li><a class="logout" href="login.html">Logout</a></li>
            	</ul>
            </div>
        </header>
      <!--header end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
      
      
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
          	<h3><i class="fa fa-angle-right"></i> Choose 3 questions</h3>
          	
          	<!-- SIMPLE TO DO LIST -->
          	<div class="row mt">
          		<div class="col-md-12">
          			<section class="task-panel tasks-widget">
	                	<div class="panel-heading">
	                        <div class="pull-left"><h5><i class="fa fa-tasks"></i> Question List</h5></div>
	                        <br>
	                 	</div>
				  		<div class="custom-check goleft mt">
				  		     <c:if test="${!empty listQuestions}">
				  		     <c:url var="addAction" value="/answer/add" ></c:url>
				  		     <form:form action="${addAction}" commandName="answer">
				             <table id="todo" class="table table-hover custom-check" style="font-size: 13px;">
				              <tbody>
				              
				                <c:forEach items="${listQuestions }" var="question">
				                  <tr>
				           			<td>
				                        <span class="check"><input type="checkbox" class="checked" name="checkname"></span>
				                        <span class="task-title-sp">${question.question}</span>
				                        
                                        <input type="text" class="form-control" style="display:none" name=${question.questionId }>
                                
									</td>
				                </tr>
				                </c:forEach>
				                				                				                				                				              				       
				              </tbody>
				          </table>
				          <div class="form-group">              
                                  <button id="tian" type="button" class="btn btn-theme" style="left:300px;position:relative">Submit</button>            
                              </div>
				          </form:form>
				          </c:if>
						</div><!-- /table-responsive -->
					</section><!--/task-panel -->
          		</div><! --/col-md-12 -->
          	</div><! -- row -->
			

          	
			
          	
			
		</section><! --/wrapper -->
      </section><!-- /MAIN CONTENT -->

      <!--main content end-->
      <!--footer start-->
      <footer class="site-footer" style="margin-top:180px">
          <div class="text-center">
              2014 - Alvarez.is
              <a href="todo_list.html#" class="go-top">
                  <i class="fa fa-angle-up"></i>
              </a>
          </div>
      </footer>
      <!--footer end-->
  </section>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="../assets/js/jquery.js"></script>
    <script src="../assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="../assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="../assets/js/jquery.scrollTo.min.js"></script>
    <script src="../assets/js/jquery.nicescroll.js" type="text/javascript"></script>


    <!--common script for all pages-->
    <script src="../assets/js/common-scripts.js"></script>

    <!--script for this page-->
	<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>    
    <script src="../assets/js/tasks.js" type="text/javascript"></script>

    <script>
      jQuery(document).ready(function() {
          TaskList.initTaskWidget();
      });

      $(function() {
          $( "#sortable" ).sortable();
          $( "#sortable" ).disableSelection();
      });

    </script>
    
    
  <script>
      $(':checkbox').change(function() {

        // do stuff here. It will fire on any checkbox change
        var inputSibling=$(this).parent().next().next();                       
        $(this).prop('checked',function()
                {
                  if ($(this).is(':checked')) {
                	 
                     return ($(':checkbox').filter(':checked').length<=3)?true:false;
                  }
                });

       if($(this).is(':checked'))
    	   {
    	   $(inputSibling).css({
               'display':'inline'
             });
    	   }
       else{
    	   $(inputSibling).css({
               'display':'none'
             });
       }
      });
      
  </script>

<!-- <script type="text/javascript">
	$(document).ready(
			function() {
				var i;
				for (i=1; i <= 10; i++) {
					$("#up" + i).live(
							"change",
							function() {
								var questionId = i;
								
								var answer = document.getElementById(i).value;
						      
								dataToPost = "questionId=" + questionId + "&answer="
										+ answer;

								$.ajax({
									type : "POST",
									url : "answer/add",
									data : dataToPost,
									success : function() {

									},
									dataType : "json",
								})
							});
				}

			});
</script> -->


<script type="text/javascript">
// Returns an array with values of the selected (checked) checkboxes in "frm"
function getSelectedChbox(frm) {
 // JavaScript & jQuery Course - http://coursesweb.net/javascript/
  var selchbox = [];        // array that will store the value of selected checkboxes
  var num=[];
  // gets all the input tags in frm, and their number
  var inpfields = frm.getElementsByTagName('input');
  var nr_inpfields = inpfields.length;
  var cot=0;

  // traverse the inpfields elements, and adds the value of selected (checked) checkbox in selchbox
  for(var i=0; i<nr_inpfields; i++) {
    if(inpfields[i].type == 'checkbox' && inpfields[i].checked == true) {
    	num.push(i);
    	cot=cot+1;
    	
    }else{
    	selchbox.push(i);
    	selchbox.push(inpfields[i].value);
    }
  }
 
  var r=[];
  var num_len=num.length;
  for(var j=0;j<num_len;j++){

	 if(j>0){
		var tt=num[j]-cot+1; 
		var t=num[j];
		  var k1=t+1;
		  r.push(tt);
		 r.push(inpfields[k1].value);
	 }else{
		 var tt=num[j]+1;
		 var t=num[j];
		  var k1=t+1;
		 r.push(tt);
		 r.push(inpfields[k1].value);
	 }
  }

  return r;
}

document.getElementById('tian').onclick = function(){
	  var selchb = getSelectedChbox(this.form);     // gets the array returned by getSelectedChbox()
	  //alert(selchb);
	  var json = JSON.stringify(selchb);
	  $.ajax({
          url: "/answer/add",
          type: "POST",
          data: json,
          cache: false,
          contentType: "application/json; charset=utf-8",
          dataType: "json",
          success: function (data) {
              
          }
      });
};

</script>
  </body>
</html>
