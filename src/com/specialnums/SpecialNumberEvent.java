package com.specialnums;

import javax.naming.event.ObjectChangeListener;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.Array;
import java.util.Arrays;

public class SpecialNumberEvent implements ActionListener, ItemListener, Runnable {
    SpecialNumbersFrame gui;

    public SpecialNumberEvent(SpecialNumbersFrame in) {
        gui = in;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String nStr = gui.nTF.getText();

        try {
            int n = Integer.getInteger(nStr);
        }
        catch (NullPointerException exception) {
            gui.resultTF.setText("type a correct numbers");
        }

        Object chosen = gui.optionsButton.getSelection();
        //int index = gui.checkBoxes.indexOf(chosen);
    }

    @Override
    public void itemStateChanged(ItemEvent event) {
        Object component = event.getItem();
    }

    @Override
    public void run() {

    }

    int calculateInt1(int n) {
        Object choose = gui.optionsButton.getSelection();
    }

}
