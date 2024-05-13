package org.example.javaprojectmonopoly;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Company extends StackPane {
    private Rectangle border = new Rectangle();
    private int cost;
    private Label label = new Label(String.valueOf(cost) + " $");
    private Player author;
    private int x;
    private int y;
    private int incomePrice;
    private boolean isFree = true;

    public Company(int type, int x, int y,boolean isFree){
        this.x = x;
        this.y = y;
        this.isFree = isFree;
        border.setFill(Color.valueOf("#FFBD59"));
        border.setStroke(Color.BLACK);
        border.setArcWidth(10);
        border.setArcHeight(10);
        setMargin(border, new Insets(1));

        switch (type){
            case 1:
                setSize(150, 150);
                break;
            case 2:
                setSize(90, 150);
                break;
            case 3:
                setSize(150, 90);
                break;
            default:
                System.out.println("NIFIGA");

        }

        getChildren().add(border);
    }

    public Company(int type, int x, int y, ImageView image, boolean isFree){
        this.x = x;
        this.y = y;
        this.isFree = isFree;
        border.setFill(Color.valueOf("#FFBD59"));
        border.setStroke(Color.BLACK);
        border.setArcWidth(10);
        border.setArcHeight(10);
        setMargin(border, new Insets(1));
        image.setFitWidth(80);
        image.setFitHeight(80);

        switch (type){
            case 1:
                setSize(150, 150);
                break;
            case 2:
                setSize(90, 150);
                break;
            case 3:
                setSize(150, 90);
                break;
            default:
                System.out.println("NIFIGA");

        }

        getChildren().addAll(border, image);
    }

    public Company(int type, int x, int y, ImageView flag, int cost, ImageView company, int incomePrice){
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.incomePrice = incomePrice;
        border.setFill(Color.valueOf("#FFBD59"));
        border.setStroke(Color.BLACK);
        border.setArcWidth(10);
        border.setArcHeight(10);
        setMargin(border, new Insets(1));
        getChildren().add(border);

        flag.setFitWidth(45);
        flag.setFitHeight(45);
        company.setFitHeight(50);
        company.setFitWidth(60);
        label.setText(String.valueOf(cost) + " $");
        label.setFont(Font.font(14));

        switch (type) {
            case 1:
                setSize(150, 150);
                break;
            case 2:
                if (y == 0) {
                    VBox companyAndCost = new VBox();
                    getChildren().add(companyAndCost);
                    companyAndCost.getChildren().addAll(flag, company, label);
                    companyAndCost.setAlignment(Pos.TOP_CENTER);
                    setMargin(companyAndCost, new Insets(10, 0, 0, 0));
                } else if (y == 7) {
                    VBox companyAndCost = new VBox();
                    getChildren().add(companyAndCost);
                    companyAndCost.setAlignment(Pos.BOTTOM_CENTER);
                    companyAndCost.getChildren().addAll(label, company, flag);
                    setMargin(companyAndCost, new Insets(0, 0, 10, 0));
                }
                setSize(90, 150);
                break;
            case 3:
                if (x == 0) {
                    HBox flagAndCompany = new HBox();
                    VBox companyAndCost = new VBox();

                    flagAndCompany.getChildren().addAll(flag, companyAndCost);
                    flagAndCompany.setAlignment(Pos.CENTER_LEFT);
                    companyAndCost.getChildren().addAll(company, label);
                    companyAndCost.setAlignment(Pos.CENTER_LEFT);


                    getChildren().add(flagAndCompany);
                    setMargin(flagAndCompany, new Insets(0, 0, 0, 10));
                    HBox.setMargin(companyAndCost, new Insets(0, 0, 0, 10));
                } else if (x == 12) {
                    HBox flagAndCompany = new HBox();
                    VBox companyAndCost = new VBox();

                    flagAndCompany.getChildren().addAll(companyAndCost, flag);
                    flagAndCompany.setAlignment(Pos.CENTER_RIGHT);
                    companyAndCost.getChildren().addAll(company, label);
                    companyAndCost.setAlignment(Pos.CENTER_RIGHT);

                    getChildren().add(flagAndCompany);
                    setMargin(flagAndCompany, new Insets(0, 10, 0, 0));
                    HBox.setMargin(companyAndCost, new Insets(0, 10, 0, 0));

                }
                setSize(150, 90);
                break;
            default:
                System.out.println("NIFIGA");
        }
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setSize(int x, int y) {
        border.setHeight(y);
        border.setWidth(x);
    }

    public Rectangle getBack(){
        return border;
    }

    public int getCost(){
        return cost;
    }

    public Label getLabel() {
        return label;
    }


    public int getIncomePrice() {
        return incomePrice;
    }

    public void setAuthor(Player player){
        author = player;
    }

    public Player getAuthor(){
        return author;
    }

}

