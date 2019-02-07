package mayintarlasi;
import java.io.*;
import java.util.Random;
public class Kutu extends MayinTarlasi implements YardimciIslemler{
	public int[] Mayinlar = new int[100];
	public int[] MayinTarlasi;
	public int[] MayinKontrol;
	public int[] Komsular = new int[8]; 
	public String [] Tarla;
	public int secilenIndis, komsuSayisi, mayinKomsular, yeniHesapSayisi, yeniHesapIndis;
	public int[] yeniHesaplar, yeniHesapYerleri;

	public void KutuIlklendir(int sayi, int satirSayisi, int sutunSayisi)
	{
		int matrisBoyutu=satirSayisi*sutunSayisi;

		MayinTarlasi = new int[matrisBoyutu];
		MayinKontrol = new int[matrisBoyutu];
		Tarla = new String[matrisBoyutu];
		yeniHesaplar = new int[100];
		yeniHesapYerleri = new int[100];
		
		yeniHesapSayisi = 0;
		RastgeleSayiUret(sayi,matrisBoyutu);
		MatrisIlklendir(matrisBoyutu);
		MayinlariYerlestir(sayi);
		MayinTarlasiOlustur(matrisBoyutu);
		MatrisCiz(matrisBoyutu,sutunSayisi);            
	}

	public boolean OncedenVarmi(int randomSayi, int count)
	{
		boolean sonuc = false;
		for(int i=0;i<count;i++)
		{
			if(Mayinlar[i]==randomSayi)
			{
				sonuc = true;
				break;
			}
		}

		return sonuc;
	}

	public boolean MayinMi()
	{		
		boolean kutuDurumu=false;
		if(MayinTarlasi[secilenIndis]==1)
		{
			kutuDurumu = true;
		}
		return kutuDurumu;
	}

	public void KomsulariBul(int satirSayisi, int sutunSayisi)
	{
		int satir,sutun;
		satir = secilenIndis/sutunSayisi;
		sutun = secilenIndis%sutunSayisi;
		int count=0;

		if((satir-1)>=0)
		{
			Komsular[count] = (satir-1)*sutunSayisi+sutun;
			count++;
			if((sutun-1)>=0)
			{
				Komsular[count] = (satir-1)*sutunSayisi+(sutun-1);
				count++;				
			}
			if((sutun+1)<sutunSayisi)
			{
				Komsular[count] = (satir-1)*sutunSayisi+(sutun+1);
				count++;				
			}
		}
		if((satir+1)<satirSayisi)
		{
			Komsular[count] = (satir+1)*sutunSayisi+sutun;
			count++;
			if((sutun-1)>=0)
			{
				Komsular[count] = (satir+1)*sutunSayisi+(sutun-1);
				count++;				
			}
			if((sutun+1)<sutunSayisi)
			{
				Komsular[count] = (satir+1)*sutunSayisi+(sutun+1);
				count++;				
			}
		}
		if((sutun-1)>=0)
		{
			Komsular[count] = (satir)*sutunSayisi+(sutun-1);
			count++;
		}
		if((sutun+1)<sutunSayisi)
		{
			Komsular[count] = (satir)*sutunSayisi+(sutun+1);
			count++;
		}
		komsuSayisi = count;
	}

	@Override
	public void RastgeleSayiUret(int sayi, int matrisBoyutu) {
		int rastgeleSayi, count=0;
		boolean Devam=true;
		Random rand = new Random();

		while(Devam)
		{
			rastgeleSayi = rand.nextInt(matrisBoyutu-1);
			if(OncedenVarmi(rastgeleSayi, count))
			{
				continue;
			}

			Mayinlar[count] = rastgeleSayi;
			count++;
			if(count==sayi)
			{
				Devam=false;
			}	
		}
	}

	@Override
	public void MatrisIlklendir(int matrisBoyutu) {
		for(int i=0;i<matrisBoyutu;i++)
		{
			MayinTarlasi[i] = 0;
			MayinKontrol[i] = 0;
		}
	}

