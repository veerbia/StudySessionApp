package ui;

import model.Event;
import model.EventLog;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// addWindowListener code based on following StackOverflow query post
// (https://stackoverflow.com/questions/12601004/do-something-before-window-closes-after-user-presses-x)

public abstract class FrameLayout extends JFrame {

    protected static final int width = 750;
    protected static final int height = 750;

    public FrameLayout() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                for (Event nextE : EventLog.getInstance()) {
                    System.out.println(nextE.toString());
                }
                System.exit(1);
            }
        });
        this.pack();
        this.setVisible(true);
        this.setSize(width, height);
    }
}
