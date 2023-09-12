package controller;

import javax.swing.JOptionPane;

import entities.Candidato;
import entities.Eleitor;

public class Funcoes {

	Candidato[] candidato = new Candidato[2];
	Eleitor[] eleitor = new Eleitor[10];
	Candidato cand = new Candidato();
	Eleitor elei = new Eleitor();

	public void showFuncoes(int opcao) {
		switch (opcao) {
		case 0:
			JOptionPane.showMessageDialog(null, "Finalizado!");
			break;

		case 1:
			for (int i = 0; i < candidato.length; i++) {
				String name = JOptionPane.showInputDialog(null, "Nome do " + (i + 1) + "º candidato(a)");
				int partido = Integer
						.parseInt(JOptionPane.showInputDialog("Número do partido do " + (i + 1) + "º candidato(a)"));
				candidato[i] = new Candidato(name, partido);
			}
			break;

		case 2:
			for (int i = 0; i < eleitor.length; i++) {
				String name = JOptionPane.showInputDialog("Informe o nome do " + (i + 1) + "º eleitor");
				eleitor[i] = new Eleitor(name);
			}
			break;

		case 3:
			int aux1 = 0, aux2 = 0;
			for (int i = 0; i < eleitor.length; i++) {
				int voto = Integer.parseInt(JOptionPane.showInputDialog(eleitor[i].getNome() + " informe seu voto"));
				if (voto == candidato[0].getPartido()) {
					aux1++;
				} else if (voto == candidato[1].getPartido()) {
					aux2++;
				} else {
					JOptionPane.showMessageDialog(null, "Opção de voto inválida!");
					i--;
				}
			}
			candidato[0].setVotos(aux1);
			candidato[1].setVotos(aux2);
			break;

		case 4:
			for (Candidato total : candidato) {
				JOptionPane.showMessageDialog(null,
						"Total de votos do candidato " + total.getNome() + " : " + total.getVotos());
			}
			break;

		default:
			JOptionPane.showMessageDialog(null, "Opção inválida");
			break;
		}
	}
}
