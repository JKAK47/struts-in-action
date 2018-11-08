<%@page contentType="text/html; charset=UTF-8" language="java"%>
<html>
<head>
    <title> first jsp and two</title>
</head>
<body>
<%
    String appContext = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+ request.getServerPort() + appContext;
    String RequestURI=request.getRequestURI();
    String realPath=request.getRealPath("/");
    String ServletPath=request.getServletPath();
    out.println("<h2> appContext "+ appContext +"</h2>");
    out.println("<h2> basePath "+ basePath+" </h2>");
    out.println("<h2> ServletPath\t"+ ServletPath+" </h2>");
    out.println("<h2> realPath\t"+ realPath+" </h2>");
    out.println("<h2> request.getRequestURI(): \t"+request.getRequestURI()+" </h2>");

%>
</body>
</html>