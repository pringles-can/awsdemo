<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ include file="navbar.html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Person</title>

    <!-- Bootstrap core CSS -->
    <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="starter-template.css" rel="stylesheet">
</head>


<style type="text/css">
    .error{
        color: #ff0000;
    }

    .errorblock {
        color: #000;
        background-color: #ffEEEE;
        border: 3px solid #ff0000;
        padding: 8px;
        margin: 16px;
    }
</style>

<body>
<script type="text/javascript" src="http://twitter.github.io/bootstrap/assets/js/bootstrap-transition.js"></script>
<script type="text/javascript" src="http://twitter.github.io/bootstrap/assets/js/bootstrap-collapse.js"></script>

<p></p>
<p></p>

<table>
    <form:errors path="*" cssClass="errorblock" element="div">

    </form:errors>

    <style type="text/css">

    </style>

    <form method="post" action="/person/save/${person.id}">
        <table class="tg">
            <tr>
                <th class="tg-mbw0">New Name:<input type="text" name="name" id="id18" placeholder="${person.name}"></th>
                <td><form:errors path="name" cssClass="error"></form:errors> </td>
                <th class="tg-mbw0">New fucking whatever:<input type="text" name="country" id="id19"
                                                                placeholder="${person.country}"></th>
                <th class="tg-mbw0"><input type="submit" id="id20"/></th>
            </tr>

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
                            <td class="tg-jnuu"><img src="data:image/jpeg;base64,${personImages.get(loop.index)}"/></td>
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