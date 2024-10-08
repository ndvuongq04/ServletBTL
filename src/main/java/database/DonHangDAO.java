package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DonHang;
import model.KhachHang;
import model.Sach;
import model.TacGia;
import model.TheLoai;

public class DonHangDAO implements DAOInterface<DonHang> {
	public static DonHangDAO getDoiTuong () {
		return new DonHangDAO() ;
	}

	@Override
	public int insert(DonHang t) {
		int kq = 0 ;
		try {
			Connection con = Jdbc.getConnection() ;
			String sql = "insert into don_hang (maDonHang ,maKhachHang , diaChiNguoiMua , diaChiNguoiNhan , trangThai , hinhThucThanhToan , soTienThanhToan , soTienConThieu , ngayDatHang , ngayGiaoHang ) "
					+ " values (? ,? ,?,?,?,?,?,?,?,?)" ;
			PreparedStatement pst = con.prepareStatement(sql) ;
			
			pst.setString(1, t.getMaDonHang());
			pst.setString(2, t.getKhachHang().getmaKhachHang());
			pst.setString(3, t.getDiaChiNguoiMua());
			pst.setString(4, t.getDiaChiNguoiNhan());
			pst.setString(5, t.getTrangThai());
			pst.setString(6, t.getHinhThucThanhToan());
			pst.setDouble(7, t.getSoTienThanhToan());
			pst.setDouble(8, t.getSoTienConThieu());
			pst.setDate(9, (Date) t.getNgayDatHang());
			pst.setDate(10, (Date)t.getNgayGiaoHang());
			
			kq = pst.executeUpdate() ;
			System.out.println(sql );
			System.out.println("So dong bi thay doi " + kq );
			
			Jdbc.ColseConnection(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}

	@Override
	public int update(DonHang t) {
		int kq = 0 ;
		try {
			Connection con = Jdbc.getConnection() ;
			String sql = "update don_hang "
					+ " set maKhachHang = ?,"
					+ " diaChiNguoiMua = ?, "
					+ " diaChiNguoiNhan = ?,"
					+ " trangThai = ?,"
					+ " hinhThucThanhToan = ?,"
					+ " soTienThanhToan = ?,"
					+ " soTienConThieu = ?,"
					+ " ngayDatHang = ?,"
					+ " ngayGiaoHang = ?"
					+ " Where maDonHang = ? ;" ;
			PreparedStatement pst = con.prepareStatement(sql) ;
			pst.setString(10, t.getMaDonHang());
			pst.setString(1, t.getKhachHang().getmaKhachHang());
			pst.setString(2, t.getDiaChiNguoiMua());
			pst.setString(3, t.getDiaChiNguoiNhan());
			pst.setString(4, t.getTrangThai());
			pst.setString(5, t.getHinhThucThanhToan());
			pst.setDouble(6, t.getSoTienThanhToan());
			pst.setDouble(7, t.getSoTienConThieu());
			pst.setDate(8, (Date) t.getNgayDatHang());
			pst.setDate(9, (Date)t.getNgayGiaoHang());
			kq = pst.executeUpdate() ;
			System.out.println(sql );
			System.out.println("So dong bi thay doi " + kq );
			Jdbc.ColseConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int delete(DonHang t) {
		int kq = 0 ;
		try {
			Connection con = Jdbc.getConnection() ;
			String sql = "delete from  don_hang "
					+ " where maDonHang = ? ; " ;
			PreparedStatement pst = con.prepareStatement(sql) ;
			pst.setString(1, t.getMaDonHang());
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
	public ArrayList<DonHang> selectAll() {
		ArrayList<DonHang> kq = new ArrayList<DonHang>() ;
		try {
			Connection con = Jdbc.getConnection() ;
			String sql = "select * from don_hang ;" ;
			PreparedStatement pst = con.prepareStatement(sql) ;
			
			ResultSet rs  = pst.executeQuery() ; // lưu list kq 
			while(rs.next()) {
				DonHang temp = new DonHang() ; // add list kq vào đây 
				temp.setMaDonHang(rs.getString("maDonHang"));
				KhachHang kh = KhachHangDAO.getDoiTuong().selectById(new KhachHang(rs.getString("maKhachHang"), null , null , null , null , null, null , null, null, null, null, 1 ));
				temp.setKhachHang(kh);
				temp.setDiaChiNguoiMua(rs.getString("diaChiNguoiMua"));
				temp.setDiaChiNguoiNhan(rs.getString("diaChiNguoiNhan"));
				temp.setTrangThai(rs.getString("trangThai"));
				temp.setHinhThucThanhToan(rs.getString("hinhThucThanhToan"));
				temp.setSoTienThanhToan(rs.getDouble("soTienThanhToan"));
				temp.setSoTienConThieu(rs.getDouble("soTienConThieu"));
				temp.setNgayDatHang(rs.getDate("ngayDatHang"));
				temp.setNgayGiaoHang(rs.getDate("ngayGiaoHang"));
				
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
	public DonHang selectById(DonHang t) {
		DonHang kq = new DonHang() ;
		try {
			Connection con = Jdbc.getConnection() ;
			String sql = "select * from don_hang where maDonHang = ? ;" ;
			PreparedStatement pst = con.prepareStatement(sql) ;
			pst.setString(1, t.getMaDonHang());
			
			ResultSet rs  = pst.executeQuery() ; // lưu list kq 
			while(rs.next()) {
				DonHang temp = new DonHang() ; // add list kq vào đây 
				temp.setMaDonHang(rs.getString("maDonHang"));
				KhachHang kh = KhachHangDAO.getDoiTuong().selectById(new KhachHang(rs.getString("maKhachHang"), null , null , null , null , null, null , null, null, null, null, 1 ));
				temp.setKhachHang(kh);
				temp.setDiaChiNguoiMua(rs.getString("diaChiNguoiMua"));
				temp.setDiaChiNguoiNhan(rs.getString("diaChiNguoiNhan"));
				temp.setTrangThai(rs.getString("trangThai"));
				temp.setHinhThucThanhToan(rs.getString("hinhThucThanhToan"));
				temp.setSoTienThanhToan(rs.getDouble("soTienThanhToan"));
				temp.setSoTienConThieu(rs.getDouble("soTienConThieu"));
				temp.setNgayDatHang(rs.getDate("ngayDatHang"));
				temp.setNgayGiaoHang(rs.getDate("ngayGiaoHang"));
				
				kq= temp ;
			}
			Jdbc.ColseConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kq;
	}

}
