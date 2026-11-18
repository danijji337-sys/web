<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <link href="./res/css/include/nav.css" rel="stylesheet" type="text/css">
    
	<nav>
		<div class="nav_warp">
			<a href="<%= request.getContextPath() %>/>">HOME</a>
			<a href="<%= request.getContextPath() %>/signup_form.mem">SIGN-UP</a>
			<a href="<%= request.getContextPath() %>/signin_form.mem">SIGN-IN</a>
			<a href="<%= request.getContextPath() %>/signout_conform.mem">SIGN-OUT</a>
			<a href="<%= request.getContextPath() %>/diary_write_form.dir">DIARY WRITE</a>
			<a href="<%= request.getContextPath() %>/diary_list.dir">DIARY LIST</a>
		</div>
	</nav>