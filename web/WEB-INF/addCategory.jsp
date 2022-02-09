<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="w-100 ">
    <h2 class="w-100 d-flex justify-content-center my-5">Добавить категорию</h2>
    <p class="w-100 d-flex justify-content-center text-info">${info}</p>
    <div class="w-100 d-flex justify-content-center">
        <div class="" style="max-width: 30rem;min-width: 30rem">
            <form action="createCategory" method="POST">
                <div class="mb-3">
                    <label for="CategoryName" class="form-label">Название категории</label>
                    <input type="text" class="form-control" name="CategoryName" id="CategoryName" aria-describedby="">
                    <div id="CategoryName" hidden class="form-text">We'll never share your email with anyone else.</div>

                <input type="submit" name="Добавить" class="btn btn-primary mb-3">
            </form>
        </div>
    </div>
</div>
  