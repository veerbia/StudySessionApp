package persistence;

import model.Session;

import static org.junit.jupiter.api.Assertions.assertEquals;

// This code was inspired by JsonSerializationDemo Demo Project
// Github: (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo)

public class JsonTest {
    protected void checkSession(String subject, String topic, String resource, int totalProblems, int correctProblems,
                                int timeStarted, int timeComplete, String mastery, String timeOfDay, Session s) {
        assertEquals(subject, s.getSubject());
        assertEquals(topic, s.getTopic());
        assertEquals(resource, s.getResource());
        assertEquals(totalProblems, s.getTotalProblems());
        assertEquals(correctProblems, s.getCorrectProblems());
        assertEquals(timeStarted, s.getTimeStarted());
        assertEquals(timeComplete, s.getTimeComplete());
        assertEquals(mastery, s.getMastery());
        assertEquals(timeOfDay, s.getTimeOfDay());

    }
}
