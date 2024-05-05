//package org.example.javaprojectmonopoly;
//
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.ChoiceBox;
//import javafx.scene.control.Label;
//import javafx.scene.control.ListCell;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//import javafx.util.Callback;
//
//public class рррр extends Application {
//    @Override
//    public void start(Stage stage) {
//        ChoiceBox<StackPane> choiceBox = new ChoiceBox<>();
//        // Добавление StackPane как элементов
//        choiceBox.getItems().addAll(
//                new StackPane(new Label("Опция 1")),
//                new StackPane(new Label("Опция 2")),
//                new StackPane(new Label("Опция 3"))
//        );
//
//        // Настройка cell factory для изменения отображения элементов
//        choiceBox.setCellFactory(new Callback<ListView<StackPane>, ListCell<StackPane>>() {
//            @Override
//            public ListCell<StackPane> call(ListView<StackPane> listView) {
//                return new ListCell<StackPane>() {
//                    @Override
//                    protected void updateItem(StackPane item, boolean empty) {
//                        super.updateItem(item, empty);
//                        if (empty || item == null) {
//                            setGraphic(null);
//                        } else {
//                            setGraphic(item);
//                        }
//                    }
//                };
//            }
//        });
//
//        Scene scene = new Scene(choiceBox, 300, 250);
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
