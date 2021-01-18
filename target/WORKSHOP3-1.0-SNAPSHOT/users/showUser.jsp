<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/users/header.jsp" %>

<div class="container-fluid">
    <div class="row">
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Information about user</h6>
        </div>
        <div class="card-body">
            Id:   ${user.userId}<br>
            Username: ${user.username}<br>
            Email:   ${user.email}<br>
            Password:   ${user.password}<br>
        </div>
    </div>
        <div>
        </div>
    </div>
</div>

<%@ include file="/users/footer.jsp" %>
