<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<meta charset='utf-8' />
<link href="../Dashboard/fullcalendar.css" rel='stylesheet' />
<link href="../Dashboard/fullcalendar.print.css" rel='stylesheet' media='print' />
<script src="../Dashboard/libs/moment.min.js"></script>
 <script src="../Dashboard/libs/jquery.min.js"></script>
<script src="../Dashboard/fullcalendar.min.js"></script>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  


<style>

	body {
		margin: 40px 10px;
		padding: 0;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		font-size: 14px;
	}

	#calendar {
		max-width: 900px;
		margin: 0 auto;
	}

</style>
<script type="text/javascript">
function aj() {
	 
    
    
    $.ajax({
	
		        type: "POST",
		
		        url: "topopulate.html",
	
		        success:
		        	function(response){
		
		        // we have the response
		
		        $('#event').html(response);
		
		       
		 }
	
	     });
       }
       
       
       
       
       
       
       

</script>
</head>
<body   onload="aj();">


<div id="event">
</div>
<div id='calendar'></div>
<div id="createEventModal" class="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
    
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
        <h3 id="myModalLabel1">Add event</h3>
    </div>   
    <div class="modal-body">
    <form:form id="createEvent" mclass="form-horizontal" >
    
         <div class="control-group">
           <label class="control-label" for="event">Event:</label>
              <input type="text" id="eventName"></input>
        </div>
        	<div class="control-group">
          	 	 <label class="control-label" for="startDate">Start date:</label>
          	 	<input type="text" id="startDate"></input>
       		 </div>
       		 <div class="control-group">
           		 <label class="control-label" for="endDate">End date:</label>
              <input type="text" id="endDate"></input>         
        </div>     
    </form:form>
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
        <button type="submit" class="btn btn-danger" id="submitButton" onclick="fu();">Fix Schedule</button>
    </div>
</div> 

</body>
</html>
