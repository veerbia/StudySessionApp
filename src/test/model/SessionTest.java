package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SessionTest {
    private Session testSession1;
    private Session testSession2;
    private Session testSession3;
    private Session testSession4;
    private Session testSession5;
    private Session testSession6;
    private Session testSession7;
    private Session testSession8;
    private Session testSession9;
    private Session testSession10;

    @BeforeEach
    void runBefore(){
        testSession1 = new Session("Math", "Number Theory", "Practice 2", 10,
                9, 1200,1248, "mastered", "Day");
        testSession2 = new Session("Computer Science", "Computers", "Text", 20,
                2, 100,102, "unmastered", "Day");
        testSession3 = new Session("Finance", "Number Theory", "PDF", 50,
                40, 234, 244, "mastered", "Morning");
        testSession4 = new Session("Science", "Numbers", "Book", 10,
                2, 1302, 1310, "mastered", "Day");
        testSession5 = new Session("Math", "Theory", "Practice 1", 20,
                18, 1800, 1820, "unmastered", "Day");
        testSession6 = new Session("Science", "Algebra", "Practice 3", 10,
                10, 1903, 1906, "mastered", "Day");
        testSession7 = new Session("Math", "Logs", "Practice 4", 100,
                100, 2000, 2059, "unmastered", "Night");

        testSession8 = new Session("Math", "Logs", "Practice 4", 100,
                100, 1159, 1159, "unmastered", "Night");
        testSession9 = new Session("Math", "Logs", "Practice 4", 100,
                100, 1759, 1759, "unmastered", "Day");
        testSession10 = new Session("Math", "Logs", "Practice 4", 100,
                100, 1959, 1959, "unmastered", "Night");
    }

    @Test
    void testConstructor() {
        assertEquals("Math", testSession1.getSubject());
        assertEquals("Number Theory", testSession1.getTopic());
        assertEquals("Practice 2", testSession1.getResource());
        assertEquals(10, testSession1.getTotalProblems());
        assertEquals(9, testSession1.getCorrectProblems());
        assertEquals(1200, testSession1.getTimeStarted());
        assertEquals(1248, testSession1.getTimeComplete());
        assertEquals("mastered", testSession1.getMastery());
        assertEquals("Day", testSession1.getTimeOfDay());
    }


    @Test
    void testCorrectToCompleted() {
        assertEquals(1.0, testSession6.correctToCompleted());
        assertEquals(0.0, testSession1.correctToCompleted());
    }

    @Test
    void testTopicSpeed(){
        assertEquals(48, testSession1.topicSpeed());
        assertEquals(2, testSession2.topicSpeed());
    }

}