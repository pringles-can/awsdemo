<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ include file="navbar.html" %>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">


<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Person</title>

</head>
<style type="text/css">
    .tg {
        border-collapse: collapse;
        border-spacing: 0;
        border-color: #aabcfe;
    }

    .tg td {
        font-family: Arial, sans-serif;
        font-size: 14px;
        padding: 10px 5px;
        border-style: solid;
        border-width: 1px;
        overflow: hidden;
        word-break: normal;
        border-color: #aabcfe;
        color: #669;
        background-color: #e8edff;
    }

    .tg th {
        font-family: Arial, sans-serif;
        font-size: 14px;
        font-weight: normal;
        padding: 10px 5px;
        border-style: solid;
        border-width: 1px;
        overflow: hidden;
        word-break: normal;
        border-color: #aabcfe;
        color: #039;
        background-color: #b9c9fe;
    }

    .tg .tg-mbw0 {
        font-size: 14px;
        font-family: "Trebuchet MS", Helvetica, sans-serif !important;;
        background-color: #cbf6c8;
        color: #a1e09d;
        vertical-align: top
    }

    .tg .tg-2l3u {
        background-color: #cbf6c8;
        color: #a1e09d;
        vertical-align: top
    }

    .tg .tg-mkpy {
        font-size: 16px;
        font-family: "Trebuchet MS", Helvetica, sans-serif !important;;
        background-color: #cbf6c8;
        color: #32cb00;
        vertical-align: top
    }


</style>


<div class="container-fluid text-center">
    <div class="row content">
        <div class="container">
            <h2>Person</h2>
            <p>Some people might be listed below</p>
            <table class="table table-bordered">
                <c:if test="${!empty listPersons}">
                    <tr style="border-color:#ccc;color:#333;">
                        <td class="tg-5919">ID</td>
                        <td class="tg-5919">Name</td>
                        <td class="tg-5919">RANDOM FUCKING TEXT</td>
                    </tr>
                    <c:forEach items="${person.content}" var="person">
                        <tr>
                            <td class="tg-d7nh">
                                <a href="<c:url value='/person/edit/${person.id}' /> "  class="button">${person.id}</a>
                            </td>
                            <td class="tg-d7nh">
                                <a href="<c:url value='/person/edit/${person.id}' />"  class="button">${person.name}</a>
                            </td>
                            <td class="tg-jnuu">
                                <a href="<c:url value='/person/edit/${person.id}' />"  class="button">${person.country}</a>
                            </td>

                        </tr>
                    </c:forEach>
                </c:if>
            </table>
        </div>


        <ul class="pagination">
            <c:forEach var="i" begin="1" end="${person.totalPages}">
                <li><a href="/?page=${i-1}"><c:out value="${i}"/></a></li>
            </c:forEach>
        </ul>
        <br/>
    </div>
</div>



</html>
