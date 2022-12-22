<%@page import="DB.Service"%>
<%@page import="DB.Member_Member"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	button{
	
	text-align: center;
	
	}

	table, td, th {
	  border: 1px solid;
	  text-align: center;
	}
	
	table {
	  width: 100%;
	  border-collapse: collapse;
	}
	
	tr:nth-child(even) {background-color: #f2f2f2;}
	
	th {
	  background-color: #04AA6D;
	  color: white;
	}

</style>
</head>

<body>


<h1> <b> 위치 히스토리 목록 </b> </h1>
<a href = "<%= request.getContextPath()%>/main.jsp">홈</a> | 
<a href = "<%= request.getContextPath()%>/getMEMBER.jsp">위치 히스토리 목록</a> |
<a href = "<%= request.getContextPath()%>/getWIFILIST.jsp">와이파이 정보 가져오기 (Open API) </a> 
<table> <!-- 테이블 만드는 기본  -->
		<thead>
			<tr>
				<th width="60">ID</th>
				<th width="200">X 좌표</th>
				<th width="200">Y 좌표</th>
				<th width="60">조회 일자</th>
				<th width="60">비고</th>
	
				
				
			</tr>
		</thead>
		
		<tbody>
			<tr>
		
	<%
		
			
			Service sv = new Service();
	
			if(request.getParameter("ID_Delete") != null){
				
				sv.dbDelete_MEMBER(Integer.parseInt(request.getParameter("ID_Delete")));
				sv.dbDelete_DISTANCE(Integer.parseInt(request.getParameter("ID_Delete")));
				
			}
			
			List<Member_Member> list = sv.dbSelect_MEMBER();
			
			for(Member_Member ml : list){
				
				out.write("<tr>"); 
				
				out.write("<td>" + ml.getID_USER() + "</td>");
				out.write("<td>" + ml.getX() + "</td>");
				out.write("<td>" + ml.getY() + "</td>");
				out.write("<td>" + ml.getREGST_DATE() + "</td>");
				out.write("<td>");
				%> 
				
				<button onclick = "location.href='<%= request.getContextPath()%>/getMEMBER.jsp?ID_Delete=<%=ml.getID_USER()%>'" >삭제</button>
				
				
				</td>

				</tr>
				
	<%
				
			}
	%>
	
			</tr>
		</tbody>
	</table>
</body>
</html>