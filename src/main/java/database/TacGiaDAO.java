package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TacGia;


public class TacGiaDAO implements DAOInterface<TacGia> {
	public static TacGiaDAO getDoiTuong() {
		return new  TacGiaDAO() ;
	}

	@Override
	public int insert(TacGia t) {
		int kq = 0;
        try {
            Connection con = Jdbc.getConnection();
            String sql = "INSERT INTO tac_gia (maTacGia, hoVaTen, ngaySinh, tieuSu) VALUES (?, ?, ?, ?);";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, t.getMaTacGia());
            pst.setString(2, t.getHoVaTen());
            pst.setDate(3, (Date) t.getNgaySinh());
            pst.setString(4, t.getTieuSu());
            
            kq = pst.executeUpdate();
            System.out.println("SQL Query: " + sql);
            System.out.println("Số dòng thay đổi: " + kq);

            Jdbc.ColseConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
	}

	@Override
	public int update(TacGia t) {
		int kq = 0;
        try {
            Connection con = Jdbc.getConnection();
            String sql = "update tac_gia set hoVaTen = ? , ngaySinh = ? , tieuSu = ? where maTacGia = ?;";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(4, t.getMaTacGia());
            pst.setString(1, t.getHoVaTen());
            pst.setDate(2, (Date) t.getNgaySinh());
            pst.setString(3, t.getTieuSu());
            
            kq = pst.executeUpdate();
            System.out.println("SQL Query: " + sql);
            System.out.println("Số dòng thay đổi: " + kq);

            Jdbc.ColseConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return 0;
	}

	@Override
	public int delete(TacGia t) {
		int kq = 0 ;
		try {
			Connection con = Jdbc.getConnection() ;
			String sql = "delete from  tac_gia "
					+ " where maTacGia = ? ; " ;
			PreparedStatement pst = con.prepareStatement(sql) ;
			pst.setString(1 , t.getMaTacGia()) ;
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
	public ArrayList<TacGia> selectAll() {
		ArrayList<TacGia> kq = new ArrayList<TacGia>() ;
		try {
			Connection con = Jdbc.getConnection() ;
			String sql = "select * from tac_gia ;" ;
			PreparedStatement pst = con.prepareStatement(sql) ;
			
			ResultSet rs  = pst.executeQuery() ; // lưu list kq 
			while(rs.next()) {
				TacGia temp = new TacGia() ; // add list kq vào đây 
				temp.setMaTacGia(rs.getString("maTacGia"));
				temp.setHoVaTen(rs.getString("hoVaTen"));
				temp.setNgaySinh(rs.getDate("ngaySinh"));
				temp.setTieuSu(rs.getString("tieuSu"));
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
	public TacGia selectById(TacGia t) {
		TacGia  kq = new TacGia() ;
		try {
			Connection con = Jdbc.getConnection() ;
			String sql = "select * from tac_gia where maTacGia = ? ;" ;
			PreparedStatement pst = con.prepareStatement(sql) ;
			pst.setString(1 , t.getMaTacGia()) ;
			ResultSet rs = pst.executeQuery() ;
			if(rs.next()) {
				kq.setMaTacGia(rs.getString("maTacGia"));
				kq.setHoVaTen(rs.getString("hoVaTen"));
				kq.setNgaySinh(rs.getDate("ngaySinh"));
				kq.setTieuSu(rs.getString("tieuSu"));
			}
			Jdbc.ColseConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return kq;
	}
	
	
}
