package ui;

import model.Session;
import model.SessionList;

import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import java.util.Scanner;

// Code based on CPSC 210 illustration application TellerApp (http://github.students.cs.ubc.ca/CPSC210/TellerApp.git)

public class StudySessionApp {
    private static final String JSON_STORE = "./data/workroom.json";
    private Scanner input;
    private SessionList lot;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private SessionList sl;

    // MODIFIES: this
    // EFFECTS: initializes SessionList and Scanner
    private void init() {
        lot = new SessionList();
        input = new Scanner(System.in);
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        switch (command) {
            case "n":
                doAddNewSession();
                break;
            case "e":
                // doDisplayEfficiency();
                break;
            case "m":
                doDisplayMasteryRate();
                break;
            case "p":
                doPrintSessions();
                break;
            case "s":
                saveSessionsList();
                break;
            case "l":
                loadSessionsList();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    // EFFECTS: prints all of total sessions completed so far
    private void doPrintSessions() {
        if (lot.listLength() == 0) {
            System.out.println("\nNo Sessions Created.");
        } else {
            System.out.println("\nAll sessions: \n");
            for (int k = 0; k < lot.listLength(); k++) {
                System.out.println(lot.viewSession().get(k));
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: calculates and displays user's mastery rate
    private void doDisplayMasteryRate() {
        if (lot.getUnmastered() == 0 && lot.getMastered() == 0) {
            System.out.println("\nPlease add your first study session.\n");
        } else {
            System.out.println("\nMastery rate: " + lot.masteryRate() + " / 100 \n");
        }
    }

//    // MODIFIES: this
//    // EFFECTS: calculates and displays efficiency of each study session
//    private void doDisplayEfficiency() {
//        if (lot.listLength() == 0) {
//            System.out.println("\nNo Sessions Created.\n");
//        } else {
//            System.out.println("\nEfficiency of all sessions: \n");
//            for (int i = 0; i < lot.listLength(); i++) {
//                System.out.println(lot.sessionEfficiency().get(i));
//            }
//        }
//    }

    // MODIFIES: this
    // EFFECTS: add new session to session list
    private void doAddNewSession() {
        System.out.println("What subject did you study? ");
        String subject = input.next();
        System.out.println("What topic did you study? ");
        String topic = input.next();
        System.out.println("In which resource are these problems located? ");
        String resource = input.next();
        System.out.println("Enter total problems to complete: ");
        int totalProblems = input.nextInt();
        System.out.println("Enter total problems completed correctly: ");
        int correctProblems = input.nextInt();
        System.out.println("At what time (HHMM) did you start? ");
        int timeStarted = input.nextInt();
        System.out.println("At what time (HHMM) did you finish? ");
        int timeComplete = input.nextInt();
        System.out.println("Do you feel you have mastered the material? ");
        String mastery = input.next();
        System.out.println("What time of day did you complete this section? ");
        String timeOfDay = input.next();

        Session s = new Session(subject, topic, resource, totalProblems, correctProblems,
                timeStarted, timeComplete, mastery, timeOfDay);

        lot.addSession(s);

        System.out.println("Session successfully added");
    }


    // EFFECTS: displays menu of options to user for selection
    private void displayMenu() {
        System.out.println("\nChoose one of the following options:\n");
        System.out.println("\tn -> Add new session");
        System.out.println("\te -> Display efficiency of sessions");
        System.out.println("\tm -> View your mastery rate");
        System.out.println("\tp -> See all sessions");
        System.out.println("\td -> Done");
        System.out.println("\ts -> Save");
        System.out.println("\tl -> Load");
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runApp() {
        boolean continueOn = true;
        String command;

        init();

        while (continueOn) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("d")) {
                continueOn = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("\nThank you for logging your session today!");

    }

    // EFFECTS: runs the study session application
    public StudySessionApp() {
        init();
        runApp();
    }

    // EFFECTS: saves the SessionsList to file
    private void saveSessionsList() {
        try {
            jsonWriter.open();
            jsonWriter.write(lot);
            jsonWriter.close();
            System.out.println("Saved to " + JSON_STORE + "\n");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE + "\n");
        }
    }

    // MODIFIES: this
    // EFFECTS: loads SessionsList from file
    private void loadSessionsList() {
        try {
            lot = jsonReader.read();
            System.out.println("Loaded from " + JSON_STORE + "\n");
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE + "\n");
        }
    }

}
