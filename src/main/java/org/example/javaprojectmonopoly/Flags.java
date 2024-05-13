package org.example.javaprojectmonopoly;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Flags {
    public static ImageView getFlagUSA(){
        return new ImageView(new Image( Flags.class.getResourceAsStream("/org/example/javaprojectmonopoly/images/flags/usa.png")));
    }

    public static ImageView getFlagBritain(){
        return new ImageView(new Image( Flags.class.getResourceAsStream("/org/example/javaprojectmonopoly/images/flags/britain.png")));
    }

    public static ImageView getFlagChina(){
        return new ImageView(new Image( Flags.class.getResourceAsStream("/org/example/javaprojectmonopoly/images/flags/china.png")));
    }

    public static ImageView getFlagFrance(){
        return new ImageView(new Image( Flags.class.getResourceAsStream("/org/example/javaprojectmonopoly/images/flags/france.png")));
    }

    public static ImageView getFlagGermany(){
        return new ImageView(new Image( Flags.class.getResourceAsStream("/org/example/javaprojectmonopoly/images/flags/germany.png")));
    }

    public static ImageView getFlagItaly(){
        return new ImageView(new Image( Flags.class.getResourceAsStream("/org/example/javaprojectmonopoly/images/flags/italy.png")));
    }

    public static ImageView getFlagJapan(){
        return new ImageView(new Image( Flags.class.getResourceAsStream("/org/example/javaprojectmonopoly/images/flags/japan.png")));
    }

    public static ImageView getFlagKorea(){
        return new ImageView(new Image( Flags.class.getResourceAsStream("/org/example/javaprojectmonopoly/images/flags/korea.png")));
    }

    public static ImageView getFlagSweden(){
        return new ImageView(new Image( Flags.class.getResourceAsStream("/org/example/javaprojectmonopoly/images/flags/sweden.png")));
    }

    public static ImageView getFlagSwiss(){
        return new ImageView(new Image( Flags.class.getResourceAsStream("/org/example/javaprojectmonopoly/images/flags/swiss.png")));
    }

    public static ImageView getStart(){
        return new ImageView(new Image( Flags.class.getResourceAsStream("/org/example/javaprojectmonopoly/images/otherCells/start.png")));
    }

    public static ImageView getCustoms(){
        return new ImageView(new Image( Flags.class.getResourceAsStream("/org/example/javaprojectmonopoly/images/otherCells/customs.png")));
    }

    public static ImageView getPrison(){
        return new ImageView(new Image( Flags.class.getResourceAsStream("/org/example/javaprojectmonopoly/images/otherCells/prison.png")));
    }

    public static ImageView getChill(){
        return new ImageView(new Image( Flags.class.getResourceAsStream("/org/example/javaprojectmonopoly/images/otherCells/chill.png")));
    }

}
