package model;

import java.util.Date;

public class KhachHang {
	private String maKhachHang ;
	private String tenDangNhap ;
	private String matKhau ;
	private String hoVaTen ;
	private String gioiTinh ;
	private String diaChi ;
	private String diaChiNhanHang ;
	private String diaChiMauHang ;
	private Date ngaySinh ;
	private String soDienThoai ;
	private String email ;
	private int checkEmail ;
	
	public KhachHang(String maKhachHang, String tenDangNhap, String matKhau, String hoVaTen, String gioiTinh,
			String diaChi, String diaChiNhanHang, String diaChiMauHang, Date ngaySinh, String soDienThoai,
			String email, int checkEmail) {
		this.maKhachHang = maKhachHang;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.hoVaTen = hoVaTen;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.diaChiNhanHang = diaChiNhanHang;
		this.diaChiMauHang = diaChiMauHang;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.checkEmail = checkEmail;
	}
	
	public KhachHang() {
	}

	public String getmaKhachHang() {
		return maKhachHang;
	}

	public void setmaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}

	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}

	public String getDiaChiMauHang() {
		return diaChiMauHang;
	}

	public void setDiaChiMauHang(String diaChiMauHang) {
		this.diaChiMauHang = diaChiMauHang;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCheckEmail() {
		return checkEmail;
	}

	public void setCheckEmail(int checkEmail) {
		this.checkEmail = checkEmail;
	}

	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau
				+ ", hoVaTen=" + hoVaTen + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", diaChiNhanHang="
				+ diaChiNhanHang + ", diaChiMauHang=" + diaChiMauHang + ", ngaySinh=" + ngaySinh + ", soDienThoai="
				+ soDienThoai + ", email=" + email + ", checkEmail=" + checkEmail + "]";
	}
	
	
	

}
