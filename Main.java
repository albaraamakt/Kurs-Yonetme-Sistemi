package kurs.yonetme.sistemi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void kursMenu(List<Kurs> kurslar) {
		@SuppressWarnings("resource")
		Scanner girdi = new Scanner(System.in);
		System.out.println("                       -<Kurslar>-\n");
		for (int i = 0; i < kurslar.size(); i++) {
			System.out.println("              " + kurslar.get(i).getIsim() + "(" + (i + 1) + ")\n" );
		}
		System.out.print("-----------------------------------------------------------\n\nConsole:");
		int console = girdi.nextInt();
		System.out.println();
		for (int j = 0; j < kurslar.size(); j++) {
			if ((console - 1) == j) {
				mainMenu(kurslar.get(j), kurslar);
			}
		}
	}
	
	public static void mainMenu(Kurs kys, List<Kurs> kurslar) {
		@SuppressWarnings("resource")
		Scanner girdi = new Scanner(System.in);
		int console;
		System.out.println("-----------------------------------------------------------\n");
		System.out.println(
			"              Ogrenci menu(1)\n\n              Ogretmen menu(2)\n\n              Geri don(3)\n");
		System.out.print("-----------------------------------------------------------\n\nConsole:");
		console = girdi.nextInt();
		System.out.println();
		if (console == 1) {
			ogrenciMenu(kys);
			mainMenu(kys, kurslar);
		}
		else if (console == 2) {
			ogretmenMenu(kys);
			mainMenu(kys, kurslar);
		}
		else if (console == 3) {
			System.out.println("-----------------------------------------------------------\n");
			kursMenu(kurslar);
			mainMenu(kys, kurslar);
		}
		else if (console == 0) {
			return;
		}
		
	}
	
	public static void ogrenciMenu(Kurs kys) {
		@SuppressWarnings("resource")
		Scanner girdi = new Scanner(System.in);
		System.out.println("-----------------------------------------------------------\n");
		System.out.println("  Yapmak istediginiz islemi sectiniz:\n\n"
				+ "              Ogrenci bilgileri ogrenme(1)\n\n"
				+ "              Ogrenci odeme bilgilerini guncelleme(2)\n\n"
				+ "              Yeni ogrenci ekleme(3)\n\n"
				+ "              Butun ogrencileri listele(4)\n");
		System.out.print("-----------------------------------------------------------\n\nConsole:");
		int console = girdi.nextInt();
		System.out.println();
		if (console == 1) {
			System.out.print("Ogrenci numarasini giriniz(id): ");
			int idConsole = girdi.nextInt();
			try {
				kys.ogrenciBilgileriGoster(kys.IndexBulmaN(kys.getOgrenciler(), idConsole));
			}
			catch (IndexOutOfBoundsException e) {
				System.out.println("Girilen id numarasi bulunmamaktadir.");
			}
		}
		else if (console == 2) {
			System.out.print("Ogrenci numarasini giriniz(id): ");
			int idConsole = girdi.nextInt();
			
			try {
				System.out.print("Kalan borc: "
						+ kys.getOgrenci(kys.IndexBulmaN(kys.getOgrenciler(), idConsole)).getBorc()
						+ "\n\nOdenecek tutari giriniz: ");
				int odeme = girdi.nextInt();
				
				kys.getOgrenci(kys.IndexBulmaN(kys.getOgrenciler(), idConsole)).odenenUcretGuncel(odeme);
				
				System.out.println("Kalan borc: "
				+ kys.getOgrenci(kys.IndexBulmaN(kys.getOgrenciler(), idConsole)).getBorc());
			}
			catch (IndexOutOfBoundsException e) {
				System.out.println("Girilen id numarasi bulunmamaktadir.");
			}
		}
		else if (console == 3) {
			System.out.print("Ad-soyad: ");
			String yeniIsim = girdi.next();
					
			Ogrenci yeniOgrenci = new Ogrenci(yeniIsim);
			kys.getOgrenciler().add(yeniOgrenci);
		}
		else if (console == 4) {
			kys.ogrenciBilgileriGoster();
		}
	}
	
	public static void ogretmenMenu(Kurs kys) {
		@SuppressWarnings("resource")
		Scanner girdi = new Scanner(System.in);System.out.println("-----------------------------------------------------------\n");
		System.out.println("  Yapmak istediginiz islemi sectiniz:\n\n"
				+ "              Ogretmen bilgileri ogrenme(1)\n\n"
				+ "              Ogretmen odeme bilgilerini guncelleme(2)\n\n"
				+ "              Yeni ogretmen ekle(3)\n\n"
				+ "              Butun ogretmenleri listele(4)\n");
		System.out.print("-----------------------------------------------------------\n\nConsole:");
		int console = girdi.nextInt();
		System.out.println("\n");
		
		if (console == 1) {
			System.out.print("Ogretmen numarasini giriniz(id): ");
			int idConsole = girdi.nextInt();
			try {
				kys.ogretmenBilgileriGoster(kys.IndexBulmaT(kys.getOgretmenler(), idConsole));
			}
			catch (IndexOutOfBoundsException e) {
				System.out.println("Girilen id numarasi bulunmamaktadir.");
			}
		}
		else if (console == 2) {
			System.out.print("Ogretmen numarasini giriniz(id): ");
			int idConsole = girdi.nextInt();
			try {
				System.out.print("Maas durumu: " + kys.getOgretmen(kys.IndexBulmaT(kys.getOgretmenler(), idConsole)).getMaasDurum()
					+ "\nMaas durumunu guncellemek istiyor musunuz?(y/n) ");
				String stringConsole = girdi.next();
				if (stringConsole.compareTo("y") == 0) {
					kys.getOgretmen(kys.IndexBulmaT(kys.getOgretmenler(), idConsole)).setMaasOdendi(true);
					System.out.println("Maas durumu: " + kys.getOgretmen(kys.IndexBulmaT(kys.getOgretmenler(), idConsole)).getMaasDurum());
				}
				else {
					System.out.println("Maas durumu: " + kys.getOgretmen(kys.IndexBulmaT(kys.getOgretmenler(), idConsole)).getMaasDurum());
					return;
				}
			}
			catch (IndexOutOfBoundsException e) {
				 System.out.println("Girilen id numarasi bulunmamaktadir.");
			}
		}
		else if (console == 3) {
			System.out.print("Ad-soyad: ");
			String yeniIsim = girdi.next();
			
			System.out.print("Maas: ");
			int yeniMaas = girdi.nextInt();
						
			Ogretmen yeniOgretmen = new Ogretmen(yeniIsim, yeniMaas);
			kys.getOgretmenler().add(yeniOgretmen);
		}
		else if (console == 4) {
			kys.ogretmenBilgileriGoster();
		}
	}
	
	public static void main(String[] args) {
		
		List<Ogrenci> ogrenciler1 = new ArrayList<Ogrenci>();
		Ogrenci ogrn01 = new Ogrenci("Muhammed");
		ogrenciler1.add(ogrn01);
		Ogrenci ogrn02 = new Ogrenci("Serdar");
		ogrenciler1.add(ogrn02);
		Ogrenci ogrn03 = new Ogrenci("Kan");
		ogrenciler1.add(ogrn03);
		
		List<Ogretmen> ogretmenler1 = new ArrayList<Ogretmen>();
		Ogretmen ogrt01 = new Ogretmen("Abdullah", 4000);
		ogretmenler1.add(ogrt01);
		Ogretmen ogrt02 = new Ogretmen("Ahmet", 4000);
		ogretmenler1.add(ogrt02);
		Ogretmen ogrt03 = new Ogretmen("Mustafa", 4000);
		ogretmenler1.add(ogrt03);
		
		List<Ogrenci> ogrenciler2 = new ArrayList<Ogrenci>();
		Ogrenci ogrn11 = new Ogrenci("Ahmet");
		ogrenciler2.add(ogrn11);
		Ogrenci ogrn12 = new Ogrenci("Ali");
		ogrenciler2.add(ogrn12);
		Ogrenci ogrn13 = new Ogrenci("Baraa");
		ogrenciler2.add(ogrn13);
		
		List<Ogretmen> ogretmenler2 = new ArrayList<Ogretmen>();
		Ogretmen ogrt11 = new Ogretmen("Mustafa", 4000);
		ogretmenler2.add(ogrt11);
		Ogretmen ogrt12 = new Ogretmen("Osman", 4000);
		ogretmenler2.add(ogrt12);
		Ogretmen ogrt13 = new Ogretmen("Koray", 4000);
		ogretmenler2.add(ogrt13);
		
		List<Kurs> kurslar = new ArrayList<Kurs>();
		Kurs kurs1 = new Kurs("Ingilzce", ogretmenler1, ogrenciler1);
		kurslar.add(kurs1);
		Kurs kurs2 = new Kurs("Almanca", ogretmenler2, ogrenciler2);
		kurslar.add(kurs2);
				
		
		System.out.println("------------Kurs Yonetme Sistemine Hosgeldiniz!------------\n");
		kursMenu(kurslar);
		
	}
}

