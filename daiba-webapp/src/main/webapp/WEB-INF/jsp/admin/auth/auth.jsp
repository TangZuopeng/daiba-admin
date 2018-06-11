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
                    <a href="<%=basePath%>Admin/auth">认证</a>
                    <i class="fa fa-angle-right"></i>
                    <a href="#">认证操作</a>
                </div>
                <span class="pull-right font-18" id="nowTime"></span>
            </div>
            <div class="container-fluid margin-md">
                <div class="col-md-6">
                    <div class="smart-widget">
                        <div class="smart-widget-header">
                            实名认证
                            <span class="smart-widget-option">
										<span class="refresh-icon-animated">
											<i class="fa fa-circle-o-notch fa-spin"></i>
										</span>
			                            <a href="#" class="widget-toggle-hidden-option">
			                                <i class="fa fa-cog"></i>
			                            </a>
			                            <a href="#" class="widget-collapse-option" data-toggle="collapse">
			                                <i class="fa fa-chevron-up"></i>
			                            </a>
			                            <a href="#" class="widget-refresh-option">
			                                <i class="fa fa-refresh"></i>
			                            </a>
			                            <a href="#" class="widget-remove-option">
			                                <i class="fa fa-times"></i>
			                            </a>
			                        </span>
                        </div>
                        <div class="smart-widget-inner">
                            <div class="smart-widget-hidden-section">
                                <ul class="widget-color-list clearfix">
                                    <li style="background-color:#20232b;" data-color="widget-dark"></li>
                                    <li style="background-color:#4c5f70;" data-color="widget-dark-blue"></li>
                                    <li style="background-color:#23b7e5;" data-color="widget-blue"></li>
                                    <li style="background-color:#2baab1;" data-color="widget-green"></li>
                                    <li style="background-color:#edbc6c;" data-color="widget-yellow"></li>
                                    <li style="background-color:#fbc852;" data-color="widget-orange"></li>
                                    <li style="background-color:#e36159;" data-color="widget-red"></li>
                                    <li style="background-color:#7266ba;" data-color="widget-purple"></li>
                                    <li style="background-color:#f5f5f5;" data-color="widget-light-grey"></li>
                                    <li style="background-color:#fff;" data-color="reset"></li>
                                </ul>
                            </div>
                            <div class="smart-widget-body">
                                <form class="form-horizontal no-margin" id="type-constraint" data-validate="parsley" novalidate="">
                                    <div class="form-group">
                                        <label class="control-label col-lg-3">真实姓名</label>
                                        <div class="col-lg-9">
                                            <input class="form-control input-sm" data-parsley-type="email" placeholder="真实姓名" type="text">
                                        </div><!-- /.col -->
                                    </div><!-- /form-group -->
                                    <div class="form-group">
                                        <label class="control-label col-lg-3">学号</label>
                                        <div class="col-lg-9">
                                            <input class="form-control input-sm" data-parsley-type="url" placeholder="学号" type="text">
                                        </div><!-- /.col -->
                                    </div><!-- /form-group -->

                                    <div class="form-group">
                                        <label class="control-label col-lg-3">学生证正面</label>
                                        <div class="col-lg-9">
                                            <input name="file" multiple="" type="file">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-lg-3">学生证反面</label>
                                        <div class="col-lg-9">
                                            <input name="file" multiple="" type="file">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-lg-3">身份证正面</label>
                                        <div class="col-lg-9">
                                            <input name="file" multiple="" type="file">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-lg-3">身份证反面</label>
                                        <div class="col-lg-9">
                                            <input name="file" multiple="" type="file">
                                        </div>
                                    </div>

                                    <div class="text-right m-top-md">
                                        <button type="submit" class="btn btn-info">提交</button>
                                    </div>
                                </form>
                            </div>
                        </div><!-- ./smart-widget-inner -->
                    </div><!-- ./smart-widget -->
                </div>
            </div>
        </div>


    </div>

</div>
</body>
</html>
<script type="text/javascript" src="<c:url value="/admin/pulgins/DataTables-1.10.11/media/js/jquery.dataTables.js"/>"></script>
<script>
    $(function (){

    });
</script>