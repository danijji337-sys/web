<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.office.diary.DiaryDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/title.jsp"/>

<link href="./res/css/member/signup_form.css" rel="stylesheet" type="text/css">

<jsp:include page="../include/diary/diary.jsp"/>

</head>
<body>

	<jsp:include page="../include/header.jsp"/>
	
	<jsp:include page="../include/nav.jsp"/>
	
	<article>
		<div class="article_warp">
			
			<h3>
				THIS PAGE IS MY DIARIES
			</h3>
			
			<table border="1">
				<thead>
					<tr>
						<th>diaryNo</th>
						<th>diaryWord</th>
						<th>diaryRegDate</th>
						<th>diaryModDate</th>
						<th>memNo</th>
						<th>memId</th>
						<th>memPw</th>
						<th>memMail</th>
						<th>memPhone</th>
						<th>memRegDate</th>
						<th>memModDate</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="item" items="${myDiaries}">
						<tr>
							<td>${item.DiaryNo}</td>
							<td>${item.DiaryWord}</td>
							<td>${item.DiaryRegDate}</td>
							<td>${item.DiaryModDate}</td>
							<td>${item.memNo}</td>
							<td>${item.memId}</td>
							<td>${item.memPw}</td>
							<td>${item.memMail}</td>
							<td>${item.memPhone}</td>
							<td>${item.memRegDate}</td>
							<td>${item.memModDate}</td>
					    </tr>
					</c:forEach>
					
			<%
				List<DiaryDto> myDiaries = (List<DiaryDto>)request.getAttribute("myDiaries");
			
			 	for (int i = 0; i < myDiaries.size(); i++) {
			%>
			 		<tr>
						<td><%= myDiaries.get(i).getDiaryNo()  %></td>
						<td><%= myDiaries.get(i).getDiaryWord()  %></td>
						<td><%= myDiaries.get(i).getDiaryRegDate()  %></td>
						<td><%= myDiaries.get(i).getDiaryModDate()  %></td>
						<td><%= myDiaries.get(i).getMemNo() %></td>
						<td><%= myDiaries.get(i).getMemId() %></td>
						<td><%= myDiaries.get(i).getMemPw() %></td>
						<td><%= myDiaries.get(i).getMemMail() %></td>
						<td><%= myDiaries.get(i).getMemPhone() %></td>
						<td><%= myDiaries.get(i).getMemRegDate() %></td>
						<td><%= myDiaries.get(i).getMemModDate() %></td>
					</tr>
			<%	
			 	}
			%>
			
				</tbody>
			</table>

		</div>
	</article>
	
	<jsp:include page="../include/footer.jsp"/>

</body>
</html>