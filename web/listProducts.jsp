<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div>
    <h2 class="w-100 d-flex justify-content-center my-5">Список продуктов</h2>
    <p class="w-100 d-flex justify-content-center text-info">${info}</p>
    <div class="w-100 d-flex justify-content-center">
        <c:forEach var="product" items="${products}">
            <div class="card border-primary m-3" style="max-width: 20rem;">
              <div class="card-header">${product.productname}</div>
              <div class="card-body">
                <h4 class="card-title">Категории:
                    <c:forEach var="category" items="${product.category}">
                        ${category.CategoryName}. 
                    </c:forEach>          
                </h4>
                <p class="card-text">В наличии: ${product.count} шт.</p>
              </div>
            </div>
        </c:forEach>
    </div>
</div>
