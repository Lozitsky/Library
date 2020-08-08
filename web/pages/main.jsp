<%--
  Created by IntelliJ IDEA.
  User: Root
  Date: 08.08.2020
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<title>Online Library</title>
	<link rel="stylesheet" href="../css/style_index.css" type="text/css">
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
<%="Hello!" %>
<h3>
	<%=request.getParameter("username") %>
</h3>
<h3>
	${param["password"]}
</h3>
</body>
</html>
