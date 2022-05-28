package com.specialnums;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SpecialNumberEvent implements ActionListener, ItemListener, Runnable {
    SpecialNumbersFrame gui;
    Thread calculator;
    Thread timer;

    public SpecialNumberEvent(SpecialNumbersFrame in) {
        gui = in;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        calculator = new Thread(this);
        calculator.start();
        timer = new Thread(new Timer(calculator, gui));
        timer.start();
    }

    @Override
    public void itemStateChanged(ItemEvent event) {
        if (gui.optionsButton.getSelection() != null) {
            int chosen = Integer.parseInt(gui.optionsButton.getSelection().getActionCommand());
            gui.kTF.setEnabled((chosen != 0) && (chosen != 4) && (chosen < 7));
        }
    }

    @Override
    public void run() {
        SpecialNumbersCalculations calc = new SpecialNumbersCalculations();

        String nStr = gui.nTF.getText();
        long n = 0;
        long ans = 0;
        int chosen = 0;

        try {
            chosen = Integer.parseInt(gui.optionsButton.getSelection().getActionCommand());
        } catch (NullPointerException e) {
            gui.resultTF.setText("choose number to calculate");
            return;
        }

        try {
            n = Long.parseLong(nStr);
        }
        catch (NumberFormatException | NullPointerException exception) {
            gui.resultTF.setText("incorrect numbers");
        }

        if ((chosen == 0) || (chosen == 4) || (chosen >= 8)) {

            switch (chosen) {
                case 0 -> ans = calc.factorial(n);
                case 4 -> ans = calc.bell(n);
                case 8 -> ans = calc.mersenne(n);
                case 9 -> ans = calc.fibonacci(n);
                case 10 -> ans = calc.lucas(n);
            }
            gui.resultTF.setText(String.valueOf(ans));
        }
        else if (chosen == 7) {
            double ansD = calc.harmonic(n);
            gui.resultTF.setText(String.valueOf(ansD));
        }
        else {
            long k = 0;
            String kStr = gui.kTF.getText();
            try {
                k = Long.parseLong(kStr);
            } catch (NumberFormatException | NullPointerException exception) {
                gui.resultTF.setText("incorrect numbers");
            }
            System.out.println(n + " " + k);
            switch (chosen) {
                case 1 -> ans = calc.binomialTheorem(n, k);
                case 2 -> ans = calc.stirlingFirstKind(n, k);
                case 3 -> ans = calc.stirlingSecondKind(n, k);
                case 5 -> ans = calc.eulerFirstKind(n, k);
                case 6 -> ans = calc.eulerSecondKind(n, k);
            }
            gui.resultTF.setText(String.valueOf(ans));
        }
    }

}
