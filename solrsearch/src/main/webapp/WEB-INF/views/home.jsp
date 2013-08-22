<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Home</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/themes/javascript/jquery.js"></script>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/themes/javascript/bootstrap.min.js"></script>
	
<script type="text/javascript"
	src="<%=request.getContextPath()%>/themes/javascript/bootstrap-datepicker.js"></script>

<%-- <script type="text/javascript"
	src="<%=request.getContextPath()%>/themes/javascript/bootstrap-tab.js"></script> --%>



<link rel="stylesheet"
	href="<%=request.getContextPath()%>/themes/css/bootstrap.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/themes/css/bootstrap-responsive.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/themes/css/bootstrap-datetimepicker.css" />

<script>
	
	var contextPath="<%= request.getContextPath() %>";
	$(document).ready(function() {
		$("#lastchanged").datepicker();
		$("#effectiveFrom").datepicker();
		$("#effectiveTo").datepicker();
	      
	      $('#myTab a').click(function (e) {
	    	    e.preventDefault();
	    	    $(this).tab('show');
	    	    })
	  	/* $("#createLpid").on('click', function(){
			$("#createLpid").show();
		}); */
		
		$("#search-lpid").live("click", function() {
			var attribVal = $("#attribVal").val();
			var attribName = $("#attribName").val();
			var param = "attributeName="+attribName+"&attributeValue="+attribVal;

			
			console.log(param);
			$.ajax({
				url: contextPath+'/searchav',
				type: 'POST',
				data:param,
				async:false,
				success: function( data ) {
					console.log(data);
					alert("Successfully searched"+data);
				},
				failure: function(data){
				}
			});
			
		});
		
		$("#attr-search").live("click", function() {
			var attrName = $("#attrName").val();
			var attrValue = $("#attrValue").val();
			var lpidid = $("#attr-lpidid").val();
			var param = "attributeName="+attrName+"&attributeValue="+attrValue;
			
			console.log(param);
			$.ajax({
				url: contextPath+'/searchav',
				type: 'POST',
				data:param,
				async:false,
				success: function( data ) {
					alert("Successfully searched"+data);
				},
				failure: function(data){
				}
			});
			
		});
		
		$("#attr-search1").live("click", function() {
			var attrName = $("#attrName1").val();
			var attrValue = $("#attrValue1").val();
			var pageSize = $("#pageSize1").val();
			var from = $("#from1").val();
			var to = $("#to1").val();
			var param = "attrName="+attrName+"&attrValue="+attrValue+"&pageSize="+pageSize+"&from="+from;
			
			console.log(param);
			$.ajax({
				url: contextPath+'/lpidsearch/searchavonly.htm',
				type: 'POST',
				data:param,
				async:false,
				success: function( data ) {
					alert("Successfully searched"+data);
				},
				failure: function(data){
				}
			});
			
		});
		
		
		$("#lpid-submit").live("click",function(){
			var id = $("#lpidid").val();
			var datasource = $("#datasource").val();
			var name = $("#Name").val();
			var description = $("#description").val();
			var lastchanged = $("#lastchanged").val();
			
			var param = "id="+id+"&datasource="+datasource+"&name="+name+"&description="+description+"&lastchanged="+lastchanged;
			console.log(param);
			$.ajax({
				url: contextPath+'/indexlpid',
				type: 'POST',
				data:param,
				async:false,
				success: function( data ) {
					alert("Successfully indexed.");
				},
				failure: function(data){
				}
			});
		});
	    
		
		
		$("#attr-submit").live("click",function(){
			var id = $("#id").val();
			var attributeName = $("#attributeName").val();
			var attributeValue = $("#attributeValue").val();
			var sellerId = $("#sellerId").val();
			var effectiveFrom = $("#effectiveFrom").val();
			var effectiveTo = $("#effectiveTo").val();
			
			var param = "id="+id+"&effectiveFrom="+effectiveFrom+"&sellerId="+sellerId+"&effectiveTo="+effectiveTo+"&attributeName="+attributeName+"&attributeValue="+attributeValue;
			console.log(param);
			$.ajax({
				url: contextPath+'/avindex',
				type: 'POST',
				data:param,
				async:false,
				success: function( data ) {
					alert("Successfully indexed.");
				},
				failure: function(data){
				}
			});
		});
	     
		
	   });
	
	/* $("#createLpid").on('click', function(){
		hideComponent();
		$("#createLpid").show();
	});
	
	 function hideComponent(){
 		$('.actioncomponent').hide();
 	} */
</script>

