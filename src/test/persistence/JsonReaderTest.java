package persistence;

import model.SessionList;
import model.Session;
import model.SessionList;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// This code was inspired by JsonSerializationDemo Demo Project
// Github: (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo)

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            SessionList sl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptySessionsList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptySessions.json");
        try {
            SessionList sessions = reader.read();
            assertEquals(0, sessions.listLength());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralSessionsList() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralSessionsList.json");
        try {
            SessionList sl = reader.read();
            List<Session> sessions = sl.getSessions();
            assertEquals(2, sessions.size());
            checkSession("math", "calculus", "text", 12, 6,
                    1200, 1210, "mastered", "day", sessions.get(0));
            checkSession("science", "physics", "book", 100, 100,
                    1300, 1340, "unmastered", "night", sessions.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}