<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<hr>
<h2 class="searchbook">Book by Author</h2>
<hr>
<form:form method="GET" name="workssearchbyauthor" action="${pageContext.request.contextPath}/searchbyauthor">
    <table class="searchbook">
        <tr>
            <label for="inputAuthor" class="sr-only">
                <td> Author </td>
            </label>
            <td><input type="text" id="inputAuthor"
                       class="form-control" placeholder="author" name="author"/></td>
        </tr>


        <tr>

            <td><input type="submit" value="Search" class="btn btn-outline-dark"/></td>
            <td><input type="reset" value="Clear the Form" class="btn btn-outline-danger"></td>
        </tr>
        <tr>
            <td><div style="color: red">${msg}</div></td>
        </tr>
    </table>
</form:form>

