package persistence;

import model.Session;
import model.SessionList;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// This code was inspired by JsonSerializationDemo Demo Project
// Github: (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo)

// Represents a reader that reads SessionList from JSON data stored in file
public class JsonReader {

    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads SessionList from file and returns it;
    // throws IOException if an error occurs reading data from file
    public SessionList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseSessionList(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses SessionList from JSON object and returns it
    private SessionList parseSessionList(JSONObject jsonObject) {
        SessionList sl = new SessionList();
        addSessions(sl, jsonObject);
        return sl;
    }

    // MODIFIES: sl
    // EFFECTS: parses sessions from JSON object and adds them to SessionList
    private void addSessions(SessionList sl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("sessions");
        for (Object json : jsonArray) {
            JSONObject nextSession = (JSONObject) json;
            addSession(sl, nextSession);
        }
    }

    // MODIFIES: sl
    // EFFECTS: parses session from JSON object and adds it to SessionList
    private void addSession(SessionList sl, JSONObject jsonObject) {
        String subject = jsonObject.getString("subject");
        String topic = jsonObject.getString("topic");
        String resource = jsonObject.getString("resource");
        int totalProblems = jsonObject.getInt("total problems");
        int correctProblems = jsonObject.getInt("correct problems");
        int timeStarted = jsonObject.getInt("time started");
        int timeComplete = jsonObject.getInt("time complete");
        String mastery = jsonObject.getString("mastery");
        String timeOfDay = jsonObject.getString("time of day");
        Session s = new Session(subject, topic, resource, totalProblems, correctProblems, timeStarted,
                timeComplete, mastery, timeOfDay);
        sl.addSession(s);
    }
}
