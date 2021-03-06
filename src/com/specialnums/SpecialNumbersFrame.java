package com.specialnums;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SpecialNumbersFrame extends JFrame {
    SpecialNumberEvent eventListener = new SpecialNumberEvent(this);

    //components
    JPanel options = new JPanel();
    ButtonGroup optionsButton = new ButtonGroup();
    ArrayList<JCheckBox> checkBoxes = new ArrayList<>();
    JPanelCenter values = new JPanelCenter();
    JLabel nLabel = new JLabel("n:");
    JTextField nTF = new JTextField();
    JLabel kLabel = new JLabel("k:");
    JTextField kTF = new JTextField();
    JButton calculateButton = new JButton("calculate...");
    JLabel resultLabel = new JLabel("result:");
    JTextField resultTF = new JTextField();
    JLabel rules = new JLabel("(k can't be bigger than n)");

    public SpecialNumbersFrame() {
        //casual settings
        super("special numbers");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(550, 500);
        //font
        Font font = new Font("sans-serif", Font.PLAIN, 14);

        //main layout
        GridLayout mainLayout = new GridLayout(1, 2, 10, 10);
        setLayout(mainLayout);

        //menu components
        GridLayout optionsLayout = new GridLayout(11, 1, 5, 5);
        options.setLayout(optionsLayout);
        checkBoxes.add(new JCheckBox("Factorial"));
        checkBoxes.add(new JCheckBox("Binomial theorem"));
        checkBoxes.add(new JCheckBox("Stirling 1. kind"));
        checkBoxes.add(new JCheckBox("Stirling 2. kind"));
        checkBoxes.add(new JCheckBox("Bell number"));
        checkBoxes.add(new JCheckBox("Euler 1. kind"));
        checkBoxes.add(new JCheckBox("Euler 2. kind"));
        checkBoxes.add(new JCheckBox("Harmonic number"));
        checkBoxes.add(new JCheckBox("Mersenne number"));
        checkBoxes.add(new JCheckBox("Fibonacci sequence"));
        checkBoxes.add(new JCheckBox("Lucas sequence"));

        for (int i = 0; i < checkBoxes.size(); i++) {
            JCheckBox checkBox = checkBoxes.get(i);
            checkBox.setFont(font);
            optionsButton.add(checkBox);
            options.add(checkBox);
            checkBox.setActionCommand(String.valueOf(i));
            checkBox.addItemListener(eventListener);
        }

        add(options);

        //values components - text fields with n, k and result
        BoxLayout valuesLayout = new BoxLayout(values, BoxLayout.Y_AXIS);
        values.setLayout(valuesLayout);
        values.setMaximumSize(new Dimension(200, 300));

        nLabel.setFont(font);
        values.add(nLabel);

        nTF.setMaximumSize(new Dimension(400, 30));
        nTF.setFont(font);
        nTF.addActionListener(eventListener);
        values.add(nTF);

        kLabel.setFont(font);
        values.add(kLabel);

        kTF.setMaximumSize(new Dimension(400, 30));
        kTF.setFont(font);
        kTF.addActionListener(eventListener);
        values.add(kTF);

        calculateButton.setFont(font);
        calculateButton.addActionListener(eventListener);
        values.add(calculateButton);

        resultLabel.setFont(font);
        values.add(resultLabel);

        resultTF.setMaximumSize(new Dimension(400, 30));
        resultTF.setFont(font);
        resultTF.setEditable(false);
        values.add(resultTF);

        rules.setFont(font);
        values.add(rules);

        add(values);

        setVisible(true);
    }

    //insets
    @Override
    public Insets getInsets() {
        return new Insets(40, 20, 20, 20);
    }

    //setting look and feel
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
