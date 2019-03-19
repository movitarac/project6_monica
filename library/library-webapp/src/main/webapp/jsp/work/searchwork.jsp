<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<hr>
<h2 class="searchbook">Find book by title and author's name</h2>
<hr>
<form:form method="GET" name="searchwork" action="${pageContext.request.contextPath}/searchwork">
    <table class="searchbook">
        <tr>
            <label for="inputAuthor" class="sr-only">
                <td>Author</td>
            </label>
            <td><input type="text" id="inputAuthor"
                       class="form-control" placeholder="author" name="author"/></td>
        </tr>

        <tr>
        <tr>
            <label for="inputTitle" class="sr-only">
                <td>Title</td>
            </label>
            <td><input type="text" id="inputTitle"
                       class="form-control" placeholder="title" name="title"/></td>
        </tr>

            <td><input type="submit" value="Search" class="btn btn-outline-dark"/></td>
            <td><input type="reset" value="Clear the Form" class="btn btn-outline-danger"></td>
        </tr>
    </table>
</form:form>