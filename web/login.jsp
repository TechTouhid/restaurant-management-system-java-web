
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="navbar.jsp"%>
<section class="loginmodal">

        <div class="modal-content center">
            </br></br></br>
            <div class="row container">
            <h4>Welcome Sir!</h4>

            <h5><small class="center" id="login_error" style="color: red;"></small></h5>
            <form action="login" method="post" name="loginForm" onsubmit="return validateForm()">

                <div class="row">

                    <div class="input-field col-sm-12 ">
                        <input name="email" id="email" type="email" class="validate">
                        <label for="email">Email</label>
                    </div>
                </div>

            <div class="row">
                    <div class="input-field col-sm-12 ">
                        <input name="password" id="password" type="password" class="validate">
                        <label for="password">Password</label>
                    </div>

                </div>
<%--                <a href="javascript:void(0)" class="modal-close waves-effect waves-light btn" id="login_btn" style="background: #ee6e73 !important;">Login</a>--%>
                <button class="modal-close waves-effect waves-light btn" id="login_btn" style="background: #ee6e73 !important; width: 100px">Login</button>
                 <a href="/AdminIndex.jsp" class="modal-close waves-effect waves-light btn" id="login_btn" style="background: #ee6e73 !important;">Admin Login</a>

            </form>
            </div>
            </br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br></br>
        </div>
    <script type="text/javascript">
        function validateForm() {
            var email=document.loginForm.email.value;
            var password=document.loginForm.password.value;
            if (email==null || email==""){
                alert("Please enter email");
                return false;
            }else if(password == null || password==""){
                alert("Please enter password");
                return false;
            }
        }
    </script>
</section>
<%@include file="footer.jsp"%>
