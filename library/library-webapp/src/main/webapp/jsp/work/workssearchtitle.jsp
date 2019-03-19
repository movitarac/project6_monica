<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<hr>
<h2 class="searchbook">Book by Title</h2>
<hr>
<form:form method="GET" name="workssearchbytitle" action="${pageContext.request.contextPath}/searchbytitle">
    <table class="searchbook">
        <tr>
            <label for="inputTitle" class="sr-only">
                <td>Title</td>
            </label>
            <td><input type="text" id="inputTitle"
                       class="form-control" placeholder="title" name="title"/></td>
        </tr>

        <tr>

            <td><input type="submit" value="Search" class="btn btn-outline-dark"/></td>
            <td><input type="reset" value="Clear the Form" class="btn btn-outline-danger"></td>
        </tr>
    </table>
</form:form>