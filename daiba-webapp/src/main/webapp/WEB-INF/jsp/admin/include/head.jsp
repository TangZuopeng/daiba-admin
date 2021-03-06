<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header class="top-nav">
    <div class="top-nav-inner">

        <!--LOGO-->
        <div class="nav-header">
            <a href="#" onclick="toHome()">
                <span class="brand-name">
                    <img style="width: 170px" height="50px" src="<c:url value="/admin/images/logo.jpg" />" />
                </span>
            </a>
        </div>

        <div class="nav-container">
            <button type="button" class="navbar-toggle pull-left sidebar-toggle" id="sidebarToggleLG">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <ul class="nav-notification">
                <li class="search-list">
                    <div class="search-input-wrapper">
                        <div class="search-input">
                            <input type="text" class="form-control input-sm inline-block">
                            <a href="#" class="input-icon text-normal"><i class="ion-ios7-search-strong"></i></a>
                        </div>
                    </div>
                </li>
            </ul>

            <div class="pull-right m-right-sm">
                <ul class="nav-notification">
                    <li>
                        <a href="#" onclick="toHome()">
                            <i class="fa fa fa-home fa-lg"></i> 首页
                        </a>
                    </li>
                    <li>
                        <a href="#" onclick="logout()">
                            <i class="fa fa ion-log-out fa-lg"></i> 退出
                        </a>
                    </li>
                </ul>
            </div>

        </div>

    </div>

</header>

<script>
    function logout() {
        window.location.href = basePath + "/Admin/logout";
    }
    function toHome() {
        window.location.href = basePath+ "/Admin/user";
    }
</script>

