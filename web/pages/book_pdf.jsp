<%--
  Date: 06.09.2020
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%-- https://stackoverflow.com/a/16243271/9586230 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<div id="book_panel">
    <div id="menu_link">
        <a href="main.jsp"><<=Menu</a>
    </div>
    <object id="pdf_book" data="${pageContext.request.contextPath}/fileReadPdf?id=${param.id}" type="application/pdf"
            width="auto"
            height="auto">
        <a href="${pageContext.request.contextPath}/fileReadPdf?id=${param.id}">Download file.pdf</a>
    </object>
</div>
