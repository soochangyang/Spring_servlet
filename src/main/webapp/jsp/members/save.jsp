<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%
    //request, response는 사용가능
    MemberRepository memberRepository = MemberRepository.getInstance();

    String userName = request.getParameter("userName");
    int age = Integer.parseInt(request.getParameter("age"));
    Member member = new Member(userName, age);
    memberRepository.save(member);
%>
<html>
<head>
    <title>TITLE</title>
</head>
<body>
    성공
    <ul>
        <li> ID: <%=member.getId()%></i>
        <li> USERNAME: <%=member.getUserName()%></i>
        <li> AGE: <%=member.getAge()%></i>
    </ul>
</body>
</html>