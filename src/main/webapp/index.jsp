<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gradle DWR Demo</title>
<script type='text/javascript' src='dwr/engine.js'></script>
<script type='text/javascript' src='dwr/util.js'></script>
<script type='text/javascript' src='dwr/interface/Message.js'></script>
</head>

<body>
	<input value="Click Me" type="button" onclick="update();" />
	<br />
	<div
		style="background-color: #ffeaa7; font-weight: bold; width: 500px;"
		id="divResponse">Click to get Message From Server using DWR</div>

	<br />
	<a href="provider/index.jsp">Click here to go to Provider Page.</a>
	<br />

	<script type="text/javascript">
		function update() {
			Message.getMessage(function(data) {
				dwr.util.setValue("divResponse", data);
			});
		}
	</script>
	<!-- 
	<a href="/dwrdemo/security/logout.jsp">Click here to log out</a>
	 -->
</body>

</html>
