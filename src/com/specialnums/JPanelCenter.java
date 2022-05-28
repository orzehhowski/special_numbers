package com.specialnums;

import javax.swing.*;
import java.awt.*;

public class JPanelCenter extends JPanel {
    //these class overrides ony insets, to center the values panel
    @Override
    public Insets getInsets() {
        return new Insets(100, 0, 0, 0);
    }
}
