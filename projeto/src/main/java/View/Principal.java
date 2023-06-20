package View;

import java.util.List;

import javax.swing.JOptionPane;

import DAO.SerieDAO;
import Model.Serie;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String texto = "SERIE - ESCOLHA UMA OPÇÃO\n\n1 – Adicionar Serie \n2 – Listar Serie \n3 – Buscar Serie \n4 – Atualizar Serie \n5 –Excluir Serie \n6 – Sair";
		Serie serie = new Serie();
		SerieDAO serDAO = new SerieDAO();
		int opcao = 0;

		while (opcao != 6) {
			try {
				opcao = Integer.parseInt(JOptionPane.showInputDialog(null, texto, "Sistema da Series", 1));
				switch (opcao) {
				case 1:
					serie.setNome_serie(JOptionPane.showInputDialog("Informe o nome da serie:"));
					serie.setAno_serie(Integer.parseInt((JOptionPane.showInputDialog("informe o Ano da Serie"))));
					serie.setNome_tema(JOptionPane.showInputDialog("informe o Nome do tema"));
					serie.setNome_streaming(JOptionPane.showInputDialog("Informe o nome do streaming"));
					serDAO.adicionarSerie(serie);
					JOptionPane.showMessageDialog(null, "Serie adicionada com sucesso!!!!");
					break;
				case 2:
					List<Serie> series = serDAO.ListarSerie();
					for (Serie seriel : series) {
						System.out.println("____Lista de Series____");
						System.out.println(seriel);
						System.out.println("_______________________");
					}
					break;
				case 3:
					long valor = Long.parseLong((JOptionPane.showInputDialog("Informe o código da Serie ")));
					serie = serDAO.buscarSerie(valor);
					System.out.println("_______________________");
					System.out.println(serie);
					System.out.println("_______________________");
					break;
				case 4:
					serie.setCod_serie(Long.parseLong((JOptionPane.showInputDialog("Informe o cod da serie"))));
					serie.setNome_serie(JOptionPane.showInputDialog("Informe o Nome"));
					serie.setAno_serie(Integer.parseInt((JOptionPane.showInputDialog("informe o Ano da Serie"))));
					serie.setNome_tema(JOptionPane.showInputDialog("Informe o tema da serie"));
					serie.setNome_streaming(JOptionPane.showInputDialog("Informe o streaming da serie"));
					serDAO.atualizarSerie(serie);
					JOptionPane.showMessageDialog(null, "Serie atualizada com Sucesso!!!!");
					break;
				case 5:
					long valor1 = Long.parseLong((JOptionPane.showInputDialog("Informe o código da Serie ")));
					serie = serDAO.excluirSerie(valor1);
					List<Serie> editoras2 = serDAO.ListarSerie();
					for (Serie ser : editoras2) {
						System.out.println(ser);
						System.out.println("-------------------------------");
					}
					JOptionPane.showMessageDialog(null, "Operação Realizada com Sucesso!!");
					break;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Informe valores Válidos!!");
			} // catch

		}
	}
}
