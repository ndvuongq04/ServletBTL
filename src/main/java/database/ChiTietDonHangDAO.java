package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ChiTietDonHang;
import model.DonHang;
import model.KhachHang;
import model.Sach;


public class ChiTietDonHangDAO implements DAOInterface<ChiTietDonHang> {
	public static ChiTietDonHangDAO getDoiTuong () {
		return new ChiTietDonHangDAO() ;
	}

	@Override
	public int insert(ChiTietDonHang t) {
		int kq = 0 ;
		try {
			Connection con = Jdbc.getConnection() ;
			String sql = "insert into chi_tiet_don_hang (maChiTietDonHang , maDonHang , maSach , soLuong , giaBan , giaBia , giamGia , thueVAT , thanhTien) "
					+ " values (? ,? ,?,?,?,?,?,?,?) ;" ;
			PreparedStatement pst = con.prepareStatement(sql) ;
			
			pst.setString(1, t.getMaChiTietDonHang());
			pst.setString(2, t.getDonHang().getMaDonHang());
			pst.setString(3, t.getsach().getMaSach());
			pst.setDouble(4, t.getSoLuong());
			pst.setDouble(6, t.getGiaBia());
			pst.setDouble(5, t.getGiaBan());
			pst.setDouble(7, t.getGiamGia());
			pst.setDouble(8, t.getthueVAT());
			pst.setDouble(9, t.getTongThanhTien());
			
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
	public int update(ChiTietDonHang t) {
		int kq = 0 ;
		try {
			Connection con = Jdbc.getConnection() ;
			String sql = "UPDATE chi_tiet_don_hang "
					+ "SET maDonHang = ?, "
					+ "    maSach = ?, "
					+ "    soLuong = ?, "
					+ "    giaBan = ?, "
					+ "    giaBia = ?, "
					+ "    giamGia = ?, "
					+ "    thueVAT = ?, "
					+ "    thanhTien = ? "
					+ "WHERE maChiTietDonHang = ?; " ;
;
			PreparedStatement pst = con.prepareStatement(sql) ;
			pst.setString(9, t.getMaChiTietDonHang());
			pst.setString(1, t.getDonHang().getMaDonHang());
			pst.setString(2, t.getsach().getMaSach());
			pst.setDouble(3, t.getSoLuong());
			pst.setDouble(4, t.getGiaBia());
			pst.setDouble(5, t.getGiaBan());
			pst.setDouble(6, t.getGiamGia());
			pst.setDouble(7, t.getthueVAT());
			pst.setDouble(8, t.getTongThanhTien());
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
	public int delete(ChiTietDonHang t) {
		int kq = 0 ;
		try {
			Connection con = Jdbc.getConnection() ;
			String sql = "delete from  chi_tiet_don_hang " 
					+ " where maChiTietDonHang = ? ; " ;
			PreparedStatement pst = con.prepareStatement(sql) ;
			pst.setString(1, t.getMaChiTietDonHang());
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
	public ArrayList<ChiTietDonHang> selectAll() {
		ArrayList<ChiTietDonHang> kq = new ArrayList<ChiTietDonHang>() ;
		try {
			Connection con = Jdbc.getConnection() ;
			String sql = "select * from chi_tiet_don_hang ;" ;
			PreparedStatement pst = con.prepareStatement(sql) ;
			
			ResultSet rs  = pst.executeQuery() ; // lưu list kq 
			while(rs.next()) {
				ChiTietDonHang temp = new ChiTietDonHang() ; // add list kq vào đây 
				temp.setMaChiTietDonHang(rs.getString("maChiTietDonHang"));
				// don hang
				DonHang dh = DonHangDAO.getDoiTuong().selectById(new DonHang(rs.getString("maDonHang"),null , null , null ,null ,null ,0, 0 , null, null ));
				temp.setDonHang(dh);
				// sach
				Sach sach = SachDAO.getDoiTuong().selectById(new Sach("", "", null, 0, 0, 0, 0, 0, null, "", ""));
				temp.setsach(sach);
				temp.setSoLuong(rs.getDouble("soLuong"));
				temp.setGiaBia(rs.getDouble("giaBia"));
				temp.setGiaBan(rs.getDouble("giaBan"));
				temp.setGiamGia(rs.getDouble("giamGia"));
				temp.setthueVAT(rs.getDouble("thueVAT"));
				temp.setTongThanhTien(rs.getDouble("thanhTien"));
				
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
	public ChiTietDonHang selectById(ChiTietDonHang t) {
		ChiTietDonHang kq = new ChiTietDonHang() ;
		try {
			Connection con = Jdbc.getConnection() ;
			String sql = "select * from chi_tiet_don_hang where maChiTietDonHang = ? ;" ;
			PreparedStatement pst = con.prepareStatement(sql) ;
			pst.setString(1, t.getMaChiTietDonHang());
			ResultSet rs  = pst.executeQuery() ; // lưu list kq 
			while(rs.next()) {
				ChiTietDonHang temp = new ChiTietDonHang() ; // add list kq vào đây 
				temp.setMaChiTietDonHang(rs.getString("maChiTietDonHang"));
				// don hang
				DonHang dh = DonHangDAO.getDoiTuong().selectById(new DonHang(rs.getString("maDonHang"),null , null , null ,null ,null ,0, 0 , null, null ));
				temp.setDonHang(dh);
				// sach
				Sach sach = SachDAO.getDoiTuong().selectById(new Sach("", "", null, 0, 0, 0, 0, 0, null, "", ""));
				temp.setsach(sach);
				temp.setSoLuong(rs.getDouble("soLuong"));
				temp.setGiaBia(rs.getDouble("giaBia"));
				temp.setGiaBan(rs.getDouble("giaBan"));
				temp.setGiamGia(rs.getDouble("giamGia"));
				temp.setthueVAT(rs.getDouble("thueVAT"));
				temp.setTongThanhTien(rs.getDouble("thanhTien"));
				
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
