package Lesson6.client;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.List;

public class ClietChat extends Application {
    public static final List<String> USERS = List.of("Milana", "Helen", "Anastaisha");
    public static final String NETWORK_ERROR_TITLE = "Сетевая ошибка";
    public static final String NETWORK_ERROR_CONNECTION_TYPE = "Невозможно установить сетевое соединение.";
    private Stage primaryStage;


    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("sample.fxml"));

        Parent root = fxmlLoader.load();

        this.primaryStage.setScene(new Scene(root));

        primaryStage.show();
        Controller controller = fxmlLoader.getController();
        connectToServer(controller);
    }

    private void connectToServer(Controller controller) {
        try {
            Network network = new Network();
            boolean result = network.connect();
            if (!result) {
                String errMsg = "Не удалось установить соединение с сервером!";
                showNetworkErrorDialog(NETWORK_ERROR_CONNECTION_TYPE, errMsg);
                return;
            }

            controller.setNetwork(network);
            controller.setApplication(this);

            primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent windowEvent) {
                    network.close();
                }
            });

        } catch (Exception e) {
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
    public void showNetworkErrorDialog(String type, String details) {
        showErrorDialog(NETWORK_ERROR_TITLE, type, details);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
