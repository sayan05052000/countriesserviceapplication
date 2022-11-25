<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add Country</title>
    </head>
    <body>
        <c:if test="${addCountrySuccess}">
            <div>Successfully added Country with id: ${savedCountry.id}</div>
        </c:if>
    
        <c:url var="add_country_url" value="/countries/addCountry"/>
        <form:form action="${add_book_url}" method="post" modelAttribute="book">
            <form:label path="id">ID: </form:label> <form:input type="text" path="id"/>
            <form:label path="countryName">Country Name: </form:label> <form:input type="text" path="countryName"/>
            <form:label path="primeMinister">Prime Minister Name: </form:label> <form:input path="primeMinister"/>
            <input type="submit" value="submit"/>
        </form:form>
    </body>
</html>