<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulario de Estudiante</title>
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
             
    <h1>Formulario de Estudiante</h1>
    <form action="../MainServletEstu?action=insertar" method="post">
        <input type="hidden" name="action" value="insertar">
        Nombre: <input type="text" name="nombre"><br>
        Apellido: <input type="text" name="apellido"><br>
        Seminario: <input type="text" name="seminario"><br>
        Confirmación: <input type="checkbox" name="confirmacion" value="true"><br>
        Fecha de Creación: <input type="Date" name="fecha" ><br>
        <input type="submit" value="Añadir Estudiante">
    </form>
    
         </div>
         </div>
</body>
</html>
