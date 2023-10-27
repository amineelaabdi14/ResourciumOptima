<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="./components/head.jsp" %>
<html lang="en">
<body id="loginContent">
<div class="">
    <div id="elements-container"
         class="d-flex flex-column-reverse flex-lg-row align-items-center justify-content-lg-around w-100 mt-5">

        <div id="first-container">
            <img src="assets/images/landing.png" id="landing-logo" alt="Freelancer.ma" class="mt-4">
        </div>

        <div id="LoginformContainer" class=" mt-5 mt-lg-0">
            <form id="auth-form" action="${pageContext.request.contextPath}/login" class="form d-flex flex-column mt-5"
                  method="POST">

                <div id="emailFormContainer">
                    <label for="email" class="MyLabels">EMAIL</label><br>
                    <input id="email" type="email" name="email" oninput="validateEmail()" class="MyInputs"
                           autocomplete="off">
                    <div id="emailError" class="text-danger"></div>
                </div>

                <div class="mb-3">
                    <label for="password" class="MyLabels">PASSWORD</label><br>
                    <input id="password" type="password" name="password" class="MyInputs">
                    <div id="comfirEmailError" class="text-danger mb-0 "></div>
                </div>
                <div id="fullName"></div>
                <div class="d-flex justify-content-between align-items-center mt-3" style="">
                    <span><a href="#" onclick="createAccount()">Create an account</a></span>
                    <button id="login-btn" type="submit" name="signMeIn">Sign In</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
