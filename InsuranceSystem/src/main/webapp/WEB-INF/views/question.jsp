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

    <title>Insurance System</title>

    <!-- Bootstrap core CSS -->
    <link href="/InsuranceSystem/pages/assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="/InsuranceSystem/pages/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    
    <!-- Custom styles for this template -->
    <link href="/InsuranceSystem/pages/assets/css/style.css" rel="stylesheet">
    <link href="/InsuranceSystem/pages/assets/css/style-responsive.css" rel="stylesheet">
    <link rel="stylesheet" href="/InsuranceSystem/pages/assets/css/to-do.css">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    
    
  </head>

  <body >

  <section id="container" style="overflow:auto">
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
				  		     <form:form  action="answer/add" commandName="answer">
				             <table id="todo" class="table table-hover custom-check" style="font-size: 13px;">
				              <tbody>
				              
				                <c:forEach items="${listQuestions }" var="question">
				                  <tr>
				           			<td>
				                        <span class="check"><input type="checkbox" class="checked" name="checkname" id=${question.questionId }></span>
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
	<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>    
    <script src="/InsuranceSystem/pages/assets/js/tasks.js" type="text/javascript"></script>

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
    	   $(inputSibling).val("");
       }
      });
      
  </script>


    <script src="/InsuranceSystem/pages/assets/js/bootbox.js"></script>

<script type="text/javascript">
// Returns an array with values of the selected (checked) checkboxes in "frm"
function getSelectedChbox(frm) {
 // JavaScript & jQuery Course - http://coursesweb.net/javascript/
  var selchbox = [];        // array that will store the value of selected checkboxes
 
  // gets all the input tags in frm, and their number
  var inpfields = frm.getElementsByTagName('input');
  var nr_inpfields = inpfields.length;

  // traverse the inpfields elements, and adds the value of selected (checked) checkbox in selchbox
  for(var i=0; i<nr_inpfields; i++) {
    if(inpfields[i].type == 'checkbox' && inpfields[i].checked == true) {
    	var an=$(inpfields[i]).attr('id');
    	console.log(an);
    	selchbox.push(an);
    	
    } else{
    	if(inpfields[i].value!='on' && inpfields[i].type=='text' && inpfields[i].value!=""){
    	
    	selchbox.push(inpfields[i].value);
    	}
    } 
  }

  return selchbox;
}

document.getElementById('tian').onclick = function(){
	  var selchb = getSelectedChbox(this.form); // gets the array returned by getSelectedChbox()
	 if(selchb.length!=6){
		 bootbox.alert("Must Answer Three Questions", function() {
			  //Example.show("Hello world callback");
			});
	 }else{ 
	  var con=selchb[0];
	 
	  for(var i=1;i<selchb.length;i++){
		  var va=selchb[i];
		  con=con+","+va;
	  }
	  console.log(con);
	  dataToPost = "answers="+con;
	  $.ajax({
          url: "answer/add",
          type: "POST",
          data: dataToPost, 
          success: function (data) {
        	// $('html').html(data);
        	  window.location.href="/InsuranceSystem/";
          },
	     dataType: "html",
      });
	 }
};

</script>
  </body>
</html>
