package ru.gb.java2.chat.client.controllers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import ru.gb.java2.chat.client.ClientChat;
import ru.gb.java2.chat.client.Dialogs.Dialogs;
import ru.gb.java2.chat.client.Network;

import ru.gb.java2.chat.client.model.ReadCommandListener;
import ru.gb.java2.chat.client.sevice.ChatHistory;
import ru.gb.java2.chat.clientserver.Command;
import ru.gb.java2.chat.clientserver.CommandType;
import ru.gb.java2.chat.clientserver.commands.ClientMessageCommandData;
import ru.gb.java2.chat.clientserver.commands.UpdateUsersListCommandData;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class ChatController {

    @FXML
    private ListView<String> usersList;
    @FXML
    private Button reconnectButton;
    @FXML
    public Button sendMessageButton;
    @FXML
    private Button sendButton;
    @FXML
    private TextArea chatHistory;
    @FXML
    private TextArea messageTextArea;
    private ChatHistory chatHistoryService;


    @FXML
    private void sendMessage() {
        String message = messageTextArea.getText().trim();
        if (message.isEmpty()) {
            messageTextArea.clear();
            return;
        }

        String recipient = null;
        if (!usersList.getSelectionModel().isEmpty()) {
            recipient = usersList.getSelectionModel().getSelectedItem();
        }

        try {
            if (recipient != null) {
                Network.getInstance().sendPrivateMessage(recipient, message);
            } else {
                Network.getInstance().sendMessage(message);
            }
        } catch (IOException e) {
            Dialogs.NetworkError.SEND_MESSAGE.show();
        }
        appendMessageToChat("Я", message);
    }

    private void appendMessageToChat(String sender, String message) {
        String appendString = chatHistory.getText();
        chatHistory.appendText(DateFormat.getDateTimeInstance().format(new Date()));
        chatHistory.appendText(System.lineSeparator());
        if (sender != null) {
            chatHistory.appendText(sender + ":");
            chatHistory.appendText(System.lineSeparator());
        }
        chatHistory.appendText(message);
        chatHistory.appendText(System.lineSeparator());
        chatHistory.appendText(System.lineSeparator());
        messageTextArea.clear();
        String appendStringNew = chatHistory.getText(appendString.length(), chatHistory.getLength());
        chatHistoryService.append(appendStringNew);
    }

    @FXML
    public void sendTextAreaMessage(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            event.consume(); // otherwise a new line will be added to the textArea after the sendFunction() call
            if (event.isShiftDown()) {
                messageTextArea.appendText(System.lineSeparator());
            } else {
                sendMessage();
            }
        }
    }
    private void createChatHistory() {
        this.chatHistoryService = new ChatHistory(Network.getInstance().getLastLogin());
        chatHistoryService.init();
    }


    public void initMessageHandler() {
        Network.getInstance().addReadMessageListener(new ReadCommandListener() {
            @Override
                public void processReceivedCommand(Command command) {
                if (!isActive()) {
                    return;
                }
                if (chatHistoryService == null) {
                    createChatHistory();
                    loadHistory();
                }


                    if (command.getType() == CommandType.CLIENT_MESSAGE) {
                        ClientMessageCommandData data = (ClientMessageCommandData) command.getData();
                        Platform.runLater(() -> ChatController.this.appendMessageToChat(data.getSender(), data.getMessage()));
                    } else if (command.getType() == CommandType.UPDATE_USERS_LIST) {
                        UpdateUsersListCommandData data = (UpdateUsersListCommandData) command.getData();
                        updateUsersList(data.getUsers());
                    }
            }
        });
    }



    public void updateUsersList(List<String> users) {
        Platform.runLater(() -> usersList.setItems(FXCollections.observableArrayList(users)));
    }
    public void reconnectToServer(ActionEvent actionEvent) {
        Network network = Network.getInstance();
        if (!network.isConnected()) {
            network.connect();
        }
    }
    public void closeChat(ActionEvent actionEvent) throws Exception {
        chatHistoryService.close();
        ClientChat.INSTANCE.getPrimaryStage().close();
    }
    private void loadHistory() {

    }
    private boolean isActive() {
        return false;
    }
}
