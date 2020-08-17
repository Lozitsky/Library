<%--<%@ page import="com.kirilo.jsp.TestConnection" %>--%>
<%@ page import="com.kirilo.jsp.beans.AuthorList" %>
<%@ page import="com.kirilo.jsp.beans.Author" %><%--
  Date: 08.08.2020
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="authorList" scope="session" class="com.kirilo.jsp.beans.AuthorList"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Online Library</title>
    <link rel="stylesheet" href="../css/main.css" type="text/css">
</head>
<body>

<div>

    <header>
        <img src="#" alt="Place for Logo" name="logo"/>
    </header>

    <div>
        <form id="search" name="search_form" method="post">

            <img id="search-logo" src="search.jpg" alt="Logo"/>

            <input id="search-field" type="text" name="search_string" value=""/>

            <div id="search-box">
                <input type="submit" value="Search" name="search_button"/>

                <select name="search_option">
                    <option>Title</option>
                    <option>Author</option>
                </select>
            </div>
        </form>
    </div>

    <div id="main">
        <nav>
            <h4>List of authors:</h4>
            <ul class="nav">
<%--                                <%
                                    final AuthorList authorList = new AuthorList();
                                    for (Author author : authorList.getAuthors()) {
                                %>

                <jsp:getProperty name="authorList" property="authors"/>
                                    <li><a href="#"><%=author.getName()%></a></li>
                                    <%
                                        }
                                    %>--%>
                <c:forEach var="author" items="${authorList.authors}">
                    <li><a href="#"><c:out value="${author.name}"/></a></li>
                </c:forEach>

            </ul>
        </nav>
        <div id="content">
            <h1>&nbsp;</h1>
            <p>&nbsp;</p>
        </div>
    </div>

</div>
<%--<% request.setCharacterEncoding("UTF-8"); %>--%>
<%--<%="Hello!" %>
<h3>
	<%=request.getParameter("username") %>
</h3>
<%
	TestConnection testConnection = new TestConnection();
	testConnection.check();
%>
<h3>
${param["password"]}
</h3>--%>
</body>
</html>
