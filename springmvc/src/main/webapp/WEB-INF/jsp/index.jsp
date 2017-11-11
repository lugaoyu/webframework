<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<html>
<body>
<h2>Hello World!</h2>
<br>
<h2>
	<%
		out.println(request.getAttribute("requestDispatcher"));
	%>
</h2>
<br>
	${requestDispatcher }
</body>
</html>
