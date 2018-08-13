package controller;

import java.awt.Desktop;
import java.io.File;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class ViewController {
	
    @FXML
    private MenuBar mainmenu;

    @FXML
    private MenuItem menuNew;

    @FXML
    private MenuItem menuOpen;

    @FXML
    void handleMenuOpenAction(ActionEvent event) {
    	FileChooser fc = new FileChooser();
    	fc.getExtensionFilters().add(new ExtensionFilter("PDF Files", "*.pdf"));
    	List<File> f = fc.showOpenMultipleDialog(null);
    	for(File file : f) {
    		System.out.println(file.getAbsolutePath());
    	}
    }

}