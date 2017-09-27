<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ include file="navbar.html" %>

<html>
<link href="//cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.2/jquery-ui.css" rel="stylesheet"/>

<link href="//cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.2/jquery-ui.css" rel="stylesheet"/>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Person Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc; cellpadding:10;
            cellspacing:10;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333; cellpadding:10;
            cellspacing:10;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0; cellpadding:10;
            cellspacing:10;}
        .tg .tg-4eph{background-color:#f9f9f9}

        a.button {
            background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 10px 15px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 15px;
            margin: 10px 15px 10px 8px;
        }
        a.btn{
            background-color: #f44336;
            border: none;
            color: white;
            padding: 10px 15px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 15px;
            margin: 10px 15px 10px 8px;
        }
        .table {
            border: 1px;

        }
        .th{ width:10%;
        }
        .value{
            margin: 10px 15px 10px 8px;
        }


        /* Set black background color, white text and some padding */
        footer {
            background-color: #555;
            color: white;
            padding: 15px;
        }

        /* On small screens, set height to 'auto' for sidenav and grid */
        @media screen and (max-width: 767px) {
            .sidenav {
                height: auto;
                padding: 15px;
            }

            .row.content {
                height: auto;
            }
        }

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

</head>

<body>
<script type="text/javascript" src="http://twitter.github.io/bootstrap/assets/js/bootstrap-transition.js"></script>
<script type="text/javascript" src="http://twitter.github.io/bootstrap/assets/js/bootstrap-collapse.js"></script>

<h1>
    Add a Person
</h1>



<c:url var="addAction" value="/person/add" ></c:url>

<%--@elvariable id="persn" type="com.crud.awsdemo.spring.model.Person"--%>
<form:form action="${addAction}" modelAttribute="persn">
    <form:errors path="*" cssClass="errorblock" element="div"></form:errors>
    <table>
        <form id="addForm" method = "post" action = "/person/person/add" >
            <table class="tg">
                <tr>
                    <butt class="tg-mkpy">Add A person:</butt>
                    <butt class="tg-mbw0"><input type="text" name = "name" id="id5"  /></butt>
                    <butt class="tg-mbw0"><input type="text" name = "country" id="id6" /></butt>
                    <butt class="tg-mbw0"><input type="submit" id="id3" /></butt>
                </tr>
            </table>
        </form>
        <tr>
            <td colspan="2">
            </td>
        </tr>
    </table>
</form:form>
<br>


<c:url var="remAction" value="/person/remove/{id}" ></c:url>
<c:url var="editAction" value="/person/edit/{id}" ></c:url>
<c:url var="imagAction" value="/imag/upload/{id}" ></c:url>
<h3>Persons List</h3>
<%--@elvariable id="person" type="com.crud.awsdemo.spring.model.Person"--%>

<c:if test="${!empty listPersons}">
    <table class="tg" >
        <tr>
            <th width="80">ID</th>
            <th width="120">Person Name</th>
            <th width="120">RANDOM FUCKING TEXT</th>
            <th width="340">Action</th>
        </tr>
        <c:forEach items="${listPersons}" var="person">
            <tr>
                <td>${person.id}</td>
                <td>${person.name}</td>
                <td>${person.country}</td>
                <td><a href="<c:url value='/person/edit/${person.id}' />"  class="button">Edit</a>
                    <a href="<c:url value='/person/remove/${person.id}' />"  class="btn" id="removeButton">Delete</a>
                    <a href="<c:url value='/imag/upload/${person.id}' />"  class="button">Upload Pic</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>


</body>
</html>