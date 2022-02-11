package model;

// Represents a session with details regarding subject, topic. problems, and time
public class Session {

    // fields
    private String subject; // the subject studied in the session
    private String topic; // the topic of the subject studied
    private String resource; // source of topic problems
    private int totalProblems; // total number of topic problems to complete
    private int correctProblems; // number of topic problems completed correctly
    private int timeStarted; // the time problems were started in min
    private int timeComplete; // the time problems were complete in min
    private String mastery; // personal assessment of understanding


    // constants
    private int morningStart = 100;
    private int morningEnd = 1159;
    private int afternoonStart = 1200;
    private int afternoonEnd = 1759;
    private int eveningStart = 1800;
    private int eveningEnd = 1959;


    // REQUIRES: subject is either "Math", "Computer Science", "Finance", or "Science"
    // totalProblems must be >= correctProblems
    // totalProblems, timeAllocated and timeTaken cannot be 0
    // timeStarted and timeComplete must be valid time with first two digit int 00 <= HH <= 23
    // and last two digit int 00 <= DD <= 59
    // timeStarted and timeComplete must also be in the same hour (HH) in accordance with Pomodoro principle
    // mastery must be one of either "mastered" or "unmastered"
    // EFFECTS: constructor for Session
    public Session(String subject, String topic, String resource, int totalProblems, int correctProblems,
                   int timeStarted, int timeComplete, String mastery) {

        this.subject = subject;
        this.topic = topic;
        this.resource = resource;
        this.totalProblems = totalProblems;
        this.correctProblems = correctProblems;
        this.timeStarted = timeStarted;
        this.timeComplete = timeComplete;
        this.mastery = mastery;
    }

    // EFFECTS: gives label for time of day based on time of session
    public String timeOfDay() {
        if (timeStarted >= morningStart && timeStarted <= morningEnd) {
            return "Morning";
        } else if (timeStarted >= afternoonStart && timeStarted <= afternoonEnd) {
            return "Afternoon";
        } else if (timeStarted >= eveningStart && timeStarted <= eveningEnd) {
            return "Evening";
        } else {
            return "Night";
        }
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

}




