<%--
  Created by IntelliJ IDEA.
  User: tao
  Date: 2016/12/10
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
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

                <table id="firm-info" class="table table-responsive table-hover table-bordered">
                    <thead>
                        <tr>
                            <th colspan="2">订单信息</th>
                        </tr>
                    </thead>
                    <tbody style="background-color: transparent;">
                        <tr>
                            <td width="20%">取件地址:</td>
                            <td>${firm.order.company}</td>
                        </tr>
                        <tr>
                            <td>送达地址:</td>
                            <td>${firm.address}</td>
                        </tr>
                        <tr>
                            <td>要求时间:</td>
                            <td id="askTime">
                                <c:choose>
                                    <c:when test="${null==firm.askTime||firm.askTime==''}">
                                        无
                                    </c:when>
                                    <c:otherwise>
                                        <script>
                                            var d=new Date();
                                            d.setTime("${firm.askTime.time}");
                                            var askTime=format(d,"yyyy-MM-dd    hh:mm:ss");
                                            $("#askTime").text(askTime);
                                        </script>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <tr>
                            <td>收货人:</td>
                            <td>${firm.order.receiver}</td>
                        </tr>
                        <tr>
                            <td>取件号:</td>
                            <td>${firm.order.takeNum}</td>
                        </tr>
                        <tr>
                            <td>手机号:</td>
                            <td>${firm.order.reservedPhone}</td>
                        </tr>
                        <tr>
                            <td>订单类型:</td>
                            <td>
                                <c:if test="${firm.order.staId==30}">
                                    快递
                                </c:if>
                                <c:if test="${firm.order.staId==31}">
                                    外卖
                                </c:if>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <c:if test="${briTel!=null}">
                    <table id="bringer-info" class="table table-responsive table-hover table-bordered">
                        <thead>
                        <tr>
                            <th colspan="2">带客信息</th>
                        </tr>
                        </thead>
                        <tbody style="background-color: transparent;">
                        <tr>
                            <td width="20%">带客手机:</td>
                            <td>${briTel}</td>
                        </tr>
                        <tr>
                            <td>真实姓名:</td>
                            <td>${briRealName}</td>
                        </tr>
                        <tr>
                            <td>地址:</td>
                            <td>${briAdd.campus}${briAdd.build}栋${briAdd.room}</td>
                        </tr>
                        </tbody>
                    </table>
                </c:if>
                    <input type="text" hidden="hidden" id="firmId" value="${firm.firmId}">
            </div>
        </div>

        <c:choose>
            <c:when test="${firm.orderState==0||firm.orderState==1}">
                <button type="button" class="btn btn-default" id="cancelFirmBtn">取消订单</button>
            </c:when>
            <c:otherwise>
                <button type="button" class="btn btn-default" id="deleteFirmBtn">删除订单</button>
            </c:otherwise>
        </c:choose>

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