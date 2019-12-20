<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de usuário</title>
<link rel="stylesheet" href="resources/css/cadastro.css" />
</head>
<body>
	<center><h1>Cadastro de usuário</h1></center>


	<form action="salvarUsuario" method="POST">

		<ul class="form-style-1">
			<li><label>Cȯdigo <span class="required">*</span></label> <input class="field-long"
				type="text" readonly="readonly" id="idUser" name="idUser"
				value="${user.idUser }" /></li>

			<li>
			<label>Nome <span class="required">*</span></label>
			
			<input class="field-long" type="text" id="nome" name="nome"
				value="${user.nome }" />
			</li>
			
			<li>
			<label>Celular <span class="required">*</span></label>
			 <input class="field-long" type="text" id="celular" name="celular"
				value="${user.celular }" />

			</li>
			
			<li>
			<label>Residencial <span class="required">*</span></label>
			 <input class="field-long" type="text" id="residencial" name="residencial"
				value="${user.residencial }" />

			</li>

			<li>
			<label>Email <span class="required">*</span></label> 
			
			<input class="field-long" type="text" id="email" name="email"
				value="${user.email }" />

			</li>

			<li>
			<label>Senha <span class="required">*</span></label>
			 <input class="field-long" type="password" id="senha" name="senha"
				value="${user.senha }" />

			</li>

			<li><input type="submit" value="Salvar" /></li>
		</ul>
	</form>




	<center><table></center>
		
		
			<tr>
			<th>Cȯdigo</th>
			<th>Nome</th>
			
			<th>E-mail</th>
			<th>Celular</th>
			<th>Residencial</th>
			
			<th></th>
			<th></th>
			</tr>
					<c:forEach items="${usuarios}" var="user">
		
			<tr>
				<td><c:out value="${user.idUser}"></c:out></td>
				<td><c:out value="${user.nome}"></c:out></td>
				<td><c:out value="${user.email}"></c:out></td>
				<td><c:out value="${user.celular}"></c:out></td>
				<td><c:out value="${user.residencial}"></c:out></td>
				


				<td><a href="salvarUsuario?acao=delete&user=${user.idUser}"><img title="Excluir"  src="resources/img/excluir.png" width="20"/></a>
				</td>
				<td><a href="salvarUsuario?acao=editar&user=${user.nome}"><img src="resources/img/editar.ico" width="20"/></a>
				</td>

			</tr>
		</c:forEach>

		<%-- <c:forEach items="${userTel}" var="user"> --%>
		<!-- <tr> -->
		<%-- <td><c:out value="${user.usuario}"></c:out>  </td> --%>
		<%-- <td><c:out value="${user.email}"></c:out>  </td> --%>
		<%-- <td><c:out value="${user.residencial}"></c:out>  </td> --%>
		<%-- <td><c:out value="${user.celular}"></c:out>  </td> --%>
		<!-- </tr> -->

		<%-- </c:forEach> --%>
	</table>

</body>
</html>