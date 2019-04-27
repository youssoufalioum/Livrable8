package com.objis.cameroun.Rexam.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import com.objis.cameroun.Rexam.domaine.Eleve;
import com.objis.cameroun.Rexam.domaine.EleveModel;
import com.objis.cameroun.Rexam.service.IEleveService;
import com.objis.cameroun.Rexam.service.impl.EleveService;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author youssouf
 *Class étandant JFrame qui affiche la fenetre principal de l'application
 */
public class EleveSwing extends JFrame {

	 private JTable jTableEleve;
	 private EleveModel jTableModel;
	 private JTextField barText;
	 
	//Constructeur de la class EleveSwing
	public EleveSwing() {
		super("Rexam");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(900, 500);
		this.setLocationRelativeTo(null);
		JPanel contentPane=(JPanel) this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(rechercheEleve(), BorderLayout.NORTH);
		contentPane.add(addEleves(), BorderLayout.WEST);//
		JPanel textArea=new JPanel();
		textArea.setBackground(Color.GRAY);
		textArea.setPreferredSize(new Dimension(250,0));
		contentPane.add(textArea,BorderLayout.EAST);
		contentPane.add(tableEleves(),BorderLayout.CENTER);
	}
	
	//methode qui recherche un Eleve par matricule et affiche la fenetre EleveSearch
	private JPanel rechercheEleve() {
		JPanel toolBar=new JPanel();
		toolBar.setBackground(Color.DARK_GRAY);
		toolBar.setLayout(new FlowLayout());
		 barText=new JTextField("Votre Matricule");
		 barText.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		searEleve();
		 	}
		 });

		barText.setPreferredSize(new Dimension(140,30));
		JButton btnSearch= new JButton("Recherche");
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				searEleve();
			}
		});
		btnSearch.setPreferredSize(new Dimension(90,30));
		toolBar.add(barText);
		toolBar.add(btnSearch);
		return toolBar;
	}
	
	//methode permettant d'afficher la liste de tous les eleves sur la fenetre principale
	private JPanel tableEleves() {
		IEleveService iEleveService=new EleveService();
		JPanel tablePanel=new JPanel();
	    jTableModel=new EleveModel();
		jTableEleve=new JTable(jTableModel);
		JScrollPane tablePane= new JScrollPane(jTableEleve);
		tablePanel.setLayout(new GridLayout());
		tablePanel.add(tablePane);
		List<Eleve> listEleve=iEleveService.listElevesService();
		jTableModel.setData(listEleve);
		return tablePanel;
	}
	
	//methode permettent d'enregistrer un Eleve
	private JScrollPane addEleves() {
		
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(20,1));
		panel.setBackground(Color.GRAY);
		JLabel label1=new JLabel("Matricule: ");
		JTextField barText1=new JTextField();
		barText1.setBounds(100, 20, 100, 30);
		JLabel label2=new JLabel("Nom et Prenom: ");
		JTextField barText2=new JTextField();
		barText2.setBounds(100, 70, 100, 30);
		JLabel label3=new JLabel("Date de Naissance: ");
		JTextField barText3=new JTextField();
		barText3.setBounds(100, 120, 100, 30);
		JLabel label4=new JLabel("Lieu de Naissance: ");
		JTextField barText4=new JTextField();
		barText4.setBounds(100, 170, 100, 30);
		JLabel label5=new JLabel("Serie: ");
		JTextField barText5=new JTextField();
		barText5.setBounds(100, 220, 100, 30);
		JLabel label6=new JLabel("Decision du jury: ");
		JTextField barText6=new JTextField();
		barText6.setBounds(100, 270, 100, 30);
		JButton button=new JButton("Enregistrer");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String matricule=barText1.getText();
				String nomPrenom=barText2.getText();
				String dateNaissance=barText3.getText();
				String lieuNaissance=barText4.getText();
				String serie=barText5.getText();
				String decisionjury=barText6.getText();
				Eleve eleve=new Eleve(matricule,nomPrenom,dateNaissance,lieuNaissance,serie,decisionjury);
				IEleveService iEService=new EleveService();
				
                int statuts;
				statuts=iEService.addElevesService(eleve);
				
				if(statuts == 1) {
					
					IEleveService iES=new EleveService();
					List<Eleve> listEleve=iES.listElevesService();
					jTableModel.setData(listEleve);
					
					  barText1.setText("");
					  barText2.setText("");
					  barText3.setText("");
					  barText4.setText("");
					  barText5.setText("");
					  barText6.setText("");
					
					JOptionPane.showMessageDialog(null, "Eleve enregistré dans la Base de Donnée!");
					  
				  }else {
					  JOptionPane.showMessageDialog(null, 
							  "Erreur lors de l'enregistrement de l'Eleve!!! ");
				  }
				
			}
		});
		button.setBounds(100, 320, 100, 30);
		panel.add(label1);
		panel.add(barText1);
		panel.add(label2);
		panel.add(barText2);
		panel.add(label3);
		panel.add(barText3);
		panel.add(label4);
		panel.add(barText4);
		panel.add(label5);
		panel.add(barText5);
		panel.add(label6);
		panel.add(barText6);
		panel.add(button);
		JScrollPane scrollPane=new JScrollPane(panel);
		scrollPane.setPreferredSize(new Dimension(250, 0));
		return scrollPane;
	}
	
	public void searEleve() {
		String matricule=barText.getText();
		EleveSearch frame = new EleveSearch(matricule);
		frame.setVisible(true);
	}
	
	public static void main(String arg[]) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		EleveSwing sr=new EleveSwing();
		sr.setVisible(true);
	}

}
