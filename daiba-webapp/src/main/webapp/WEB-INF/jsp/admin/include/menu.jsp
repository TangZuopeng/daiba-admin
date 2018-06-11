<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<aside class="sidebar-menu fixed">
    <div class="sidebar-inner scrollable-sidebar">
        <div class="main-menu">
            <ul class="accordion">

                <%--发布通知--%>
                <li class="bg-palette2">
                    <a href="<%=basePath%>Admin/user">
                        <span class="menu-content block">
                            <span class="menu-icon"><i class="block fa fa-bell fa-lg"></i></span>
                            <span class="text m-left-sm">用户</span>
                        </span>
                        <span class="menu-content-hover block">用户</span>
                    </a>
                </li>
                <%--发布任务--%>
                <li class="bg-palette3">
                    <a href="<%=basePath%>Admin/firm">
                        <span class="menu-content block">
                            <span class="menu-icon"><i class="block fa fa-tags fa-lg"></i></span>
                            <span class="text m-left-sm">订单</span>
                        </span>
                        <span class="menu-content-hover block">订单</span>
                    </a>
                </li>
                <%--任务一览--%>
                <li class="bg-palette4">
                    <a href="<%=basePath%>info/task">
                        <span class="menu-content block">
                            <span class="menu-icon"><i class="block fa fa-desktop fa-lg"></i></span>
                            <span class="text m-left-sm">认证</span>
                        </span>
                        <span class="menu-content-hover block">认证</span>
                    </a>
                </li>
                <%--意见反馈--%>
                <li class="bg-palette4">
                    <a href="<%=basePath%>Admin/todayData">
                        <span class="menu-content block">
                            <span class="menu-icon"><i class="block fa fa-envelope fa-lg"></i></span>
                            <span class="text m-left-sm">今日数据</span>
                        </span>
                        <span class="menu-content-hover block">今日数据</span>
                    </a>
                </li>
            </ul>
        </div>
    </div><!-- sidebar-inner -->

    <%@ include file="foot.jsp" %>

</aside>
