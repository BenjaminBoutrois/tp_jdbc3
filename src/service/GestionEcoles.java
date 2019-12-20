package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import metier.Ecole;
import metier.Etudiant;

public class GestionEcoles {
	public static void ajouterEcole(Ecole ecole)
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
			
			String sql = "INSERT INTO `ecole` VALUES ('" + ecole.getNomEcole() + "',"
							+ " '" + ecole.getAdresse() + "')";
			
			// Etape 4 : Ex�cution requ�te
			statement.executeUpdate(sql);
			
			System.out.println("Ajout de l'�cole '" + ecole.getNomEcole() + "'.");
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
	
	public static void modifierEcole(String nomAncienneEcole, Ecole nouvelleEcole)
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
					+ "SET `nom_ecole` = '" + nouvelleEcole.getNomEcole() + "',"
					+ "`adresse_ecole` = '" + nouvelleEcole.getAdresse() + "',"
					+ "WHERE `nom_ecole` = '" + nomAncienneEcole + "'";
			
			// Etape 4 : Ex�cution requ�te
			statement.executeUpdate(sql);
			
			System.out.println("Modification de l'�cole '" + nomAncienneEcole + "'"
					+ " en '" + nouvelleEcole.getNomEcole() + "'.");
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
	
	public static void supprimerEcole(String nomEcole)
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
			
			String sql = "DELETE FROM `ecole` WHERE nom_ecole = '" + nomEcole + "'";
			
			// Etape 4 : Ex�cution requ�te
			statement.executeUpdate(sql);
			
			System.out.println("Suppression de l'�cole '" + nomEcole + "'.");
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
	
	public static Ecole trouverEcole(String nomEcole)
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
			
			String sql = "SELECT * FROM `ecole` WHERE nom_ecole = '" + nomEcole + "'";
			
			// Etape 4 : Ex�cution requ�te
			result = statement.executeQuery(sql);
			
			System.out.println("Ecole correspondante � '" + nomEcole + "' :");
			
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
	
	public static List<Etudiant> trouverEtudiants(String nomEcole)
	{
		// Information d'acc�s � la base de donn�es
		String url = "jdbc:mysql://127.0.0.1/tp_jdbc?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String login = "root";
		String password = "";
		
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		List<Etudiant> etudiants = null;
		
		try
		{
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : R�cup�ration de la connexion
			connection = DriverManager.getConnection(url, login, password);
			
			// Etape 3 : Cr�ation d'un statement
			statement = connection.createStatement();
			
			String sql = "SELECT etudiant.nom, etudiant.prenom, etudiant.numero_etudiant" +
						"FROM ecole, inscription, etudiant\r\n" + 
						"WHERE ecole.nom_ecole = inscription.nom_ecole\r\n" + 
						"AND inscription.numero_etudiant = etudiant.numero_etudiant\r\n" + 
						"AND ecole.nom_ecole = '" + nomEcole + "'";
			
			// Etape 4 : Ex�cution requ�te
			result = statement.executeQuery(sql);
			
			System.out.println("Etudiants correspondant � l'�cole '" + nomEcole + "' :");
			
			etudiants = new ArrayList<Etudiant>();
			
			while (result.next())
			{
				System.out.println(result.getString("prenom") + " " + result.getString("nom"));
				
				etudiants.add(new Etudiant(result.getString("numero_etudiant"),
											result.getString("prenom"),
											result.getString("nom")));
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
		return etudiants;
	}
	
	public static void afficherEcoles(int limite)
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
			
			String sql = "SELECT * FROM `ecole`";
			
			// Etape 4 : Ex�cution requ�te
			result = statement.executeQuery(sql);
			
			System.out.println("Liste des " + limite + " premi�res �coles :");
			
			while (result.next())
			{
				System.out.println(result.getString("nom_ecole") + " " + result.getString("adresse_ecole"));
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
