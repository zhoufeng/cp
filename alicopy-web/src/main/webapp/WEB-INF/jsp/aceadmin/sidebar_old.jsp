
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/core" prefix="c"%>


<div class="sidebar" id="sidebar">
	<script type="text/javascript">
		try {
			ace.settings.check('sidebar', 'fixed')
		} catch (e) {
		}
	</script>

	<div class="sidebar-shortcuts" id="sidebar-shortcuts">
		<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
			<button class="btn btn-success">
				<i class="icon-signal"></i>
			</button>

			<button class="btn btn-info">
				<i class="icon-pencil"></i>
			</button>

			<button class="btn btn-warning">
				<i class="icon-group"></i>
			</button>

			<button class="btn btn-danger">
				<i class="icon-cogs"></i>
			</button>
		</div>

		<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
			<span class="btn btn-success"></span> <span class="btn btn-info"></span>

			<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
		</div>
	</div>
	<!-- #sidebar-shortcuts -->

	<ul class="nav nav-list">
		<li class="active"><a href="${URL_ROOT}/console"> <i
				class="icon-dashboard"></i> <span class="menu-text"> 控制台 </span> </a></li>

		<li><a href="${URL_ROOT}/top/opt"> <i class="icon-text-width"></i>
				<span class="menu-text"> 商品列表 </span> </a></li>
		<%-- <li class="active"><a href="#" class="dropdown-toggle"> <i
				class="icon-desktop"></i> <span class="menu-text"> 淘宝 </span> <b
				class="arrow icon-angle-down"></b> </a>

			<ul class="submenu">
				<li id="test1" class="active"><a href="${URL_ROOT}/top/opt"> <i
						class="icon-double-angle-right"></i> 商品列表 </a></li>

				<li id="test2"><a href="buttons.html"> <i
						class="icon-double-angle-right"></i> 图片空间 </a></li>

				<li id="test3"><a href="treeview.html"> <i
						class="icon-double-angle-right"></i> 树菜单 </a></li>
			</ul></li>

		
		<li><a href="#" class="dropdown-toggle"> <i
				class="icon-desktop"></i> <span class="menu-text">阿里巴巴</span> <b
				class="arrow icon-angle-down"></b> </a>

			<ul class="submenu">
				<li><a href="${URL_ROOT}/ali/opt"> <i
						class="icon-double-angle-right"></i> 商品列表 </a></li>

				<li><a href="buttons.html"> <i
						class="icon-double-angle-right"></i> 图片空间 </a></li>

				<li><a href="treeview.html"> <i
						class="icon-double-angle-right"></i> 树菜单 </a></li>
			</ul></li> --%>
		
		
		
	</ul>
	<!-- /.nav-list -->


	<div class="sidebar-collapse" id="sidebar-collapse">
		<i class="icon-double-angle-left" data-icon1="icon-double-angle-left"
			data-icon2="icon-double-angle-right"></i>
	</div>

	<script type="text/javascript">
		try {
			ace.settings.check('sidebar', 'collapsed')
		} catch (e) {
		}
	</script>
</div>


