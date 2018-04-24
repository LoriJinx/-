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
                        <h1 class="col-md-5">学生综合信息</h1>
                        <select style="position: absolute; top: 55px; right: 30px" onchange="window.location=this.value">
                            <c:forEach items="${classes}" var="cls">
                                <option value="/teacher/showActivityInfo/${cls.clsId}"
                                        <c:if test="${cls.clsId == selected}">selected="selected"</c:if>
                                >${cls.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>姓名</th>
                        <th>活动信息</th>
                        <th>时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${activityInfos}" var="item">
                        <tr>
                            <td>${item.uName}</td>
                            <td>${item.description}</td>
                            <td>
                                <fmt:formatDate
                                        value="${item.createTime}"
                                        type="date"
                                        dateStyle="medium"/>
                            </td>
                            <td>
                                <button class="btn btn-default btn-xs btn-danger btn-primary" onClick="del(${item.aiId})">删除</button>
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
<script type="text/javascript">
    del = function(aiId) {
        $.ajax({
            url: '/teacher/activityInfo?aiId=' + aiId,
            type: 'DELETE',
            success: function (result) {
                if (result === 'success'){
                    location.reload()
                }else {
                    alert('删除失败！')
                }
            },
            error:function (result) {
                alert('删除失败！')
            }
        });
    }
</script>
</html>