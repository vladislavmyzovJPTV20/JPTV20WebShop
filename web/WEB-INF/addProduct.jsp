<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="w-100 ">
    <h2 class="w-100 d-flex justify-content-center my-5">Добавить продукт</h2>
    <p class="w-100 d-flex justify-content-center text-info">${info}</p>
    <div class="w-100 d-flex justify-content-center">
        <div class="" style="max-width: 30rem;min-width: 30rem"
            <form action="createProduct" method="POST">
                <div class="mb-3">
                    <label for="productname" class="form-label">Название продукта</label>
                    <input type="text" class="form-control" name="productname" id="productname" aria-describedby="">
                    <div id="productname" hidden class="form-text">We'll never share your email with anyone else.</div>
                </div>
                <div class="mb-3">
                    <label for="categories" class="form-label">Категории</label>
                    <select name="categories"  id="categories" multiple class="form-select" aria-label="Default select example">
                        <c:forEach var="category" items="${categories}">
                            <option value="${category.id}">${category.CategoryName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="price" class="form-label">Цена</label>
                    <input type="text" class="form-control" name="price" id="price" aria-describedby="">
                    <div id="price" hidden class="form-text">We'll never share your email with anyone else.</div>
                </div>
                <div class="mb-3">
                    <label for="quantity" class="form-label">Количество экземпляров</label>
                    <input type="text" class="form-control" name="quantity" id="quantity" aria-describedby="">
                    <div id="quantity" hidden class="form-text">We'll never share your email with anyone else.</div>
                </div>

                <input type="submit" name="Добавить" class="btn btn-success mb-3">
            </form>
        </div>
    </div>
</div>
    