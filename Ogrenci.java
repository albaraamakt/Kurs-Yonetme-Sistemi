package kurs.yonetme.sistemi;

import java.util.concurrent.atomic.AtomicInteger;

public class Ogrenci {
	private static AtomicInteger ID = new AtomicInteger(1000);
	private int id;
	private String isim;
	private int toplamUcret;
	private int odenenUcret;
	private int borc;

	
	Ogrenci(String isim){
		toplamUcret = 3000;
		odenenUcret = 0;
		this.setBorc(toplamUcret - odenenUcret);
		this.setId(ID.getAndIncrement() + 1);
		this.setIsim(isim);
	}
		
	public int getOdenenUcret() {
		return odenenUcret;
	}
	
	public void odenenUcretGuncel(int ucret) {
		this.odenenUcret += ucret;
		this.borc -= ucret;
	}
	
	public int getToplamUcret() {
		return toplamUcret;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}


	public int getBorc() {
		return borc;
	}

	public void setBorc(int borc) {
		this.borc = borc;
	}
}
