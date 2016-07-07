<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Second JSP is ready</h1>
        
        <%
            String g = (String)request.getAttribute("SimpleName");
            out.append(g);
        %>
        
        <h3><%=request.getAttribute("SimpleName") %></h3>

        <% for(int i=0; i<5; i++) { %>
            <h3>${SimpleName}  -  Scriptlet</h3>
        <% } %>
        
        <c:forEach begin="0" end="1">
            <h3>${SimpleName}  - TAG</h3>
        </c:forEach>
            
            
    </body>
</html>
