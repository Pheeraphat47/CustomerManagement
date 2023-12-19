<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<html>
<head>
    <title>บันทึกข้อมูลลูกค้า</title>
</head>
<body>
<form action="customer" method="post">
    <input type="number" name="id" placeholder="ไอดี">
    <input type="text" name="firstname" placeholder="ชื่อ">
    <input type="text" name="lastname" placeholder="นามสกุล">
    <input type="text" name="address" placeholder="ที่อยู่">
    <input type="text" name="phone" placeholder="เบอร์โทรศัพท์">
    <input type="text" name="city" placeholder="เมือง">
    <input type="submit" value="บันทึก">
</form>
</body>
</html>

</body>
</html>