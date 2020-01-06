package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Departemen;
import model.Pegawai;
import ui.PegawaiFrame;

public class PegawaiService extends FrameService {

	private List<Pegawai> pegawaiList;

	public PegawaiService() {
		super(new PegawaiFrame());
		pegawaiList = generatePegawaiList();
	}
	
	public List<Pegawai> getData() {
		return pegawaiList;
	}
	
	public Pegawai getDataAt(int index) {
		return pegawaiList.get(index);
	}
	
	private List<Pegawai> generatePegawaiList() {
		List<Pegawai> pegawaiList = new ArrayList<Pegawai>();
		
		Departemen deptIt = new Departemen("IT");
		Departemen deptKeuangan = new Departemen("Keuangan");
		
		try {
			pegawaiList.add(new Pegawai(
				"123", 
				"Agus", 
				new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1990"), 
				deptIt
			));
			
			pegawaiList.add(new Pegawai(
				"456", 
				"Budi", 
				new SimpleDateFormat("dd/MM/yyyy").parse("01/02/1991"), 
				deptIt
			));
			
			pegawaiList.add(new Pegawai(
				"789", 
				"Cahyo", 
				new SimpleDateFormat("dd/MM/yyyy").parse("28/02/1989"), 
				deptKeuangan
			));
			
		} catch (ParseException e) {
			System.err.println(e.getMessage());
		}
		
		return pegawaiList;
	} 
}
