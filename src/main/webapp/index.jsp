<%@ page import="mx.edu.utez.ejercicioentidades.model.Proveedor" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Proveedores</title>
</head>
<body>
<h1>Lista de Proveedores</h1>
<form action="proveedor" method="post">
    Nombre: <input type="text" name="nombre">
    <input type="submit" value="Agregar Proveedor">
</form>

<%
    List<Proveedor> proveedores = (List<Proveedor>) request.getAttribute("proveedores");
    if (proveedores == null) {
        proveedores = new ArrayList<>();
    }
%>
<table>
    <tr>
        <th>ID</th>
        <th>Nombre</th>
    </tr>
    <% for (Proveedor proveedor : proveedores) { %>
    <tr>
        <td><%= proveedor.getId() %></td>
        <td><%= proveedor.getNombre() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>
