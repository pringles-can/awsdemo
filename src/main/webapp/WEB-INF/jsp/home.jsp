<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
    </style>

    <table class="tg">
        <tr>
            <th class="tg-au1h" colspan="7">Person</th>
        </tr>

        <tr>
            <td class="tg-5919">ID</td>
            <td class="tg-5919">Name</td>
            <td class="tg-5919">Country</td>
        </tr>

        <c:forEach items="${person.content}" var="person">
            <tr>
                <td class="tg-d7nh">${person.id}</td>
                <td class="tg-d7nh">${person.name}</td>
                <td class="tg-jnuu">${person.country}</td>


            </tr>
        </c:forEach>

    </table>


    <c:forEach var="i" begin="1" end="${person.totalPages}">
        <div style="display: inline-block;"><a href="F="><c:out value="${i}"/></a></div>
    </c:forEach>
    </p>

</table>
</html>
