<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test = "${sessionScope.error !=null}">
    <div class="alert alert-danger">
        <strong>Mensaje! </strong><c:out value = "${sessionScope.error}"/>
    </div>
</c:if> 

<c:if test = "${sessionScope.success !=null}">
    <div class="alert alert-success">
        <strong>Mensaje! </strong><c:out value = "${sessionScope.success}"/>
    </div>
</c:if>

<c:remove var="success" scope="session"/> 
<c:remove var="error" scope="session"/> 