package model;

public class Sach {
	private String maSach ;
	private String tenSach ;
	private TacGia tacGia  ;
	private int namXuatBan  ;
	private double giaNhap  ;
	private double giaGoc  ;
	private double giaBan  ;
	private double soLuong  ;
	private TheLoai theLoai  ;
	private String ngonNgu  ;
	private String moTa  ;
	
	public Sach(String maSach, String tenSach, TacGia tacGia, int namSanXuat, double giaNhap, double giaGoc,
			double giaBan, double soLuong, TheLoai theLoai, String ngonNgu, String moTa) {
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.namXuatBan = namSanXuat;
		this.giaNhap = giaNhap;
		this.giaGoc = giaGoc;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
		this.theLoai = theLoai;
		this.ngonNgu = ngonNgu;
		this.moTa = moTa;
	}
	
	public Sach() {
		// TODO Auto-generated constructor stub
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public TacGia getTacGia() {
		return tacGia;
	}

	public void setTacGia(TacGia tacGia) {
		this.tacGia = tacGia;
	}

	public int getNamSanXuat() {
		return namXuatBan;
	}

	public void setNamSanXuat(int namSanXuat) {
		this.namXuatBan = namSanXuat;
	}

	public double getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}

	public double getGiaGoc() {
		return giaGoc;
	}

	public void setGiaGoc(double giaGoc) {
		this.giaGoc = giaGoc;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public double getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(double soLuong) {
		this.soLuong = soLuong;
	}

	public TheLoai getTheLoai() {
		return theLoai;
	}

	@Override
	public String toString() {
		return "Sach [maSach=" + maSach + ", tenSach=" + tenSach + ", tacGia=" + tacGia + ", namXuatBan=" + namXuatBan
				+ ", giaNhap=" + giaNhap + ", giaGoc=" + giaGoc + ", giaBan=" + giaBan + ", soLuong=" + soLuong
				+ ", theLoai=" + theLoai + ", ngonNgu=" + ngonNgu + ", moTa=" + moTa + "]";
	}

	public void setTheLoai(TheLoai theLoai) {
		this.theLoai = theLoai;
	}

	public String getNgonNgu() {
		return ngonNgu;
	}

	public void setNgonNgu(String ngonNgu) {
		this.ngonNgu = ngonNgu;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
	
	
	
	
	

}
