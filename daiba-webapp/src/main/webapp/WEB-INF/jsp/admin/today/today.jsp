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
                    <i class="fa fa-angle-right"></i>
                    <a href="#">今日数据</a>
                </div>
                <span class="pull-right font-18" id="nowTime"></span>
            </div>
            <div class="container-fluid margin-md">
                <table id="base-info" class="table table-responsive table-hover table-bordered">
                    <thead>
                        <tr>
                            <th colspan="2">今日基本数据</th>
                        </tr>
                    </thead>
                    <tbody style="background-color: transparent;">
                        <tr>
                            <td width="20%">今日新用户数</td>
                            <td id="reguser"></td>
                        </tr>
                        <tr>
                            <td>今日登录用户数</td>
                            <td id="login"></td>
                        </tr>
                        <tr>
                            <td>今日发单数</td>
                            <td id="give"></td>
                        </tr>
                        <tr>
                            <td>今日退单数</td>
                            <td id="back"></td>
                        </tr>
                        <tr>
                            <td>今日总订单数</td>
                            <td id="firmsum"></td>
                        </tr>
                        <tr>
                            <td>今日带客总收入（单位：元）</td>
                            <td id="income"></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
</body>
</html>
<script>
    $(function (){
        $.ajax({
            "url": basePath + "/Admin/todayData.do",
            "dataType": 'json',
            "type": "POST",
            "success": function (result) {
                $("#reguser").text(result.reguser);//今日新用户数
                $("#login").text(result.login);//今日登录用户数
                $("#give").text(result.give);//今日发单数
                $("#back").text(result.back);//今日退单数
                $("#firmsum").text(result.firmsum); //今日总订单数
                $("#income").text(result.income/100); //今日带客总收入
            },
            "error": function () {
                alert("数据请求失败")
            }
        });
    });
</script>