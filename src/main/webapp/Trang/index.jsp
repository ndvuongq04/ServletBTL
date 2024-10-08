<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
		crossorigin="anonymous">
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
		integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
		crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">Navbar</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="#">Home</a>
	        </li>

	        <%	
	     		// lấy đối tượng khachHang từ session ( đối tượng khachHang của session đã được lưu vào ở trang DangNhap.java)
	        	Object obj = session.getAttribute("khachHang") ;
	        	KhachHang khachHangTemp = null ; // để lưu thông tin khách hàng dưới database gửi lên
	        	if(obj != null)
	        		khachHangTemp = (KhachHang)obj ;
	        	if(khachHangTemp == null ) { // nghĩa là chưa có ai đăng nhập vào trang 
	        		
	        	
	        %>
	        
	        <li class="nav-item">
	          <a class="nav-link" href="DangKy.jsp">Đăng ký</a>
	        </li>
	        
	        <li class="nav-item">
	          <a class="nav-link" href="DangNhap.jsp">Đăng nhập</a>
	        </li>
	        
	        <%
	        	}else { // nếu trang có tài khoản đăng nhập -> hiển thị nút đăng xuât 
	        %>
	        
	         <li class="nav-item dropdown">
		         <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		           Tài khoản <b><%=khachHangTemp.getTenDangNhap() %></b>
		         </a>
		         
		         <ul class="dropdown-menu" aria-labelledby="navbarDropdown"
		         	style = "min-width: fit-content; /* Tự động điều chỉnh theo nội dung bên trong */
  							width: 100%;"
		         >
		         	<li><a class="dropdown-item" href="#">Đơn hàng của tôi</a></li>
		           <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Trang/ThayDoiThongTinKH.jsp">Thay đổi thông tin</a></li>
		           <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Trang/DoiMatKhau.jsp">Đổi mật khẩu</a></li>
		           <li><hr class="dropdown-divider"></li>
		           <li><a class="dropdown-item" href="${pageContext.request.contextPath}/controller/khach-hang?hanhDong=dang-xuat">Đăng xuất</a></li>
		         </ul>
	       </li>
	        
	        <%	}%>
	        
	        
	      </ul>
	      <form class="d-flex ">
	        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
	        <button class="btn btn-outline-success" type="submit">Search</button>
	      </form>
	    </div>
	  </div>
	</nav>
</body>
</html>