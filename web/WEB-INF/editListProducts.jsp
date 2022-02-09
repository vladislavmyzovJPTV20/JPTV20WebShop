<%-- 
    Document   : editListBooks
    Created on : 09-Feb-2022, 14:40:40
    Author     : pupil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="w-100 ">
    <h2 class="w-100 d-flex justify-content-center my-5">Редактировать продукты</h2>
    <p class="w-100 d-flex justify-content-center text-info">${info}</p>
    <div class="w-100 d-flex justify-content-center">
        <div class="" style="max-width: 30rem;min-width: 30rem">
            <form action="editProduct" method="POST">
                <div class="mb-3">
                    <label for="productId" class="form-label">Список продуктов</label>
                    <select name="productId"  id="productId" class="form-select" aria-label="">
                        <c:forEach var="product" items="${products}">
                            <option value="${product.id}">
                                ${product.productname} 
                                <c:forEach var="category" items="${product.category}">
                                    ${category.CategoryName}. 
                                </c:forEach>
                            ${product.price}. ${product.quantity} шт.
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <input type="submit" name="Редактировать" class="btn btn-success mb-3">            
            </form>
        </div>
    </div>
</div>






