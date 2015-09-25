<%@ page session="true"%>
<META http-equiv="Pragma" content="No-cache" />
<%
	session.invalidate();
	response.sendRedirect("/dwrdemo");
%>
