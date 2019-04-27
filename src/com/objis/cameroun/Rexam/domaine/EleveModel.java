package com.objis.cameroun.Rexam.domaine;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class EleveModel extends AbstractTableModel{
	
	private String[] nomColonnes=new String[] {"Matricule","Nom et Prenom","Date de Naissance","Lieu de Naissance","Serie","Decision du jury"};
	List<String[]> tableValues=new ArrayList<String[]>(); 

	public EleveModel() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return tableValues.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return nomColonnes.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return tableValues.get(rowIndex)[columnIndex];
	}
	@Override
	public String getColumnName(int column) {
		
		return nomColonnes[column];
	}
	
	public void setData(List<Eleve> eleve) {
		tableValues=new ArrayList<>();
		for(Eleve e: eleve) {
			tableValues.add(new String[] {
			e.getMatricule(),
			e.getNomprenom(),
			e.getDatenaissance(),
			e.getLieunaissance(),
			e.getSerie(),
			e.getDecisionjuge()
			});
		}
		fireTableChanged(null);
	}

}
