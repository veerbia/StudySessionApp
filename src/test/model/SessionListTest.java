package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SessionListTest {

    private SessionList sl;
    private Session testSession1;
    private Session testSession2;
    private Session testSession3;
    private Session testSession4;
    private Session testSession5;
    private Session testSession6;
    private Session testSession7;

    @BeforeEach
    void runBefore() {
        sl = new SessionList();

        testSession1 = new Session("Math", "Number Theory", "Practice 2", 10,
                9, 1200,1248, "mastered");
        testSession2 = new Session("Computer Science", "Computers", "Text", 20,
                2, 100,102, "unmastered");
        testSession3 = new Session("Finance", "Number Theory", "PDF", 50,
                40, 234, 244, "mastered");
        testSession4 = new Session("Science", "Numbers", "Book", 10,
                2, 1302, 1310, "mastered");
        testSession5 = new Session("Math", "Theory", "Practice 1", 20,
                18, 1800, 1820, "unmastered");
        testSession6 = new Session("Science", "Algebra", "Practice 3", 10,
                10, 1903, 1906, "mastered");
        testSession7 = new Session("Math", "Logs", "Practice 4", 100,
                100, 2000, 2059, "unmastered");
    }

    @Test
    void testAddSession() {
        assertEquals(0, sl.listLength());
        sl.addSession(testSession2);
        assertEquals(1, sl.listLength());
        sl.addSession(testSession1);
        sl.addSession(testSession3);
        assertEquals(3, sl.listLength());
    }

    @Test
    void testMasteryRateOneSession() {
        sl.addSession(testSession2);
        assertEquals(0, sl.masteryRate());
    }

    @Test
    void testMasteryRateMultipleSessions() {
        sl.addSession(testSession1);
        assertEquals(100, sl.masteryRate());
        sl.addSession(testSession2);
        assertEquals(50, sl.masteryRate());
        sl.addSession(testSession4);
        sl.addSession(testSession5);
        sl.addSession(testSession6);
        sl.addSession(testSession7);
        sl.addSession(testSession3);
        assertEquals(57, sl.masteryRate());
    }

    @Test
    void testSessionEfficiencyOneSessionAdded() {
        sl.addSession(testSession1);
        double testAnswer1 = 0.0;
        List<Double> testAnswerList = new ArrayList<>();
        testAnswerList.add(testAnswer1);
        assertEquals(testAnswerList, sl.sessionEfficiency());
    }

    @Test
    void testSessionEfficiencyMultipleSessionsAdded() {
        sl.addSession(testSession1);
        double testAnswer1 = 0.0;
        sl.addSession(testSession2);
        double testAnswer2 = 1.0;
        sl.addSession(testSession3);
        double testAnswer3 = 4.0;
        List<Double> testAnswerList = new ArrayList<>();
        testAnswerList.add(testAnswer1);
        testAnswerList.add(testAnswer2);
        testAnswerList.add(testAnswer3);
        assertEquals(testAnswerList, sl.sessionEfficiency());
    }

    @Test
    void testViewSessionNoSessions() {
        List<String> testAnswerList = new ArrayList<String>();
        assertEquals(testAnswerList, sl.viewSession());
    }

    @Test
    void testViewSessionOneSession() {
        sl.addSession(testSession3);
        String testAnswer3 = "This session, you studied Number Theory of Finance solving 40 correctly out of 50 " +
                "using PDF during the Morning. This topic is mastered.";
        List<String> testAnswerList = new ArrayList<>();
        testAnswerList.add(testAnswer3);
        assertEquals(testAnswerList, sl.viewSession());
    }

    @Test
    void testViewSessionMultipleSessions() {
        sl.addSession(testSession3);
        String testAnswer3 = "This session, you studied Number Theory of Finance solving 40 correctly out of 50 " +
                "using PDF during the Morning. This topic is mastered.";
        sl.addSession(testSession4);
        String testAnswer4 = "This session, you studied Numbers of Science solving 2 correctly out of 10 using Book " +
                "during the Afternoon. This topic is mastered.";
        sl.addSession(testSession5);
        String testAnswer5 = "This session, you studied Theory of Math solving 18 correctly out of 20 using " +
                "Practice 1 during the Evening. This topic is unmastered.";
        List<String> testAnswerList = new ArrayList<>();
        testAnswerList.add(testAnswer3);
        testAnswerList.add(testAnswer4);
        testAnswerList.add(testAnswer5);
        assertEquals(testAnswerList, sl.viewSession());

    }

    @Test
    void testUnmastered() {
        sl.addSession(testSession1);
        assertEquals(0, sl.getUnmastered());
        sl.addSession(testSession2);
        assertEquals(1, sl.getUnmastered());
        sl.addSession(testSession4);
        sl.addSession(testSession5);
        sl.addSession(testSession6);
        sl.addSession(testSession7);
        sl.addSession(testSession3);
        assertEquals(3, sl.getUnmastered());
    }

    @Test
    void testMastered() {
        sl.addSession(testSession1);
        assertEquals(1, sl.getMastered());
        sl.addSession(testSession2);
        assertEquals(1, sl.getMastered());
        sl.addSession(testSession4);
        sl.addSession(testSession5);
        sl.addSession(testSession6);
        sl.addSession(testSession7);
        sl.addSession(testSession3);
        assertEquals(4, sl.getMastered());
    }





}
