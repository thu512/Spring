<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>


    <div class="login-box">
        <div class="logo">
            <a href="/login.do"><img
                    src="/AdminBSBMaterialDesign-master/img/GS_SHOP_logo.png"
                    style="width: 250px; height: 90px; margin-top: -20px;"></a>
            <small>세상에 없는 모든것</small>
        </div>
        <div class="card">
            <div class="body">
                <form id="sign_id" class="form-signin" method="post" action="j_spring_security_check">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <div class="msg">GS SHOP에 오신걸 환영합니다.</div>
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">person</i>
                        </span>
                        <div class="form-line">
                            <input type="text" class="form-control" name="username" placeholder="Username" required autofocus/>
                        </div>
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">lock</i>
                        </span>
                        <div class="form-line">
                            <input type="password" class="form-control" name="password" placeholder="Password" required/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-8 p-t-5">
                            <input type="checkbox" id="rememberme" class="filled-in chk-col-pink" value="remember-me" name="_spring_security_remember_me"/>
                            <label for="_spring_security_remember_me">Remember Me</label>
                        </div>
                        <div class="col-xs-4">
                            <button class="btn btn-block bg-pink waves-effect" type="submit">로그인</button>
                        </div>
                    </div>
                    <div class="row m-t-15 m-b--20">
                        <div class="col-xs-6">
                            <a href="/AdminBSBMaterialDesign-master/pages/examples/sign-up.html">회원가입!</a>
                        </div>
                        <div class="col-xs-6 align-right">
                            <a href="/AdminBSBMaterialDesign-master/pages/examples/forgot-password.html">비밀번호 몰라?</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- Jquery Core Js -->
    <script src="/AdminBSBMaterialDesign-master/plugins/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core Js -->
    <script src="/AdminBSBMaterialDesign-master/plugins/bootstrap/js/bootstrap.js"></script>

    <!-- Waves Effect Plugin Js -->
    <script src="/AdminBSBMaterialDesign-master/plugins/node-waves/waves.js"></script>

    <!-- Validation Plugin Js -->
    <script src="/AdminBSBMaterialDesign-master/plugins/jquery-validation/jquery.validate.js"></script>

    <!-- Custom Js -->
    <script src="/AdminBSBMaterialDesign-master/js/admin.js"></script>
    <script src="/AdminBSBMaterialDesign-master/js/pages/examples/sign-in.js"></script>