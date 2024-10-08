/**
 * 
 */
console.log("hello") ;
 //Lấy ra elements của trang
const formDangNhap = document.getElementById("formDangNhap") ;

const tenDangNhapElement = document.getElementById("tenDangNhap") ;
const matKhauElement = document.getElementById("matKhau") ;

// lắng nghe sự kiện của form
formDangNhap.addEventListener("submit", function(e){
	// Biến kiểm tra xem có lỗi hay không
	var check = true ;
	
	
	
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
	if(!matKhauElement.value){ // chưa có dữ liệu
		// hiển thị lỗi
		check = false ;
		matKhauError.style.display = "block" ;	
	}
	else { // có dữ liệu rồi
		// ẩn lỗi
		matKhauError.style.display = "none" ;
	}
	
	if(!check){
		//ngăn chặn sự kiện submit trang khi có lỗi
		e.preventDefault() ;
	}
	// nếu không có lỗi -> check = true -> form vẫn sẽ được submit 
});