package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DodavanjePica extends JFrame {

	private JPanel contentPane;
	private JLabel lblImePica;
	private JLabel lblSifraPica;
	private JLabel lblTipPica;
	private JLabel lblCenaPica;
	private JLabel lblKolicinaPica;
	private JTextField txtIme;
	private JTextField txtSifra;
	private JComboBox comboBox;
	private JTextField txtCena;
	private JTextField txtKolicina;
	private JButton btnDodajPice;

	
	

	/**
	 * Create the frame.
	 */
	public DodavanjePica() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GuiKontroler.zatvoriProzorDodavanjePica();
			}
		});
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblImePica());
		contentPane.add(getLblSifraPica());
		contentPane.add(getLblTipPica());
		contentPane.add(getLblCenaPica());
		contentPane.add(getLblKolicinaPica());
		contentPane.add(getTxtIme());
		contentPane.add(getTxtSifra());
		contentPane.add(getComboBox());
		contentPane.add(getTxtCena());
		contentPane.add(getTxtKolicina());
		contentPane.add(getBtnDodajPice());
		setLocationRelativeTo(null);
	}
	private JLabel getLblImePica() {
		if (lblImePica == null) {
			lblImePica = new JLabel("Ime pica : ");
			lblImePica.setBounds(31, 31, 76, 14);
		}
		return lblImePica;
	}
	private JLabel getLblSifraPica() {
		if (lblSifraPica == null) {
			lblSifraPica = new JLabel("Sifra pica :");
			lblSifraPica.setBounds(31, 68, 76, 14);
		}
		return lblSifraPica;
	}
	private JLabel getLblTipPica() {
		if (lblTipPica == null) {
			lblTipPica = new JLabel("Tip pica :");
			lblTipPica.setBounds(31, 105, 57, 14);
		}
		return lblTipPica;
	}
	private JLabel getLblCenaPica() {
		if (lblCenaPica == null) {
			lblCenaPica = new JLabel("Cena pica : ");
			lblCenaPica.setBounds(31, 141, 76, 14);
		}
		return lblCenaPica;
	}
	private JLabel getLblKolicinaPica() {
		if (lblKolicinaPica == null) {
			lblKolicinaPica = new JLabel("Kolicina pica :");
			lblKolicinaPica.setBounds(31, 181, 97, 14);
		}
		return lblKolicinaPica;
	}
	private JTextField getTxtIme() {
		if (txtIme == null) {
			txtIme = new JTextField();
			txtIme.setBounds(138, 28, 86, 20);
			txtIme.setColumns(10);
		}
		return txtIme;
	}
	private JTextField getTxtSifra() {
		if (txtSifra == null) {
			txtSifra = new JTextField();
			txtSifra.setBounds(138, 65, 86, 20);
			txtSifra.setColumns(10);
		}
		return txtSifra;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"bezalkoholno", "alkoholno", "pivo", "topliNapitak"}));
			comboBox.setBounds(136, 102, 88, 17);
		}
		return comboBox;
	}
	private JTextField getTxtCena() {
		if (txtCena == null) {
			txtCena = new JTextField();
			txtCena.setBounds(138, 138, 86, 20);
			txtCena.setColumns(10);
		}
		return txtCena;
	}
	private JTextField getTxtKolicina() {
		if (txtKolicina == null) {
			txtKolicina = new JTextField();
			txtKolicina.setBounds(138, 178, 86, 20);
			txtKolicina.setColumns(10);
		}
		return txtKolicina;
	}
	private JButton getBtnDodajPice() {
		if (btnDodajPice == null) {
			btnDodajPice = new JButton("Dodaj pice");
			btnDodajPice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String tip = comboBox.getSelectedItem().toString();
					GuiKontroler.dodajPiceUListu(txtIme.getText(), txtCena.getText(), txtKolicina.getText(), txtSifra.getText(),tip);
				}
			});
			btnDodajPice.setBounds(270, 195, 143, 50);
		}
		return btnDodajPice;
	}
}
