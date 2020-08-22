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

<%--<%
    int genreId = 0;

    try {
        genreId = Integer.parseInt(request.getParameter("genre_id"));
    } catch (Exception ex) {
        ex.printStackTrace();
    }
%>--%>

<c:set var="genreId" value="${param.genre_id}" scope="session"/>

<div id="content">
    <h3>${param.name}</h3>
    <table cellpadding="30" style="font-size: 12px;">
        <jsp:useBean id="bookList" class="com.kirilo.jsp.beans.BookList" scope="request"/>
        <%--                <c:forEach var="book" items="${bookList.allBooks}">--%>
        <c:forEach var="book" items="${bookList.getBooksByGenre(genreId)}">
            <tr>
                <td style="width:400px;height: 100px;">
                    <p><c:out value=" ${book.name}"/></p>
                    <p><strong>ISBN:</strong><c:out value=" ${book.isbn}"/></p>
                    <p><strong>Number of pages:</strong><c:out value=" ${book.pageCount}"/></p>
                    <p><strong>Author:</strong><c:out value=" ${book.author}"/></p>
                    <p><strong>Year of publication:</strong><c:out value=" ${book.publishYear}"/></p>
                    <p><strong>Publisher:</strong><c:out value=" ${book.publisher}"/></p>
                    <p style="margin:10px;"><a href="#">Read</a></p>
                </td>
                <td>
                    picture
                </td>
            </tr>
        </c:forEach>

        <%--&lt;%&ndash;        <%

                    for (Book book : bookList.getBooksByGenre(genreId)) {
        //            for (Book book : bookList.getAllBooks()) {

                %>
                <tr>
                    <td style="width:400px;height: 100px;">
                        <p style="color:#378de5 ;font-weight: bold; font-size: 15px;"><%=book.getName()%>
                        </p>
                        <br><strong>ISBN:</strong> <%=book.getIsbn()%>
                        <br><strong>Издательство:</strong> <%=book.getPublisher() %>

                        <br><strong>Количество страниц:</strong> <%=book.getPageCount() %>
                        <br><strong>Год издания:</strong> <%=book.getPublishYear() %>
                        <br><strong>Автор:</strong> <%=book.getAuthor() %>
                        <p style="margin:10px;"><a href="#">Читать</a></p>
                    </td>
                    <td style="width:150px;height: 100px;">
                        картинка
                    </td>
                </tr>
                <%}%> --%--%>

    </table>
</div>

</body>
</html>