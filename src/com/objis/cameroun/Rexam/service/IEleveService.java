package com.objis.cameroun.Rexam.service;

import java.util.List;

import com.objis.cameroun.Rexam.domaine.Abonnes;
import com.objis.cameroun.Rexam.domaine.Eleve;

/**
 * @author youssouf
 *
 *Interface qui liste toutes les méthodes à implémentées dans la class
 */
public interface IEleveService  {
	
	public int addElevesService(Eleve eleve);
	public Eleve getEleveParMtService(String matricule);
	public int addAbonnesService(Abonnes abonnes);
	public void addExcelFileService(String nomfichier);
	public List<Eleve> listElevesService();
}