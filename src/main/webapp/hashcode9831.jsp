<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP & 서블릿 연습</title>
</head>
<body>
<%!
    int num = 1;
    String str = "테스트 문자열";
    List<String> arr = new ArrayList<>();

    int addNums(int n1, int n2) {
        return n1 + n2;
    }
%>

// [1]
<%
    System.out.println("안녕 JSP!");

    for (int i = 0; i < 5; ++i) {
        arr.add(str + " " + num);
        ++num;
    }

    for (String s : arr) {
        System.out.println(s);
    }
%>

<%
    if (num >= 5) {
%>
<p>if문 동작</p>
<%
	} else {
%>
<p>else문 동작</p>
<%
    }
%>

num의 값은 <%=num%>입니다.<br/>  // [2]
<p>addNum(2, 3)의 값은 <%=addNums(2, 3)%>입니다.</p>
</body>
</html>