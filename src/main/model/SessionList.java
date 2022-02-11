package model;

import java.util.ArrayList;
import java.util.List;

public class SessionList {

    private List<Session> listOfSession;

    // EFFECTS: constructs an empty list of sessions
    public SessionList() {
        listOfSession = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds session to listOfSession
    public void addSession(Session s) {
        listOfSession.add(s);
    }

    // REQUIRES: at least one session added to listOfSession
    public double masteryRate() {
        double mastered = 0.0;
        double unmastered = 0.0;

        for (Session s : listOfSession) {
            if (s.getMastery().equals("mastered")) {
                mastered++;
            } else if (s.getMastery().equals("unmastered")) {
                unmastered++;
            }
        }
        return Math.round(mastered / (mastered + unmastered) * 100);
    }



    // EFFECTS: calculates efficiency of sessions in listOfSession
    public List<Double> sessionEfficiency() {
        List<Double> ratings = new ArrayList<>();
        for (Session s : listOfSession) {
            double temp = s.getCorrectProblems() / s.topicSpeed();
            ratings.add(temp);
        }
        return ratings;
    }

    // EFFECTS: displays summary of information for each session in list
    public List<String> viewSession() {
        List<String> summary = new ArrayList<>();

        if (listOfSession.isEmpty()) {
            return new ArrayList<>();
        } else {
            for (Session s : listOfSession) {
                summary.add("This session, you studied " + s.getTopic() + " of " + s.getSubject()
                        + " solving " + s.getCorrectProblems() + " correctly out of "
                        + s.getTotalProblems() + " using " + s.getResource() + " during the " + s.getTimeOfDay()
                        + "." + " This topic is " + s.getMastery() + ".");
            }
            return summary;
        }
    }



    // EFFECTS: returns the size of SessionList
    public int listLength() {
        return listOfSession.size();
    }

    // EFFECTS: returns number of unmastered sessions of list of sessions
    public int getUnmastered() {
        int unmastered = 0;
        for (Session s : listOfSession) {
            if (s.getMastery().equals("unmastered")) {
                unmastered++;
            }
        }
        return unmastered;
    }

    // EFFECTS: returns number of mastered sessions of list of sessions
    public int getMastered() {
        int mastered = 0;
        for (Session s : listOfSession) {
            if (s.getMastery().equals("mastered")) {
                mastered++;
            }
        }
        return mastered;
    }

}
