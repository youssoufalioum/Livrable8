package com.objis.cameroun.Rexam.presentation;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.objis.cameroun.Rexam.domaine.Eleve;
import com.objis.cameroun.Rexam.domaine.EleveModel;
import com.objis.cameroun.Rexam.service.IEleveService;
import com.objis.cameroun.Rexam.service.impl.EleveService;

public class EleveSearch extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public EleveSearch(String matricule) {
		setTitle("R\u00E9sultat de l'Eleve");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 867, 100);
		setResizable(false);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		contentPane.add(tableEleve(matricule));
		setContentPane(contentPane);
	}
	
	private JPanel tableEleve(String matricule) {
		IEleveService iEleveService=new EleveService();
		JPanel tablePanel=new JPanel();
		EleveModel jTableModel=new EleveModel();
		JTable jTableEleve=new JTable(jTableModel);
		JScrollPane tablePane= new JScrollPane(jTableEleve);
		tablePanel.setLayout(new GridLayout());
		tablePanel.add(tablePane);
		Eleve listEleve=iEleveService.getEleveParMtService(matricule); // supprimer List<Eleve>
		//jTableModel.setData(listEleve);
		return tablePanel;
	}

}
