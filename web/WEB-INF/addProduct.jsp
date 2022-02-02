<%-- 
    Document   : addBook
    Created on : 02.02.2022, 19:04:00
    Author     : Влад
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Добавить продукт</h1>
        <p>${info}</p>
        <form action="createProduct" method="POST">
            Название продукта <input type="text" name="productName"><br>
            Категории:
            <select name="categories" multiple>
                <c:forEach var="category" items="${categories}">
                    <option value="${category.id}">${category.categoryname}</option>
                </c:forEach>
            </select><br>
            Цена: <input type="text" name="price"><br>
            Количество экземпляров: <input type="text" name="quantity"><br>
            <input type="submit" name="Добавить">
        </form>
    </body>
</html>
