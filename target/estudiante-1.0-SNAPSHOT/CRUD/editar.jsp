<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Estudiante</title>
     <style>
         
          /* Estilos para los textos */
        h1, label {
            font-family: Arial, sans-serif;
            font-size: 18px;
            color: #333;
            text-align: center; /* Centra horizontalmente */
        }
        /* Estilos para centrar el formulario */
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            text-align: center; /* Centra horizontalmente */
        }
        .form-container {
            width: 400px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        /* Estilos para el botón */
        input[type="submit"] {
            background-color: #4CAF50; /* Color de fondo */
            color: white; /* Color del texto */
            padding: 12px 20px; /* Espaciado interno */
            border: none; /* Borde */
            border-radius: 4px; /* Borde redondeado */
            cursor: pointer; /* Cursor */
            font-size: 16px; /* Tamaño del texto */
        }

        /* Cambio de estilo cuando se pasa el cursor */
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        
        body {
    background-color: #f2f2f2; /* Color de fondo */
    font-family: Arial, sans-serif; /* Tipo de fuente */
    margin: 0; /* Elimina el margen predeterminado */
    padding: 0; /* Elimina el relleno predeterminado */
}

    </style>
</head>
<body>
    
    <div class="container">
        <div class="form-container">
    <h1>Editar Estudiante</h1>
    <form action="MainServletEstu" method="post">
        <input type="hidden" name="action" value="actualizar">
        <input type="hidden" name="id" value="${estudiantes.id}">
        <label>Nombre:</label>
        <input type="text" name="nombre" value="${estudiantes.nombre}"><br>
        <label>Apellido:</label>
        <input type="text" name="apellido" value="${estudiantes.apellido}"><br>
        <label>Seminario:</label>
        <input type="text" name="seminario" value="${estudiantes.seminario}"><br>
        <label>Confirmación:</label>
        <input type="checkbox" name="confirmacion" value="true" ${estudiantes.confirmacion ? 'checked' : ''}><br>
        <label>Fecha de Creación:</label>
        <input type="Date" name="fecha" value="${estudiantes.fecha}" ><br>
        <input type="submit" value="Guardar">
    </form>
                </div>
    </div>

</body>
</html>
