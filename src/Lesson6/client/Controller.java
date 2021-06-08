package Lesson6.client;

import Lesson4.Main;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Controller {


    @FXML public ListView<String> usersList;
    @FXML private TextArea chatTextArea;
    @FXML private TextArea textMessageArea;
    @FXML private Button sendMessageButton;


    @FXML private void sendMessage() {
        chatTextArea.appendText(textMessageArea.getText());
        chatTextArea.appendText(System.lineSeparator());
        textMessageArea.clear();
    }

    @FXML
    public void initialize() {
        usersList.setItems(FXCollections.observableArrayList(ClietChat.USERS));
    }

    @FXML
    public void sendTextAreaMessage(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            event.consume();
            if (event.isShiftDown()) {
                textMessageArea.appendText(System.lineSeparator());
            } else {
                sendMessage();
            }
        }
    }
}
