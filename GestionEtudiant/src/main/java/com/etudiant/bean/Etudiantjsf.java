/**
 * 
 */
package com.etudiant.bean;


import java.sql.SQLException;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;







/**
 * @author User
 *
 */
@ManagedBean(value = "etudiantjsf")
@RequestScoped
@Named
public class Etudiantjsf {
	
	
	private EtudiantBean etudiantbean= new EtudiantBean();
	private List<Etudiant> listEtudiants;
	private Etudiant etudiant;
	private Etudiant currentEtudiant=null;
    
	
	
	public Etudiantjsf() {
		

		etudiant = new Etudiant();
	}
	
	

	

   
	public String etudiantAdd() {
		
		etudiantbean.addEtudiant(etudiant);
		etudiantbean.chargerListEtudiant();
		etudiant = new Etudiant();
		
		return "list.xhtml";
	}

	public String delete(Etudiant etu) {
		System.out.println("Méthode delete appelée avec l'étudiant ID : " + etu.getId());
		etudiantbean.deleteEtudiant(etu);
		System.out.println("Etudiant supprimé avec succès.");
		etudiantbean.chargerListEtudiant();
		return "list.xhtml";
		
}
	
	public String updateRow(Etudiant e) {
		System.out.println("here");
		currentEtudiant=e;
		e.setUpdate(true);
		return "list.xhtml";
	}

    public String save() {
    	//try {
    		System.out.println(currentEtudiant);
    		etudiantbean.update(currentEtudiant);
    		etudiantbean.chargerListEtudiant();
//    		listEtudiants.clear();
//    		listEtudiants.addAll(etudiantbean.chargerListEtudiant());
    		return "list.xhtml";
//    }catch(Exception e){
//    	e.printStackTrace();
//    }
    	
    }

	/**
	 * @return the listEtudiants
	 */
	public List<Etudiant> getListEtudiants() {
		return etudiantbean.chargerListEtudiant();
	}



	/**
	 * @param listEtudiants the listEtudiants to set
	 */
	public void setListEtudiants(List<Etudiant> listEtudiants) {
		//this.listEtudiants = listEtudiants;
	}



	/**
	 * @return the etudiant
	 */
	public Etudiant getEtudiant() {
		return etudiant;
	}



	/**
	 * @param etudiant the etudiant to set
	 */
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}






	/**
	 * @return the currentEtudiant
	 */
	public Etudiant getCurrentEtudiant() {
		return currentEtudiant;
	}






	/**
	 * @param currentEtudiant the currentEtudiant to set
	 */
	public void setCurrentEtudiant(Etudiant currentEtudiant) {
		this.currentEtudiant = currentEtudiant;
	}



	
}	
