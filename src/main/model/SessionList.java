package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;
import java.util.ArrayList;
import java.util.List;



public class SessionList implements Writable {

    private List<Session> listOfSession;

    // EFFECTS: constructs an empty list of sessions
    public SessionList() {
        listOfSession = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds session to listOfSession
    public void addSession(Session s) {
        EventLog.getInstance().logEvent(new Event("A new " + s.getSubject()
                + " session was added to SessionList"));
        listOfSession.add(s);
    }

    // REQUIRES: at least one session added to listOfSession
    public double masteryRate() {
        double mastered = 0.0;
        double unmastered = 0.0;

        for (Session s : listOfSession) {
            if (s.getMastery().equals("mastered")) {
                mastered++;
            } else {
                unmastered++;
            }
        }
        EventLog.getInstance().logEvent(new Event("Mastery Rate of SessionList was calculated."));
        return Math.round(mastered / (mastered + unmastered) * 100);
    }



    // EFFECTS: calculates efficiency of sessions in listOfSession
    public int sessionEfficiency() {
        List<Double> ratings = new ArrayList<>();
        int efficiency = 0;
        for (Session s : listOfSession) {
            double temp = s.getCorrectProblems() / s.topicSpeed();
            ratings.add(temp);
        }
        for (double r : ratings) {
            efficiency += r;
        }
        EventLog.getInstance().logEvent(new Event("Session Efficiency of SessionList was calculated."));
        return efficiency / ratings.size();
    }

    // EFFECTS: displays summary of information for each session in list
    public List<String> viewSession() {
        EventLog.getInstance().logEvent(new Event("Summary of SessionList was created."));
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

    public List<Session> getSessions() {
        return listOfSession;
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


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("sessions", tradesToJson());
        return json;
    }

    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray tradesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Session s : listOfSession) {
            jsonArray.put(s.toJson());
        }

        return jsonArray;
    }

}
