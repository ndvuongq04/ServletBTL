// test xem điều hướng file đúng chưa
//console.log("hello") ;

// Lấy ra elements của trang
const formDangKy = document.getElementById("formDangKy") ;

const hoVaTenElement = document.getElementById("hoVaTen") ;
const tenDangNhapElement = document.getElementById("tenDangNhap") ;
const emailElement = document.getElementById("email") ;
const matKhauElement = document.getElementById("matKhau") ;
const matKhauNhapLaiElement = document.getElementById("matKhauNhapLai") ;

// Element liên quan đến lỗi
const hoVaTenError = document.getElementById("hoVaTenError") ;
const tenDangNhapError = document.getElementById("tenDangNhapError") ;
const emailError = document.getElementById("emailError") ;
const matKhauError = document.getElementById("matKhauError") ;
const matKhauNhapLaiError = document.getElementById("matKhauNhapLaiError") ;




// Lắng nghe sự kiện của form
formDangKy.addEventListener("submit", function(e){ // onsubmit -> trang sẽ load như bthg 

	// Biến kiểm tra xem có lỗi hay không
	var check = true ;
	
	// Validate dữ liệu đầu vào
	if(!hoVaTenElement.value){ // chưa có dữ liệu
		// hiển thị lỗi
		check = false ; // đánh dấu là có lỗi 
		hoVaTenError.style.display = "block" ;
		
	}
	else { // có dữ liệu rồi
		// ẩn lỗicheck = false ;
		hoVaTenError.style.display = "none" ;
	}
	
	// Validate dữ liệu đầu vào
	if(!tenDangNhapElement.value){ // chưa có dữ liệu
		// hiển thị lỗi
		check = false ;
		tenDangNhapError.style.display = "block" ;
		
	}
	else { // có dữ liệu rồi
		// ẩn lỗi
		tenDangNhapError.style.display = "none" ;
	}
	
	// Validate dữ liệu đầu vào
	if(!emailElement.value){ // chưa có dữ liệu
		// hiển thị lỗi
		check = false ;
		emailError.style.display = "block" ;	
	}
	else { // có dữ liệu rồi
		// ẩn lỗi
		emailError.style.display = "none" ;
	}
	
	// Validate dữ liệu đầu vào
	if(!matKhauElement.value){ // chưa có dữ liệu
		// hiển thị lỗi
		check = false ;
		matKhauError.style.display = "block" ;	
	}
	else { // có dữ liệu rồi
		// ẩn lỗi
		matKhauError.style.display = "none" ;
	}
	
	// Validate dữ liệu đầu vào
	if(!matKhauNhapLaiElement.value){ // chưa có dữ liệu
		// hiển thị lỗi
		check = false ;
		matKhauNhapLaiError.style.display = "block" ;	
	}
	else { // có dữ liệu rồi
		// ẩn lỗi
		matKhauNhapLaiError.style.display = "none" ;
	}
	
	// kiểm tra mật khẩu và nhập lại mật khẩu
	if( matKhauElement.value !== matKhauNhapLaiElement.value  ){
		check = false ;
		matKhauNhapLaiError.style.display = "block" ;
		matKhauNhapLaiError.innerHTML = "Mật khẩu nhập lại không khớp với mật khẩu " ;
	}
	
	if(!check){
		//ngăn chặn sự kiện submit trang khi có lỗi
		e.preventDefault() ;
	}
	// nếu không có lỗi -> check = true -> form vẫn sẽ được submit 
	
	
	
	
	
});