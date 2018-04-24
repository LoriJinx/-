<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>课程信息显示</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入bootstrap -->
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <!-- 引入JQuery  bootstrap.js-->
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>

    <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>

</head>
<body>
<!-- 顶栏 -->
<jsp:include page="top.jsp"></jsp:include>
<!-- 中间主体 -->
<div class="container" id="content">
    <div class="row">
        <jsp:include page="menu.jsp"></jsp:include>
        <div class="col-md-10">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <h1 class="col-md-5">导师信息</h1>
                    </div>
                </div>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>职称</th>
                        <th>年龄</th>
                        <th>联系方式</th>
                        <th>地址</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${teacher.name}</td>
                        <c:if test="${teacher.sex == 0}">
                            <td>女</td>
                        </c:if>
                        <c:if test="${teacher.sex == 1}">
                            <td>男</td>
                        </c:if>
                        <td>${teacher.title}</td>
                        <td>${age}</td>
                        <td>${teacher.phone}</td>
                        <td>${teacher.area}</td>
                    </tr>
                    </tbody>
                </table>
                <div class="panel-heading">
                    <div class="row">
                        <h1 class="col-md-5">负责班级</h1>
                    </div>
                </div>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>班号</th>
                        <th>班长</th>
                        <th>副班长</th>
                        <th>专业</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${classes}" var="item">
                        <tr>
                            <td>${item.clsId}</td>
                            <td>${item.monitorName}</td>
                            <td>${item.deMonitorName.get(0)}, ${item.deMonitorName.get(1)}</td>
                            <td>${item.majorName}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="panel-heading">
                    <div class="row">
                        <h1 class="col-md-5">工作记录</h1>
                    </div>
                </div>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>时间</th>
                        <th>详情</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${workRecords}" var="workRecord">
                        <tr>
                            <td><fmt:formatDate
                                    value="${workRecord.createTime}"
                                    type="date"
                                    dateStyle="medium"/>
                            </td>
                            <td>${workRecord.description}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<div class="container" id="footer">
    <div class="row">
        <div class="col-md-12"></div>
    </div>
</div>
</body>
<script type="text/javascript">

    function confirmd() {
        var msg = "您真的确定要删除吗？！";
        if (confirm(msg) == true) {
            return true;
        } else {
            return false;
        }
    }

    $("#sub").click(function () {
        $("#form1").submit();
    });
</script>
</html>