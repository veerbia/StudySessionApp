package persistence;

import model.Session;
import model.SessionList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// This code was inspired by JsonSerializationDemo Demo Project
// Github: (https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo)


class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            SessionList sessions = new SessionList();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptySessionsList() {
        try {
            SessionList sessions = new SessionList();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptySessionsList.json");
            writer.open();
            writer.write(sessions);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptySessionsList.json");
            sessions = reader.read();
            assertEquals(0, sessions.listLength());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            SessionList sessions = new SessionList();
            sessions.addSession(new Session("math", "calculus", "text", 12,
                    6, 1200, 1210, "mastered", "day"));
            sessions.addSession(new Session("science", "physics", "book", 100,
                    100, 1300, 1340, "unmastered", "night"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorkroom.json");
            writer.open();
            writer.write(sessions);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorkroom.json");
            sessions = reader.read();
            List<Session> sl = sessions.getSessions();
            assertEquals(2, sessions.listLength());
            checkSession("math", "calculus", "text", 12, 6,
                    1200, 1210, "mastered", "day", sl.get(0));
            checkSession("science", "physics", "book", 100, 100,
                    1300, 1340, "unmastered", "night", sl.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}