package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Serie;
import projeto.ConnectionFactory;

// fazendo a conexão
public class SerieDAO {
	private ConnectionFactory Connection;
	public SerieDAO() {
		this.Connection= new ConnectionFactory();
	}
	
// criando o metodo adicionarSerie que vai se comunicar com o banco de dados!!!

	public void adicionarSerie(Serie serie) {
		String sql = "INSERT INTO serie (nome_serie,ano_serie,nome_tema,nome_streaming)VALUES(?,?,?,?)";
		Connection conn = Connection.conexao();
		try {
			PreparedStatement prepareStatement = conn.prepareStatement(sql);
			prepareStatement.setString(1, serie.getNome_serie());
			prepareStatement.setInt(2, serie.getAno_serie());
			prepareStatement.setString(3, serie.getNome_tema());
			prepareStatement.setString(4, serie.getNome_streaming());
			
			prepareStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//criando o metodo ListarSerie que vai se comunicar com o banco de dados e mostrar informações ao usuario!!! 
	public List<Serie> ListarSerie() {
		List<Serie> series = new ArrayList<Serie>();
		Connection conn = Connection.conexao();

		try {

			String sql = "SELECT * FROM serie";
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();
			while (resultado.next()) {
				Serie serie = new Serie();
				serie.setCod_serie(resultado.getLong("cod_serie"));
				serie.setNome_serie(resultado.getString("Nome_serie"));
				serie.setAno_serie(resultado.getInt("Ano_serie"));
				serie.setNome_tema(resultado.getString("Nome_tema"));
				serie.setNome_streaming(resultado.getString("Nome_streaming"));
				
				series.add(serie);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return series;
	}


           //Criando o metodo buscar serie, que vai ser comunicar com o banco e trazer apenas uma serie ultilizando seu codigo
               public Serie buscarSerie(long cod) {
               Serie serie = new Serie();
               Connection conn = Connection.conexao();
               try {
            	   String sql = "SELECT * FROM serie WHERE cod_serie = ? ";
            	   PreparedStatement prepareStatement = conn.prepareStatement(sql);
            	   prepareStatement.setLong(1, cod);
            	   ResultSet resultado = prepareStatement.executeQuery();
            	   resultado.next();
            	   serie.setCod_serie(resultado.getLong("Cod_serie"));
            	   serie.setNome_serie(resultado.getString("Nome_serie"));
            	   serie.setAno_serie(resultado.getInt("Ano_serie"));
            	   serie.setNome_tema(resultado.getString("Nome_tema"));
            	   serie.setNome_streaming(resultado.getString("Nome_Streaming"));
            	   } catch (SQLException e) {
            	   // TODO Auto-generated catch block
            	   e.printStackTrace();
            	   }
            	   return serie;// retorna a lista
            	   }
  
               //Criando o metodo atualizarSerie que vai se comunicar com o banco de dados e atualiar uma serie existente no mesmo
               public void atualizarSerie(Serie serie) {
            	   Connection conn = Connection.conexao();
            	   try {
            	   String sql = "Update serie set nome_serie = ?, ano_serie = ?, nome_tema = ?, nome_streaming = ? where cod_serie = ?";
            	   PreparedStatement prepareStatement = 
            	   conn.prepareStatement(sql);
            	   prepareStatement.setString(1,serie.getNome_serie());
            	   prepareStatement.setInt(2,serie.getAno_serie());
            	   prepareStatement.setString(3,serie.getNome_tema());
            	   prepareStatement.setString(4,serie.getNome_streaming());
            	   prepareStatement.setLong(5,serie.getCod_serie());
            	   prepareStatement.execute();
            	   } catch (SQLException e) {
            	   e.printStackTrace();
            	   }
            	   }

               
               //Criando o metodo excluirSerie que vai se comunicar com o banco de dados e excluir a serie pelo codigo
               public Serie excluirSerie(Long cod) {
            	   Serie serie = new Serie();
            	   Connection conn = Connection.conexao();
            	   try {
            	   String sql = "Delete from serie where cod_serie = ? ";
            	   PreparedStatement prepareStatement = conn.prepareStatement(sql);
            	   prepareStatement.setLong(1, cod);
            	   prepareStatement.execute();
            	   } catch (SQLException e) {
            	   // TODO Auto-generated catch block
            	   e.printStackTrace();
            	   }
            	   return serie;
            	   }
}

