package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

public class ViewController {

	@FXML
	private MenuBar mainmenu;

	@FXML
	private MenuItem miLer;

	@FXML
	private MenuItem miEscrever;

	@FXML
	private MenuItem miCriar;

	// File arquivo = new File("/home/user/nome_do_arquivo.txt");

	@FXML
	void handleMiEscreverAction(ActionEvent event) {
		FileChooser fc = new FileChooser();
		// fc.getExtensionFilters().add(new ExtensionFilter("TXT Files", "*.txt"));

		/*
		 * List<File> f = fc.showOpenMultipleDialog(null); if (f != null) { for (File
		 * file : f) { System.out.println(file.getAbsolutePath()); } } else {
		 * System.out.println("Arquivo não selecionado."); }
		 */

		File f = fc.showOpenDialog(null);
		if (f != null) {
			// System.out.println(f.getAbsolutePath());
			try {
				// FileWriter fw = new FileWriter(f, true); para escrever 'append' no arquivo
				FileWriter fw = new FileWriter(f);
				BufferedWriter bw = new BufferedWriter(fw);

				// escreve o conteúdo no arquivo
				bw.write("\nTexto a ser escrito no txt");

				// quebra de linha
				bw.newLine();

				Desktop.getDesktop().open(f);

				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				System.out.println("Terminado.");
			}
		} else
			System.out.println("Arquivo não selecionado.");
	}

	@FXML
	void handleMiLerAction(ActionEvent event) {
		FileChooser fc = new FileChooser();
		// fc.getExtensionFilters().add(new ExtensionFilter("TXT Files", "*.txt"));

		File f = fc.showOpenDialog(null);
		if (f != null) {
			try {
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);

				// enquanto houver mais linhas
				while (br.ready()) {
					// lê a proxima linha
					String linha = br.readLine();
					// faz algo com a linha
					System.out.println(linha);
				}

				br.close();
				fr.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("Terminado.");
			}
		} else
			System.out.println("Arquivo não selecionado.");
	}

	@FXML
	void handleMiCriarAction(ActionEvent event) {
		DirectoryChooser dc = new DirectoryChooser();
		File directory = dc.showDialog(null);
		System.out.println(directory.getAbsolutePath() + "\\test.doc");
		File f = new File(directory.getAbsolutePath() + "\\test.doc");

		try {
			f.createNewFile();

			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);

			// escreve o conteúdo no arquivo
			bw.write("\nTexto a ser escrito no txt");

			Desktop.getDesktop().open(f);

			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Terminado.");
		}
	}

}