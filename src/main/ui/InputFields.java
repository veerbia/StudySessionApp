package ui;

import javax.swing.*;
import java.awt.*;

public class InputFields extends JPanel {

    private JTextField subjectField;
    private JTextField topicField;
    private JTextField resourceField;
    private JTextField totalProblemsField;
    private JTextField correctProblemsField;
    private JTextField timeStartedField;
    private JTextField timeCompleteField;
    private JTextField masteryField;
    private JTextField timeOfDayField;

    private JLabel subjectLabel;
    private JLabel topicLabel;
    private JLabel resourceLabel;
    private JLabel totalProblemsLabel;
    private JLabel correctProblemsLabel;
    private JLabel timeStartedLabel;
    private JLabel timeCompleteLabel;
    private JLabel masteryLabel;
    private JLabel timeOfDayLabel;

    private Dimension textDimension = new Dimension(200, 40);

    public InputFields() {
        subjectLabel = new JLabel("What subject did you study?");
        subjectField = new JTextField();
        subjectField.setPreferredSize(textDimension);
        topicLabel = new JLabel("What topic did you study?");
        topicField = new JTextField();
        topicField.setPreferredSize(textDimension);
        resourceLabel = new JLabel("In which resource are these problems located?");
        resourceField = new JTextField();
        resourceField.setPreferredSize(textDimension);
        totalProblemsLabel = new JLabel("Enter total problems to complete:");
        totalProblemsField = new JTextField();
        totalProblemsField.setPreferredSize(textDimension);
        correctProblemsLabel = new JLabel("Enter total problems completed correctly:");
        correctProblemsField = new JTextField();
        timeStartedLabel = new JLabel("At what time (HHMM) did you start?");
        timeStartedField = new JTextField();
        timeCompleteLabel = new JLabel("At what time (HHMM) did you finish?");
        timeCompleteField = new JTextField();
        masteryLabel = new JLabel("Do you feel you have mastered the material?");
        masteryField = new JTextField();
        timeOfDayLabel = new JLabel("What time of day did you complete this section?");
        timeOfDayField = new JTextField();
        addFields();
    }

    public void addFields() {
        this.add(subjectLabel);
        this.add(subjectField);
        this.add(topicLabel);
        this.add(topicField);
        this.add(resourceLabel);
        this.add(resourceField);
        this.add(totalProblemsLabel);
        this.add(totalProblemsField);
        this.add(correctProblemsLabel);
        correctProblemsField.setPreferredSize(textDimension);
        this.add(correctProblemsField);
        this.add(timeStartedLabel);
        timeStartedField.setPreferredSize(textDimension);
        this.add(timeStartedField);
        this.add(timeCompleteLabel);
        timeCompleteField.setPreferredSize(textDimension);
        this.add(timeCompleteField);
        this.add(masteryLabel);
        masteryField.setPreferredSize(textDimension);
        this.add(masteryField);
        this.add(timeOfDayLabel);
        timeOfDayField.setPreferredSize(textDimension);
        this.add(timeOfDayField);
    }

    public JTextField getSubjectField() {
        return subjectField;
    }

    public JTextField getTopicField() {
        return topicField;
    }

    public JTextField getResourceField() {
        return resourceField;
    }

    public JTextField getTotalProblemsField() {
        return totalProblemsField;
    }

    public JTextField getCorrectProblemsField() {
        return correctProblemsField;
    }

    public JTextField getTimeStartedField() {
        return timeStartedField;
    }

    public JTextField getTimeCompleteField() {
        return timeCompleteField;
    }

    public JTextField getMasteryField() {
        return masteryField;
    }

    public JTextField getTimeOfDayField() {
        return timeOfDayField;
    }


}
