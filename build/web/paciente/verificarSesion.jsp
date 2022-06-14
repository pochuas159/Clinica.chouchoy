<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sessionScope.usuario == null}">
    <c:redirect url = "../401.jsp"/>
</c:if>

 <c:if test="${sessionScope.usuario.tipoUsu !='PACIENTE'}">
    <c:redirect url = "../403.jsp"/>
</c:if>