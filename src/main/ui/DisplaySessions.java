package ui;

import javax.swing.*;
import java.awt.*;


import java.util.ArrayList;

public class DisplaySessions extends FrameLayout {

    public DisplaySessions(ArrayList<String> texts) {
        super();
        this.setLayout(new FlowLayout());

        for (String t : texts) {
            JLabel label = new JLabel(t);
            this.add(label);
        }
    }
}
