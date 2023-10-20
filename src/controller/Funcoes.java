package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import entities.Candidato;
import entities.Eleitor;

public class Funcoes {

	Candidato[] candidato = new Candidato[2];
	Eleitor[] eleitor = new Eleitor[3];
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
							.parseInt(
									JOptionPane.showInputDialog("Número do partido do " + (i + 1) + "º candidato(a)"));
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
					int voto = Integer
							.parseInt(JOptionPane.showInputDialog(eleitor[i].getNome() + " informe seu voto"));
					if (voto == candidato[0].getPartido()) {
						aux1++;
					} else if (voto == candidato[1].getPartido()) {
						aux2++;
					} else {
						JOptionPane.showMessageDialog(null, "Opção de voto inválida!");
						i--;
					}
					eleitor[i].setVoto(voto);
				}
				candidato[0].setVotos(aux1);
				candidato[1].setVotos(aux2);
				break;

			case 4:
				for (Candidato total : candidato) {
					if (total != null) {
						JOptionPane.showMessageDialog(null,
								"Total de votos do candidato " + total.getNome() + " : " + total.getVotos());
					} else {
						JOptionPane.showMessageDialog(null, "Nenhuma votação cadastrada!");
						break;
					}
				}

				break;

			case 5:
				try {
					String nameArquivo = JOptionPane.showInputDialog(null, "Informe o nome do arquivo");
					BufferedWriter escrita = new BufferedWriter(new FileWriter(nameArquivo + ".txt"));

					for (Candidato c : candidato) {
						escrita.write(c.getNome() + "\n");
						escrita.write(c.getPartido() + "\n");
						escrita.write(c.getVotos() + "\n");
						escrita.newLine();
					}

					for (Eleitor e : eleitor) {
						escrita.write(e.getNome() + "\n");
						escrita.write(e.getVoto() + "\n");
						escrita.newLine();
					}

					escrita.close();
					JOptionPane.showMessageDialog(null, "Dados salvos no arquivo: " + nameArquivo);
				} catch (IOException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao gravar arquivo!");
				}
				break;

			case 6:
				try {
					String nameArquivo = JOptionPane.showInputDialog(null, "Informe o nome do arquivo");
					BufferedReader leitura = new BufferedReader(new FileReader(nameArquivo + ".txt"));

					Candidato[] c = new Candidato[2];
					Eleitor[] e = new Eleitor[3];

					for (int i = 0; i < c.length; i++) {
						c[i] = new Candidato();
						c[i].setNome(leitura.readLine());
						c[i].setPartido(Integer.parseInt(leitura.readLine()));
						c[i].setVotos(Integer.parseInt(leitura.readLine()));
						leitura.readLine();
					}

					for (int i = 0; i < e.length; i++) {
						e[i] = new Eleitor();
						e[i].setNome(leitura.readLine());
						e[i].setVoto(Integer.parseInt(leitura.readLine()));
						leitura.readLine();
					}

					leitura.close();

					candidato = c;
					eleitor = e;

					JOptionPane.showMessageDialog(null, "Resultados lidos do arquivo " + nameArquivo);
				} catch (IOException | NumberFormatException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao ler arquivo");
				}
				break;

			default:
				JOptionPane.showMessageDialog(null, "Opção inválida");
				break;
		}
	}
}
