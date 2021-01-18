<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/users/header.jsp" %>
<div class="container-fluid">
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800"></h1>
        <a href="/user/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"> + NEW USER</a>
    </div>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h5 class="m-0 font-weight-bold text-primary">List of Users</h5>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="50%" cellspacing="0">
                    <tbody>
                    <thead>
                    <tr>
                        <th class="text-center">User ID</th>
                        <th class="text-center">Username</th>
                        <th class="text-center">Email</th>
                        <th class="text-center">Action</th>
                    </tr>
                    </thead>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td>${user.userId}</td>
                            <td>${user.username}</td>
                            <td>${user.email}</td>
                            <td class="text-center">
                                <div class="rounded-lg">
                                <a class="btn btn-google" href="/user/delete?id=${user.userId}"> DELETE </a>
                                <a class="btn btn-outline-warning " href="/user/edit?id=${user.userId}">UPDATE</a>
                                <a class="btn btn-primary" href="/user/show?id=${user.userId}">SHOW</a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<%@ include file="/users/footer.jsp" %>
