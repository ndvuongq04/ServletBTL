/**
 * 
 */
// test form 
console.log("hello") ;
 // Lấy element của form
const formDoiMatKhau = document.getElementById("formDoiMatKhau") ;

const matKhauHienTai = document.getElementById("matKhauHienTai") ;
const matKhauMoi = document.getElementById("matKhauMoi") ;
const nhapLaiMatKhauMoi = document.getElementById("nhapLaiMatKhauMoi") ;

// lắng nghe sự kiện của form
formDoiMatKhau.addEventListener("submit",function(e){
	
	// biến kiểm tra lỗi
	var check = false ; // hiện tại chưa có lỗi
	
	// Xác nhận dữ liệu đầu vào
	if(!matKhauHienTai.value){// null
		check = true ;
		matKhauHienTaiError.style.display = "block" ;
	}
	else{// có dữ liệu rồi
		matKhauHienTaiError.style.display = "none" ;		
	}
	
	// Xác nhận dữ liệu đầu vào
	if(!matKhauMoi.value){// null
		check = true ;
		matKhauMoiError.style.display = "block" ;
	}
	else{// có dữ liệu rồi
		matKhauMoiError.style.display = "none" ;		
	}
	
	// Xác nhận dữ liệu đầu vào
	if(!nhapLaiMatKhauMoi.value){// null
		check = true ;
		nhapLaiMatKhauMoiError.style.display = "block" ;
	}
	else{// có dữ liệu rồi
		nhapLaiMatKhauMoiError.style.display = "none" ;		
	}
	
	// Xác nhận dữ liệu mật khẩu mới và nhập lại mật khẩu mới
	if(nhapLaiMatKhauMoi.value !== matKhauMoi.value){ // hai mật khẩu khác nhau
		check = true ;
		nhapLaiMatKhauMoiError.style.display = "block" ;
		nhapLaiMatKhauMoiError.innerHTML = "Mật khẩu nhập lại không khớp với mật khẩu mới"
	}
	
	// Xác nhận có lỗi hay không
	if(check){
		// ngăn chặn sự kiện submit của form
		e.preventDefault() ;
	}
	// nếu không có lỗi thì form vẫn submit như thường
	
});