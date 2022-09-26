<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bom-trajeto - Lista de Clientes</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">


</head>
<body style="background-color: #b5dcfc;">

	<nav class="navbar navbar-expand-sm navbar-dark"
		style="background-color: #3f82c0";>
		<div class="container-fluid">
			<a class="navbar-brand" href="index.html"><strong
				style="text-decoration: overline;">BOM TRAJETO.COM</strong></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="destino.html">Destino</a></li>

				</ul>
				<form class="d-flex" action="CreateAndFind" method="GET">
					<input name="pesquisa" class="form-control me-2" type="search"
						placeholder="Digite o nome ou CPF" aria-label="Search">
					<button class="btn btn-outline-info" type="submit">Buscar</button>
				</form>
			</div>
		</div>
	</nav>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-md-7">
				<hr>
				<h3>CLIENTES</h3>
				<hr>
				<table class=table>
					<thead>
						<tr>
							<th>#</th>
							<th>Nome</th>
							<th>CPF</th>
							<th>Nascimento</th>
							<th>Email</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${clientes}" var="cliente">
							<tr>
								<td>${cliente.id_cli}</td>
								<td>${cliente.nome}</td>
								<td>${cliente.cpf}</td>
								<td>${cliente.nascimento}</td>
								<td>${cliente.email}</td>
								<td><a
									href="ClienteDestroy?clienteId_cli=${cliente.id_cli}"><button
											type="button" class="btn btn-primary">EXCLUIR</button></a>
								<td><a href="ClienteUpdate?clienteId_cli=${cliente.id_cli}"><button
											type="button" class="btn btn-primary">EDITAR</button></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<a href="index.html" class="btn btn-primary " tabindex="-1"
					role="button" aria-disabled="true">INCLUIR CLIENTES</a>

			</div>
		</div>
	</div>


	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
		crossorigin="anonymous"></script>
</body>
</html>