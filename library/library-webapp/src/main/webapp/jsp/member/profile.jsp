<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<body class="profile">
<%@ include file="../_include/header.jsp" %>
<main role="main" class="inner cover">


        <h1 class="persoinfo">Your personal information</h1>
        <p class="lead">
            <span class="profDetail">First Name: </span> <span class="profInfo">${memberConnected.firstName}</span> <br>
            <span class="profDetail">Last Name: </span> <span class="profInfo">${memberConnected.lastName}</span> <br>
            <span class="profDetail">Username: </span> <span class="profInfo">${memberConnected.username}</span> <br>
            <span class="profDetail">Email: </span> <span class="profInfo">${memberConnected.email}</span> <br>
            <span class="profDetail">Address: </span> <span class="profInfo">${memberConnected.address}</span> <br>
            <a class="badge badge-info" href="${pageContext.request.contextPath}/update">edit profile</a>
        </p>

</main>

</body>
