package kurs.yonetme.sistemi;

import java.util.concurrent.atomic.AtomicInteger;

public class Ogretmen {
	
	static private AtomicInteger ID = new AtomicInteger(1100);
	private int id;
	private String isim;
	private int maas;
	private boolean maasOdendi;
	
	public Ogretmen(String isim, int maas){
		this.setId(ID.getAndIncrement() + 1);
		this.setIsim(isim);
		this.setMaas(maas);
		maasOdendi = false;
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

	public int getMaas() {
		return maas;
	}
	
	public String getMaasDurum() {
		if (maasOdendi == false) {
			return "Maas odenmedi.";
		}
		else {
			return "Maas odendi.";
		}
		
	}

	public void setMaas(int maas) {
		this.maas = maas;
	}

	public boolean isMaasOdendi() {
		return maasOdendi;
	}

	public void setMaasOdendi(boolean maasOdendi) {
		this.maasOdendi = maasOdendi;
	}
}
