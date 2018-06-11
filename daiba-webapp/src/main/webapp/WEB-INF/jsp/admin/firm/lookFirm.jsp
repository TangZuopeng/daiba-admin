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
                    <a href="<%=basePath%>Admin/firm">订单</a>
                    <i class="fa fa-angle-right"></i>
                    <a href="#">订单详情</a>
                </div>
                <span class="pull-right font-18" id="nowTime"></span>
            </div>
            <div class="container-fluid margin-md">
                <a href="#">发单人:<spam>${firm.order.reservedPhone}</spam></a><br>
                <a href="#">

                        <c:if test="${bringer!=null}">
                            带客:<spam> ${bringer.phoneNum}</spam>
                        </c:if>
                </a><br>
                <table id="base-info" class="table table-responsive table-hover table-bordered">
                    <thead>
                        <tr>
                            <th colspan="2">基本信息</th>
                        </tr>
                    </thead>
                    <tbody style="background-color: transparent;">
                        <tr>
                            <td width="20%">订单号:</td>
                            <td>${firm.firmId}</td>
                        </tr>
                        <tr>
                            <td>订单状态:</td>
                            <td>
                                <c:if test="${firm.orderState==0}">
                                    未接单
                                </c:if>
                                <c:if test="${firm.orderState==1}">
                                    已接单
                                </c:if>
                                <c:if test="${firm.orderState==2}">
                                    已完成
                                </c:if>
                                <c:if test="${firm.orderState==3}">
                                    已取消
                                </c:if>
                                <c:if test="${firm.orderState==4}">
                                    待付款
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <td>发单时间:</td>
                            <td id="giveTime">
                                <script>
                                    var d=new Date();
                                    d.setTime("${firm.giveTime.time}");
                                    var giveTime=format(d,"yyyy-MM-dd    hh:mm:ss");
                                    $("#giveTime").text(giveTime);
                                </script>
                            </td>
                        </tr>
                        <tr>
                            <td>接单时间:</td>
                            <td id="acceptTime">
                                <c:choose>
                                    <c:when test="${null==firm.acceptTime||firm.acceptTime==''}">
                                        无
                                    </c:when>
                                    <c:otherwise>
                                        <script>
                                            var d=new Date();
                                            d.setTime("${firm.acceptTime.time}");
                                            var acceptTime=format(d,"yyyy-MM-dd    hh:mm:ss");
                                            $("#acceptTime").text(acceptTime);
                                        </script>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <tr>
                            <td>完成时间:</td>

                            <td id="finishTime">
                            <c:choose>
                                <c:when test="${null==firm.finishTime||firm.finishTime==''}">
                                    无
                                </c:when>
                                <c:otherwise>
                                    <script>
                                        var d=new Date();
                                        d.setTime("${firm.finishTime.time}");
                                        var finishTime=format(d,"yyyy-MM-dd    hh:mm:ss");
                                        $("#finishTime").text(finishTime);
                                    </script>
                                </c:otherwise>
                            </c:choose>
                            </td>

                        </tr>
                        <tr>
                            <td>金额:</td>
                            <td>${firm.orderMoney*0.01}</td>
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
                <button id="cancelFirmBtn" type="submit" class="btn btn-success marginTB-xs">取消订单</button>
            </c:when>
            <c:otherwise>
                <button id="deleteFirmBtn" type="submit" class="btn btn-success marginTB-xs">删除订单</button>
            </c:otherwise>
        </c:choose>

    </div>

</div>
</body>
</html>
<script type="text/javascript" src="<c:url value="/admin/pulgins/DataTables-1.10.11/media/js/jquery.dataTables.js"/>"></script>
<script>
    $(function (){

        function cancelOrder() {
            $.ajax({
                url: basePath + "/Admin/cancelFirm.do",
                data: {
                    firmId: "${firm.firmId}",
                    userId: ${firm.user.userId}
                },
                dataType: "json",
                type: "POST",
                async: false,
                success: function (result) {
                    if (result.cancelMessage == 1) {
                        alert('取消订单成功！');
                        location.reload();
                    } else if (result.cancelMessage == 2) {
                        alert('取消订单失败，该订单不是可取消状态');
                    } else if (result.cancelMessage == 3) {
                        alert('取消订单失败，该订单不存在，可能被删除');
                    } else if (result.cancelMessage == 4) {
                        alert('权限异常！');
                    }
                },
                error: function () {
                    mui.toast('取消订单失败，请检查网络是否正常');
                }
            });
        }

        //取消订单触发的事件
        $("#cancelFirmBtn").click(function () {
            $.ajax({
                url: basePath + "/WeiXin/pay/cancelOrder.do",
                data: {
                    out_trade_no: "${firm.firmId}",
                    total_fee: ${firm.orderMoney}
                },
                dataType: "json",
                type: "POST",
                async: false,
                success: function (result) {
                    if (result) {
                        cancelOrder();
                    } else {
                        alert("退款失败！");
                    }
                },
                error: function () {
                    alert("退款失败！");
                }
            });
        });

        function deleteFirm() {
            $.ajax({
                url: basePath + "/Admin/deleteFirm.do",
                data: {
                    firmId: "${firm.firmId}",
                },
                dataType: "json",
                type: "POST",
                async: false,
                success: function (result) {
                    if (result) {
                        alert("删除订单成功！");
                    } else {
                        alert("删除订单失败！");
                    }
                },
                error: function () {
                    alert("删除订单失败！");
                }
            });
        }

        //删除订单触发的事件
        $("#deleteFirmBtn").click(function(){
            var flag = confirm("你确定删除该订单吗？");
            if (flag) {
                deleteFirm();
            }
        });
    });
</script>