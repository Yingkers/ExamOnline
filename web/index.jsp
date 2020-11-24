<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>登录</title>
  <link href="css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="head"></div>
<div id="body">
  <form action="/login" method="post" class="login_form">
    <ol>
      <li class="userName"><input type="text" name="username" /></li>
      <li class="password"><input type="password" name="password" /></li>
      <li class="register"><a href="/register.jsp">账号注册</a></li>
      <li class="button"><input type="submit" value="登录"></li>
    </ol>
  </form>
</div>
<div id="foot"></div>
</body>
</html>