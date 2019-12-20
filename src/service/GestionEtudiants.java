package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import metier.Ecole;
import metier.Etudiant;

public class GestionEtudiants {
	public static void ajouterEtudiant(Etudiant etudiant)
	{
		// Information d'acc�s � la base de donn�es
		String url = "jdbc:mysql://127.0.0.1/tp_jdbc?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String login = "root";
		String password = "";
		
		Connection connection = null;
		Statement statement = null;
		
		try
		{
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : R�cup�ration de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Cr�ation d'un statement
			statement = connection.createStatement();
			
			String sql = "INSERT INTO `etudiant` VALUES ('" + etudiant.getPrenom() + "',"
							+ " '" + etudiant.getNom() + "', '" + etudiant.getNumEtudiant() + "')";
			
			// Etape 4 : Ex�cution requ�te
			statement.executeUpdate(sql);
			
			System.out.println("Ajout de l'�tudiant '" + etudiant.getPrenom() + " " + etudiant.getNom() + "'.");
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
				// Etape 5 : Lib�rer ressources de la m�moire
				connection.close();
				statement.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void modifierEtudiant(String numeroEtudiant, Etudiant nouvelEtudiant)
	{
		// Information d'acc�s � la base de donn�es
		String url = "jdbc:mysql://127.0.0.1/tp_jdbc?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String login = "root";
		String password = "";
		
		Connection connection = null;
		Statement statement = null;
		
		try
		{
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : R�cup�ration de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Cr�ation d'un statement
			statement = connection.createStatement();
			
			String sql = "UPDATE `etudiant`"
					+ "SET prenom = '" + nouvelEtudiant.getPrenom() + "',"
					+ "nom = '" + nouvelEtudiant.getNom() + "'"
					+ "WHERE numero_etudiant = '" + numeroEtudiant + "'";
			
			// Etape 4 : Ex�cution requ�te
			statement.executeUpdate(sql);
			
			System.out.println("Modification de l'�tudiant au num�ro '" + numeroEtudiant + "'.");
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
				// Etape 5 : Lib�rer ressources de la m�moire
				connection.close();
				statement.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void supprimerEtudiant(String numeroEtudiant)
	{
		// Information d'acc�s � la base de donn�es
		String url = "jdbc:mysql://127.0.0.1/tp_jdbc?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String login = "root";
		String password = "";
		
		Connection connection = null;
		Statement statement = null;
		
		try
		{
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : R�cup�ration de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Cr�ation d'un statement
			statement = connection.createStatement();
			
			String sql = "DELETE FROM `etudiant` WHERE numero_etudiant = '" + numeroEtudiant + "'";
			
			// Etape 4 : Ex�cution requ�te
			statement.executeUpdate(sql);
			
			System.out.println("Suppression de l'�tudiant au num�ro '" + numeroEtudiant + "'.");
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
				// Etape 5 : Lib�rer ressources de la m�moire
				connection.close();
				statement.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static Etudiant trouverEtudiant(String numeroEtudiant)
	{
		// Information d'acc�s � la base de donn�es
		String url = "jdbc:mysql://127.0.0.1/tp_jdbc?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String login = "root";
		String password = "";
		
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		Etudiant etudiant = null;
		
		try
		{
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : R�cup�ration de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Cr�ation d'un statement
			statement = connection.createStatement();
			
			String sql = "SELECT * FROM `etudiant` WHERE numero_etudiant = '" + numeroEtudiant + "'";
			
			// Etape 4 : Ex�cution requ�te
			result = statement.executeQuery(sql);
			
			System.out.println("Etudiant correspondant au num�ro '" + numeroEtudiant + "' :");
			
			while (result.next())
			{
				System.out.println(result.getString("prenom") + " " + result.getString("nom"));
				
				etudiant = new Etudiant(result.getString("numero_etudiant"),
										result.getString("prenom"),
										result.getString("nom"));
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
				// Etape 5 : Lib�rer ressources de la m�moire
				connection.close();
				statement.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return etudiant;
	}
	
	public static Ecole trouverEcole(String numeroEtudiant)
	{
		// Information d'acc�s � la base de donn�es
		String url = "jdbc:mysql://127.0.0.1/tp_jdbc?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String login = "root";
		String password = "";
		
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		Ecole ecole = null;
		
		try
		{
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : R�cup�ration de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Cr�ation d'un statement
			statement = connection.createStatement();
			
			String sql = "SELECT ecole.nom_ecole, ecole.adresse_ecole FROM ecole, inscription, etudiant\r\n" + 
						"WHERE ecole.nom_ecole = inscription.nom_ecole\r\n" + 
						"AND inscription.numero_etudiant = etudiant.numero_etudiant\r\n" + 
						"AND etudiant.numero_etudiant = '" + numeroEtudiant + "'";
			
			// Etape 4 : Ex�cution requ�te
			result = statement.executeQuery(sql);
			
			System.out.println("Etudiant correspondant au num�ro '" + numeroEtudiant + "' :");
			
			while (result.next())
			{
				System.out.println(result.getString("prenom") + " " + result.getString("nom"));
				
				ecole = new Ecole(result.getString("nom_ecole"),
										result.getString("adresse_ecole"));
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
				// Etape 5 : Lib�rer ressources de la m�moire
				connection.close();
				statement.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return ecole;
	}
	
	public static void afficherEtudiants(int limite)
	{
		// Information d'acc�s � la base de donn�es
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
			
			// Etape 2 : R�cup�ration de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Cr�ation d'un statement
			statement = connection.createStatement();
			
			String sql = "SELECT * FROM `etudiant` LIMIT " + limite;
			
			// Etape 4 : Ex�cution requ�te
			result = statement.executeQuery(sql);
			
			System.out.println("Liste des " + limite + " premiers �tudiants :");
			
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
				// Etape 5 : Lib�rer ressources de la m�moire
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
