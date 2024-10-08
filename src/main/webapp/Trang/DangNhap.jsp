<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
		crossorigin="anonymous"
	>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous">
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
		integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
		crossorigin="anonymous">
	</script>
	
	<style>
		.red{
			color : red ; 
		}
	</style>
	
	
</head>
<body>
	<%
		// lấy lỗi 
		String errorTenDangNhap = request.getAttribute("errorTenDangNhap") + "" ;
		String errorMatKhau = request.getAttribute("errorMatKhau") + "" ;
		
		// sửa lỗi null
		errorTenDangNhap = errorTenDangNhap.equals("null")?"":errorTenDangNhap ;
		errorMatKhau = errorMatKhau.equals("null")?"":errorMatKhau ;
	%>
	<div 
		style = "height : 100vh "
		class="container d-flex justify-content-center align-items-center"
	>
		
		<form 
			style = "width :400px ;"
			id = "formDangNhap"
			method = "post"
			action = "${pageContext.request.contextPath}/controller/khach-hang"
		>
		<input type = "hidden" name = "hanhDong" value = "dang-nhap">
		<h3 class = "text-center mb-3" >Đăng nhập tài khoản </h3>
		
		  <div class="mb-3">
		    <label for="tenDangNhap" class="form-label ">Tên đăng nhập 
		    	<span class = "red">*</span> 
		    </label>
		    <input 
			    type="text" 
			    class="form-control" 
			    id="tenDangNhap" 
			    name = "tenDangNhap"
		    >
		    <div style = "color : red ;" ><%= errorTenDangNhap %></div>
		    <div  id = "tenDangNhapError" style = "color : red ; display : none ;">
		    	Tên đăng nhập không được để trống
		    </div>
		  </div>
		  <div class="mb-3">
		    <label for="matKhau" class="form-label ">Mật khẩu 
		   		<span class = "red">*</span> 
		    </label>
		    <input 
			    type="text" 
			    class="form-control" 
			    id="matKhau" 
			    name = "matKhau" 
		    >
		    <div style = "color : red ;" ><%= errorMatKhau %></div>
		    <div  id = "matKhauError"  style = "color : red ; display : none ;">
		    	Mật khẩu không được để trống
		    </div>
		  </div>
		  
		  <div  >
		  	<button style = "width :100% ;" type="submit" class="btn btn-primary">Đăng nhập</button>
		  </div>
		 	<p class = "text-center mt-2 ">
		 		Bạn chưa có tài khoản ? <a href = "${pageContext.request.contextPath}/Trang/DangKy.jsp">Đăng ký </a>
		  		
		  	</p>
		  
		</form>
	</div>
	<!-- Script  -->
	<script src = "../Js_file/DangNhap.js"></script>
</body>
</html>