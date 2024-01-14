///**
// * 
// */
//package com.etudiant.bean;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//
//
///**
// * @author User
// *
// */
//public class update {
//	private Etudiant etudiant;
//	private List<Etudiant> listEtudiants;
//	
//	//methode pour recupere la liste des etudiants
//		public List<Etudiant> chargerListEtudiant() {
//			
//			
//			try {
//				//choisir notre driver mysql
//				Class.forName("com.mysql.jdbc.Driver");
//				
//				//base de donnee connexion
//				
//				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbetudiant","root","");
//				
//				//prepare une requete
//				PreparedStatement ps = con.prepareStatement("select * from etudiant");
//				
//				//execution de la requete
//				ResultSet rs = ps.executeQuery();
//				
//				//recuperation du resultat et on le stock dans listeEtudiant
//				while(rs.next()) {
//					
//					//instance etudiant
//					Etudiant e = new Etudiant();
//					e.setId(rs.getInt("id"));
//					e.setNom(rs.getString("nom"));
//					e.setPrenom(rs.getString("prenom"));
//					e.setDatenaiss(rs.getDate("datenaiss"));
//					
//					//ajout de l'etudiant dans la liste
//					
//					listEtudiants.add(e);
//				}
//				
//			}catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return listEtudiants;
//		}
//
//	 public void updateEtudiant(Etudiant e) {
//	        try {
//	            Class.forName("com.mysql.jdbc.Driver");
//	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbetudiant", "root", "");
//
//	            // Prépare la requête SQL pour la mise à jour de l'étudiant
//	            String sql = "UPDATE etudiant SET nom=?, prenom=?, datenaiss=? WHERE id=?";
//	            PreparedStatement ps = con.prepareStatement(sql);
//
//	            // Renseigne les paramètres de la requête avec les nouvelles valeurs de l'étudiant
//	            ps.setString(1, e.getNom());
//	            ps.setString(2, e.getPrenom());
//	            java.util.Date utilDate = e.getDatenaiss();
//	            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//	            ps.setDate(3, sqlDate);
//	            ps.setInt(4,e.getId());
//
//	            // Exécute la requête de mise à jour
//	            ps.execute();
//
//	            // Ferme la connexion
//	            con.close();
//	        } catch (ClassNotFoundException | SQLException ex) {
//	            ex.printStackTrace();
//	            // Vous pouvez ajouter une gestion des erreurs plus appropriée
//	        }
//	    }
//}
