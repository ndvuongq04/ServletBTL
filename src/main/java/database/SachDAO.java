package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Sach;
import model.TacGia;
import model.TheLoai;

public class SachDAO implements DAOInterface<Sach> {
	
	public static SachDAO getDoiTuong() {
		return new  SachDAO() ;
	}

	@Override
	public int insert(Sach t) {
		int kq = 0;
        try {
            Connection con = Jdbc.getConnection();
            String sql = "INSERT INTO sach (maSach ,tenSach , maTacGia , namXuatBan , giaNhap , giaGoc , giaBan , soLuong , maTheLoai , ngonNgu , moTa  ) VALUES (?, ?, ?, ?, ? , ? , ? , ? , ? , ? , ?);";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, t.getMaSach());
            pst.setString(2, t.getTenSach());
            pst.setString(3, t.getTacGia().getMaTacGia());
            pst.setInt(4 , t.getNamSanXuat()) ;
            pst.setDouble(5 , t.getGiaNhap()) ;
            pst.setDouble(6 , t.getGiaGoc()) ;
            pst.setDouble(7 , t.getGiaBan()) ;
            pst.setDouble(8 , t.getSoLuong()) ;
            pst.setString(9, t.getTheLoai().getMaTheLoai());
            pst.setString(10, t.getNgonNgu());
            pst.setString(11, t.getMoTa());
            
            
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
	public int update(Sach t) {
		int kq = 0 ;
		try {
			Connection con = Jdbc.getConnection() ;

			String sql = "update sach "
					+ " set tenSach = ?  , "
					+ " maTacGia = ? ,"
					+ " namXuatBan = ? ,"
					+ " giaNhap = ? ,"
					+ " giaGoc = ? , "
					+ " giaBan = ? ,"
					+ " soLuong = ? , "
					+ " maTheLoai = ? ,"
					+ " ngonNgu = ? ,"
					+ " moTa = ? "
					+ " Where maSach = ? ;" ;
			PreparedStatement pst = con.prepareStatement(sql) ;
			
			pst.setString(11, t.getMaSach());
            pst.setString(1, t.getTenSach());
            pst.setString(2, t.getTacGia().getMaTacGia());
            pst.setInt(3 , t.getNamSanXuat()) ;
            pst.setDouble(4 , t.getGiaNhap()) ;
            pst.setDouble(5 , t.getGiaGoc()) ;
            pst.setDouble(6 , t.getGiaBan()) ;
            pst.setDouble(7 , t.getSoLuong()) ;
            pst.setString(8, t.getTheLoai().getMaTheLoai());
            pst.setString(9, t.getNgonNgu());
            pst.setString(10, t.getMoTa());
            
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
	public int delete(Sach t) {
		int kq = 0 ;
		try {
			Connection con = Jdbc.getConnection() ;
			String sql = "delete from  sach "
					+ " where maSach = ? ; " ;
			PreparedStatement pst = con.prepareStatement(sql) ;
			pst.setString(1 , t.getMaSach()) ;
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
	public ArrayList<Sach> selectAll() {
		ArrayList<Sach> kq = new ArrayList<Sach>() ;
		try {
			Connection con = Jdbc.getConnection() ;
			String sql = "select * from sach ;" ;
			PreparedStatement pst = con.prepareStatement(sql) ;
			
			ResultSet rs  = pst.executeQuery() ; // lưu list kq 
			while(rs.next()) {
				Sach temp = new Sach() ; // add list kq vào đây 
			//   , , maTacGia ,  , ,  ,  ,  , maTheLoai ,  ,
				temp.setMaSach(rs.getString("maSach"));
				temp.setTenSach(rs.getString("tenSach"));
				// lấy 1 tác giả qua maTacGia 
				TacGia tg = TacGiaDAO.getDoiTuong().selectById(new TacGia(rs.getString("maTacGia"), null , null , null )) ;
				temp.setTacGia(tg);
				temp.setNamSanXuat(rs.getInt("namXuatBan"));
				temp.setGiaNhap(rs.getDouble("giaNhap"));
				temp.setGiaGoc(rs.getDouble("giaGoc"));
				temp.setGiaBan(rs.getDouble("giaBan"));
				temp.setSoLuong(rs.getDouble("soLuong"));
				// lấy 1 thể loai qua maTheLoai
				TheLoai tl = TheLoaiDAO.getDoiTuong().selectById(new TheLoai(rs.getString("maTheLoai"), null )) ;
				temp.setTheLoai(tl);
				temp.setNgonNgu(rs.getString("ngonNgu"));
				temp.setMoTa(rs.getString("moTa"));
				
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
	public Sach selectById(Sach t) {
		Sach kq = new Sach() ;
		try {
			Connection con = Jdbc.getConnection() ;
			String sql = "select * from sach where maSach = ? ;" ;
			PreparedStatement pst = con.prepareStatement(sql) ;
			pst.setString(1, t.getMaSach());
			
			ResultSet rs  = pst.executeQuery() ; // lưu list kq 
			while(rs.next()) {
				Sach temp = new Sach() ; // add list kq vào đây 
			//   , , maTacGia ,  , ,  ,  ,  , maTheLoai ,  ,
				temp.setMaSach(rs.getString("maSach"));
				temp.setTenSach(rs.getString("tenSach"));
				// lấy 1 tác giả qua maTacGia 
				TacGia tg = TacGiaDAO.getDoiTuong().selectById(new TacGia(rs.getString("maTacGia"), null , null , null )) ;
				temp.setTacGia(tg);
				temp.setNamSanXuat(rs.getInt("namXuatBan"));
				temp.setGiaNhap(rs.getDouble("giaNhap"));
				temp.setGiaGoc(rs.getDouble("giaGoc"));
				temp.setGiaBan(rs.getDouble("giaBan"));
				temp.setSoLuong(rs.getDouble("soLuong"));
				// lấy 1 thể loai qua maTheLoai
				TheLoai tl = TheLoaiDAO.getDoiTuong().selectById(new TheLoai(rs.getString("maTheLoai"), null )) ;
				temp.setTheLoai(tl);
				temp.setNgonNgu(rs.getString("ngonNgu"));
				temp.setMoTa(rs.getString("moTa"));
				
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
