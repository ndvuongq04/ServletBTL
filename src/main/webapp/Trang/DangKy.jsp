<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
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
	

</head>
<body>

	<%
		// lấy thông tin lỗi
		String errorTenDangNhap = request.getAttribute("errorTenDangNhap")+"" ;
		// xử lý null 
		errorTenDangNhap = errorTenDangNhap.equals("null")?"":errorTenDangNhap ;
	%>
	<div 
		style = "height : 100vh "
		class="container d-flex justify-content-center align-items-center "
	>
		
		<form 
			id = "formDangKy" 
			style = "width :450px ;"
			action = "${pageContext.request.contextPath}/controller/khach-hang"
			method = "Post"
			
		>
			<input type="hidden" name="hanhDong" value="dang-ky"/>
			<h3 class = "text-center mb-3" >Đăng ký tài khoản</h3>
			
		  <div class="mb-3">
		    <label for="hoVaTen" class="form-label ">Họ Và tên 
		    	<span style = "color : red ;">*</span> 
		    </label>
		    <input 
		    	type="text" 
		    	class="form-control" 
		    	id="hoVaTen" 
		    	name = "hoVaTen"
		    >
		    
		    <div  id = "hoVaTenError" style = "color : red ; display : none ;">
		    	Tên không được để trống
		    </div>
		  </div>
		  
		  <div class="mb-2">
		    <label for="tenDangNhap" class="form-label ">Tên đăng nhập 
		    	<span style = "color : red ;">*</span> 
		    </label>
		    <input 
			    type="text" 
			    class="form-control" 
			    id="tenDangNhap" 
			    name = "tenDangNhap"
		    >
		    <div style = "color : red ;"><%= errorTenDangNhap %></div>
		    <div  id = "tenDangNhapError" style = "color : red ; display : none ;">
		    	Tên đăng nhập không được để trống
		    </div>
		  </div>
		  
		  <div class="mb-2">
		    <label for="email" class="form-label ">Email 
		   		<span style = "color : red ;">*</span> 
		    </label>
		    <input 
			    type="email" 
			    class="form-control" 
			    id="email" 
			    name = "email" 
			    placeholder = "name@gmail.com"
		    >
		    <div  id = "emailError" style = "color : red ; display : none ;">
		   	 	Email không được để trống
		    </div>
		  </div>
		  
		  <div class="mb-2">
		    <label for="matKhau" class="form-label ">Mật khẩu 
		   		<span style = "color : red ;">*</span> 
		    </label>
		    <input 
			    type="text" 
			    class="form-control" 
			    id="matKhau" 
			    name = "matKhau" 
		    >
		    <div  id = "matKhauError"  style = "color : red ; display : none ;">
		    	Mật khẩu không được để trống
		    </div>
		  </div>
		  
		  <div class="mb-2">
		    <label for="matKhauNhapLai" class="form-label">Nhập lại mật khẩu
		    	 <span style = "color : red ;">*</span>
		    </label>
		    <input 
			    type="text" 
			    class="form-control" 
			    id="matKhauNhapLai" 
			    name = "matKhauNhapLai"
		    >
		      <div  id = "matKhauNhapLaiError" class ="error" style = "color : red ; display : none ;">
		      	Nhập lại mật khẩu không được để trống
		      </div>
		  </div>
		  <div class="mb-2 form-check">
		    <input 
			    type="checkbox" 
			    class="form-check-input" 
			    id="checkEmail" 
			    name = "checkEmail"
		    >
		    <label class="form-check-label" for="checkEmail">Nhận thông báo từ Email
		    	<span style = "color : red ;">*</span>
		    </label>
		  </div>
		  <div  >
		  	<button style = "width :100% ;" type="submit" class="btn btn-primary">Đăng ký</button>
		  </div>
		 	<p class = "text-center mt-2 ">
		 		Bạn đã có tài khoản? <a href = "${pageContext.request.contextPath}/Trang/DangNhap.jsp">Đăng nhập</a>
		  		
		  	</p>
		  
		</form>
	</div>
	
	<!-- Script  -->
	<script src = "../Js_file/DangKy.js"></script>
</body>
</html>