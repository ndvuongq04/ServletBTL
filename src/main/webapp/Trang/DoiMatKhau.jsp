<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đổi mật khẩu</title>
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

	<%	
	// Kiểm tra Đã Đăng nhập hệ thống chưa 
		// lấy đối tượng khachHang từ session ( đối tượng khachHang của session đã được lưu vào ở trang DangNhap.java)
		Object obj = session.getAttribute("khachHang") ;
		KhachHang khachHangTemp = null ;
		if( obj != null )
			khachHangTemp = (KhachHang)obj ; //lưu đối tượng vừa lấy dưới session cho khachHangTemp
		if(khachHangTemp == null ){
			
	%>
		<h3 class = "text-center mb-3"> Bạn chưa đăng nhập vào hệ thống .<a href = "/website_banHang/Trang/index.jsp"> Vui lòng quay lại trang chủ ! </a></h3>
	<% 
		}else{
	
	%>	
		<div style = "height : 100vh "
			 class=" mb-3 container d-flex justify-content-center align-items-center "  		
		>	
			<%
				// lấy các Lỗi ở trang DoiMatKhau.java lên trang .jsp này
				String matKhauHienTaiError = request.getAttribute("matKhauHienTaiError") +"" ;
				String capNhatMatKhauError = request.getAttribute("capNhatMatKhauError") +"" ;

				
				// xử lý null
				matKhauHienTaiError = matKhauHienTaiError.equals("null")?"":matKhauHienTaiError ;
				capNhatMatKhauError = capNhatMatKhauError.equals("null")?"":capNhatMatKhauError ;

			%>
			<form
				id = "formDoiMatKhau"
				style = "width :450px ;"
				action = "${pageContext.request.contextPath}/controller/khach-hang"
				method = "POST"
			>
			 <input type = "hidden" name = "hanhDong" value = "doi-mat-khau">
			  <h3 class = "text-center mb-3">Đổi mật khẩu
			  		<br><span  style = "color : red ;"> <%= capNhatMatKhauError %></span>
			  </h3>
			 
			  
			  <div class=" mb-3">
			    <label for="matKhauHienTai" class="form-label">Mật khẩu hiện tại 
			    	<span style = "color : red ;">*</span> 
			    </label>
			    <input type="text" class="form-control" id="matKhauHienTai" name = "matKhauHienTai" >
			    <div style = "color : red ;"><%= matKhauHienTaiError %></div>
			     <div id = "matKhauHienTaiError" style = "color : red ; display : none ;"> Mật khẩu hiện không được để trống</div>
			  </div>
			  
			  <div class="mb-3">
			    <label for="matKhauMoi" class="form-label">Mật khẩu mới
			    	<span style = "color : red ;">*</span> 
			    </label>
			    <input type="text" class="form-control" id="matKhauMoi" name = "matKhauMoi" >
			    <div id = "matKhauMoiError" style = "color : red ; display : none ;"> Mật khẩu mới không được để trống</div>
			  </div>
			  
			  <div class="mb-4">
			    <label for="nhapLaiMatKhauMoi" class="form-label">Nhập lại mật khẩu mới 
			    	<span style = "color : red ;">*</span> 
			    </label>
			    <input type="text" class="form-control" id="nhapLaiMatKhauMoi" name = "nhapLaiMatKhauMoi">
			     <div id = "nhapLaiMatKhauMoiError" style = "color : red ; display : none ;"> Nhập lại mật khẩu mới không được để trống</div>
			  </div>
			  
			  <button type="submit" class="btn btn-primary" style = "width : 100% ;">Đổi mật khẩu</button>
			</form>
		</div>
		
		<!-- Script-->
		<script src = "../Js_file/DoiMatKhau.js"></script>
		

	<% 
		}
	%>	
</body>
</html>