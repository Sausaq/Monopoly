package org.example.javaprojectmonopoly;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;


public class NewPlayerMenu extends StackPane {
    private MyButton createButton = new MyButton("Новый игрок",400, 170);
    private MyButton cancelButton = new MyButton("Назад",400, 170);


    public NewPlayerMenu() {
        ImageView background = new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/background.png")));

        Rectangle rectangle = new Rectangle(1200, 800);
        rectangle.setFill(Color.valueOf("#A6A6A6"));
        rectangle.setArcHeight(50);
        rectangle.setArcWidth(50);
        rectangle.setStroke(Color.valueOf("#545454"));
        rectangle.setStrokeWidth(30);


        VBox fields = new VBox();
        fields.setMaxSize(944, 638);
        ImageView monopoly = new ImageView(new Image(getClass().getResourceAsStream("/org/example/javaprojectmonopoly/images/monopoly_icon.jpg")));

        monopoly.setFitWidth(140);
        monopoly.setFitHeight(140);

        Rectangle nameBackground = new Rectangle(200, 110);
        nameBackground.setFill(Color.valueOf("#FF3131"));
        nameBackground.setArcWidth(20);
        nameBackground.setArcHeight(20);

        Label nameLabel = new Label("Имя");
        nameLabel.setFont(Font.font(20));

        StackPane name = new StackPane(nameBackground, nameLabel);

        Rectangle textFieldBack = new Rectangle(720, 110);
        textFieldBack.setFill(Color.valueOf("#545454"));
        textFieldBack.setArcWidth(20);
        textFieldBack.setArcHeight(20);
        textFieldBack.setStroke(Color.BLACK);
        textFieldBack.setStrokeWidth(2);
        TextField nameTextField = new TextField();
        nameTextField.setFont(Font.font(20));
        nameTextField.setStyle("-fx-background-color: #545454; -fx-text-fill: white");
        nameTextField.setMaxSize(700, 90);
        StackPane nameText = new StackPane(textFieldBack, nameTextField);

        HBox.setMargin(name, new Insets(10,0,0,0));
        HBox.setMargin(nameText, new Insets(10,0,0,20));
        HBox nameAndText = new HBox(name, nameText);

        Rectangle colorTextBackground = new Rectangle(200, 110);
        colorTextBackground.setFill(Color.valueOf("#FF3131"));
        colorTextBackground.setArcWidth(20);
        colorTextBackground.setArcHeight(20);
        Label colorLabel = new Label("Цвет");
        colorLabel.setFont(Font.font(20));

        StackPane colorText = new StackPane(colorTextBackground, colorLabel);

        Rectangle colorChooseBack = new Rectangle(720, 110);
        colorChooseBack.setFill(Color.valueOf("#545454"));
        colorChooseBack.setArcWidth(20);
        colorChooseBack.setArcHeight(20);
        colorChooseBack.setStroke(Color.BLACK);
        colorChooseBack.setStrokeWidth(2);

        ColorPicker colorChoose = new ColorPicker();
        colorChoose.setMaxSize(700, 90);
        colorChoose.setStyle("-fx-background-color: #545454");


        StackPane colorChooseField = new StackPane(colorChooseBack, colorChoose);


        HBox.setMargin(name, new Insets(10,0,0,0));
        HBox.setMargin(nameText, new Insets(10,0,0,20));
        HBox.setMargin(colorText, new Insets(10,0,0,0));
        HBox.setMargin(colorChooseField, new Insets(10,0,0,20));
        HBox color = new HBox(colorText, colorChooseField);

        HBox buttons = new HBox(createButton, cancelButton);
        HBox.setMargin(createButton, new Insets(20,0,0,0));
        HBox.setMargin(cancelButton, new Insets(20,0,0,144));


        fields.getChildren().addAll(monopoly, nameAndText, color, buttons);

        createButton.setOnAction(e -> {
            Color selectedColor = colorChoose.getValue();
            String hexColor = String.format("#%02X%02X%02X",
                    (int) (selectedColor.getRed() * 255),
                    (int) (selectedColor.getGreen() * 255),
                    (int) (selectedColor.getBlue() * 255));
            Player player = new Player(nameTextField.getText(), hexColor);
            Menu.updatePlayersList(player);
            DBManager.insertPlayer(player);
            System.out.println(nameTextField.getText() + hexColor);
        });


        getChildren().addAll(background, rectangle, fields);
        setAlignment(Pos.CENTER);
    }

    public Button getCreate(){
        return createButton;
    }

    public Button getCancelButton(){
        return cancelButton;
    }
}
