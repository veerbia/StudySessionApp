package ui;

import model.Session;
import model.SessionList;

import java.util.Scanner;

// Code based on CPSC 210 illustration application TellerApp (http://github.students.cs.ubc.ca/CPSC210/TellerApp.git)

public class StudySessionApp {
    private SessionList sl;
    private Scanner input;

    // MODIFIES: this
    // EFFECTS: initializes SessionList and Scanner
    private void init() {
        input = new Scanner(System.in);
        sl = new SessionList();
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        switch (command) {
            case "n":
                doAddNewSession();
                break;
            case "e":
                doDisplayEfficiency();
                break;
            case "m":
                doDisplayMasteryRate();
                break;
            case "p":
                doPrintSessions();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    // EFFECTS: prints all of total sessions completed so far
    private void doPrintSessions() {
        if (sl.listLength() == 0) {
            System.out.println("\nNo Sessions Created.");
        } else {
            System.out.println("\nAll sessions: \n");
            for (int k = 0; k < sl.listLength(); k++) {
                System.out.println(sl.viewSession().get(k));
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: calculates and displays user's mastery rate
    private void doDisplayMasteryRate() {
        if (sl.getUnmastered() == 0 && sl.getMastered() == 0) {
            System.out.println("\nPlease add your first study session.\n");
        } else {
            System.out.println("\nMastery rate: " + sl.masteryRate() + " / 100 \n");
        }
    }

    // MODIFIES: this
    // EFFECTS: calculates and displays efficiency of each study session
    private void doDisplayEfficiency() {
        if (sl.listLength() == 0) {
            System.out.println("\nNo Sessions Created.\n");
        } else {
            System.out.println("\nEfficiency of all sessions: \n");
            for (int i = 0; i < sl.listLength(); i++) {
                System.out.println(sl.sessionEfficiency().get(i));
            }
        }
    }

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

        sl.addSession(s);

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

}
