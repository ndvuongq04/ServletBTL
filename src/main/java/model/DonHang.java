package model;

import java.util.Date;

public class DonHang {
	private String maDonHang ;
	private KhachHang khachHang ;
	private String diaChiNguoiMua ;
	private String diaChiNguoiNhan ;
	private String trangThai ;
	private String hinhThucThanhToan ;
	private double soTienThanhToan ;
	private double soTienConThieu ;
	private Date ngayDatHang ;
	private Date ngayGiaoHang ;
	
	public DonHang() {
	}
	public DonHang(String maDonHang, KhachHang khachHang, String diaChiNguoiMua, String diaChiNhanHang,
			String trangThai, String hinhThucThanhToan, double soTienThanhToan, double soTienConThieu,
			Date ngayDatHang, Date ngayGiaoHang) {
		this.maDonHang = maDonHang;
		this.khachHang = khachHang;
		this.diaChiNguoiMua = diaChiNguoiMua;
		this.diaChiNguoiNhan = diaChiNhanHang;
		this.trangThai = trangThai;
		this.hinhThucThanhToan = hinhThucThanhToan;
		this.soTienThanhToan = soTienThanhToan;
		this.soTienConThieu = soTienConThieu;
		this.ngayDatHang = ngayDatHang;
		this.ngayGiaoHang = ngayGiaoHang;
	}
	public String getMaDonHang() {
		return maDonHang;
	}
	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public String getDiaChiNguoiMua() {
		return diaChiNguoiMua;
	}
	public void setDiaChiNguoiMua(String diaChiNguoiMua) {
		this.diaChiNguoiMua = diaChiNguoiMua;
	}
	public String getDiaChiNguoiNhan() {
		return diaChiNguoiNhan;
	}
	public void setDiaChiNguoiNhan(String diaChiNhanHang) {
		this.diaChiNguoiNhan = diaChiNhanHang;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public String getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}
	public void setHinhThucThanhToan(String hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
	}
	public double getSoTienThanhToan() {
		return soTienThanhToan;
	}
	public void setSoTienThanhToan(double soTienThanhToan) {
		this.soTienThanhToan = soTienThanhToan;
	}
	public double getSoTienConThieu() {
		return soTienConThieu;
	}
	public void setSoTienConThieu(double soTienConThieu) {
		this.soTienConThieu = soTienConThieu;
	}
	public Date getNgayDatHang() {
		return ngayDatHang;
	}
	public void setNgayDatHang(Date ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}
	public Date getNgayGiaoHang() {
		return ngayGiaoHang;
	}
	public void setNgayGiaoHang(Date ngayGiaoHang) {
		this.ngayGiaoHang = ngayGiaoHang;
	}
	@Override
	public String toString() {
		return "DonHang [maDonHang=" + maDonHang + ", khachHang=" + khachHang + ", diaChiNguoiMua=" + diaChiNguoiMua
				+ ", diaChiNguoiNhan=" + diaChiNguoiNhan + ", trangThai=" + trangThai + ", hinhThucThanhToan="
				+ hinhThucThanhToan + ", soTienThanhToan=" + soTienThanhToan + ", soTienConThieu=" + soTienConThieu
				+ ", ngayDatHang=" + ngayDatHang + ", ngayGiaoHang=" + ngayGiaoHang + "]";
	}
	
	
}
