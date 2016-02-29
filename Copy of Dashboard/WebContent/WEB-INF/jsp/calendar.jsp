<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<link href="../Dashboard/fullcalendar.css" rel='stylesheet' />
<link href="../Dashboard/fullcalendar.print.css" rel='stylesheet' media='print' />
<script src="../Dashboard/libs/moment.min.js"></script>
<script src="../Dashboard/libs/jquery.min.js"></script>
<script src="../Dashboard/fullcalendar.min.js"></script>
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

</body>
</html>
