<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculadora</title>
</head>
<body>
<h1>Calculadora</h1>
<!-- mensaje de ayuda -->
<div>${mensaje}</div>

<!--  este If aparece si la operacion a realizar es una suma -->
      <c:if test = "${operacion=='suma'}">
         <h2>El resultado de sumar ${primero} y ${segundo} da ${resultado}</h2>
      </c:if>
<!--  este If aparece si la operacion a realizar es una resta -->
     <c:if test = "${operacion=='resta'}">
         <h2>El resultado de restar ${primero} menos ${segundo} da ${resultado}</h2>
      </c:if>
<!--  este If aparece si la operacion a realizar es una multiplicacion -->
      <c:if test = "${operacion=='multiplicacion'}">
         <h2>El resultado de multiplicar ${primero} por ${segundo} da ${resultado}</h2>
      </c:if>
<!--  este If aparece si la operacion a realizar es una division -->
      <c:if test = "${operacion=='division'}">
         <h2>El resultado de dividir ${primero} por ${segundo} da ${resultado}</h2>
      </c:if>
</body>
</html>