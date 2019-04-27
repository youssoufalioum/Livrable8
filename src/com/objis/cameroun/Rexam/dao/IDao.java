package com.objis.cameroun.Rexam.dao;

import java.util.List;

import com.objis.cameroun.Rexam.domaine.Abonnes;
import com.objis.cameroun.Rexam.domaine.Eleve;

/**
 * @author youssouf
 *Interface IDao qui affiche la liste de tous les signature des methodes implémentées dans la class Dao
 */
public interface IDao {
	
	public int addElevesDao(Eleve eleve);
	public Eleve getEleveParMtDao(String matricule);
	public int addAbonnesDao(Abonnes abonnes);
	public void addExcelFileDao(String nomfichier);
	public List<Eleve> listElevesDao();

}