	@Override
	public void MatrisCiz(int matrisBoyutu,int sutunSayisi) {
		int deger1=0,deger2=0;

		for(int i=0;i<matrisBoyutu;i++)
		{
			deger1=i/sutunSayisi;
			if(deger1!=deger2)
			{
				System.out.println();
				deger2 = deger1;
			}
			System.out.printf("%6S",Tarla[i]);
		}
		System.out.println();
	}

	@Override
	public void MayinlariYerlestir(int sayi) {
		for(int i=0;i<sayi;i++)
		{
			MayinTarlasi[Mayinlar[i]] = 1;
		}
	}

	@Override
	public void NoktaDegeri(int [] MayinTarlasi) {
		mayinKomsular=0;
		for(int i=0;i<komsuSayisi;i++)
		{
			if(MayinTarlasi[Komsular[i]]==1)
			{
				mayinKomsular++;
			}
		}
	}

	@Override
	public void MayinTarlasiOlustur(int matrisBoyutu) {
		String icerik, sayi;
		for(int i=0;i<matrisBoyutu;i++)
		{
			icerik="T";
			sayi= Integer.toString(i+1);
			Tarla[i] = icerik.concat(sayi);
		}
	}

	@Override
	public void TarlayiDoldur(Kutu a, String [] Tarla, int[] MayinTarlasi, int[] MayinKontrol, int satirSayisi, int sutunSayisi, int iterasyon)/*int secilenIndis, int mayinKomsular, int komsuSayisi, int [] Komsular)*/ {
		//System.out.println(a.mayinKomsular+" "+a.komsuSayisi+" "+a.secilenIndis);
		Tarla[a.secilenIndis] = Integer.toString(a.mayinKomsular);
		yeniHesapIndis++;
		yeniHesaplar[yeniHesapIndis] = a.mayinKomsular;
		yeniHesapYerleri[yeniHesapIndis] = a.secilenIndis;
		yeniHesapSayisi = yeniHesapIndis+1;
		MayinKontrol[a.secilenIndis] = 1;
		if(a.mayinKomsular==0)
		{
			for(int i=0;i<a.komsuSayisi;i++)
			{
				/*System.out.println("Komsu:"+a.Komsular[i]+" kontrol:"+MayinKontrol[a.Komsular[i]]+" mayin mi? "+
				MayinTarlasi[a.Komsular[i]]);*/

				if(MayinKontrol[a.Komsular[i]]==1)
				{
					continue;
				}
				Kutu komsu = new Kutu();
				komsu.secilenIndis = a.Komsular[i];
				MayinKontrol[komsu.secilenIndis] = 1;
				komsu.KomsulariBul(satirSayisi,sutunSayisi);
				komsu.NoktaDegeri(MayinTarlasi);
				//System.out.println(i+" "+komsu.mayinKomsular+" "+MayinTarlasi[komsu.secilenIndis]+" "+komsu.secilenIndis);
				if((komsu.mayinKomsular==0)&&(MayinTarlasi[komsu.secilenIndis]!=1))
				{
					//System.out.println("tarla doldur");
					TarlayiDoldur(komsu, Tarla, MayinTarlasi, MayinKontrol, satirSayisi, sutunSayisi, iterasyon);
				}
				else
				{
					Tarla[komsu.secilenIndis] = Integer.toString(komsu.mayinKomsular);
					yeniHesapIndis++;
					yeniHesaplar[yeniHesapIndis] = komsu.mayinKomsular;
					yeniHesapYerleri[yeniHesapIndis] = komsu.secilenIndis;
					yeniHesapSayisi = yeniHesapIndis+1;
				}
			}      
		}
	}

	@Override
	public void MayinlariGoster(int[] MayinTarlasi, int matrisBoyutu, int sutunSayisi) {
		// TODO Auto-generated method stub
		int deger1=0,deger2=0;

		for(int i=0;i<matrisBoyutu;i++)
		{
			if(MayinTarlasi[i]==1)
			{
				Tarla[i] = "BOM";
				yeniHesapIndis++;
				yeniHesaplar[yeniHesapIndis] = 1;
				yeniHesapYerleri[yeniHesapIndis] = i;
				yeniHesapSayisi = yeniHesapIndis+1;
			}
		}
	}
}
