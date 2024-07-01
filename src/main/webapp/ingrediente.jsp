<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ingredientes</title>
</head>
<body>
<h1>Ingredientes</h1>
<form action="ingrediente" method="post">
    <input type="hidden" name="action" value="add">
    Nombre: <input type="text" name="nombre">
    Proveedor: <input type="text" name="proveedor">
    <input type="submit" value="Agregar Ingrediente">
</form>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Proveedor</th>
        <th>Acciones</th>
    </tr>
    <c:forEach var="ingrediente" items="${ingredientes}">
        <tr>
            <td>${ingrediente.id}</td>
            <td>${ingrediente.nombre}</td>
            <td>${ingrediente.proveedor}</td>
            <td>
                <form action="ingrediente" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="${ingrediente.id}">
                    <input type="submit" value="Eliminar">
                </form>
                <form action="ingrediente" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="id" value="${ingrediente.id}">
                    <input type="text" name="nombre" value="${ingrediente.nombre}">
                    <input type="text" name="proveedor" value="${ingrediente.proveedor}">
                    <input type="submit" value="Actualizar">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

