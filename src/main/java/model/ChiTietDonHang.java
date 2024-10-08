package model;

public class ChiTietDonHang {
	private String maChiTietDonHang ;
	private DonHang donHang ;
	private Sach sach ;
	private double soLuong ;
	private double giaBia ;
	private double giaBan ;
	private double giamGia ;
	private double thueVAT ;
	private double tongThanhTien ;
	
	public ChiTietDonHang() {
	}

	public ChiTietDonHang(String maChiTietDonHang, DonHang donHang, Sach sach, double soLuong, double giaBia,
			double giaBan, double giamGia, double thueVAT, double tongThanhTien) {
		this.maChiTietDonHang = maChiTietDonHang;
		this.donHang = donHang;
		this.sach = sach;
		this.soLuong = soLuong;
		this.giaBia = giaBia;
		this.giaBan = giaBan;
		this.giamGia = giamGia;
		this.thueVAT = thueVAT;
		this.tongThanhTien = tongThanhTien;
	}

	public String getMaChiTietDonHang() {
		return maChiTietDonHang;
	}

	public void setMaChiTietDonHang(String maChiTietDonHang) {
		this.maChiTietDonHang = maChiTietDonHang;
	}

	public DonHang getDonHang() {
		return donHang;
	}

	public void setDonHang(DonHang donHang) {
		this.donHang = donHang;
	}

	public Sach getsach() {
		return sach;
	}

	public void setsach(Sach sach) {
		this.sach = sach;
	}

	public double getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(double soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaBia() {
		return giaBia;
	}

	public void setGiaBia(double giaBia) {
		this.giaBia = giaBia;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public double getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}

	public double getthueVAT() {
		return thueVAT;
	}

	public void setthueVAT(double thueVAT) {
		this.thueVAT = thueVAT;
	}

	public double getTongThanhTien() {
		return tongThanhTien;
	}

	public void setTongThanhTien(double tongThanhTien) {
		this.tongThanhTien = tongThanhTien;
	}

	@Override
	public String toString() {
		return "ChiTietDonHang [maChiTietDonHang=" + maChiTietDonHang + ", donHang=" + donHang + ", sach=" + sach
				+ ", soLuong=" + soLuong + ", giaBia=" + giaBia + ", giaBan=" + giaBan + ", giamGia=" + giamGia
				+ ", thueVAT=" + thueVAT + ", tongThanhTien=" + tongThanhTien + "]";
	}
	
	
	

}
