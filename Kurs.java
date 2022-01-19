package kurs.yonetme.sistemi;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Kurs {
	static private AtomicInteger ID = new AtomicInteger(2000);
	private int id;
	private String isim;
	private List<Ogretmen> ogretmenler;
	private List<Ogrenci> ogrenciler;
	private int kazanilanToplamPara;
	private int harcananToplamPara;
	
	Kurs(String isim, List<Ogretmen> ogretmenler, List<Ogrenci> ogrenciler){
		this.setId(ID.getAndIncrement() + 1);
		this.setIsim(isim);
		this.ogretmenler = ogretmenler;
		this.ogrenciler = ogrenciler;
		kazanilanToplamPara = 0;
		harcananToplamPara = 0;
	}
	
	public void ogrenciEkleme(Ogrenci ogrenci) {
		ogrenciler.add(ogrenci);
	}
	
	public void ogretmenEkleme(Ogretmen ogretmen) {
		ogretmenler.add(ogretmen);
	}
	
	public List<Ogretmen> getOgretmenler(){
		return ogretmenler;
	}
	
	public List<Ogrenci> getOgrenciler(){
		return ogrenciler;
	}
	
	public int ogrencilerSize() {
		return ogrenciler.size();
	}
	
	public int ogretmenlerSize() {
		return ogretmenler.size();
	}
	
	public Ogretmen getOgretmen(int index) {
		return ogretmenler.get(index);
	}
	
	public Ogrenci getOgrenci(int index) {
		return ogrenciler.get(index);
	}
	
	public void  ogrenciBilgileriGoster(int i) {
		System.out.println("     ID     |     Ad     |     Toplam Ucret     |     Odenen Ucret     \n"
				         + "-----------------------------------------------------------------------\n"
				         + "     " + getOgrenci(i).getId() + "  |     " + getOgrenci(i).getIsim() + "     |     " + getOgrenci(i).getToplamUcret() + "     |     " + getOgrenci(i).getOdenenUcret()
				         + "\n---------------------------------------------------------------------\n");
	}
	
	public void  ogrenciBilgileriGoster() {
		System.out.println("     ID     |     Ad     |     Toplam Ucret     |     Odenen Ucret     \n"
						 + "-----------------------------------------------------------------------\n");
		for (int i = 0; i < ogretmenlerSize(); i++) {
			System.out.println("     " + getOgrenci(i).getId() + "  |     " + getOgrenci(i).getIsim() + "     |     " + getOgrenci(i).getToplamUcret() + "     |     " + getOgrenci(i).getOdenenUcret()
					     + "\n-----------------------------------------------------------------------\n");
		}
	}
	
	public void  ogretmenBilgileriGoster(int i) {
		System.out.println("     ID     |     Ad     |     Maas     |     Maas Durumu     \n"
						 + "--------------------------------------------------------------\n"
						 + "     " + getOgretmen(i).getId() + "  |     " + getOgretmen(i).getIsim() + "     |     " + getOgretmen(i).getMaas() + "     |     " + getOgretmen(i).getMaasDurum()
						 + "\n--------------------------------------------------------------\n");
	}
	
	public void ogretmenBilgileriGoster() {
		System.out.println("     ID     |     Ad     |     Maas     |     Maas Durumu     \n"
				 		 + "--------------------------------------------------------------\n");
		for (int i = 0; i < ogretmenlerSize(); i++) {
			System.out.println("     " + getOgretmen(i).getId() + "  |     " + getOgretmen(i).getIsim() + "     |     " + getOgretmen(i).getMaas() + "     |     " + getOgretmen(i).getMaasDurum()
					     + "\n--------------------------------------------------------------\n");
		}
	}
	
	
	public int IndexBulmaT(List<Ogretmen> ogretmenler, int id) {
		for (int i = 0; i < ogretmenler.size(); i++) {
			if (ogretmenler.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}
	
	public int IndexBulmaN(List<Ogrenci> ogrenciler, int id) {
		for (int i = 0; i < ogrenciler.size(); i++) {
			if (ogrenciler.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
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
}
