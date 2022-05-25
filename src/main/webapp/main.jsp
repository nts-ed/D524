<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String userHand=(String)request.getAttribute("userHand");
userHand=userHand==null? "":userHand;
String pcHand=(String)request.getAttribute("pcHand");
pcHand=pcHand==null? "":pcHand;
String result=(String)request.getAttribute("result");
result=result==null? "":result;

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>here</title>
</head>
<body>
<form action="Main" method="post">
手を選んでね:<br>


<input type="radio" name="hand" value="0" <%=userHand.equals("グー")? "checked":"" %>>グー
<input type="radio" name="hand" value="1" <%=userHand.equals("チョキ")? "checked":"" %>>チョキ
<input type="radio" name="hand" value="2" <%=userHand.equals("パー")? "checked":"" %>>パー
<input type="submit" value="送信">

</form>
<%if(result.length() >0){%>
<p>あなたは<%=userHand %></p>
<p>PCは<%=pcHand %></p>
<p><%=result %></p>
<%} %>
</body>
</html>