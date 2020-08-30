<%--
  Date: 21.08.2020
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<%@include file="../WEB-INF/jspf/left_menu.jspf" %>

<div id="book_panel">
    <h3>${param.name}</h3>
    <%@include file="../WEB-INF/jspf/letters.jspf" %>
    <h5>Books found: ${list.size()}</h5>

    <div id="content">
        <c:forEach var="book" items="${list}">
            <div class="book_info">
                <p id="book_title"><c:out value=" ${book.name}"/></p>
                <div id="book_image">
                    <img src="${pageContext.servletContext.contextPath}/showImage?id=${book.id}"
                         height="190" width="190" alt="Book Picture"/>
                </div>

                <div id="book_details"><p><strong>ISBN:</strong><c:out value=" ${book.isbn}"/></p>
                    <p><strong>Number of pages:</strong><c:out value=" ${book.pageCount}"/></p>
                    <p><strong>Author:</strong><c:out value=" ${book.author}"/></p>
                    <p><strong>Year of publication:</strong><c:out value=" ${book.publishYear}"/></p>
                    <p><strong>Publisher:</strong><c:out value=" ${book.publisher}"/></p>
                    <p style="margin:10px;"><a href="#">Read</a></p>
                </div>
            </div>
        </c:forEach>
    </div>
</div>


</body>
</html>
