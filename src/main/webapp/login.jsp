<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Iniciar sesion</title>
</head>
<body>
  <h1>Login</h1>
  <form action="/RepasoServlet/login" method="POST">
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