

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<body class="loginelement">
<%@ include file="../_include/header.jsp" %>

<form:form action="${pageContext.request.contextPath}/update" method="POST">

    <div id="editprofile">
        <h1 class="h3 mb-3 font-weight-normal">edit your profile and click save</h1>
        <div class="form-row">
            <div class="col-md-4 mb-3">
                <label for="validationServer01">First name</label>
                <input type="text" class="form-control is-valid" id="validationServer01" placeholder="first name"
                       name="firstname" path="firstname" required>
            </div>
            <div class="col-md-4 mb-3">
                <label for="validationServer02">Last name</label>
                <input type="text" class="form-control is-valid" id="validationServer02" placeholder="last name"
                       name="lastname" path="lastname" required>
            </div>
            <div class="col-md-4 mb-3">
                <label for="validationServerAddress">Address</label>

                    <input type="text" class="form-control is-valid" id="validationServerAddress"
                           placeholder="address" name="address" path="address" aria-describedby="inputGroupPrepend3"
                           required>
            </div>
        </div>


        <button class="btn btn-primary" type="submit">save</button>
    </div>
</form:form>
</body>


