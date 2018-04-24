<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>导师管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入bootstrap -->
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <!-- 引入JQuery  bootstrap.js-->
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <style type="text/css">
        body {
            text-align: center;
            background: url(images/a.jpg) repeat;
        }

        #login-box {
            /*border:1px solid #F00;*/
            padding: 35px;
            border-radius: 15px;
            background: #56666B;
            color: #fff;
        }

        #name {
            margin-top: 80px;
            color: #ffffff;

        }

    </style>
</head>
<body>
<h1 id="name">导师管理系统</h1>
<div class="container" id="top">
    <div class="row" style="margin-top: 180px; ">
        <div class="col-md-4"></div>
        <div class="col-md-4" id="login-box">
            <form class="form-horizontal" id="from1">
                <div class="form-group">
                    <label for="firstname" class="col-sm-3 control-label">账号</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="userID" placeholder="请输入名字" name="account">
                    </div>
                </div>
                <div class="form-group">
                    <label for="lastname" class="col-sm-3 control-label">密码</label>
                    <div class="col-sm-9">
                        <input type="password" class="form-control" id="password" placeholder="请输入密码" name="password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="checkbox">
                            <label class="checkbox-inline">
                                <input type="radio" name="role" value="1" checked>管理员
                            </label>
                            <label class="checkbox-inline">
                                <input type="radio" name="role" value="2">老师
                            </label>
                            <label class="checkbox-inline">
                                <input type="radio" name="role" value="3">学生
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group pull-right" style="margin-right: 15px;">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button class="btn btn-default btn-info" id="loginButton">登录</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $('#from1').submit(function () {
            jQuery.ajax({
                url: '/login',
                data: $(this).serialize(),
                type: "POST",
                success: function (result) {
                    if (result[0] === '/') {
                        location.href = result
                    } else {
                        alert(result.message)
                    }
                }
            });
            return false;
        });
    });
</script>
</html>