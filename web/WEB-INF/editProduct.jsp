<%-- 
    Document   : editBook
    Created on : 09-Feb-2022, 13:19:54
    Author     : pupil
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="w-100 ">
    <h2 class="w-100 d-flex justify-content-center my-5">Редактировать продукт</h2>
    <p class="w-100 d-flex justify-content-center text-info">${info}</p>
    <div class="w-100 d-flex justify-content-center">
        <div class="" style="max-width: 30rem;min-width: 30rem"
            <form action="updateProduct" method="POST">
                <div class="mb-3">
                    <label for="productname" class="form-label">Название продукта</label>
                    <input type="text" class="form-control" name="productname" id="productname" aria-describedby="" value="${product.productname}">
                    <div id="productname" hidden class="form-text">error</div>
                    <input type="text" class="form-control" hidden name="productId" id="productId" value="${product.id}">
                </div>
                <div class="mb-3">
                    <label for="categories" class="form-label">Категории</label>
                    <select name="categories"  id="categories" multiple class="form-select" aria-label="Default select example">
                        <c:forEach var="category" items="${product.category}">
                            <option value="${category.id}">${category.CategoryName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="price" class="form-label">Цена</label>
                    <input type="text" class="form-control" name="price" id="price" aria-describedby="" value="${product.price}">
                    <div id="price" hidden class="form-text">error</div>
                </div>
                <div class="mb-3">
                    <label for="quantity" class="form-label">Количество экземпляров</label>
                    <input type="text" class="form-control" name="quantity" id="quantity" aria-describedby="" value="${product.quantity}">
                    <div id="quantity" hidden class="form-text">error</div>
                </div>

                <input type="submit" name="Изменить" class="btn btn-success mb-3">
            </form>
        </div>
    </div>
</div>