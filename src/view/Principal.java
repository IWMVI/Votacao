package view;

import java.io.IOException;

import controller.Funcoes;

public class Principal {
	public static void main(String[] args) throws IOException{

		Menu menu = new Menu();
		Funcoes func = new Funcoes();

		do {
			menu.showMenu();
			func.showFuncoes(menu.getOpcao());
		} while (menu.getOpcao() != 0);
		
	}
}
