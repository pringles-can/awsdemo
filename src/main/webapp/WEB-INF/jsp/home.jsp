<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
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
    <link rel="icon" href="../../favicon.ico">

    <title>Person</title>

    <!-- Bootstrap core CSS -->
    <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="starter-template.css" rel="stylesheet">
</head>
<table>

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

        /* Remove the navbar's default margin-bottom and rounded borders */
        .navbar {
            margin-bottom: 0;
            border-radius: 0;
        }

        /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
        .row.content {
            height: auto
        }

        /* Set gray background color and 100% height */
        .sidenav {
            padding-top: 20px;
            background-color: #f1f1f1;
            height: 100%;
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


    </style>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Person</a>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="${pageContext.request.contextPath}/person">Add</a></li>
                    <li><a href="#">Remove</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Don't click this</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container-fluid text-center">
        <div class="row content">
            <div class="container">
                <h2>Person</h2>
                <p>Some people might be listed below</p>
                <table class="table table-bordered">
                    <c:if test="${!empty listPersons}">
                        <tr>
                            <td class="tg-5919">ID</td>
                            <td class="tg-5919">Name</td>
                            <td class="tg-5919">RANDOM FUCKING TEXT</td>
                        </tr>
                        <c:forEach items="${person.content}" var="person">
                            <tr>
                                <td class="tg-d7nh">${person.id}</td>
                                <td class="tg-d7nh">${person.name}</td>
                                <td class="tg-jnuu">${person.country}</td>

                            </tr>
                        </c:forEach>
                    </c:if>
                </table>
            </div>


            <ul class="pagination">
                <c:forEach var="i" begin="1" end="${person.totalPages}">
                    <li><a href="F="><c:out value="${i}"/></a></li>
                </c:forEach>
                </p>
            </ul>
            <br/>
        </div>
        </div>
</table>
</html>
