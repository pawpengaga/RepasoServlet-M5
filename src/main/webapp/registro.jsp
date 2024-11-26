<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
</head>
<body>
    <h1>Registro</h1>
    <form action="/RepasoServlet/registro" method="POST">
      <label for="nombre">Nombre</label>
      <input type="text" name="nombre" id="nombre" required />
      <br>
      <label for="usuario">Usuario</label>
      <input type="text" name="usuario" id="usuario" required />
      <br>
      <label for="clave">Contraseña</label>
      <input type="password" name="clave" id="clave" required />
      <br>
      <button type="submit">Entrar</button>
    </form>
</body>
</html>