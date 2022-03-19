package ui;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

    private JButton addNewSession;
    private JButton viewEfficiency;
    private JButton viewMasteryRate;
    private JButton displaySessions;
    private JButton saveSessionsList;
    private JButton loadSessionsList;


    public ButtonPanel() {
        this.setPreferredSize(new Dimension(450, 80));
        addNewSession = new JButton("Add New Session");
        addNewSession.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        this.add(addNewSession);
        viewEfficiency = new JButton("View Efficiency");
        viewEfficiency.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        this.add(viewEfficiency);
        viewMasteryRate = new JButton("View Mastery Rate");
        viewMasteryRate.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        this.add(viewMasteryRate);
        displaySessions = new JButton("Display Sessions");
        displaySessions.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        this.add(displaySessions);
        saveSessionsList = new JButton("Save Sessions");
        saveSessionsList.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        this.add(saveSessionsList);
        loadSessionsList = new JButton("Load Previous Sessions");
        loadSessionsList.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        this.add(loadSessionsList);
    }

    public JButton getAddNewSession() {
        return addNewSession;
    }

    public JButton getViewEfficiency() {
        return viewEfficiency;
    }

    public JButton getViewMasteryRate() {
        return viewMasteryRate;
    }

    public JButton getDisplaySessions() {
        return displaySessions;
    }

    public JButton getSaveSessionsList() {
        return saveSessionsList;
    }

    public JButton getLoadSessionsList() {
        return loadSessionsList;
    }



}
