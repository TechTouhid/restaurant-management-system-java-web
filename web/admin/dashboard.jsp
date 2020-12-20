<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="layout/header.jsp"%>
<%@include file="layout/left-sidebar-long.jsp"%>
<%@include file="layout/topnav.jsp"%>
<%@include file="layout/left-sidebar-short.jsp"%>

<div class="section white-text center" style="background: #B35458; margin-top: 20px;">

	<h4>Dashboard</h4>
	
	<div class="row" style="padding: 50px;">
		<div class="col s12">

			<a class="dash-btn" href="/listmenu"><div class="sec white white-text" style="margin: 15px; padding: 40px;border: 2px solid white; border-radius: 20px; font-size: 20px; background: linear-gradient(to right, #AF6568, #FA797F);">Foods</div></a>
			<a class="dash-btn" href="category-list.jsp"><div class="sec white white-text" style="margin: 15px; padding: 40px;border: 2px solid white; border-radius: 20px; font-size: 20px; background: linear-gradient(to right, #AF6568, #FA797F);">Categories</div></a>
			<a class="dash-btn" href="order-list.jsp"><div class="sec white white-text" style="margin: 15px; padding: 40px;border: 2px solid white; border-radius: 20px; font-size: 20px; background: linear-gradient(to right, #AF6568, #FA797F);">Orders</div></a>

		</div>

	</div>

</div>
<%@include file="layout/footer.jsp"%>