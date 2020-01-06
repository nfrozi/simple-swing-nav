package model;

import java.util.Date;

public class Pegawai {

	private String ktp;
	private String nama;
	private Date tglLahir;
	private Departemen departemen;
	
	public Pegawai(String ktp, String nama, Date tglLahir, Departemen departemen) {
		super();
		this.ktp = ktp;
		this.nama = nama;
		this.tglLahir = tglLahir;
		this.departemen = departemen;
	}
	
	public String getKtp() {
		return ktp;
	}

	public String getNama() {
		return nama;
	}

	public Date getTglLahir() {
		return tglLahir;
	}

	public Departemen getDepartemen() {
		return departemen;
	}
	
	public String __toString() {
		return "[" + ktp + ", " + nama + "]";
	}
}
