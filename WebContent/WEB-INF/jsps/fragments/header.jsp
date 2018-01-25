<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<nav class="navbar navbar-inverse">
		<div class="container-fluid">
		
			<div class="navbar-header" style="margin-left:3%">
      			<a class="navbar-brand" href="#">Project Management</a>
    		</div>
    		
    		<ul class="nav navbar-nav pull-right">
    		
    			<li><a href="#">Home</a></li>
    		
        		
    			<li class="dropdown">
          		
          			<a href="#" class="dropdown-toggle" 
          				data-toggle="dropdown" role="button" 
          				aria-expanded="false">Resources <span class="caret"></span></a>
          		
          			<ul class="dropdown-menu" role="menu">
            			<li><a href="<spring:url value="/"/>">Add</a></li>
            			<li><a href="viewSubscribers">Find</a></li>
          			</ul>
        		
        		</li>
        		<li><a href="#">About us</a></li>
        		<li><a href="#">Contact us</a></li>
        		
    		</ul>
    		
		</div>
</nav>