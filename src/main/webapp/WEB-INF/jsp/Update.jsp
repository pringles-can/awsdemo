<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ include file="navbar.html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="//cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.2/jquery-ui.css" rel="stylesheet"/>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Person</title>

    <!-- Bootstrap core CSS -->
    <!-- Custom styles for this template -->
</head>

<body>
<p></p>
<p></p>

<table>


    <form method="post" action="/person/save/${person.id}" modelAttribute="addPerson">
        <form:errors path="*" cssClass="errorblock" element="div"></form:errors>
        <table class="tg">
            <tr>
                <th class="tg-mbw0">New Name:</th><td><form:input path="addPerson.name" value="${addPerson.name}"/></td>
                <td><form:errors path="addPerson.name" cssClass="error"> </form:errors> </td>
                <td class="tg-mbw0"></td>
                <th class="tg-mbw0"> New fucking whatever:<input type="text" name="country" id="id19"
                                                                value="${person.country}"></th>
                <td colspan="4">
                <th class="tg-mbw0"><input type="submit" id="id20"/></th>
                </td>
            </tr>
            <td>
                <a href="<c:url value='/person/remove/${person.id}' />" class="btn"
                   id="removeButton">Delete</a>
                <a href="<c:url value='/imag/upload/${person.id}' />" class="button">Upload Pic</a>
            </td>

            <img src="" alt=""/>
        </table>

    </form>

    <table>
        <div class="container-fluid text-center">
            <div class="row content">
                <div class="container">
                    <h2>IMAG 4 PERSEN: </h2>
                    <p></p>
                    <table class="table table-bordered">
                        <c:if test="${!empty personImages}">
                            <c:forEach items="${personImages}" var="person" varStatus="loop">
                            <td class="tg-jnuu"><img src="data:image/jpeg;base64,${personImages.get(loop.index)}" height="256" width="256"/></td>
                            <tr>
                            </tr>
                            </c:forEach>
                        </c:if>
                    </table>
                </div>
            </div>
        </div>
    </table>

</table>


</html>