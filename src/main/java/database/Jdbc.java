package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc {
	public static Connection getConnection() {
	    Connection c = null;

	    try {
	        // Đăng kí MySQL driver với DriverManager
	    	DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
	    	// các thông số
	        String url = "jdbc:mysql://localhost:3306/website_banHang";
	        String username = "root";
	        String password = "123456";

	        // Tạo kết nối
	        c = DriverManager.getConnection(url, username, password);
	        System.out.println("Kết nối thành công!");
	    } catch (SQLException e) {
	        System.err.println("Lỗi kết nối: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return c;
	}

    
    public static void ColseConnection (Connection c) {
    	try {
			if( c!= null ) {
				c.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Lỗi ngắt kết nối : " + e.getMessage()) ;;
			e.printStackTrace() ;
		}
    }
    
    public static void printInfo( Connection c) {
    	try {
			if( c!= null ) {
				DatabaseMetaData mtdt = c.getMetaData() ;
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
}
