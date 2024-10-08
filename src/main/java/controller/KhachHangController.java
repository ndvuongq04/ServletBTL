package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.KhachHang;

import java.io.IOException;
import java.sql.Date;
import java.util.Random;

import database.KhachHangDAO;

/**
 * Servlet implementation class KhachHang
 */
public class KhachHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KhachHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String hanhDong = request.getParameter("hanhDong");
		if (hanhDong.equals("dang-nhap")) {
			DangNhap(request, response);
		} else if (hanhDong.equals("dang-xuat")) {
			DangXuat(request, response);
		} else if (hanhDong.equals("dang-ky")) {
			DangKy(request, response);
		} else if (hanhDong.equals("doi-mat-khau")) {
			DoiMatKhau(request, response);
		}else if (hanhDong.equals("thay-doi-thong-tin")) {
			ThayDoiThongTinKH(request, response);
		}
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void ThayDoiThongTinKH (HttpServletRequest request, HttpServletResponse response ) {
		try {
			//	 	KHÁCH HÀNG CHƯA ĐĂNG NHẬP VÀO WEB
			/*
			 * - Khách hang chưa đăng nhập , cố tính gõ ThayDoiThongTinKH lên url
			 * -> Lỗi 500 , lỗi rỏ rỉ dữ liệu
			 * -> Bắt lỗi : 
			 * 	- Tạo 1 Đối tượng lưu giá trị của session ( người dùng hiện tại có được lưu dưới session )
							-> null : là chưa được lưu -> chưa đăng nhập vào website
							-> !null : ___________
						- Tạo 1 thông báo và đường link chuyển sang trang DangNhap.jsp
			 * */
			HttpSession session = request.getSession(false) ;
			if(session == null || session.getAttribute("khachHang")== null) {
				// chuyển trang
				String url = "/Trang/DangNhap.jsp" ;
				System.out.println("NGƯỜI DÙNG CHƯA ĐĂNG NHẬP VÀO Website ");
				System.out.println("URL cuối trang ThongTinKhachHang.java = " + url );
				RequestDispatcher rq = request.getRequestDispatcher(url);
				rq.forward(request, response) ;
				return ;
				
			}else {
				// KHÁCH HÀNG ĐÃ ĐĂNG NHẬP VÀO WEB
					/*
					 * - khi khách hàng đăng nhập vào hệ thống -> thông tin khách hàng đã được lưu vào session
					 * -> Dùng session đê lấy ra thông tin khách hàng ->
					 * 	-> chuyển lên trang .jsp
					 *  -> lấy thông tin ra và lưu vào database
					 *  
					 * */
				
				// Lấy thông tin khachHang từ session về 
				KhachHang kHTemp = (KhachHang) session.getAttribute("khachHang") ;
				String error = "" ;

				// Xác nhận dữ liệu 
				if(kHTemp != null) {
					// Lưu lại thông tin khách hàng
					request.setAttribute("hoVaTen", kHTemp.getHoVaTen()) ;
					request.setAttribute("ngaySinh", kHTemp.getNgaySinh()) ;
					request.setAttribute("gioiTinh", kHTemp.getGioiTinh()) ;
					request.setAttribute("diaChi", kHTemp.getDiaChi()) ;
					request.setAttribute("diaChiNhanHang", kHTemp.getDiaChiNhanHang()) ;
					request.setAttribute("diaChiMauHang", kHTemp.getDiaChiMauHang()) ;
					request.setAttribute("soDienThoai", kHTemp.getSoDienThoai()) ;
					
					// Cập nhật thông tin khách hàng vừa sửa xuống database
					
					// Dùng session để lấy ( vì không cho khách hàng các mấy thông tin này 
					String maKhachHang = kHTemp.getmaKhachHang() ;
					String tenDangNhap = kHTemp.getTenDangNhap();
					String matKhau =   kHTemp.getMatKhau();
					String email = kHTemp.getEmail()  ;
					
					// Thong tin khách hàng vừa nhập vào 
					String hoVaTen = request.getParameter("hoVaTen")   ;
					String ngaySinh =  request.getParameter("ngaySinh")   ;
					String gioiTinh = request.getParameter("gioiTinh")  ;
					String diaChi = request.getParameter("diaChi")  ;
					String diaChiNhanHang = request.getParameter("diaChiNhanHang")  ;
					String diaChiMauHang = request.getParameter("diaChiMauHang")  ;
					String soDienThoai = request.getParameter("soDienThoai")  ;
					
					KhachHang kh = new KhachHang(maKhachHang , tenDangNhap , matKhau , hoVaTen , gioiTinh , diaChi , diaChiNhanHang , diaChiMauHang , Date.valueOf(ngaySinh) , soDienThoai , email, 1 );
					// Kiểm tra cập nhật thông tin khách hàng
					if(KhachHangDAO.getDoiTuong().update(kh) > 0 ) {
						System.out.println("CẬP NHẬT THÔNG TIN THÀNH CÔNG !");
						// Cập nhật lại thông tin cho khách hàng -> để hiển thị lên form
						KhachHang kh2 = KhachHangDAO.getDoiTuong().selectById(kh);
						request.getSession().setAttribute("khachHang", kh2);
						RequestDispatcher rq = request.getRequestDispatcher("/Trang/ThongBaoCapNhapThongTin.jsp");
						rq.forward(request, response) ;
						return ;
						
					}else {
						error = "Không cập nhật được thông tin !" ;
						System.out.println("LỖI CẬP NHẬT THONG TIN XUỐNG DATABASE");
					}
				}else {
					error = "Không cập nhật được thông tin !" ;
					System.out.println("LỖI session null ");
				}
				
				// Lưu lại lỗi
				request.setAttribute("error", error) ;
				
				// Chuyển trang
				RequestDispatcher rq = request.getRequestDispatcher("/Trang/ThayDoiThongTinKH.jsp");
				rq.forward(request, response) ;
				
			}
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void DoiMatKhau (HttpServletRequest request, HttpServletResponse response ) {
		try {
			// Khởi tạo phiên mới nếu không có
			HttpSession session = request.getSession(false) ; // Lấy phiên đăng nhập hiện tại
			
			// NGƯỜI DÙNG CHƯA ĐĂNG NHẬP 
			/* ( truy cập bằng cách gõ url : http://localhost:8080/website_banHang/controller/DoiMatKhau )
				-> Nếu không bắt lỗi này thì nó sẽ hiện lỗi 500
				-> Quy trình bắt lỗi :
					- session: tham chiếu đến một đối tượng đang làm việc với Website
						-> null : nghĩa là hiện tại không có phiên làm việc nào
						-> !null : ____
					- session.getAttribute("khachHang") :
					-> khi đăng nhập thì sẽ lưu phiên làm việc của khách hàng xuống session
						-> null : chưa đăng nhập vì thong tin khách hàng chưa được lưu vào session
						-> !null : __________
				-> Bắt lỗi :
					- Nếu người dùng chưa đăng nhập -> chuyển về trang DangNhap.jsp 
				
			 */	
			if( session == null || session.getAttribute("khachHang") == null) {
				// Thông báo lên console
				System.out.println("NGƯỜI DÙNG CHƯA ĐĂNG NHẬP");
				System.out.println("URL cuối trang DoiMatKhau.java = " + "/Trang/DangNhap.jsp");
				RequestDispatcher rq = request.getRequestDispatcher("/Trang/DangNhap.jsp") ;
				rq.forward(request, response) ;
				// Thoát khỏi phương thức này
				return ;
			}
			// NGƯỜI DÙNG ĐÃ ĐĂNG NHẬP 
			KhachHang khachHangTemp = (KhachHang)session.getAttribute("khachHang") ; // Vì đã đăng nhập rồi -> đã lưu thông tin khác hàng vào session -> có thể lấy ra
			
			// Lấy các thành phần về
			String matKhauMoi = request.getParameter("matKhauMoi") ;
			String matKhauHienTai = request.getParameter("matKhauHienTai") ;
			
			// Tạo lỗi để lưu
			String matKhauHienTaiError = "" ;
			String capNhatMatKhauError = "" ;
			
			// Kiểm tra mật khẩu hiện tại
			if(matKhauHienTai.equals(khachHangTemp.getMatKhau()) ) { // Đúng
				System.out.println("MẬT KHẨU HIỆN TẠI ĐÚNG ");
				// Lưu mật khẩu mới vào đối tượng khachHangTemp
				khachHangTemp.setMatKhau(matKhauMoi) ;
				// Tạo đôi tượng khách hang DAO
				KhachHangDAO khDAO = new KhachHangDAO() ;
				
				// Kiểm tra cập nhật khẩu
				if(khDAO.updatePassword(khachHangTemp) ) {
					// Đổi mật khẩu thành công
					System.out.println("CẬP NHẬT MẬT KHẨU THÀNH CÔNG ");
					System.out.println("URL cuối trang DoiMatKhau.java = " + "/Trang/DangNhap.jsp");
					RequestDispatcher rq = request.getRequestDispatcher("/Trang/DangNhap.jsp") ;
					rq.forward(request, response) ;
					return ;
					
				}
				else {
					capNhatMatKhauError = "Cập nhật mật khẩu không thành công !" ;
					System.out.println("CẬP NHẬT MẬT KHẨU KHÔNG THÀNH CÔNG ");
				}
			}else {
				matKhauHienTaiError = "Mật khẩu hiện tại chưa đúng !" ;
				System.out.println("MẬT KHẨU HIỆN TẠI KHÔNG ĐÚNG ");
			}
			
			// Lưu lại lỗi
			request.setAttribute("matKhauHienTaiError", matKhauHienTaiError) ;
			request.setAttribute("capNhatMatKhauError", capNhatMatKhauError) ;
			
			// Đổi mật khẩu không thành công
			RequestDispatcher rq = request.getRequestDispatcher("/Trang/DoiMatKhau.jsp") ;
			rq.forward(request, response) ;
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void DangXuat (HttpServletRequest request, HttpServletResponse response ) {
		try {
			HttpSession session = request.getSession() ; // tạo 1 đối tương session
			// hủy bỏ session
			session.invalidate();
			
			// url 
			
			String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
			System.out.println("ĐĂNG XUẤT THÀNH CÔNG ");
			url = url + "/Trang/index.jsp" ;
			System.out.println("URL Ở CUỐI TRANG DangXuat.java = " + url);
			response.sendRedirect(url) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void DangNhap (HttpServletRequest request, HttpServletResponse response ) {
		try {
			// lấy các thuộc tính của form
			String tenDangNhap = request.getParameter("tenDangNhap") ;
			String matKhau = request.getParameter("matKhau") ;
			
			
			// url
			String url = "/Trang/DangNhap.jsp" ;
			
			// Lỗi có thể gặp
			String errorTenDangNhap = "" ;
			String errorMatKhau = "" ;
			
			KhachHangDAO khachHangDAO = new KhachHangDAO() ;
			KhachHang kH = new KhachHang() ;
			kH.setTenDangNhap(tenDangNhap) ;
			kH.setMatKhau(matKhau) ;
			
			
			KhachHang khachHang = khachHangDAO.selectByUsernameAndPassWord(kH) ;
			if(khachHang != null ) { // thông tin đăng nhập đúng
				// taoj 1 đối tượng session
				HttpSession session = request.getSession() ; 
				// lưu đối tượng khách hàng vào session
				session.setAttribute("khachHang", khachHang) ;
				System.out.println("ĐĂNG NHẬP THÀNH CÔNG !");
				url = "/Trang/index.jsp" ;
			}else {
				
				// khi khong có tenDangNhap trong database -> sẽ vào đây
					errorTenDangNhap = "Tên đăng nhập bị sai !";
					// khi khong có matKhau trong database -> sẽ vào đây
					errorMatKhau = "Mật khẩu bị sai !";
					System.out.println("ĐĂNG NHẬP KHÔNG THÀNH CÔNG !");
					System.out.println("DangNhap-> " + errorTenDangNhap);
					System.out.println("DangNhap-> " + errorMatKhau);
			}
			
			
			// Lưu lại lỗi
			request.setAttribute("errorTenDangNhap", errorTenDangNhap);
			request.setAttribute("errorMatKhau", errorMatKhau);
			
			
			RequestDispatcher rd = request.getRequestDispatcher(url) ;
			System.out.println("url ở cuối trang DangNhap.jsp = " + url);
			rd.forward(request, response) ;
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void DangKy (HttpServletRequest request, HttpServletResponse response ) {
		try {
			String hoVaTen = request.getParameter("hoVaTen") ;
			String tenDangNhap = request.getParameter("tenDangNhap") ;
			String email = request.getParameter("email") ;
			String matKhau = request.getParameter("matKhau") ;
			String gioiTinh = request.getParameter("gioiTinh");
			
			
			// Thông tin lỗi
			String errorTenDangNhap = "" ;
			String errorDangKy = "" ;
			
			// url
			String url = "/Trang/DangKy.jsp"  ;
			
			
			
			
			if ((hoVaTen == null || hoVaTen.isEmpty()) &&
				    (tenDangNhap == null || tenDangNhap.isEmpty()) &&
				    (email == null || email.isEmpty()) &&
				    (gioiTinh == null || gioiTinh.isEmpty()) &&
				    (matKhau == null || matKhau.isEmpty())
			){		
					System.out.println("ĐÃ KÝ TÀI KHOẢN THÀNH CÔNG ! ");
				    errorDangKy = "Vui lòng nhập thông tin trước khi tải lại trang!";
				    request.setAttribute("errorDangKy", errorDangKy);
				}

			else {
				KhachHangDAO khachHangDAO = new KhachHangDAO() ;
				if(khachHangDAO.kiemTraTenDangNhap(tenDangNhap)) {
					errorTenDangNhap = "Tên đăng nhập đã tồn tại !" ;
					System.out.println("ĐÃ KÝ TÀI KHOẢN KHÔNG THÀNH CÔNG ! ");
					System.out.println("TÊN ĐĂNG NHẬP ĐÃ TỒN TẠI ");
					// giữ lại lỗi -> hiển thị lên form đăng ký 
					request.setAttribute("errorTenDangNhap", errorTenDangNhap) ;
				}else {
					// tao maKhacHang ngẫu nhiên
					Random rd = new Random() ;
					String maKhachHang = System.currentTimeMillis() + rd.nextInt(1000) + "" ; // giờ hiện tại của máy tính + số ranDum
					//maKhachHang , tenDangNhap , matKhau , hoVaTen , gioiTinh , diaChi , diaChiNhanHang , diaChiMuaHang , ngaySinh , soDienThoai , email, checkEmail 
			
					KhachHang khachHangMoi = new KhachHang (maKhachHang , tenDangNhap , matKhau , hoVaTen , gioiTinh , null , null , null , null , null , email, 1 ) ;
					
					khachHangDAO.insert(khachHangMoi) ;
					System.out.println("ĐÃ KÝ TÀI KHOẢN THÀNH CÔNG ! ");
					url = "/Trang/DangNhap.jsp" ;
				}
				RequestDispatcher rd = request.getRequestDispatcher(url) ;
				System.out.println("URL Ở CUỐI TRANG DangKy.java = " + url );
				rd.forward(request, response) ;
			}
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
