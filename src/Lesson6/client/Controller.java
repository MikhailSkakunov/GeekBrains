package Lesson6.client;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.function.Consumer;


public class Controller {


    @FXML public ListView<String> userList;
    @FXML private TextArea chatTextArea;
    @FXML private TextArea textMessageArea;
    @FXML private Button sendMessageButton;
    @FXML TextArea chatHistory;

    private Network network;
    private ClietChat application;
    private String sender;



    @FXML private void sendMessage() {
        String message = textMessageArea.getText();
        String sender = null;
        if (!userList.getSelectionModel().isEmpty()) {
            sender = userList.getSelectionModel().getSelectedItem();
        }

        appendMessageToChat(sender, message);
        try {
            network.sendMessage(message);
        } catch (IOException e) {
            application.showNetworkErrorDialog("Ошибка передачи данных по сети", "Не удалось отправить сообщение!");
            e.printStackTrace();
        }
    }
    private void appendMessageToChat(String sender, String message) {
        chatHistory.appendText(DateFormat.getDateTimeInstance().format(new Date()));
        chatHistory.appendText(System.lineSeparator());
        if (sender != null) {
            String selectedUser = userList.getSelectionModel().getSelectedItem();
            chatHistory.appendText(sender + ":");
            chatHistory.appendText(System.lineSeparator());
        }
        chatHistory.appendText(message);
        chatHistory.appendText(System.lineSeparator());
        textMessageArea.clear();
    }

    @FXML
    public void initialize() {
        userList.setItems(FXCollections.observableArrayList(ClietChat.USERS));
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

    public void setNetwork(Network network) {
        this.network = network;
        network.waitMessages(new Consumer<String>() {
            @Override
            public void accept(String message) {
            appendMessageToChat("Server", message);
            }
        });
    }

    public void setApplication(ClietChat application) {
        this.application = application;

    }
}
