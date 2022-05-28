package com.specialnums;

import javax.swing.*;
import java.awt.*;

public class SpecialNumbersFrame extends JFrame {
    JPanel options = new JPanel();
    ButtonGroup optionsButton = new ButtonGroup();
    JCheckBox[] checkBoxes = new JCheckBox[11];
    JPanelCenter values = new JPanelCenter();
    JLabel nLabel = new JLabel("n:");
    JTextField nTF = new JTextField();
    JLabel kLabel = new JLabel("k:");
    JTextField kTF = new JTextField();
    JLabel resultLabel = new JLabel("result:");
    JTextField resultTF = new JTextField();
    JLabel rules = new JLabel("(k can't be bigger than n)");

    public SpecialNumbersFrame() {
        super("special numbers");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(550, 500);
        Font font = new Font("sans-serif", Font.PLAIN, 14);

        GridLayout mainLayout = new GridLayout(1, 2, 10, 10);
        setLayout(mainLayout);

        GridLayout optionsLayout = new GridLayout(11, 1, 5, 5);
        options.setLayout(optionsLayout);
        checkBoxes[0] = new JCheckBox("Factorial", true);
        checkBoxes[1] = new JCheckBox("Binomial theorem");
        checkBoxes[2] = new JCheckBox("Stirling 1. kind");
        checkBoxes[3] = new JCheckBox("Stirling 2. kind");
        checkBoxes[4] = new JCheckBox("Bell number");
        checkBoxes[5] = new JCheckBox("Euler 1. kind");
        checkBoxes[6] = new JCheckBox("Euler 2. kind");
        checkBoxes[7] = new JCheckBox("Harmonic number");
        checkBoxes[8] = new JCheckBox("Mersenne number");
        checkBoxes[9] = new JCheckBox("Fibonacci sequence");
        checkBoxes[10] = new JCheckBox("Lucas sequence");

        for (JCheckBox checkBox : checkBoxes) {
            checkBox.setFont(font);
            optionsButton.add(checkBox);
            options.add(checkBox);
        }
        add(options);
        BoxLayout valuesLayout = new BoxLayout(values, BoxLayout.Y_AXIS);
        values.setLayout(valuesLayout);
        values.setMaximumSize(new Dimension(200, 300));
        nLabel.setFont(font);
        values.add(nLabel);
        nTF.setMaximumSize(new Dimension(200, 30));
        nTF.setFont(font);
        values.add(nTF);
        kLabel.setFont(font);
        values.add(kLabel);
        kTF.setMaximumSize(new Dimension(200, 30));
        kTF.setFont(font);
        values.add(kTF);
        resultLabel.setFont(font);
        values.add(resultLabel);
        resultTF.setMaximumSize(new Dimension(200, 30));
        resultTF.setFont(font);
        resultTF.setEditable(false);
        values.add(resultTF);
        rules.setFont(font);
        values.add(rules);
        add(values);

        setVisible(true);
    }

    public Insets getInsets() {
        return new Insets(40, 20, 20, 20);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception exc) {
            //ignore
        }
    }

    public static void main(String[] args) {
        SpecialNumbersFrame.setLookAndFeel();
        new SpecialNumbersFrame();
    }
}
