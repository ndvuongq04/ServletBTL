package database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TheLoai;

public class TheLoaiDAO implements DAOInterface<TheLoai>{
	
	public static TheLoaiDAO getDoiTuong() {
		return new  TheLoaiDAO() ;
	}

	@Override
	public int insert(TheLoai t) {
		int kq = 0 ;
		try {
			Connection con = Jdbc.getConnection() ;
			String sql = "insert into the_loai (maTheLoai , tenTheLoai) "
					+ " values (? , ? ); " ;
			PreparedStatement pst = con.prepareStatement(sql) ;
			
			pst.setString(1, t.getMaTheLoai());
			pst.setString(2, t.getTenTheLoai());
			
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
	public int update(TheLoai t) {
		int kq = 0 ;
		try {
			Connection con = Jdbc.getConnection() ;
			String sql = "update the_loai "
					+ " set tenTheLoai = ?  "
					+ " Where maTheLoai = ? ;" ;
			PreparedStatement pst = con.prepareStatement(sql) ;
			pst.setString(1 , t.getTenTheLoai()) ;
			pst.setString(2 , t.getMaTheLoai()) ;
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
	public int delete(TheLoai t) {
		int kq = 0 ;
		try {
			Connection con = Jdbc.getConnection() ;
			String sql = "delete from  the_loai "
					+ " where maTheLoai = ? ; " ;
			PreparedStatement pst = con.prepareStatement(sql) ;
			pst.setString(1 , t.getMaTheLoai()) ;
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
	public ArrayList<TheLoai> selectAll() {
		ArrayList<TheLoai> kq = new ArrayList<TheLoai>() ;
		try {
			Connection con = Jdbc.getConnection() ;
			String sql = "select * from the_loai ;" ;
			PreparedStatement pst = con.prepareStatement(sql) ;
			
			ResultSet rs  = pst.executeQuery() ; // lưu list kq 
			while(rs.next()) {
				TheLoai temp = new TheLoai() ; // add list kq vào đây 
				temp.setMaTheLoai(rs.getString("maTheLoai"));
				temp.setTenTheLoai(rs.getString("tenTheLoai"));
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
	public TheLoai selectById(TheLoai t) {
		TheLoai  kq = new TheLoai() ;
		try {
			Connection con = Jdbc.getConnection() ;
			String sql = "select * from the_loai where maTheLoai = ? ;" ;
			PreparedStatement pst = con.prepareStatement(sql) ;
			pst.setString(1 , t.getMaTheLoai()) ;
			ResultSet rs = pst.executeQuery() ;
			if(rs.next()) {
				kq.setMaTheLoai(rs.getString("maTheLoai"));
				kq.setTenTheLoai(rs.getString("tenTheLoai"));
			}
			Jdbc.ColseConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return kq;
	}

}
