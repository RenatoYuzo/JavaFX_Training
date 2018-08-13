package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainViewController {

    @FXML
    private Button btnClickMe;

    @FXML
    private Label label01;

    @FXML
    void handleBntClickMeAction(ActionEvent event) {
    	label01.setText("Clicked.");
    }

}