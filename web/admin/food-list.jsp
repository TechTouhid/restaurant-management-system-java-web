
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="layout/header.jsp"%>
<%@include file="layout/left-sidebar-long.jsp"%>
<%@include file="layout/topnav.jsp"%>
<%@include file="layout/left-sidebar-short.jsp"%>
<%--<jsp:useBean id="menu" class="model.Menu" scope="session"/>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="section white-text" style="background: #B35458;">

	<div class="section">
		<h3>Foods</h3>
	</div>

	<div class="section right" style="padding: 15px 25px;">
		<a href="admin/food-add.jsp" class="waves-effect waves-light btn">Add New</a>
	</div>
	
	<div class="section center" style="padding: 20px;">
		<table class="centered responsive-table">
        <thead>
          <tr>
              <th>Name</th>
              <th>Description</th>
              <th>Category</th>
              <th>Delete</th>
              <th>Edit</th>
          </tr>
        </thead>

        <tbody>
          <c:forEach var="menu" items="${listMenu}">

              <tr>
                  <td><c:out value="${menu.name}" /></td>
                  <td><c:out value="${menu.price}" /></td>
                  <td><c:out value="${menu.category}" /></td>
                  <td><a href="edit?id=<c:out value='${menu.id}' />">Edit</a>
                      &nbsp;&nbsp;&nbsp;&nbsp; <a
                              href="delete?id=<c:out value='${menu.id}' />">Delete</a></td>
              </tr>
          </c:forEach>
         
        </tbody>
      </table>
	</div>
</div>


<%@include file="layout/footer.jsp"%>