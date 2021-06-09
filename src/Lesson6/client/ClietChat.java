package Lesson6.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

public class ClietChat extends Application {
    public static final List<String> USERS = List.of("Milana", "Helen", "Anastaisha");
    public static final String NETWORK_ERROR_TITLE = "Сетевая ошибка";
    public static final String NETWORK_ERROR_CONNECTION_TYPE = "Невозможно установить сетевое соединение.";



    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("sample.fxml"));

        Parent root = fxmlLoader.load();

        primaryStage.setScene(new Scene(root));

        primaryStage.show();
        connectToServer();
    }

    private void connectToServer() {
        try {
            Network network = new Network();
            boolean result = network.connect();
            if (!result) {
                String errMsg = "Не удалось установить соединение с сервером!";
                showNetworkErrorDialog(NETWORK_ERROR_CONNECTION_TYPE, errMsg);
                return;
            }
            Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        }
          catch (UnknownHostException e) {
            String errMsg = "Хост неизвестен!";
            System.err.println(errMsg);
            showNetworkErrorDialog(NETWORK_ERROR_CONNECTION_TYPE, errMsg);
            e.printStackTrace();
        } catch (IOException e) {
            String errMsg = "Не удалось установить соединение с сервером!";
            System.err.println(errMsg);
            showNetworkErrorDialog(NETWORK_ERROR_CONNECTION_TYPE, errMsg);
            e.printStackTrace();
        }

    }

    private void showErrorDialog(String title, String type, String details) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(type);
        alert.setContentText(details);
        alert.showAndWait();

    }
    private void showNetworkErrorDialog(String type, String details) {
        showErrorDialog(NETWORK_ERROR_TITLE, type, details);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
