package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents a session with details regarding subject, topic. problems, and time
public class Session implements Writable {

    // fields
    private String subject; // the subject studied in the session
    private String topic; // the topic of the subject studied
    private String resource; // source of topic problems
    private int totalProblems; // total number of topic problems to complete
    private int correctProblems; // number of topic problems completed correctly
    private int timeStarted; // the time problems were started in min
    private int timeComplete; // the time problems were complete in min
    private String mastery; // personal assessment of understanding
    private String timeOfDay; // time of day when session was completed




    // REQUIRES: subject is either "Math", "Computer Science", "Finance", or "Science"
    // totalProblems must be >= correctProblems
    // totalProblems, timeAllocated and timeTaken cannot be 0
    // timeStarted and timeComplete must be valid time with first two digit int 00 <= HH <= 23
    // and last two digit int 00 <= DD <= 59
    // timeStarted and timeComplete must also be in the same hour (HH) in accordance with Pomodoro principle
    // mastery must be one of either "mastered" or "unmastered"
    // timeOfDay must be one of "morning", "day", "night"
    // EFFECTS: constructor for Session
    public Session(String subject, String topic, String resource, int totalProblems, int correctProblems,
                   int timeStarted, int timeComplete, String mastery, String timeOfDay) {

        this.subject = subject;
        this.topic = topic;
        this.resource = resource;
        this.totalProblems = totalProblems;
        this.correctProblems = correctProblems;
        this.timeStarted = timeStarted;
        this.timeComplete = timeComplete;
        this.mastery = mastery;
        this.timeOfDay = timeOfDay;
    }

    // EFFECTS: calculates correct to total problems ratio
    public double correctToCompleted() {
        return correctProblems / totalProblems;
    }

    // EFFECTS: calculates speed of problem completion
    public int topicSpeed() {
        return timeComplete - timeStarted;
    }

    public String getSubject() {
        return subject;
    }

    public String getTopic() {
        return topic;
    }

    public String getResource() {
        return resource;
    }

    public int getTotalProblems() {
        return totalProblems;
    }

    public int getCorrectProblems() {
        return correctProblems;
    }

    public int getTimeStarted() {
        return timeStarted;
    }

    public int getTimeComplete() {
        return timeComplete;
    }

    public String getMastery() {
        return mastery;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("subject", subject);
        json.put("topic", topic);
        json.put("resource", resource);
        json.put("total problems", totalProblems);
        json.put("correct problems", correctProblems);
        json.put("time started", timeStarted);
        json.put("time complete", timeComplete);
        json.put("mastery", mastery);
        json.put("time of day", timeOfDay);
        return json;
    }

}




