package ui;

import javax.swing.*;

public abstract class FrameLayout extends JFrame {

    protected static final int width = 750;
    protected static final int height = 750;

    public FrameLayout() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setSize(width, height);
    }
}
