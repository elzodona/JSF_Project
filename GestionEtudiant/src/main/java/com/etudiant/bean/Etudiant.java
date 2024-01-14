/**
 * 
 */
package com.etudiant.bean;

import java.util.Date;

/**
 * @author User
 *
 */
public class Etudiant {

	private Integer id;
	private String nom;
	private String prenom;
	private Date datenaiss;
	private boolean update;
	
	
	public Etudiant() {
		// TODO Auto-generated constructor stub
	}


	public Etudiant(Integer id, String nom, String prenom, Date datenaiss) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.datenaiss = datenaiss;
	}


//	/**
//	 * @return the id
//	 */
//	public int getId() {
//		return id;
//	}
//
//
//	/**
//	 * @param id the id to set
//	 */
//	public void setId(int id) {
//		this.id = id;
//	}


	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}


	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}


	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}


	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	/**
	 * @return the datenaiss
	 */
	public Date getDatenaiss() {
		return datenaiss;
	}


	/**
	 * @param datenaiss the datenaiss to set
	 */
	public void setDatenaiss(Date datenaiss) {
		this.datenaiss = datenaiss;
	}


	/**
	 * @return the update
	 */
	public boolean isUpdate() {
		return update;
	}


	/**
	 * @param update the update to set
	 */
	public void setUpdate(boolean update) {
		this.update = update;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", datenaiss=" + datenaiss + ", update="
				+ update + "]";
	}
	
	
	
}
