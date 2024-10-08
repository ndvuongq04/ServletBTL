<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin khách hàng</title>
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
	// KHÁCH HÀNG CHƯA ĐĂNG NHẬP TÀI KHOẢN VÀO Website 
		/*
			- Lỗi khách hàng chưa đăng nhập vào website mà gõ link url : ThayDoiThongTinKH.jsp
				-> Bắt lỗi bằng : session 
					- Tạo 1 Đối tượng lưu giá trị của session ( người dùng hiện tại có được lưu dưới session )
						-> null : là chưa được lưu -> chưa đăng nhập vào website
						-> !null : ___________
					- Tạo 1 thông báo và đường link chuyển sang trang index.jsp
		*/
		Object obj = session.getAttribute("khachHang") ;
		KhachHang khachHangTemp = null ;
		if( obj != null )
			khachHangTemp = (KhachHang)obj ; //lưu đối tượng vừa lấy dưới session cho khachHangTemp
		if(khachHangTemp == null ){
			
	%>
	
	<h3 class = "text-center mb-3"> Bạn chưa đăng nhập vào hệ thống .<a href = "/website_banHang/Trang/index.jsp"> Vui lòng quay lại trang chủ ! </a></h3>
	
	<%
			
		}else {
			
			
			// KHÁCH HÀNG ĐÃ ĐĂNG NHẬP TÀI KHOẢN VÀO Website 
			
			// Cách làm :
			/*	
				- Cho khách hàng cập nhật thông tin xuống database
				- Nếu xảy ra lỗi -> hiển thị lỗi và dữ lại các thông tin mà khách hàng đã nhập trước đó
				- Nếu không có lỗi -> hiển thị thông báo cập nhật thông tin thành công và điều hướng vè trang chủ 
				- Luôn hiển thị thông tin khách hàng đã có trong database lên các ô input
					- null -> xử lý null
					- !null -> giữ nó và hiển thị
				
				
				
			*/
			
			// Lấy thông tin khách hàng từ session -> lên và hiển thị nó 
			String hoVaTen = khachHangTemp.getHoVaTen() ;
			// Xử lý null -> nếu null thì sẽ không gọi được hàm toString => null -> chuyển thành chuỗi rỗng ""
			String ngaySinh = (khachHangTemp.getNgaySinh() != null) ? khachHangTemp.getNgaySinh().toString() : "";
			
			String gioiTinh = khachHangTemp.getGioiTinh() ;
			String diaChi = khachHangTemp.getDiaChi() ;
			String diaChiNhanHang = khachHangTemp.getDiaChiNhanHang() ;
			String diaChiMauHang = khachHangTemp.getDiaChiMauHang() ;
			String soDienThoai = khachHangTemp.getSoDienThoai() ;
			
			
			// XỬ LÝ LỖI String
				// nếu chuỗi rỗng thì gán cho nó 1 giá trị mặc đinh
			ngaySinh = ngaySinh.isEmpty()?"2024-10-07":ngaySinh ;
				// null 
			gioiTinh = gioiTinh == null?"":gioiTinh ;
				
			diaChi = diaChi == null?"":diaChi ;
			diaChiNhanHang = diaChiNhanHang == null?"":diaChiNhanHang ;
			diaChiMauHang = diaChiMauHang == null?"":diaChiMauHang ;
			soDienThoai = soDienThoai == null?"":soDienThoai ;
			
			// Xử lý NULL
			
						
			
			// Lấy lỗi
			String error = request.getAttribute("error") +"" ;
			// Xử lý lỗi null 
			error = error.equals("null")?"":error ;
			
			
	%>		
	
	
	
	<div 
		style = "height : 110vh "
		class="container d-flex justify-content-center align-items-center "
	>
		
		<form 
			id = "formThayDoiThongTinKH" 
			style = "width :450px ;"
			action = "${pageContext.request.contextPath}/controller/khach-hang"
			method = "Post"
			
		>
			<input type = "hidden" name = "hanhDong" value = "thay-doi-thong-tin">
			<h3 class = "text-center mb-3" >Thay đổi thông tin </h3>
			
			<div  class = "text-center mb-2" style = "color : red ;"><%=error %></div>
		  <div class="mb-3">
		    <label for="hoVaTen" class="form-label ">Họ Và tên 
		    	<span style = "color : red ;">*</span> 
		    </label>
		    <input 
		    	type="text" 
		    	class="form-control" 
		    	id="hoVaTen" 
		    	name = "hoVaTen"
		    	value = "<%= hoVaTen %>"
		    >
		  </div>
		  
		  <div class="mb-2">
		    <label for="ngaySinh" class="form-label ">Ngày sinh 
		   		<span style = "color : red ;">*</span> 
		    </label>
		    <input 
			    type="date" 
			    class="form-control" 
			    id="ngaySinh" 
			    name = "ngaySinh"
			    value = "<%= (ngaySinh.isEmpty() )?"2002-12-02":ngaySinh %>"
		    >
		 </div>
		 
		 <div class="mb-2">
						<label for="gioiTinh" class="form-label">Giới tính</label> 
						<select class="form-control" id="gioiTinh" name="gioiTinh">
						    <option></option>
						    <option value="Nam" <%= (gioiTinh != null && gioiTinh.equals("Nam")) ? "selected='selected'" : "" %>>Nam</option>
						    <option value="Nữ" <%= (gioiTinh != null && gioiTinh.equals("Nữ")) ? "selected='selected'" : "" %>>Nữ</option>
						    <option value="Khác" <%= (gioiTinh != null && gioiTinh.equals("Khác")) ? "selected='selected'" : "" %>>Khác</option>
						</select>
					</div>
		  
		  <div class="mb-2">
		    <label for="diaChi" class="form-label ">Địa chỉ
		   		<span style = "color : red ;">*</span> 
		    </label>
		    <input 
			    type="text" 
			    class="form-control" 
			    id="diaChi" 
			    name = "diaChi" 
			    value = "<%= diaChi %>"
			    placeholder = "Liên mạc / Bắc từ liêm / Hà nội"
		    >
		  </div>
		  
		  <div class="mb-2">
		    <label for="diaChiNhanHang" class="form-label ">Địa chỉ nhận hàng 
		   		<span style = "color : red ;">*</span> 
		    </label>
		    <input 
			    type="text" 
			    class="form-control" 
			    id="diaChiNhanHang" 
			    name = "diaChiNhanHang" 
			    value = "<%= diaChiNhanHang %>"
			    placeholder = "Số nhà 15 ngách 5/35 Liên mạc / Bắc từ liêm / Hà nội"
		    >
		  </div>
		  
		  <div class="mb-2">
		    <label for="diaChiMauHang" class="form-label ">Địa chỉ mua hàng 
		   		<span style = "color : red ;">*</span> 
		    </label>
		    <input 
			    type="text" 
			    class="form-control" 
			    id="diaChiMauHang" 
			    name = "diaChiMauHang" 
			    value = "<%= diaChiMauHang %>"
			    placeholder = "Số nhà 09 Cửu việt 1 / Trâu quỳ / Gia lâm / Hà nội"
		    >
		  </div>
		  
		  <div class="mb-3">
		    <label for="soDienThoai" class="form-label ">Số điện thoại  
		   		<span style = "color : red ;">*</span> 
		    </label>
		    <input 
			    type="text" 
			    class="form-control" 
			    id="soDienThoai" 
			    name = "soDienThoai" 
			    value = "<%= soDienThoai %>"
			    placeholder = "0123456789"
		    >
		  </div>
		  
		 <div class="mb-3 form-check">
		    <input 
			    type="checkbox" 
			    class="form-check-input" 
			    id="temp" 
			    name = "temp"
			    required
		    >
		    <label class="form-check-label" for="temp">Tôi hoàn toàn chịu trách nhiệm với những thông tin này
		    	<span style = "color : red ;">*</span>
		    </label>
		  </div>
		  <div  >
		  	<button style = "width :100% ;" type="submit" class="btn btn-primary">Thay đổi</button>
		  </div>
		  
		</form>
	</div>
	<%
		}	
	%>
</body>
</html>