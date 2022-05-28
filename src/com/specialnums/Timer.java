package com.specialnums;

public class Timer implements Runnable {
    //class to stop calculations after 10 seconds
    int current;
    Thread toStop;
    Thread timer;
    SpecialNumbersFrame gui;

    public Timer(Thread toStop, SpecialNumbersFrame in) {
        gui = in;
        this.toStop = toStop;
    }

    @Override
    public void run() {
        current = 0;
        String before, after;
        timer = Thread.currentThread();
        while ((timer != null) && (current < 10)) {
                before = gui.resultTF.getText();
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    //ignore
                }
                after = gui.resultTF.getText();
                if (!after.equals(before)) {
                    timer = null;
                }
                current += 1;
        }
        if (current == 10) {
            toStop = null;
            gui.resultTF.setText("time exceeded");
            timer = null;
        }
    }
}
