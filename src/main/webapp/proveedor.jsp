<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Proveedores</title>
</head>
<body>
<h1>Proveedores</h1>
<form action="proveedor" method="post">
    <input type="hidden" name="action" value="add">
    Nombre: <input type="text" name="nombre">
    <input type="submit" value="Agregar Proveedor">
</form>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Acciones</th>
    </tr>
    <c:forEach var="proveedor" items="${proveedores}">
        <tr>
            <td>${proveedor.id}</td>
            <td>${proveedor.nombre}</td>
            <td>
                <form action="proveedor" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="${proveedor.id}">
                    <input type="submit" value="Eliminar">
                </form>
                <form action="proveedor" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="id" value="${proveedor.id}">
                    <input type="text" name="nombre" value="${proveedor.nombre}">
                    <input type="submit" value="Actualizar">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
