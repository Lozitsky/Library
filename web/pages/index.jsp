<%--
  Created by IntelliJ IDEA.
  User: Root
  Date: 08.08.2020
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<title>Online Library Enter</title>
	<link rel="stylesheet" href="../css/style_index.css" type="text/css">
</head>
<body>
<div class="main">
	<div class="content">
		<p class="title"><span
				class="text"><img src="../images/shelf_n.png" width="76" height="77" hspace="10" vspace="10"
								  alt="Library emblem"></span></p>
		<p class="title">Online Library</p>
		<p class="text"><span>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Autem corporis debitis illum inventore porro possimus quam quasi! Aperiam beatae cum, ex id in iure neque, nesciunt obcaecati omnis quisquam vero.</span>
		</p>
		<p class="text"><span>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Consequatur dolore inventore non obcaecati possimus quam quibusdam reiciendis repellendus sit vero? Asperiores atque earum enim, facilis odio qui rerum suscipit tempore?</span>
		</p>
		<p class="text"><span>Lorem ipsum dolor sit amet, consectetur adipisicing elit. A, aliquam dicta dolorem doloremque earum enim exercitationem explicabo facilis ipsum iusto libero nisi nobis odit praesentium sequi sint ullam? Ad, itaque!</span>
		</p>
		<p>&nbsp;</p>
	</div>
	<div class="login_div">
		<p class="title">Enter your data for Entrance: </p>
		<form class="login_form" name="username" action="main.jsp" method="post">
			<label>Name: <input type="text" name="username" value="" size="20"/><input type="submit"
																					   value="Enter"></label>
		</form>

		<div class="footer">
			Kirilo @ 2020
		</div>
	</div>
</div>
</body>
</html>
