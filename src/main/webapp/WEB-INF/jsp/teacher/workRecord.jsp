<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title></title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入bootstrap -->
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <!-- 引入JQuery  bootstrap.js-->
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
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
                        <h1>工作记录</h1>
                    </div>
                </div>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>记录详情</th>
                        <th>时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${workRecords}" var="wr">
                        <tr>
                            <td>${wr.description}</td>
                            <td>
                                <fmt:formatDate
                                        value="${wr.createTime}"
                                        type="date"
                                        dateStyle="medium"/>
                            </td>
                            <td>
                                <button class="btn btn-default btn-xs btn-danger btn-primary" onClick="del(${wr.wrId})">删除</button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="container" id="footer">
        <div class="row">
            <div class="col-md-12"></div>
        </div>
    </div>
</div>
</body>
<script>
    del = function (wrId) {
        $.ajax({
            url: '/teacher/workRecord?wrId=' + wrId,
            type: 'DELETE',
            success: function (result) {
                if (result === 'success') {
                    location.reload()
                } else {
                    alert('删除失败！')
                }
            },
            error: function (result) {
                alert('删除失败！')
            }
        });
    }
</script>
</html>