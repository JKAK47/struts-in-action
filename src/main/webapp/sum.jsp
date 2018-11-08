<%--
  Created by IntelliJ IDEA.
  User: PengRong
  Date: 2018/9/12
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
    <title>输入操作数</title>
</head>

<body>
求代数和
<br/>
<%--
 action="mystruts/sum.action" 就是 context/struts-action.xml 中定义的 package 的 namespace="/mystruts"
 加上 action name="sum" 属性拼接起来的。
 form 表达数据通过 post 方式提交。
--%>
<s:form action="mystruts/sum.action" >
    <s:textfield name="operand1" label=" 操作数1"/>
    <s:textfield name="operand2"  label=" 操作数2" />
    <s:submit value="代数和" />
</s:form>
</body>
</html>