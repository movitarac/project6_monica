<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<hr>
<h2 class="searchbook">Book by Title</h2>
<hr>
<form:form method="GET" name="workssearchtitle" action="${pageContext.request.contextPath}/searchbytitle">
    <table class="searchbook">
        <tr>
            <label for="inputTitle" class="sr-only">
                <td>Author</td>
            </label>
            <td><input type="text" id="inputTitle"
                       class="form-control" placeholder="title" name="title"/></td>
        </tr>

        <tr>

            <td><input type="submit" value="Search" class="btn btn-secondary"/></td>
            <td><input type="reset" value="Clear the Form" class="btn btn-secondary"></td>
        </tr>
    </table>
</form:form>