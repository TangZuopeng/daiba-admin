<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>带吧网络后台管理</title>
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
                    <a href="<%=basePath%>Admin/user">用户</a>
                    <i class="fa fa-angle-right"></i>
                    <a href="#">用户详情</a>
                </div>
                <span class="pull-right font-18" id="nowTime"></span>
            </div>
            <div class="container-fluid margin-md">
                <table id="base-info" class="table table-responsive table-hover table-bordered">
                    <thead>
                        <tr>
                            <th colspan="2">基本信息</th>
                        </tr>
                    </thead>
                    <tbody style="background-color: transparent;">
                        <tr>
                            <td width="20%">手机号:</td>
                            <td>${user.phoneNum}</td>
                        </tr>
                        <tr>
                            <td>昵称:</td>
                            <td>${user.name}</td>
                        </tr>
                        <tr>
                            <td>性别:</td>
                            <td>${user.sex}</td>
                        </tr>
                        <tr>
                            <td>注册时间:</td>
                            <td id="registerTime">
                                <script>
                                    var d=new Date();
                                    d.setTime("${user.registerTime.time}");
                                    var registerTime=format(d,"yyyy-MM-dd    hh:mm:ss");
                                    $("#registerTime").text(registerTime);
                                </script>
                            </td>
                        </tr>
                        <tr>
                            <td>最近登录时间:</td>
                            <td id="recetlyLoginTime">
                                <script>
                                    var d=new Date();
                                    d.setTime("${user.recetlyLoginTime.time}");
                                    var recetlyLoginTime=format(d,"yyyy-MM-dd    hh:mm:ss");
                                    $("#recetlyLoginTime").text(recetlyLoginTime);
                                </script>
                            </td>
                        </tr>
                        <tr>
                            <td>发单数:</td>
                            <td>${user.orderNum}</td>
                        </tr>
                        <tr>
                            <td>支出:</td>
                            <td>${user.spending*0.01}</td>
                        </tr>
                    </tbody>
                </table>

                <c:if test="${qualification!=null}">
                    <table id="bringer-info" class="table table-responsive table-hover table-bordered">
                        <thead>
                        <tr>
                            <th colspan="2">认证信息</th>
                        </tr>
                        </thead>
                        <tbody style="background-color: transparent;">
                        <tr>
                            <td>真实姓名:</td>
                            <td>${qualification.realName}</td>
                        </tr>
                        <tr>
                            <td>学号:</td>
                            <td>${qualification.studentNum}</td>
                        </tr>
                        </tbody>
                    </table>
                </c:if>

                <input type="text" hidden="hidden" id="firmId" value="${firm.firmId}">
            </div>
        </div>

        <button type="submit" class="btn btn-success marginTB-xs">Success</button>
        <button type="button" class="btn btn-default" id="deleteFirmBtn">删除用户</button>

    </div>

</div>
</body>
</html>
<script type="text/javascript" src="<c:url value="/admin/pulgins/DataTables-1.10.11/media/js/jquery.dataTables.js"/>"></script>
<script>
    $(function (){
        //取消订单触发的事件
        $("#cancelFirmBtn").click(function () {
            alert(1);
        });

        //删除订单触发的事件
        $("#deleteFirmBtn").click(function(){
            alert(2);
        });
    });
</script>