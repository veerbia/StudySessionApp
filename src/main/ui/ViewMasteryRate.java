package ui;

import javax.swing.*;
import java.awt.*;

public class ViewMasteryRate extends FrameLayout {

    private JLabel label;
    private ImageIcon image;
    private JLabel imgLabel;

    public ViewMasteryRate(String text, Boolean bool) {
        super();
        this.setLayout(new FlowLayout());

        if (bool) {
            image = new ImageIcon("data/cheer.gif");
        } else {
            image = new ImageIcon("data/sadgif.gif");
        }

        imgLabel = new JLabel(image);
        label = new JLabel(text);

        this.add(imgLabel);
        this.add(label);
    }




}
