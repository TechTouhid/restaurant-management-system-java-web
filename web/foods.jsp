
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="navbar.jsp"%>
<div class="modal-content center">
    <div class="row container">
        <div class="section white-text" style="background: #B35458;">

        <div class="section">
            <h3>Order Foods</h3>
        </div>
            </br></br></br>
        <div class="section center" style="padding: 20px;">
                <table class="centered responsive-table">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Price</th>
                        <th>Order now</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach var="menu" items="${listMenu}">

                        <tr>
                            <td><c:out value="${menu.id}" /></td>
                            <td><c:out value="${menu.name}" /></td>
                            <td><c:out value="${menu.category}" /></td>
                            <td><c:out value="${menu.price}" /></td>
                            <td><a href="addorder?id=<c:out value='${menu.id}' />&username=<c:out value='${user.fullname}' />&email=<c:out value='${user.email}' />&foodName=<c:out value='${menu.name}' />&category=<c:out value='${menu.category}' />&price=<c:out value='${menu.price}' /> ">Order</a></td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
        </div>
    </div>
    </div>
</div>
<%@include file="footer.jsp"%>