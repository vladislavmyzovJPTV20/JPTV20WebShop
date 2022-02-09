<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div>
    <h2 class="w-100 d-flex justify-content-center my-5">Список категорий</h2>
    <p class="w-100 d-flex justify-content-center text-info">${info}</p>
    <div class="w-100 d-flex justify-content-center">
        <c:forEach var="category" items="${categories}">
            <div class="card border-primary m-3" style="max-width: 20rem;">
              <div class="card-header">${category.CategoryName}</div>
            </div>
        </c:forEach>
    </div>
</div>
