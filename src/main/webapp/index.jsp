<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="com.emergentes.modelo.Estudiante"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Estudiantes</title>
    <style>
        /* Estilos para el contenedor del texto */
        .contenedor-texto {
            width: 80%;
            margin: 20px auto; /* Centra el contenedor horizontalmente */
            text-align: center; /* Centra el texto horizontalmente */
            border: 2px solid #000; /* Borde de color negro */
            padding: 20px;
            background-color: #f0f0f0;
        }

        /* Estilos para el texto dentro del contenedor */
        .texto {
            font-size: 20px;
            font-weight: bold;
            color: #333;
        }
         h1 {
            text-align: center; /* Centra horizontalmente */
            
        }
        
        /* Estilo para la tabla */
        table {
            width: 100%;
            border-collapse: collapse;
            border: 2px solid #ddd;
        }
        
        /* Estilo para las celdas de la tabla */
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        
        /* Estilo para las filas impares */
        tr:nth-child(odd) {
            background-color: #f2f2f2;
        }
        
        /* Estilo para el encabezado de la tabla */
        th {
            background-color: #4CAF50;
            color: white;
        }
         /* Estilo para los botones */
        .btn {
            display: inline-block;
            padding: 10px 20px;
            margin: 5px;
            font-size: 16px;
            text-align: center;
            text-decoration: none;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        
        /* Estilo para el botón primario */
        .btn-primary {
            background-color: #4CAF50;
            color: white;
        }
        
        /* Estilo para el botón secundario */
        .btn-secondary {
            background-color: #008CBA;
            color: white;
        }
        
        /* Estilo para el botón de peligro */
        .btn-danger {
            background-color: #f44336;
            color: white;
        }
        
        /* Estilo para el botón de información */
        .btn-info {
            background-color: #2196F3;
            color: white;
        }
        
        /* Estilo para el botón de advertencia */
        .btn-warning {
            background-color: #ff9800;
            color: white;
        }
        
        /* Estilo para el botón de éxito */
        .btn-success {
            background-color: #4CAF50;
            color: white;
        }
        
        /* Estilo para el botón de enlace */
        .btn-link {
            background-color: transparent;
            color: #007bff;
            border: none;
        }

        /* Hover sobre los botones */
        .btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
     <div class="contenedor-texto">
        <div class="texto">
            <h1>SEGUNDO PARCIAL TEM-742</h1>
            Nombre:Ever Quispe Apaza
            <p></p>
            Carnet:10071741
        </div>
         
    </div>
    <h1>Reguistro dia del Internet</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Seminario</th>
            <th>Confirmación</th>
            <th>Fecha</th>
            <th>Acciones</th>
        </tr>
        <c:forEach items="${estu}" var="estudiantes">
            <tr>
                <td>${estudiantes.id}</td>
                <td>${estudiantes.nombre}</td>
                <td>${estudiantes.apellido}</td>
                <td>${estudiantes.seminario}</td>
                <td><input type="checkbox" ${estudiantes.confirmacion ? 'checked' : ''} disabled></td>
                <td>${estudiantes.fecha}</td>
                <td>
                            <form action="MainServletEstu" method="post">
                                <input type="hidden" name="action" value="ver">
                                <input type="hidden" name="id" value="${estudiantes.id}">
                                <button type="submit" class="btn btn-primary">Editar</button>
                            </form>
                            <form action="MainServletEstu" method="post">
                                <input type="hidden" name="action" value="select">
                                <input type="hidden" name="id" value="${estudiantes.id}">
                                <button type="submit"class="btn btn-secondary" >Eliminar</button>
                            </form>
                        </td>            </tr>
        </c:forEach>
    </table>
    <br>
     <form action="CRUD/añadir.jsp" method="post">
            <input type="hidden" name="action" value="insertar">
            <button type="submit" class="btn btn-secondary">Agregar Estudiante</button>
        </form>
</body>
</html>
