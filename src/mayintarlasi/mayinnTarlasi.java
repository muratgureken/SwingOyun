package mayintarlasi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class mayinnTarlasi extends JFrame{
	int mayinSayisi=40,hamleSayisi, satirSayisi=16, sutunSayisi=16, flagSayisi, secimSayisi=0;
	boolean Devam=true, ilkTahmin=true;
	JButton[] array= new JButton[256];
	private JTextField textFlagSayisi;
	private JTextField textSure;
	//ImageIcon flag = new ImageIcon("FLAG.ICON");
	int matrisBoyutu = satirSayisi*sutunSayisi;

	public mayinnTarlasi() {

		Kutu a = new Kutu();
		hamleSayisi = matrisBoyutu - mayinSayisi;
		flagSayisi = mayinSayisi;

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
		textSure.setHorizontalAlignment(SwingConstants.CENTER);
		textSure.setBounds(729, 46, 86, 20);
		textSure.setEditable(false);
		getContentPane().add(textSure);
		textSure.setColumns(10);

		JToggleButton tglbtnFlagSecimi = new JToggleButton("");
		//tglbtnFlagSecimi.setIcon(new ImageIcon("C:\\Users\\MGUREKEN\\Downloads\\SwingOyun-master\\FLAG.ICO"));
		tglbtnFlagSecimi.setBounds(467, 45, 121, 23);
		tglbtnFlagSecimi.setText("M");
		tglbtnFlagSecimi.setFont(new Font("Tahoma", Font.BOLD, 16));
		tglbtnFlagSecimi.setForeground(Color.blue);
		getContentPane().add(tglbtnFlagSecimi);
		tglbtnFlagSecimi.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
				{
					tglbtnFlagSecimi.setText("F");
					tglbtnFlagSecimi.setFont(new Font("Tahoma", Font.BOLD, 16));
					tglbtnFlagSecimi.setForeground(Color.red);
				}
				else if(e.getStateChange()==ItemEvent.DESELECTED)
				{
					tglbtnFlagSecimi.setText("M");
					tglbtnFlagSecimi.setFont(new Font("Tahoma", Font.BOLD, 16));
					tglbtnFlagSecimi.setForeground(Color.blue);
				}		
			}
		});
		
		
		JLabel lblMaynSays = new JLabel("May\u0131n Say\u0131s\u0131");
		lblMaynSays.setBounds(100, 44, 74, 20);
		getContentPane().add(lblMaynSays);

		JLabel lblHamleSays = new JLabel("Hamle Say\u0131s\u0131");
		lblHamleSays.setBounds(641, 46, 74, 20);
		getContentPane().add(lblHamleSays);

		JLabel lblOyunSonuc = new JLabel("");
		lblOyunSonuc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOyunSonuc.setHorizontalAlignment(SwingConstants.CENTER);
		lblOyunSonuc.setBounds(325, 590, 294, 20);
		getContentPane().add(lblOyunSonuc);
		int ofset1=49,ofset3=30,ofset2=0,count=0, count2=0;
		/*setResizable(false);
		setSize(940, 650);*/

		JButton btnYeniOyun = new JButton("Yeni Oyun");
		btnYeniOyun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hamleSayisi = matrisBoyutu - mayinSayisi;
				flagSayisi = mayinSayisi;
				secimSayisi = 0;
				textFlagSayisi.setText(String.valueOf(mayinSayisi));
				textSure.setText(String.valueOf(secimSayisi));
				lblOyunSonuc.setText("");
				ilkTahmin = true;
				tglbtnFlagSecimi.setSelected(false);
				tglbtnFlagSecimi.setText("M");
				tglbtnFlagSecimi.setFont(new Font("Tahoma", Font.BOLD, 16));
				tglbtnFlagSecimi.setForeground(Color.blue);
				a.KutuIlklendir(mayinSayisi,satirSayisi,sutunSayisi);
				for(int i=0;i<256; i++)
				{
					array[i].setEnabled(true);
					array[i].setText("");
				}
			}
		});
		btnYeniOyun.setBounds(320, 45, 120, 23);
		getContentPane().add(btnYeniOyun);

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
					secimSayisi++;
					if(tglbtnFlagSecimi.isSelected())//flag secilirse ve flag sayisi kalmissa
					{
						if(a.Tarla[a.secilenIndis].contains("F"))/*flag secmis ve flag olan yerden flag kaldirilmak isteniyorsa*/
						{
							a.Tarla[a.secilenIndis] = "T"+a.secilenIndis;
							//a.MatrisCiz(matrisBoyutu, sutunSayisi);
							a.MayinKontrol[a.secilenIndis] = 0;
							flagSayisi++;
							array[a.secilenIndis].setText("");
							array[a.secilenIndis].setFont(new Font("Tahoma", Font.BOLD, 16));
							array[a.secilenIndis].setForeground(Color.red);
							textFlagSayisi.setText(String.valueOf(flagSayisi));

							Devam = OyunDevam(a, matrisBoyutu, hamleSayisi, flagSayisi);
						}
						else
						{
							if(flagSayisi>0)
							{
								a.Tarla[a.secilenIndis] = "F"+a.secilenIndis;
								a.MayinKontrol[a.secilenIndis] = 1;
								flagSayisi--;
								array[a.secilenIndis].setText("F");
								array[a.secilenIndis].setFont(new Font("Tahoma", Font.BOLD, 16));
								array[a.secilenIndis].setForeground(Color.red);
								textFlagSayisi.setText(String.valueOf(flagSayisi));
								Devam = OyunDevam(a, matrisBoyutu, hamleSayisi, flagSayisi);
							}
						}
					}

					if((!tglbtnFlagSecimi.isSelected())&&!(a.Tarla[a.secilenIndis].contains("F")))/*flag secilmemisse*/
					{
						if(a.MayinMi())
						{
							if(ilkTahmin)/*ilk tahmin oldugunda rastgele yeni sayi uret*/
							{
								a.MayiniDegistir(matrisBoyutu, mayinSayisi); 
								a.KomsulariBul(satirSayisi, sutunSayisi);
								a.NoktaDegeri(a.MayinTarlasi);
								a.TarlayiDoldur(a, a.Tarla, a.MayinTarlasi, a.MayinKontrol, satirSayisi, sutunSayisi, 0);
								for(int i=0;i<a.yeniHesapSayisi; i++)
								{
									array[a.yeniHesapYerleri[i]].setText(a.yeniHesaplar[i]);
									array[a.yeniHesapYerleri[i]].setFont(new Font("Tahoma", Font.BOLD, 16));
									array[a.yeniHesapYerleri[i]].setForeground(Color.red);
									array[a.yeniHesapYerleri[i]].setEnabled(false);
								}
								/*lblOyunSonuc.setFont(new Font("Tahoma", Font.PLAIN, 16));
								lblOyunSonuc.setText("ILK TAHMIN MAYIN :)");*/
							}
							else
							{
								a.MayinlariGoster(a.MayinTarlasi, matrisBoyutu, sutunSayisi);
								a.Tarla[a.secilenIndis] = "*BOM*";
								//a.MatrisCiz(matrisBoyutu, sutunSayisi);
								a.MayinKontrol[a.secilenIndis] = 1;

								//tum mayinlari goster
								for(int i=0;i<a.yeniHesapSayisi; i++)
								{
									array[a.yeniHesapYerleri[i]].setText("B");
									array[a.yeniHesapYerleri[i]].setFont(new Font("Tahoma", Font.BOLD, 16));
									array[a.yeniHesapYerleri[i]].setForeground(Color.red);
								}
								for(int i=0;i<256; i++)
								{
									array[i].setEnabled(false);
								}
								lblOyunSonuc.setFont(new Font("Tahoma", Font.BOLD, 16));
								lblOyunSonuc.setText("OYUNU KAYBETTINIZ !...");
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
								array[a.yeniHesapYerleri[i]].setText(a.yeniHesaplar[i]);
								array[a.yeniHesapYerleri[i]].setFont(new Font("Tahoma", Font.BOLD, 16));
								array[a.yeniHesapYerleri[i]].setForeground(Color.red);
								array[a.yeniHesapYerleri[i]].setEnabled(false);
							}
							//a.MatrisCiz(matrisBoyutu, sutunSayisi);
						}
						Devam = OyunDevam(a, matrisBoyutu, hamleSayisi, flagSayisi);
						if(!Devam)
						{
							for(int i=0;i<256; i++)
							{
								array[i].setEnabled(false);
							}
							lblOyunSonuc.setFont(new Font("Tahoma", Font.BOLD, 16));
							lblOyunSonuc.setText("TEBRIKLER, OYUNU KAZANDINIZ :)");
						}
						ilkTahmin = false;
					}

					if((!tglbtnFlagSecimi.isSelected())&&(a.Tarla[a.secilenIndis].contains("F")))
					{
						secimSayisi--;
					}
					textSure.setText(String.valueOf(secimSayisi));
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

		//System.out.println("Flag Sayisi: "+flagSayisi+" Acilan Kutu: "+count2+" Toplam Hamle: "+hamleSayisi);

		if(count2==hamleSayisi)
		{
			//System.out.println("Tebrikler, oyunu tamamladiniz :)");
			oyunDevam = false;			
		}

		return oyunDevam;
	}
}