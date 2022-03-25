package ui;

import model.Session;
import model.SessionList;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class MainApp extends FrameLayout implements ActionListener {

    private JTextField subjectField;
    private JTextField topicField;
    private JTextField resourceField;
    private JTextField totalProblemsField;
    private JTextField correctProblemsField;
    private JTextField timeStartedField;
    private JTextField timeCompleteField;
    private JTextField masteryField;
    private JTextField timeOfDayField;

    private JButton addNewSessionButton;
    private JButton viewEfficiencyButton;
    private JButton viewMasteryRateButton;
    private JButton displaySessionsButton;
    private JButton saveSessionsListButton;
    private JButton loadSessionsListButton;

    private SessionList sl;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/workroom.json";

    private Title title;
    private ButtonPanel buttonPanel;
    private InputFields inputFields;

    public MainApp() {
        super();
        sl = new SessionList();
        title = new Title();
        inputFields = new InputFields();
        buttonPanel = new ButtonPanel();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        this.add(title, BorderLayout.NORTH);
        this.add(inputFields);
        this.add(buttonPanel, BorderLayout.SOUTH);
        getButtons();
        getFields();
        addListeners();
    }

    // EFFECTS: adds action listener to buttons
    private void addListeners() {
        addNewSessionButton.addActionListener(this);
        viewEfficiencyButton.addActionListener(this);
        viewMasteryRateButton.addActionListener(this);
        displaySessionsButton.addActionListener(this);
        saveSessionsListButton.addActionListener(this);
        loadSessionsListButton.addActionListener(this);
    }

    // EFFECTS: getter method for buttons from ButtonPanel
    public void getButtons() {
        addNewSessionButton = buttonPanel.getAddNewSession();
        viewEfficiencyButton = buttonPanel.getViewEfficiency();
        viewMasteryRateButton = buttonPanel.getViewMasteryRate();
        displaySessionsButton = buttonPanel.getDisplaySessions();
        saveSessionsListButton = buttonPanel.getSaveSessionsList();
        loadSessionsListButton = buttonPanel.getLoadSessionsList();
    }

    // EFFECTS: getter method for fields from inputFields
    public void getFields() {
        subjectField = inputFields.getSubjectField();
        topicField = inputFields.getTopicField();
        resourceField = inputFields.getResourceField();
        totalProblemsField = inputFields.getTotalProblemsField();
        correctProblemsField = inputFields.getCorrectProblemsField();
        timeStartedField = inputFields.getTimeStartedField();
        timeCompleteField = inputFields.getTimeCompleteField();
        masteryField = inputFields.getMasteryField();
        timeOfDayField = inputFields.getTimeOfDayField();
    }

    // EFFECTS: based on button clicked, the method is called to perform the action
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addNewSessionButton) {
            createSessionAndAddToList();
        } else if (e.getSource() == viewMasteryRateButton) {
            viewMasteryRate();
        } else if (e.getSource() == displaySessionsButton) {
            displaySessions();
        } else if (e.getSource() == viewEfficiencyButton) {
            viewEfficiency();
        } else if (e.getSource() == saveSessionsListButton) {
            saveSessions();
        } else if (e.getSource() == loadSessionsListButton) {
            loadSessions();
        }
    }

    // MODIFIES: this
    // EFFECTS: Adds sessions to SessionList
    public void createSessionAndAddToList() {
        String subject = subjectField.getText();
        String topic = topicField.getText();
        String resource = resourceField.getText();
        int totalProblems = Integer.parseInt(totalProblemsField.getText());
        int correctProblems = Integer.parseInt(correctProblemsField.getText());
        int timeStarted = Integer.parseInt(timeStartedField.getText());
        int timeComplete = Integer.parseInt(timeCompleteField.getText());
        String mastery = masteryField.getText();
        String timeOfDay = timeOfDayField.getText();

        sl.addSession(new Session(subject, topic, resource, totalProblems, correctProblems,
                timeStarted, timeComplete, mastery, timeOfDay));

    }

    // MODIFIES: JSON_STORE
    // EFFECTS: saves SessionList to Json
    public void saveSessions() {
        try {
            jsonWriter.open();
            jsonWriter.write(sl);
            jsonWriter.close();
            System.out.println("Saved to " + JSON_STORE + "\n");
        } catch (FileNotFoundException exc) {
            System.out.println("Unable to write to file: " + JSON_STORE + "\n");
        }
    }

    // MODIFIES: this
    // EFFECTS: loads SessionList from Json
    public void loadSessions() {
        try {
            sl = jsonReader.read();
        } catch (IOException exc) {
            System.out.println("Unable to read from file: " + JSON_STORE + "\n");
        }
    }

    // EFFECTS: opens new view efficiency frame with text as a parameter
    public void viewEfficiency() {
        String text = "\nYour efficiency rate from your previous sessions is "
                + sl.sessionEfficiency() + "%\n";
        new ViewEfficiencyFrame(text, sl.sessionEfficiency() >= 30);
    }

    // EFFECTS: opens new view mastery rate frame with text as a parameter
    public void viewMasteryRate() {
        String text;
        if (sl.getUnmastered() == 0 && sl.getMastered() == 0) {
            text = "\nYou haven't completed any sessions yet.\n";
        } else {
            text = "\nYour mastery rate for your logged sessions is " + sl.masteryRate() + "%.\n";
        }
        new ViewMasteryRate(text, sl.masteryRate() >= 50.0);
    }

    // EFFECTS: opens new display sessions frame with text as a parameter
    public void displaySessions() {
        ArrayList<String> texts = new ArrayList<>();
        if (sl.listLength() == 0) {
            texts.add("\nYou haven't completed any sessions yet.\n");
        } else {
            texts.add("\nAll sessions: \n");
            for (int i = 0; i < sl.listLength(); i++) {
                texts.add("\n" + sl.viewSession().get(i));
            }
        }
        new DisplaySessions(texts);
    }

























}
