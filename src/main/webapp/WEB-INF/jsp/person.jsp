<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
            cellpadding: 10;
            cellspacing: 10;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            cellpadding: 10;
            cellspacing: 10;
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
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
            cellpadding: 10;
            cellspacing: 10;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }

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

        a.btn {
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

        .th {
            width: 10%;
        }

        .value {
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

        .error {
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


    <form:errors path="*" cssClass="errorblock" element="div"></form:errors>
    <table>
        <form id="addForm" method="post" action="/person/add">
            <table class="tg">
                <tr>
                    <butt class="tg-mkpy">Add A person:</butt>
                    <butt class="tg-mbw0"><input type="text" name="name" id="id5"/></butt>
                    <td><form:errors path="addPerson.name" cssClass="error"> </form:errors> </td>
                    <butt class="tg-mbw0"><input type="text" name="country" id="id6"/></butt>
                    <butt class="tg-mbw0"><input type="submit" id="id3"/></butt>
                </tr>
            </table>
        </form>
        <tr>
            <td colspan="2">
            </td>
        </tr>
    </table>
<br>


    <%--<table>
        <form method="post" action="/person/add">
            <form:errors path="*" cssClass="errorblock" element="div"></form:errors>
            <table class="tg">
                <tr>
                    <th class="tg-mbw0">New Name:</th><td><form:input path="name" /></td>
                    <td><form:errors path="name" cssClass="error"> </form:errors> </td>
                    <td class="tg-mbw0"></td>
                    <th class="tg-mbw0"> New fucking whatever:<input type="text" name="country" id="id19"></th>
                    <td colspan="4">
                    <th class="tg-mbw0"><input type="submit" id="id20"/></th>
                    </td>
                </tr>

                <img src="" alt=""/>
            </table>

        </form>
    </table>--%>
<br>

</body>
</html>