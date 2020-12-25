<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="fdes">
    <div class="section white center">
        <h2 class="header" style="padding:20px; padding-bottom: 30px;">Restaurant Management System By Touhid</h2>
        <div class="row container center">
            <div class="col center l8 s12">
                <p>This Restaurant offers the most variety of food choices you can find anywhere in Dhaka. More than 130 items across cuisines from Continental, Indian, Chinese, Mediterranean, Japanese and Local you will find options to satisfy all your moods and all your tastes. Elements is equipped with 3 live kitchens for you to experience the amazing art of cooking by our globally acclaimed chefs. The restaurant also offers one of the biggest all day dining in a five star facility in the city, catering to more than 144 guests at a time. We also have fast delivery to satisfy our customers</p>

                </br></br>
                <%
                    if(session.getAttribute("user") != null) {
                        out.print("<a href=\"/foodlist\" class=\"modal-close waves-effect waves-light btn\" id=\"login_btn\" style=\"background: #ee6e73 !important;\">Order Now</a>");
                    }
                %>                </br></br></br>
            </div>
        </div>
</section>