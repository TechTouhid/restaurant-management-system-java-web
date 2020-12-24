
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="layout/header.jsp"%>
<%@include file="layout/left-sidebar-long.jsp"%>
<%@include file="layout/topnav.jsp"%>
<%@include file="layout/left-sidebar-short.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="section white-text" style="background: #B35458;">

    <div class="section">
        <h3>Order</h3>
    </div>
    <div class="section center" style="padding: 20px;">
        <table class="centered responsive-table">
            <thead>
            <tr>
                <th>Order ID</th>
                <th>Food name</th>
                <th>Price</th>
                <th>Category</th>
                <th>User Email</th>
                <th>isApprove</th>
                <th>Approve</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="food" items="${listOrder}">

                <tr>
                    <td><c:out value="${food.id}" /></td>
                    <td><c:out value="${food.foodName}" /></td>
                    <td><c:out value="${food.price}" /></td>
                    <td><c:out value="${food.category}" /></td>
                    <td><c:out value="${food.email}" /></td>
<%--                    <td><c:out value="${food.isApproved}" /></td>--%>
                    <td><c:choose>
                        <c:when test="${food.isApproved == 0}">
                            NO
                        </c:when>
                        <c:otherwise>
                            Yes
                        </c:otherwise>
                    </c:choose></td>
                    <td><a href="approveorder?id=<c:out value='${food.id}' />">Approve</a></td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</div>


<%@include file="layout/footer.jsp"%>