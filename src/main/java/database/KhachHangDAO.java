package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.KhachHang;
import model.Sach;
import model.TacGia;
import model.TheLoai;


public class KhachHangDAO implements DAOInterface<KhachHang> {
	public static KhachHangDAO getDoiTuong() {
		return new  KhachHangDAO() ;
	}
	@Override
	public int insert(KhachHang t) {
		int kq = 0 ;
		try {
			Connection con = Jdbc.getConnection() ;
//			if (con != null) {
//			    System.out.println("Kết nối thành công!");
//			}
			String sql = "insert into khach_hang (maKhachHang , tenDangNhap , matKhau , hoVaTen , gioiTinh , diaChi , diaChiNhanHang , diaChiMuaHang , ngaySinh , soDienThoai , email, checkEmail ) "
					+ " values (? ,? ,?,?,?,?,?,?,?,?,?,?)" ;
			PreparedStatement pst = con.prepareStatement(sql) ;
			
			pst.setString(1, t.getmaKhachHang());
			pst.setString(2, t.getTenDangNhap());
			pst.setString(3, t.getMatKhau());
			pst.setString(4, t.getHoVaTen());
			pst.setString(5, t.getGioiTinh());
			pst.setString(6, t.getDiaChi());
			pst.setString(7, t.getDiaChiNhanHang());
			pst.setString(8, t.getDiaChiMauHang());
			pst.setDate(9, (Date) t.getNgaySinh());
			pst.setString(10, t.getSoDienThoai());
			pst.setString(11, t.getEmail());
			pst.setInt(12, t.getCheckEmail());
			
			kq = pst.executeUpdate() ;
//			System.out.println(sql );
//			System.out.println("So dong bi thay doi " + kq );
//			
			Jdbc.ColseConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}

	@Override
	public int update(KhachHang t) {
		int kq = 0 ;
		try {
//maKhachHang , tenDangNhap , matKhau , hoVaTen , gioiTinh , diaChi , diaChiNhanHang , diaChiMuaHang , ngaySinh , soDienThoai , email, checkEmail 
			Connection con = Jdbc.getConnection() ;
			String sql = "update khach_hang "
					+ " set tenDangNhap = ?,"
					+ " matKhau = ?, "
					+ " hoVaTen = ?,"
					+ " gioiTinh = ?,"
					+ " diaChi = ?,"
					+ " diaChiNhanHang = ?,"
					+ " diaChiMuaHang = ?,"
					+ " ngaySinh = ?,"
					+ " soDienThoai = ?,"
					+ " email = ?,"
					+ " checkEmail = ? "
					+ " Where maKhachHang = ? ;" ;
			PreparedStatement pst = con.prepareStatement(sql) ;
			pst.setString(12, t.getmaKhachHang());
			pst.setString(1, t.getTenDangNhap());
			pst.setString(2, t.getMatKhau());
			pst.setString(3, t.getHoVaTen());
			pst.setString(4, t.getGioiTinh());
			pst.setString(5, t.getDiaChi());
			pst.setString(6, t.getDiaChiNhanHang());
			pst.setString(7, t.getDiaChiMauHang());
			pst.setDate(8, (Date) t.getNgaySinh());
			pst.setString(9, t.getSoDienThoai());
			pst.setString(10, t.getEmail());
			pst.setInt(11, t.getCheckEmail());
			kq = pst.executeUpdate() ;
			System.out.println(sql );
			System.out.println("So dong bi thay doi " + kq );
			Jdbc.ColseConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kq;
	}

	@Override
	public int delete(KhachHang t) {
		int kq = 0 ;
		try {
			Connection con = Jdbc.getConnection() ;
			String sql = "delete from  khach_hang "
					+ " where maKhachHang = ? ; " ;
			PreparedStatement pst = con.prepareStatement(sql) ;
			pst.setString(1, t.getmaKhachHang());
			kq = pst.executeUpdate();
			Jdbc.ColseConnection(con);
			System.out.println(sql );
			System.out.println("So dong bi thay doi " + kq );
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<KhachHang> selectAll() {
		ArrayList<KhachHang> kq = new ArrayList<KhachHang>() ;
		try {
			Connection con = Jdbc.getConnection() ;
			String sql = "select * from khach_hang ;" ;
			PreparedStatement pst = con.prepareStatement(sql) ;
			
			ResultSet rs  = pst.executeQuery() ; // lưu list kq 
			while(rs.next()) {
//maKhachHang , tenDangNhap , matKhau , hoVaTen , gioiTinh , diaChi , diaChiNhanHang , diaChiMuaHang , ngaySinh , soDienThoai , email, checkEmail 
				KhachHang temp = new KhachHang() ; // add list kq vào đây 
				temp.setmaKhachHang(rs.getString("maKhachHang"));
				temp.setTenDangNhap(rs.getString("tenDangNhap"));
				temp.setMatKhau(rs.getString("matKhau"));
				temp.setHoVaTen(rs.getString("hoVaTen"));
				temp.setGioiTinh(rs.getString("gioiTinh"));
				temp.setDiaChi(rs.getString("diaChi"));
				temp.setDiaChiNhanHang(rs.getString("diaChiNhanHang"));
				temp.setDiaChiMauHang(rs.getString("diaChiMuaHang"));
				temp.setNgaySinh(rs.getDate("ngaySinh"));
				temp.setSoDienThoai(rs.getString("soDienThoai"));
				temp.setEmail(rs.getString("email"));
				temp.setCheckEmail(rs.getInt("checkEmail"));
				
				kq.add(temp) ;
			}
			Jdbc.ColseConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kq;
	}

	@Override
	public KhachHang selectById(KhachHang t) {
		KhachHang kq = new KhachHang() ;
		try {
			Connection con = Jdbc.getConnection() ;
			String sql = "select * from khach_hang where maKhachHang = ? ;" ;
			PreparedStatement pst = con.prepareStatement(sql) ;
			pst.setString(1, t.getmaKhachHang());
			
			ResultSet rs  = pst.executeQuery() ; // lưu list kq 
			while(rs.next()) {
				KhachHang temp = new KhachHang() ; // add list kq vào đây 
				temp.setmaKhachHang(rs.getString("maKhachHang"));
				temp.setTenDangNhap(rs.getString("tenDangNhap"));
				temp.setMatKhau(rs.getString("matKhau"));
				temp.setHoVaTen(rs.getString("hoVaTen"));
				temp.setGioiTinh(rs.getString("gioiTinh"));
				temp.setDiaChi(rs.getString("diaChi"));
				temp.setDiaChiNhanHang(rs.getString("diaChiNhanHang"));
				temp.setDiaChiMauHang(rs.getString("diaChiMuaHang"));
				temp.setNgaySinh(rs.getDate("ngaySinh"));
				temp.setSoDienThoai(rs.getString("soDienThoai"));
				temp.setEmail(rs.getString("email"));
				temp.setCheckEmail(rs.getInt("checkEmail"));
				kq = temp ;
			}
			Jdbc.ColseConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kq;
	}
	
	public boolean kiemTraTenDangNhap( String checkTenDangNhap ) { // checkTenDangNhap là tenDangNhap mà người dùng nhập ở form đăng ký
		boolean kq = false ;
		try {
			Connection con = Jdbc.getConnection() ;
			String sql = "SELECT COUNT(*) FROM khach_hang WHERE tenDangNhap = ?";
			PreparedStatement pst = con.prepareStatement(sql) ;
			
			pst.setString(1, checkTenDangNhap ); // truyền checkTenDangNhap vào câu lệnh sql -> xuống database kiểm tra 

			ResultSet st = pst.executeQuery() ; // trả về list các đối tượng 
			
			st = pst.executeQuery();
			if (st.next()) {
			    kq = st.getInt(1) > 0; // Nếu có ít nhất 1 bản ghi, trả về true
			}

			
			Jdbc.ColseConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kq  ;
		
	}
	
	public KhachHang selectByUsernameAndPassWord(KhachHang t) {
		KhachHang ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = Jdbc.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM khach_hang WHERE tenDangNhap=? and matKhau=?";
			PreparedStatement st = con.prepareStatement(sql);
//			System.out.println(t.getTenDangNhap()+"/"+t.getMatKhau());
			st.setString(1, t.getTenDangNhap());
			st.setString(2, t.getMatKhau());
			

			// Bước 3: thực thi câu lệnh SQL
//			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:
			while (rs.next()) {
				KhachHang temp = new KhachHang() ; // add list kq vào đây 
				temp.setmaKhachHang(rs.getString("maKhachHang"));
				temp.setTenDangNhap(rs.getString("tenDangNhap"));
				temp.setMatKhau(rs.getString("matKhau"));
				temp.setHoVaTen(rs.getString("hoVaTen"));
				temp.setGioiTinh(rs.getString("gioiTinh"));
				temp.setDiaChi(rs.getString("diaChi"));
				temp.setDiaChiNhanHang(rs.getString("diaChiNhanHang"));
				temp.setDiaChiMauHang(rs.getString("diaChiMuaHang"));
				temp.setNgaySinh(rs.getDate("ngaySinh"));
				temp.setSoDienThoai(rs.getString("soDienThoai"));
				temp.setEmail(rs.getString("email"));
				temp.setCheckEmail(rs.getInt("checkEmail"));
				ketQua = temp ;
			}

			// Bước 5:
			Jdbc.ColseConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	
	
	public boolean updatePassword(KhachHang t) {
		int kq = 0 ;
		try {
			//maKhachHang , tenDangNhap , matKhau , hoVaTen , gioiTinh , diaChi , diaChiNhanHang , diaChiMuaHang , ngaySinh , soDienThoai , email, checkEmail 
			Connection con = Jdbc.getConnection() ;
			String sql = "update khach_hang "
					+ " set matKhau = ? "
					+ " Where maKhachHang = ? ;" ;
			PreparedStatement pst = con.prepareStatement(sql) ;
			
			pst.setString(1, t.getMatKhau());
			pst.setString(2, t.getmaKhachHang());
			kq = pst.executeUpdate() ;
			System.out.println(sql );
			System.out.println("So dong bi thay doi " + kq );
			Jdbc.ColseConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kq>0 ;
	}
	
	public KhachHang selectByTenDangNhap(String t) {
		KhachHang kq = new KhachHang() ;
		try {
			Connection con = Jdbc.getConnection() ;
			String sql = "select * from khach_hang where tenDangNhap = ? ;" ;
			PreparedStatement pst = con.prepareStatement(sql) ;
			pst.setString(1, t);
			
			ResultSet rs  = pst.executeQuery() ; // lưu list kq 
			while(rs.next()) {
				KhachHang temp = new KhachHang() ; // add list kq vào đây 
				temp.setmaKhachHang(rs.getString("maKhachHang"));
				temp.setTenDangNhap(rs.getString("tenDangNhap"));
				temp.setMatKhau(rs.getString("matKhau"));
				temp.setHoVaTen(rs.getString("hoVaTen"));
				temp.setGioiTinh(rs.getString("gioiTinh"));
				temp.setDiaChi(rs.getString("diaChi"));
				temp.setDiaChiNhanHang(rs.getString("diaChiNhanHang"));
				temp.setDiaChiMauHang(rs.getString("diaChiMuaHang"));
				temp.setNgaySinh(rs.getDate("ngaySinh"));
				temp.setSoDienThoai(rs.getString("soDienThoai"));
				temp.setEmail(rs.getString("email"));
				temp.setCheckEmail(rs.getInt("checkEmail"));
				kq = temp ;
			}
			Jdbc.ColseConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kq;
	}

}
