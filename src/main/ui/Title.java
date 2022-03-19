package ui;

import javax.swing.*;
import java.awt.*;

public class Title extends JPanel {

    public Title() {
        this.setPreferredSize(new Dimension(300, 90));

        JLabel title = new JLabel("Session App");
        title.setPreferredSize(new Dimension(225, 80));
        title.setFont(new Font("Sans-serif", Font.BOLD, 20));
        title.setHorizontalAlignment(JLabel.CENTER);
        this.add(title);

    }
}
