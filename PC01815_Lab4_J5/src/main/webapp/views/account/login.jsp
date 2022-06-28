<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form action="/account/login" method="post" enctype="multipart/form-data">
       <input type="text" name="usename" placeholder="usename..."><br><br>
       <input type="password" name="password" placeholder="password..."><br>
       <input type="checkbox" name="remember" value="true">Remember me?<br>
       <input type="file" name="file"><br>
       <button>Login</button><br>
       ${tb }<br>
       ${luu }
   </form>
</body>
</html>