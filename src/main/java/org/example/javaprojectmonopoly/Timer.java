package org.example.javaprojectmonopoly;

import javafx.scene.control.Label;

public class Timer implements Runnable {

    private int remainingMinutes;
    private int remainingSeconds;
    private Label label;
    private boolean running;

    public Timer() {
        this.remainingSeconds = 60;
        this.label = label;
        this.running = false;
    }

    @Override
    public void run() {
        try {
            running = true;
            while (running) {
                Thread.sleep(1000); // Приостанавливаем поток на секунду
                remainingSeconds--;
                if (remainingSeconds < 0) {
                    remainingMinutes--;
                    remainingSeconds = 59;
                }
                if (remainingMinutes < 0) {
                    break;
                }
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void restartTimer() {
        this.remainingSeconds = 60;
        running = false;
//        try {
//            join(); // Ждем завершения потока
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public void startTimer() {
        this.remainingSeconds = 60;
        running = true;
    }




    public int getRemainingMinutes() {
        return remainingMinutes;
    }

    public int getRemainingSeconds() {
        return remainingSeconds;
    }
}