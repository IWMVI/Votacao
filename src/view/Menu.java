package view;

import javax.swing.JOptionPane;

public class Menu {

	private int opcao;

	public int getOpcao() {
		return opcao;
	}

	public void showMenu() {
		opcao = Integer.parseInt(JOptionPane.showInputDialog(
				"---- MENU ----\n" + "01. Cadastrar Candidato\n" + "02. Cadastrar Eleitor\n" + "03. Cadastrar Votação\n"
						+ "04. Resultados\n" + "05. Gravar Dados\n" + "06. Acessar Dados\n" + "00. Finalizar"));
	}
}
