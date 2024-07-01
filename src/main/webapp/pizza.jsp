<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pizzas</title>
</head>
<body>
<h1>Pizzas</h1>
<form action="pizza" method="post">
    <input type="hidden" name="action" value="add">
    Nombre: <input type="text" name="nombre">
    Precio: <input type="text" name="precio">
    <input type="submit" value="Agregar Pizza">
</form>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Precio</th>
        <th>Acciones</th>
    </tr>
    <c:forEach var="pizza" items="${pizzas}">
        <tr>
            <td>${pizza.id}</td>
            <td>${pizza.nombre}</td>
            <td>${pizza.precio}</td>
            <td>
                <form action="pizza" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="${pizza.id}">
                    <input type="submit" value="Eliminar">
                </form>
                <form action="pizza" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="id" value="${pizza.id}">
                    <input type="text" name="nombre" value="${pizza.nombre}">
                    <input type="text" name="precio" value="${pizza.precio}">
                    <input type="submit" value="Actualizar">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
