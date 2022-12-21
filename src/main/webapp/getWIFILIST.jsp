<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="DB.Service"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Get WIFI DATA</title>
<style>

	.success {
	
		text-align: center;
		border: 1px solid green;
		width: 100%;
		
	
	}

</style>
</head>
<body>

<%
	Service sv = new Service();
	int numDatum = sv.dbInsert_WIFILIST_API();
	
	out.print("<div class = success>");
	
	if(numDatum == -1){out.print("<h1>데이터 불러오기 실패</h1>");}
	else{out.print("<h1>" + numDatum + "개의 데이터 불러오기 성공</h1>");}
	
	out.print("<a href = " + request.getContextPath() + "/main.jsp> 홈으로 가기 </a>");
	
	out.print("</div>");
	

	
%>

</body>
</html>