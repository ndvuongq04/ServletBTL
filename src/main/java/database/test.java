package database;

import model.ChiTietDonHang;
import model.DonHang;
import model.KhachHang;
import model.Sach;
import model.TacGia;
import model.TheLoai;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Random;

import database.TheLoaiDAO;

public class test {
	public static void main(String[] args) {
		Random rd = new Random() ;
		String maKhachHang = System.currentTimeMillis() + rd.nextInt(1000) + "" ;
		KhachHang khachHangMoi = new KhachHang(maKhachHang, "123", "123", "123", null, null, null, null, null, null, "123", 1 ) ;
		KhachHangDAO.getDoiTuong().insert(khachHangMoi) ;
		
		
	}

}
