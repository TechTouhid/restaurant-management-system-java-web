<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="layout/header.jsp"%>
<%@include file="layout/left-sidebar-long.jsp"%>
<%@include file="layout/topnav.jsp"%>
<%@include file="layout/left-sidebar-short.jsp"%>

<%--<jsp:useBean id="menu" class="model.Menu" scope="session"/>--%>

<div class="section white-text" style="background: #B35458;">

	<div class="section">
		<h3>Add Food Item</h3>
	</div>


    <div class="section center" style="padding: 40px;">

        <form action="/addmenu" method="post">
            <div class="row">
                <div class="col s6" style="">
                            <div class="input-field">
                            <input id="name" name="name" type="text" class="validate" style="color: white; width: 70%">
                            <label for="name" style="color: white;"><b>Food Name :</b></label>
                            </div>
                </div>
                <div class="col s6" style="">
                            <div class="input-field" style="color: white !important; width: 90%">
						    <select name="category">
                                <option value="Main">Main</option>
                                <option value="Drinks">Drinks</option>
                                <option value="Alcohols">Alcohols</option>
                                <option value="Desert">Desert</option>
						    </select>
						    <label style="color: white;">Categories</label>
						  </div>
                </div>
            </div>

            <div class="row">
                <div class="col s12">

                    <div class="input-field">
                        <input id="price" name="price" type="text" class="validate" style="color: white; width: 85%">
                        <label style="color: white;"><b>Price :</b></label>
                    </div>

                </div>

            </div>
            <div class="row">
                <div class="col s12">
                    <div class="section right" style="padding: 15px 10px;">
                        <a href="/listmenu" class="waves-effect waves-light btn">Dismiss</a>
                    </div>
                    <div class="section right" style="padding: 15px 20px;">
                        <button type="submit" class="waves-effect waves-light btn">Add New</button>
                    </div>
                </div>
            </div>

        </form>


    </div>

</div>

<%@include file="layout/footer.jsp"%>