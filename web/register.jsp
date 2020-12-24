
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="navbar.jsp"%>

        <div class="modal-content center">
            </br></br></br>
            <div class="row container">
            <h4>Register Here!</h4>

            <h5><small class="center" id="reg_error" style="color: red;"></small></h5>
            <form action="adduser" method="post" name="registerForm" onsubmit="return validateForm()">

                <div class="row">

                    <div class="input-field col s12">
                        <input name="fullname" onkeypress="return isAlphaNumSpace(event);" id="name_reg" type="text" class="validate" required>
                        <label for="name_reg">Full Name</label>

                    </div>

                    <div class="input-field col s12">
                        <input name="email" onkeypress="return isEmail(event);" id="email_reg" type="email" class="validate" required>
                        <label for="email_reg">Email</label>
                    </div>

                </div>

                <div class="row">

                    <div class="input-field col s6">
                        <input name="password" id="password_reg" type="password" class="validate" required>
                        <label for="password_reg">Password</label>
                    </div>

                    <div class="input-field col s6">
                        <input id="con_password_reg" name="con_password" type="password" class="validate" required>
                        <label for="con_password_reg">Confirm Password</label>
                    </div>

                </div>

<%--                <a href="adduser" id="submit_reg" class="waves-effect waves-light btn" style="background: #ee6e73 !important;">Register</a>--%>
                <button  class="waves-effect waves-light btn" style="background: #ee6e73 !important; width: 100px" name="" type="submit">Register</button>

            </form>
            </div>
            </br></br></br></br></br></br></br></br></br>
        </div>
<script type="text/javascript">
    function validateForm() {
        var password=document.registerForm.password.value;
        var con_password=document.registerForm.con_password.value;
        if (password !== con_password) {
            alert("Password and Confirm Password Does not match!")
            return false;
        }
    }
</script>
<%@include file="footer.jsp"%>
