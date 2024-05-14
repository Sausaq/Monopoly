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

import java.util.ArrayList;

public class Company extends StackPane {
    private int cost;
    private int incomePrice;
    private boolean isFree = true;
    private int[] stocks = new int[6];
    private int stockPrice;

    private Rectangle border = new Rectangle();
    private Label label = new Label(String.valueOf(cost) + " $");
    private Player author;
    private int width;
    private int height;
    private String otherTypes;


    public Company(int type, int width, int height, ImageView image,String otherTypes ,boolean isFree){
        this.width = width;
        this.height = height;
        this.isFree = isFree;
        this.otherTypes = otherTypes;
        border.setFill(Color.valueOf("#FFBD59"));
        border.setStroke(Color.BLACK);
        border.setArcWidth(10);
        border.setArcHeight(10);
        setMargin(border, new Insets(1));


        switch (type){
            case 1:
                setSize(150, 150);
                image.setFitWidth(90);
                image.setFitHeight(90);
                break;
            case 2:
                setSize(90, 150);
                image.setFitWidth(80);
                image.setFitHeight(50);
                break;
            case 3:
                setSize(150, 90);
                image.setFitWidth(80);
                image.setFitHeight(50);
                break;
            default:
                System.out.println("NIFIGA");

        }

        getChildren().addAll(border, image);
    }

    public Company(int type, int width, int height, ImageView flag, int cost, ImageView company, int incomePrice){
        this.width = width;
        this.height = height;
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
                if (height == 0) {
                    VBox companyAndCost = new VBox();
                    getChildren().add(companyAndCost);
                    companyAndCost.getChildren().addAll(flag, company, label);
                    companyAndCost.setAlignment(Pos.TOP_CENTER);
                    VBox.setMargin(label, new Insets(20, 0, 0, 0));
                    setMargin(companyAndCost, new Insets(10, 0, 0, 0));
                } else if (height == 7) {
                    VBox companyAndCost = new VBox();
                    getChildren().add(companyAndCost);
                    companyAndCost.setAlignment(Pos.BOTTOM_CENTER);
                    companyAndCost.getChildren().addAll(label, company, flag);
                    VBox.setMargin(label, new Insets(0, 0, 20, 0));
                    setMargin(companyAndCost, new Insets(0, 0, 10, 0));
                }
                setSize(90, 150);
                break;
            case 3:
                if (width == 0) {
                    HBox flagAndCompany = new HBox();
                    VBox companyAndCost = new VBox();

                    flagAndCompany.getChildren().addAll(flag, companyAndCost);
                    flagAndCompany.setAlignment(Pos.CENTER_LEFT);
                    companyAndCost.getChildren().addAll(company, label);
                    companyAndCost.setAlignment(Pos.CENTER_LEFT);

                    getChildren().add(flagAndCompany);
                    setMargin(flagAndCompany, new Insets(0, 0, 0, 10));
                    HBox.setMargin(companyAndCost, new Insets(0, 0, 0, 10));
                } else if (width == 12) {
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

    public Company(int type, int width, int height, ImageView flag, int cost, ImageView company, int incomePrice, int stockPrice, int[] stocks){
        this.width = width;
        this.height = height;
        this.cost = cost;
        this.incomePrice = incomePrice;
        this.stocks = stocks;
        this.stockPrice = stockPrice;
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
                if (height == 0) {
                    VBox companyAndCost = new VBox();
                    getChildren().add(companyAndCost);
                    companyAndCost.getChildren().addAll(flag, company, label);
                    companyAndCost.setAlignment(Pos.TOP_CENTER);
                    VBox.setMargin(label, new Insets(20, 0, 0, 0));
                    setMargin(companyAndCost, new Insets(10, 0, 0, 0));
                } else if (height == 7) {
                    VBox companyAndCost = new VBox();
                    getChildren().add(companyAndCost);
                    companyAndCost.setAlignment(Pos.BOTTOM_CENTER);
                    companyAndCost.getChildren().addAll(label, company, flag);
                    VBox.setMargin(label, new Insets(0, 0, 20, 0));
                    setMargin(companyAndCost, new Insets(0, 0, 10, 0));
                }
                setSize(90, 150);
                break;
            case 3:
                if (width == 0) {
                    HBox flagAndCompany = new HBox();
                    VBox companyAndCost = new VBox();

                    flagAndCompany.getChildren().addAll(flag, companyAndCost);
                    flagAndCompany.setAlignment(Pos.CENTER_LEFT);
                    companyAndCost.getChildren().addAll(company, label);
                    companyAndCost.setAlignment(Pos.CENTER_LEFT);

                    getChildren().add(flagAndCompany);
                    setMargin(flagAndCompany, new Insets(0, 0, 0, 10));
                    HBox.setMargin(companyAndCost, new Insets(0, 0, 0, 10));
                } else if (width == 12) {
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
        return width;
    }

    public int getY(){
        return height;
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

    public String getOtherTypes() {
        return otherTypes;
    }
}

