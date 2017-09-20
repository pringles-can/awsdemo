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

    <title>Imag</title>

    <!-- Bootstrap core CSS -->

    <!-- Custom styles for this template -->
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
<c:url var="uploadAction" value="/imag/upload/${prsn_id}" ></c:url>

<table>
    <form:errors path="*" cssClass="errorblock" element="div">

    </form:errors>

    <style type="text/css">

    </style>

    <%--@elvariable id="imag" type="com.crud.awsdemo.spring.model.Imag"--%>
    <form:form action="${uploadAction}" commandName="imag">
        <table>
            <form method="post" action="/imag/upload/${prsn_id}">
                <table class="tg">
                    <tr>
                        <th class="tg-mbw0">Upload an image, or don't:<input type="file" name="image" id="idImg"></th>
                        <th class="tg-mbw0"><input type="submit" id="id210"/></th>
                    </tr>
                </table>
            </form>
        </table>

    </form:form>



</table>


</html>