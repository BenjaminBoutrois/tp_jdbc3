package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import metier.Ecole;
import metier.Etudiant;

public class GestionInscriptions {
	public static void inscrireEtudiant(Etudiant etudiant, Ecole ecole)
	{
		// Information d'accès à la base de données
		String url = "jdbc:mysql://127.0.0.1/tp_jdbc?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String login = "root";
		String password = "";
		
		Connection connection = null;
		Statement statement = null;
		
		try
		{
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : Récupération de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Création d'un statement
			statement = connection.createStatement();
			
			String sql = "INSERT INTO `inscription`"
							+ "VALUES ('" + ecole.getNomEcole() + "',"
							+ "'" + etudiant.getNumEtudiant() + "')";
			
			// Etape 4 : Exécution requête
			statement.executeUpdate(sql);
			
			System.out.println("Inscription de l'étudiant '" + etudiant.getPrenom() + " " + etudiant.getNom() +
								"' à l'école '" + ecole.getNomEcole() + "'.");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				// Etape 5 : Libérer ressources de la mémoire
				connection.close();
				statement.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void desinscrireEtudiant(Etudiant etudiant, Ecole ecole)
	{
		// Information d'accès à la base de données
		String url = "jdbc:mysql://127.0.0.1/tp_jdbc?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String login = "root";
		String password = "";
		
		Connection connection = null;
		Statement statement = null;
		
		try
		{
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : Récupération de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Création d'un statement
			statement = connection.createStatement();
			
			String sql = "DELETE FROM `inscription`"
							+ "WHERE inscription.nom_ecole = '" + ecole.getNomEcole() + "'"
							+ "AND inscription.num_etudiant = '" + etudiant.getNumEtudiant() + "'";
			
			// Etape 4 : Exécution requête
			statement.executeUpdate(sql);
			
			System.out.println("Désinscription de l'étudiant '" + etudiant.getPrenom() + " " + etudiant.getNom() +
								"' à l'école '" + ecole.getNomEcole() + "'.");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				// Etape 5 : Libérer ressources de la mémoire
				connection.close();
				statement.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void afficherEtudiants(String nomEcole)
	{
		// Information d'accès à la base de données
		String url = "jdbc:mysql://127.0.0.1/tp_jdbc?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String login = "root";
		String password = "";
		
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		try
		{
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : Récupération de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Création d'un statement
			statement = connection.createStatement();
			
			String sql = "SELECT etudiant.nom, etudiant.prenom" +
						"FROM ecole, inscription, etudiant" + 
						"WHERE ecole.nom_ecole = inscription.nom_ecole" + 
						"AND inscription.numero_etudiant = etudiant.numero_etudiant" + 
						"AND ecole.nom_ecole = '" + nomEcole + "'";
			
			// Etape 4 : Exécution requête
			result = statement.executeQuery(sql);
			
			System.out.println("Etudiants correspondant à l'école '" + nomEcole + "' :");
			
			while (result.next())
			{
				System.out.println(result.getString("prenom") + " " + result.getString("nom"));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				// Etape 5 : Libérer ressources de la mémoire
				connection.close();
				statement.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
