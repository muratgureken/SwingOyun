package mayintarlasi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

public class mayinnTarlasi extends JFrame{
	int mayinSayisi=40,hamleSayisi, satirSayisi=16, sutunSayisi=16, flagSayisi;
	boolean Devam=true, ilkTahmin=true;
	JButton[] array= new JButton[256];
	private JTextField textFlagSayisi;
	private JTextField textSure;
	
	public mayinnTarlasi() {

		JButton button = new JButton("New button");
		getContentPane().add(button, BorderLayout.WEST);
		getContentPane().setLayout(null);
		
		JLabel lblMaynTarlas = new JLabel("MAYIN TARLASI");
		lblMaynTarlas.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMaynTarlas.setBounds(358, 11, 171, 14);
		getContentPane().add(lblMaynTarlas);
		
		textFlagSayisi = new JTextField();
		textFlagSayisi.setHorizontalAlignment(SwingConstants.CENTER);
		textFlagSayisi.setEditable(false);
		textFlagSayisi.setBounds(184, 44, 86, 20);
		getContentPane().add(textFlagSayisi);
		textFlagSayisi.setColumns(10);
		textFlagSayisi.setText(String.valueOf(mayinSayisi));
		textFlagSayisi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textSure = new JTextField();
		textSure.setBounds(729, 46, 86, 20);
		textSure.setEditable(false);
		getContentPane().add(textSure);
		textSure.setColumns(10);
		
		JToggleButton tglbtnFalgSecimi = new JToggleButton("\u015Eekil");
		tglbtnFalgSecimi.setBounds(387, 45, 121, 23);
		getContentPane().add(tglbtnFalgSecimi);
		
		JLabel lblMaynSays = new JLabel("May\u0131n Say\u0131s\u0131");
		lblMaynSays.setBounds(100, 44, 74, 20);
		getContentPane().add(lblMaynSays);
		
		JLabel lblHamleSays = new JLabel("Hamle Say\u0131s\u0131");
		lblHamleSays.setBounds(641, 46, 74, 20);
		getContentPane().add(lblHamleSays);
		int ofset1=49,ofset3=30,ofset2=0,count=0, count2=0;
		setResizable(false);
		setSize(940, 650);

		Kutu a = new Kutu();
		int matrisBoyutu = satirSayisi*sutunSayisi;
		hamleSayisi = matrisBoyutu - mayinSayisi;
		flagSayisi = mayinSayisi;
		a.KutuIlklendir(mayinSayisi,satirSayisi,sutunSayisi);

		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() instanceof JButton)
				{
					String text = ((JButton)e.getSource()).getText();
					//((JButton)e.getSource()).setEnabled(false);
					/*((JButton)e.getSource()).setFont(new Font("Tahoma", Font.PLAIN, 10));
					((JButton)e.getSource()).setForeground(Color.red);
					((JButton)e.getSource()).setText(((JButton)e.getSource()).getName());*/
					a.secilenIndis = Integer.parseInt(((JButton)e.getSource()).getName());
					a.secilenIndis = a.secilenIndis - 1;
					a.yeniHesapIndis = -1;
					a.yeniHesapSayisi = 0;
					if(false)//flag secilirse ve flag sayisi kalmissa
					{
						a.Tarla[a.secilenIndis] = "F"+a.secilenIndis;
						a.MayinKontrol[a.secilenIndis] = 1;
						flagSayisi--;
						Devam = OyunDevam(a, matrisBoyutu, hamleSayisi, flagSayisi);
					}
					if(false/*flag secmis ve flag olan yerden flag kaldirilmak isteniyorsa*/)
					{
						if(a.Tarla[a.secilenIndis].contains("F"))
						{
							a.Tarla[a.secilenIndis] = "T"+a.secilenIndis;
							a.MatrisCiz(matrisBoyutu, sutunSayisi);
							a.MayinKontrol[a.secilenIndis] = 0;
							flagSayisi++;
						}
						Devam = OyunDevam(a, matrisBoyutu, hamleSayisi, flagSayisi);
					}
					if(true)/*flag secilmemisse*/
					{
						if(a.MayinMi())
						{
							if(ilkTahmin)/*ilk tahmin oldugunda rastgele yeni sayi uret*/
							{
								flagSayisi--;
								a.Tarla[a.secilenIndis] = "F"+a.secilenIndis;
								a.MayinKontrol[a.secilenIndis] = 1;
								
								for(int i=0;i<a.yeniHesapSayisi; i++)
								{
									array[a.yeniHesapYerleri[i]].setText(String.valueOf(a.yeniHesaplar[i]));
									array[a.yeniHesapYerleri[i]].setFont(new Font("Tahoma", Font.PLAIN, 16));
									array[a.yeniHesapYerleri[i]].setForeground(Color.red);
								}
								//a.MatrisCiz(matrisBoyutu, sutunSayisi);
							}
							else
							{
								a.MayinlariGoster(a.MayinTarlasi, matrisBoyutu, sutunSayisi);
								a.Tarla[a.secilenIndis] = "*BOM*";
								//a.MatrisCiz(matrisBoyutu, sutunSayisi);
								a.MayinKontrol[a.secilenIndis] = 1;
								
								for(int i=0;i<a.yeniHesapSayisi; i++)
								{
									array[a.yeniHesapYerleri[i]].setText(String.valueOf(a.yeniHesaplar[i]));
									array[a.yeniHesapYerleri[i]].setFont(new Font("Tahoma", Font.PLAIN, 16));
									array[a.yeniHesapYerleri[i]].setForeground(Color.red);
								}
								Devam = false;
							}
						}
						else
						{
							a.KomsulariBul(satirSayisi, sutunSayisi);
							a.NoktaDegeri(a.MayinTarlasi);
							a.TarlayiDoldur(a, a.Tarla, a.MayinTarlasi, a.MayinKontrol, satirSayisi, sutunSayisi, 0);
							for(int i=0;i<a.yeniHesapSayisi; i++)
							{
								array[a.yeniHesapYerleri[i]].setText(String.valueOf(a.yeniHesaplar[i]));
								array[a.yeniHesapYerleri[i]].setFont(new Font("Tahoma", Font.PLAIN, 16));
								array[a.yeniHesapYerleri[i]].setForeground(Color.red);
							}
							//a.MatrisCiz(matrisBoyutu, sutunSayisi);
						}
						Devam = OyunDevam(a, matrisBoyutu, hamleSayisi, flagSayisi);
						ilkTahmin = false;
					}
				}
			}
		};

		/*JPanel panel = new JPanel();	
		panel.setBounds(50, 50, 500, 500);*/

		for(int i=0; i<array.length; i++)
		{
			if((i%16)==0)
			{
				ofset2 = ofset3*count;
				count++;
				count2 = 0;
			}

			array[i] = new JButton(/*String.valueOf(i)*/);
			array[i].setFont(new Font("Tahoma", Font.PLAIN, 10));
			array[i].setBounds(70+ofset1*count2, 90+ofset2, ofset1+1, ofset3+1);
			array[i].addActionListener(listener);
			array[i].setName(String.valueOf(i+1));
			//panel.add(array[i]);
			getContentPane().add(array[i]);
			count2++;
		}
	}
	public static boolean OyunDevam(Kutu a, int matrisBoyutu, int hamleSayisi, int flagSayisi)
	{
		boolean oyunDevam=true;
		int count2=0;
		for(int i=0;i<matrisBoyutu;i++)
		{
			if((!a.Tarla[i].contains("T"))&&(!a.Tarla[i].contains("F")))
			{
				count2++;
			}
		}

		System.out.println("Flag Sayisi: "+flagSayisi+" Acilan Kutu: "+count2+" Toplam Hamle: "+hamleSayisi);

		if(count2==hamleSayisi)
		{
			System.out.println("Tebrikler, oyunu tamamladiniz :)");
			oyunDevam = false;			
		}

		return oyunDevam;
	}
}
