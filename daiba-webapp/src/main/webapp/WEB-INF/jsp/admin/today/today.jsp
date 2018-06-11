<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>今日数据</title>
    <%@include file="../include/common.jsp" %>
</head>
<body class="overflow-hidden">
<div class="wrapper preload">
    <%@include file="../include/head.jsp"%>
    <%@include file="../include/menu.jsp"%>

    <div class="main-container">
        <div class="padding-md">

            <div class="sidebar-fix-bottom clearfix">
                <div class="pull-left font-16">
                    <i class="fa fa-home fa-lg"></i>
                    <a href="<%=basePath%>Admin/home">&nbsp; 首页</a>
                    <%--<i class="fa fa-angle-right"></i>--%>
                    <%--<a href="<%=basePath%>Admin/firm">今日数据</a>--%>
                    <i class="fa fa-angle-right"></i>
                    <a href="#">今日数据</a>
                </div>
                <span class="pull-right font-18" id="nowTime"></span>
            </div>
            <div class="container-fluid margin-md">
                <a href="#">日期:<spam>2018:06:01</spam></a><br>
                <%--<a href="#">--%>

                        <%--<c:if test="${briTel!=null}">--%>
                            <%--带客:<spam> ${briTel}</spam>--%>
                        <%--</c:if>--%>
                <%--</a><br>--%>
                <table id="base-info" class="table table-responsive table-hover table-bordered">
                    <thead>
                        <tr>
                            <th colspan="2">今日基本数据</th>
                        </tr>
                    </thead>
                    <tbody style="background-color: transparent;">
                        <tr>
                            <td width="20%">今日新用户数</td>
                            <td>${todayData.reguser}</td>
                        </tr>
                        <tr>
                            <td>今日登录用户数</td>
                            <td>${todayData.login}</td>
                        </tr>
                        <tr>
                            <td>今日发单数</td>
                            <td>${todayData.give}</td>
                        </tr>
                        <tr>
                            <td>今日退单数</td>
                            <td>${todayData.back}</td>
                        </tr>
                        <tr>
                            <td>今日总订单数</td>
                            <td>${todayData.firmsum}</td>
                        </tr>
                        <tr>
                            <td>今日带客总收入（单位：元）</td>
                            <td>${todayData.income*0.01}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
</body>
</html>
<script type="text/javascript" src="<c:url value="/admin/pulgins/DataTables-1.10.11/media/js/jquery.dataTables.js"/>"></script>
<script>
    $(function (){
        $.ajax({
            "url": basePath + "Admin/todayData.do",
            "dataType": 'json',
            "type": "POST",
            "success": function (result) {
                result.data = result.resultList;
                fnCallback(result);
            },
            "error": function () {
            }
        });
    });
</script>