<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/style.css" />
</head>
<body>

	<%-- <c:out value="${'Bem vindo ao JSTL'}"/>
<c:import var="data" url="https://www.google.com.br"/>
<c:out value="${data}"/>

 <br/>
<c:set var="result" scope="page" value="${997 * 2 }"></c:set>
<c:remove var="result" />
<c:out value="${result }"/>
<br/>

<c:catch var="erro">
	<% int var = 100/2; %>
</c:catch>

<c:if test="${erro != null }">
	${erro.message}
</c:if>
<br/> --%>

	<%-- 
condição IF

<c:set var="numero" value="${100/2 }"></c:set>

<c:choose>

<c:when test="${numero > 50 }">
	<c:out value="${'Maior que 50'}"/>
</c:when>

<c:when test="${numero < 50 }">
	<c:out value="${'Menor que 50'}"/>
</c:when>

<c:otherwise>
	<c:out value="${'Igual a 50'}"/>
</c:otherwise>

</c:choose>
 --%>


	<%-- FOR
<c:set var="numero" value="${100/50 }"></c:set>
<c:forEach var="n" begin="1" end="${numero}">
	item: ${n}
</c:forEach> 
<br/>

<c:forTokens items="Israel-Gomes-Da-Lapa" delims="-" var="nome">
<br/>Nome:<c:out value="${nome}"></c:out>
</c:forTokens>
 --%>


	<br />

	<%-- MONTA URL 
 <c:url value="/acessoLiberado.jsp" var="acesso">
 	<c:param name="para1" value="132"></c:param>
 	<c:param name="para2" value="321"></c:param>
 </c:url>
 
  ${acesso}
 
  --%>

	<c:set var="numero" value="${100/2 }"></c:set>

	<c:if test="${numero > 50 }">
		<c:redirect url="https://www.google.com.br">
		</c:redirect>
	</c:if>

	<c:if test="${numero < 50 }">
		<c:redirect url="http://www.javaavancado.com">
		</c:redirect>
	</c:if>


	<p />
	<p />
	<p />
	<p />

	<div class="login-page">
		<div class="form">
			<form action="LoginServelet" method="post" class="login-form" >
				<input placeholder="email" type="text" id="email" name="email">
				<input placeholder="senha" type="password" id="senha" name="senha">
				<button type="submit">login</button>

				<!-- <input type="submit" value="Logar"> -->

			</form>
		</div>
	</div>


</body>
</html>