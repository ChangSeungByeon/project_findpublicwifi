<%@page import="java.util.List" %>
<%@page import="DB.Service"%>
<%@page import="DB.Member_listed"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서울시 와이파이 정보 구하기</title>
<style>
	table, td, th {
	  border: 1px solid;
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
	
	.info {
	
		text-align: center;
		border: 1px solid green;
		width: 100%;
		
	
	}
</style>
</head>
<body>



<h1>와이파이 정보 구하기 </h1>
<a href = "<%= request.getContextPath()%>/main.jsp">홈</a> | 
<a href = "<%= request.getContextPath()%>/getMEMBER.jsp">위치 히스토리 목록</a> |
<a href = "<%= request.getContextPath()%>/getWIFILIST.jsp">와이파이 정보 가져오기 (Open API) </a> 

<form action ="<%= request.getContextPath()%>/main.jsp" method="get">	
    LAT: <input type="text" name="LAT"> ,
    LNT: <input type="text" name="LNT"> 
    <input type="submit" value="근처 WIFI 정보 보기">
</form>

<h1></h1>
	<table> <!-- 테이블 만드는 기본  -->
		<thead>
			<tr>
				<th width="50">거리<br>(Km)</th>
				<th width="70">관리번호</th>
				<th width="50">자치구</th>
				<th>와이파이명</th>
				<th>도로명주소</th>
				<th>상세주소</th>
				<th>설치위치<br>(층)</th>
				<th>설치유형</th>
				<th>설치기관</th>
				<th>서비스구분</th>
				<th>망종류</th>
				<th>설치년도</th>
				<th>실내외<br>구분</th>
				<th>WIFI접속환경</th>
				<th>X좌표</th>
				<th>Y좌표</th>
				<th>작업일자</th>
			</tr>
		</thead>

				<%-- <%
					for(Member member : memberList){ 
						out.write("<tr>"); 
						out.write("<td>" + member.getName() + "</td>");
						out.write("<td>" + member.getEmail() + "</td>");
						out.write("<td>" + member.getMobile_no() + "</td>");
						out.write("<td>" + member.getPassword() + "</td>");
						out.write("<td>" + member.isMarketing_yn() + "</td>");
						out.write("</tr>"); 
					}
				%> --%>
				
				<!-- 아래와 같이 적용 가능함 --> 
				<%-- 한 줄 java 실행하여면 '<%= %>' 안에 넣으면 됨 (세미콜론 미필요) --%>
				
<%-- 				<%
					for(Member member : memberList){
				%>
				
					<tr>
						<td> <!-- 주소?파라미터1=값1&파라미터2=값2... 로 이루어진다.  -->
							<a href="detail.jsp?name=<%=member.getName()%>&email=<%=member.getEmail()%>">
								<%=member.getName()%>
							</a>
						</td>
						<td><%=member.getEmail()%></td>
						<td><%=member.getMobile_no()%></td>
						<td><%=member.getPassword()%></td>
						<td><%=member.isMarketing_yn()%></td>
					</tr>
					
				<%
					}
				%> --%>
				
	


	<%
		if(request.getParameter("LAT") == null){
	%>
		<tbody>
		</tbody>
	</table>
	
		<div class = info>
			<br>
				위치 정보를 입력해주세요
			<br>
			<br>
		</div>
	
	<%
		}else{
			double LAT = Double.parseDouble(request.getParameter("LAT"));
			double LNT = Double.parseDouble(request.getParameter("LNT"));
			
			Service sv = new Service();
			
			List<Member_listed> list = sv.dbSelect_DISTANCE(LAT,LNT);
			
			out.write("<tbody>");
			out.write("<tr>");
			
			
			for(Member_listed ml : list){
				
				out.write("<tr>"); 
				
				out.write("<td>" + ml.getDIS() + "</td>");
				out.write("<td>" + ml.getID_WIFI() + "</td>");
				out.write("<td>" + ml.getGU() + "</td>");
				out.write("<td>" + ml.getNAME() + "</td>");
				out.write("<td>" + ml.getADDRESS_STREET() + "</td>");
				out.write("<td>" + ml.getADDRESS_SPECIFIC() + "</td>");
				out.write("<td>" + ml.getFLOOR() + "</td>");
				out.write("<td>" + ml.getINSTALL_TYPE() + "</td>");
				out.write("<td>" + ml.getINSTALL_TEAM() + "</td>");
				out.write("<td>" + ml.getSERVICE_TYPE() + "</td>");
				out.write("<td>" + ml.getMANG() + "</td>");
				out.write("<td>" + ml.getREGST_YEAR() + "</td>");
				out.write("<td>" + ml.getIN_OUT() + "</td>");
				out.write("<td>" + ml.getCIRCUM() + "</td>");
				out.write("<td>" + ml.getX() + "</td>");
				out.write("<td>" + ml.getY() + "</td>");
				out.write("<td>" + ml.getREGST_DATE() + "</td>");

				out.write("</tr>"); 
				
			}
			
		}
	%>
	
	</tr>
	
	</tbody>
	</table>


</body>
</html>