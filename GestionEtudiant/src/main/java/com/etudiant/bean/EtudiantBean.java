/**
 * 
 */
package com.etudiant.bean;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;





/**
 * @author User
 *
 */
//@RequestScoped
//@Named
public class EtudiantBean {

	private Etudiant etudiant;
	private List<Etudiant> listEtudiants;
	
	public EtudiantBean() {
		// TODO Auto-generated constructor stub
		
		 etudiant= new Etudiant();
	}
	
	public Connection bdconnection(){
		try { 
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con = DriverManager.getConnection( 
					"jdbc:mysql://localhost:3306/dbetudiant","root",""); 
			System.out.println("Connection established."); 
			return con;
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
			
		}
		return null;
		
	}
public void update(Etudiant e) {
		
		try {
			String req = "UPDATE etudiant SET nom = ?, prenom = ?, datenaiss = ? WHERE id = ?";
			PreparedStatement ps = bdconnection().prepareStatement(req);
			ps.setString(1, e.getNom());
			ps.setString(2, e.getPrenom());
			 java.util.Date utilDate = e.getDatenaiss();
			  java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			    ps.setDate(3, (java.sql.Date) sqlDate);
			ps.setInt(4, e.getId());
			
			System.out.println(e.getId());
			System.out.println(ps);
			
			ps.executeUpdate();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
//	public void update(Etudiant e) {
//	    try {
//	        // Charger le driver MySQL
//	        try {
//	            Class.forName("com.mysql.jdbc.Driver");
//	        } catch (ClassNotFoundException e1) {
//	            e1.printStackTrace();
//	        }
//
//	        // Connexion à la base de données
//	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbetudiant", "root", "");
//
//	        // Préparer la requête de mise à jour
//	        PreparedStatement ps = con.prepareStatement("UPDATE etudiant SET nom=?, prenom=?, datenaiss=? WHERE id=?");
//	        ps.setString(1, e.getNom());
//	        ps.setString(2, e.getPrenom());
//	        java.util.Date utilDate = e.getDatenaiss();
//	        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//	        ps.setDate(3, sqlDate);
//	        ps.setInt(4, e.getId());
//
//	        // Exécuter la requête de mise à jour
//	        ps.execute();
//
//	        // Fermer les ressources
//	        ps.close();
//	        con.close();
//
//	    } catch (SQLException e1) {
//	        e1.printStackTrace();
//	    }
//	}

	
//public void update(Etudiant e) {
//		
//		try {
//			//choisir notre driver mysql
//			try {
//				Class.forName("com.mysql.jdbc.Driver");
//			} catch (ClassNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//            //base de donnee connexion
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbetudiant","root","");
//			//prepare une requete
//			PreparedStatement ps = con.prepareStatement("insert into etudiant(nom,prenom,datenaiss) value (?,?,?)");
//			 ps.setInt(1, e.getId());
//			 ps.setString(2,e.getNom());
//			 ps.setString(3,e.getPrenom());
//			 java.util.Date utilDate = e.getDatenaiss();
//			 java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//			 ps.setDate(4, (java.sql.Date) sqlDate);
//			
//			
//			
//			ps.execute();
//			
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	}
//	

//public Etudiant getEtudiantById(Integer etudiantId) {
//    Etudiant etudiant = null;
//
//    try {
//        // Charger le driver MySQL
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e1) {
//            e1.printStackTrace();
//        }
//
//        // Connexion à la base de données
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbetudiant", "root", "");
//
//        // Préparer la requête
//        PreparedStatement ps = con.prepareStatement("select * from etudiant where id = ?");
//        ps.setInt(1, etudiantId);
//
//        // Exécuter la requête
//        ResultSet rs = ps.executeQuery();
//
//        // Vérifier si un enregistrement a été trouvé
//        if (rs.next()) {
//            // Récupérer les informations de l'étudiant
//            int id = rs.getInt("id");
//            String nom = rs.getString("nom");
//            String prenom = rs.getString("prenom");
//            java.sql.Date datenaiss = rs.getDate("datenaiss");
//
//            // Créer un objet Etudiant avec les informations récupérées
//            etudiant = new Etudiant(id, nom, prenom, datenaiss);
//        }
//
//        // Fermer les ressources
//        rs.close();
//        ps.close();
//        con.close();
//
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//
//    return etudiant;
//}



	public void addEtudiant( Etudiant e) {
		
		try {
			//choisir notre driver mysql
			Class.forName("com.mysql.jdbc.Driver");
            //base de donnee connexion
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbetudiant","root","");
			//prepare une requete
			PreparedStatement ps = con.prepareStatement("insert into etudiant(nom,prenom,datenaiss) value (?,?,?)");
			//renseigner nos parametre
		    ps.setString(1,e.getNom());
		    ps.setString(2,e.getPrenom());
		    java.util.Date utilDate = e.getDatenaiss();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    ps.setDate(3, (java.sql.Date) sqlDate);
		    //ps.setDate(3, new java.sql.Date(e.getDatenaiss().getTime()));
		    
		    //on execute la requete
		    ps.execute();
		    
		    //etudiant = new Etudiant();
		   
		}catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
		 catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
	}
	
	
	
	public  void deleteEtudiant(Etudiant e) {
		
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbetudiant", "root", "");
	        PreparedStatement ps = con.prepareStatement("delete from etudiant where id= ?");
	        ps.setInt(1, e.getId());
	        ps.execute();
	        System.out.println(ps);
	       
	       
	    } catch (SQLException | ClassNotFoundException ex) {
	        ex.printStackTrace();
	       // Vous pouvez ajouter une gestion des erreurs plus appropriée
	    }
	   

	}
//	
//
//	
//	
	//methode pour recupere la liste des etudiants
	public List<Etudiant> chargerListEtudiant() {
		listEtudiants = new ArrayList<Etudiant>();
		
		try {
			//choisir notre driver mysql
			Class.forName("com.mysql.jdbc.Driver");
			
			//base de donnee connexion
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbetudiant","root","");
			
			//prepare une requete
			PreparedStatement ps = con.prepareStatement("select * from etudiant");
			
			//execution de la requete
			ResultSet rs = ps.executeQuery();
			
			//recuperation du resultat et on le stock dans listeEtudiant
			while(rs.next()) {
				
				//instance etudiant
				Etudiant e = new Etudiant();
				e.setId(rs.getInt("id"));
				e.setNom(rs.getString("nom"));
				e.setPrenom(rs.getString("prenom"));
				e.setDatenaiss(rs.getDate("datenaiss"));
				
				//ajout de l'etudiant dans la liste
				
				listEtudiants.add(e);
			}
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listEtudiants;
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
	 * @return the listetudiants
	 */
	public List<Etudiant> getListEtudiants() {
		return listEtudiants;
	}
	/**
	 * @param listetudiants the listetudiants to set
	 */
	public void setListtudiants(List<Etudiant> listEtudiants) {
		this.listEtudiants = listEtudiants;
	}

	
	
}