</head>
<body>
	<h1>Index and Search your data </h1>

	<div class="container">
		<ul class="nav nav-tabs" id="myTab" >
			<li class="active"><a href="#searchForm">Search Lpid</a></li>
			<li><a href="#searchAttrForm">Search Attribute With LPID</a></li>
			<li><a href="#createLpid">Create Attribute Values</a></li>
			<li><a href="#createLpidAttribs">Create LPID</a></li>
			<li><a href="#searchAttrFormOnly">Search Attribute Only</a></li>
			<li><a href="#uploadForm">Upload</a>
		</ul>

		<div class="tab-content">
			<!-- <div class="active" id="home">...</div> -->
			<!--  Search Form    -->
			<div id="searchForm" class="tab-pane active actioncomponent">
				<form class="form-horizontal">
					<div class="control-group">
						<label class="control-label" for="attribName">Attribute Name:</label>
						<div class="controls">
							<input type="text" id="attribName" placeholder="Brand Name">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="attribVal">Attribute Value:</label>
						<div class="controls">
							<input type="text" id="attribVal" placeholder="Breadth">
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<button type="submit" id="search-lpid" class="btn btn-info">Search</button>
						</div>
					</div>
				</form>
			</div>
			
			<div id="searchAttrForm" class="tab-pane actioncomponent">
				<form class="form-horizontal">
					<div class="control-group">
						<label class="control-label" for="attr-lpidid">Lpid Id:</label>
						<div class="controls">
							<input type="text" id="attr-lpidid" placeholder="Lpid Id">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="attrName">Attribute Name:</label>
						<div class="controls">
							<input type="text" id="attrName" placeholder="Attribute Name">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="attr-breadth">Attribute Value:</label>
						<div class="controls">
							<input type="text" id="attrValue" placeholder="Attribute Value">
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<button type="submit" id="attr-search" class="btn btn-info">Search</button>
						</div>
					</div>
				</form>
			</div>

			<!--  Create LPID  -->
			<div id="createLpid" class="tab-pane actioncomponent">
				<form class="form-horizontal" action="" method="post">
					<div class="control-group">
						<label class="control-label" for="inputEmail">Lpid Id:</label>
						<div class="controls">
							<input type="text" id="id" placeholder="Lpid Id">
						</div>
					</div>
					<!-- <div class="control-group">
						<label class="control-label" for="inputAttributeName">LpidAttribute
							Name</label>
						<div class="controls">
							<input type="password" id="inputPassword" placeholder="Attribute">
						</div>
					</div> -->
					
					<div class="control-group">
						<label class="control-label" for="inputBrand">Effective From:</label>
						<div class="controls">
							<input type="text" id="effectiveFrom" placeholder="Effective From">
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="inputBreadth">Effective To:</label>
						<div class="controls">
							<input type="text" id="effectiveTo" placeholder="Effective To">
						</div>
					</div>
					
					
					<div class="control-group">
						<label class="control-label" for="sellerId">Seller:</label>
						<div class="controls">
							<input type="text" id="sellerId" placeholder="Seller">
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="attributeName">Attribute Name:</label>
						<div class="controls">
							<input type="text" id="attributeName" placeholder="Attribute Name">
						</div>
					</div>
					
					
					<div class="control-group">
						<label class="control-label" for="attributeValue">Attribute Value:</label>
						<div class="controls">
							<input type="text" id="attributeValue" placeholder="Attribute Value">
						</div>
					</div>
					
					
					<div class="control-group">
						<div class="controls">
							<button type="submit" class="btn btn-primary" id="attr-submit">Create</button>
						</div>
					</div>
				</form>
			</div>

			<div id="createLpidAttribs" class="tab-pane actioncomponent">
				<form class="form-horizontal">
					
					<div class="control-group">
						<label class="control-label" for="lpidid">PKey:</label>
						<div class="controls">
							<input type="text" id="lpidid" placeholder="Lpid Id">
						</div>
					</div>
					<!-- <div class="control-group">
						<label class="control-label" for="inputAttributeName">LpidAttribute
							Name</label>
						<div class="controls">
							<input type="password" id="inputPassword" placeholder="Attribute">
						</div>
					</div> -->
					
					<div class="control-group">
						<label class="control-label" for="Name">Name:</label>
						<div class="controls">
							<input type="text" id="Name" placeholder="Name">
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="description">Description:</label>
						<div class="controls">
							<input type="text" id="description" placeholder="Description">
						</div>
					</div>
					
					<div class="control-group input-append date" data-datepicker-format="dd-mm-yyyy">
						<label class="control-label" for="lastchanged">LastChanged:</label>
						<div class="controls">
							<input class="span2" size=16 type="text" id="lastchanged" placeholder="Last Changed">
						</div>
					</div>				
					
					<div class="control-group">
						<div class="controls">
							<button type="submit" class="btn btn-primary" id="lpid-submit" >Create</button>
						</div>
					</div>
				</form>
			</div>
			<div id="searchAttrFormOnly" class="tab-pane actioncomponent">
				<form class="form-horizontal">
					<div class="control-group">
						<label class="control-label" for="attrName1">Attribute Name:</label>
						<div class="controls">
							<input type="text" id="attrName1" placeholder="Attribute Name">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="attrValue1">Attribute Value:</label>
						<div class="controls">
							<input type="text" id="attrValue1" placeholder="Attribute Value">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="pageSize1">Page Size:</label>
						<div class="controls">
							<input type="text" id="pageSize1" placeholder="Attribute Value">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="from1">From:</label>
						<div class="controls">
							<input type="text" id="from1" placeholder="Attribute Value">
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<button type="submit" id="attr-search1" class="btn btn-info">Search</button>
						</div>
					</div>
				</form>
			</div>
			
			<div id="uploadForm" class="tab-pane actioncomponent">
				<form enctype="multipart/form-data" method="POST" action="upload.htm" class="form-horizontal" >
					<div class="control-group">
						<label class="control-label" for="file">File</label>
						<input type="file" name="file" />
					</div>
					<div class="control-group">
						<input type="submit" value="Upload File" />
					</div>
				</form>
			</div>

		</div>
	</div>
</body>
</html>
