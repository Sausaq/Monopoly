package org.example.javaprojectmonopoly;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class Timer implements Runnable {

    private int remainingMinutes;
    private int remainingSeconds;
    private Label label;
    private boolean running;
    private Thread timerThread;

    public Timer(Label label) {
        this.remainingSeconds = 60;
        this.label = label;
        this.running = false;
    }

    @Override
    public void run() {
        try {
            running = true;
            while (running) {
                Thread.sleep(1000);
                remainingSeconds--;
                if (remainingSeconds < 0) {
                    remainingMinutes--;
                    remainingSeconds = 59;
                }
                if (remainingMinutes < 0) {
                    break;
                }
                updateLabel();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void startTimer() {
        if (timerThread == null || !timerThread.isAlive()) {
            timerThread = new Thread(this);
            timerThread.start();
        }
    }
    public void stopTimer() {
        running = false;
        timerThread.interrupt();
    }
    public void restartTimer() {
        this.remainingMinutes = 0;
        this.remainingSeconds = 60;
        stopTimer();
        startTimer();
    }
    private void updateLabel() {
        Platform.runLater(() -> {
            if (label != null) {
                label.setText(String.format("%02d:%02d", remainingMinutes, remainingSeconds));
            }
        });
    }
    public int getRemainingMinutes() {
        return remainingMinutes;
    }
    public int getRemainingSeconds() {
        return remainingSeconds;
    }
}
