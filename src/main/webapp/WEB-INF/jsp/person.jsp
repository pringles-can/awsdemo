<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
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

    </style>
</head>
<body>
<h1>
    Add a Person
</h1>

<c:url var="addAction" value="/person/add" ></c:url>

<%--@elvariable id="person" type="com.crud.awsdemo.spring.model.Person"--%>
<form:form action="${addAction}" commandName="person">
    <table>

        <form id="theform" method = "post" action = "/person/person/add" >
            <table class="tg">
                <tr>
                    <th class="tg-mkpy">Add A person:</th>

                    <th class="tg-mbw0"><input type="text" name = "name" id="id5" /></th>
                    <th class="tg-mbw0"><input type="text" name = "country" id="id6" /></th>
                    <th class="tg-mbw0"><input type="submit" id="id3" /></th>
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

<h3>Persons List</h3>
<c:if test="${!empty listPersons}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Person Name</th>
            <th width="120">RANDOM FUCKING TEXT</th>
            <th width="60">Action</th>

        </tr>
        <c:forEach items="${listPersons}" var="person">
            <tr>
                <td>${person.id}</td>
                <td>${person.name}</td>
                <td>${person.country}</td>
                <td><a href="<c:url value='/edit/${person.id}' />"  class="button">Edit</a>
                    <a href="<c:url value='/remove/${person.id}' />"  class="btn">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>