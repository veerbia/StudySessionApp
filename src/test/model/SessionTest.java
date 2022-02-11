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
        testSession8 = new Session("Math", "Logs", "Practice 4", 100,
                100, 1159, 1159, "unmastered");
        testSession9 = new Session("Math", "Logs", "Practice 4", 100,
                100, 1759, 1759, "unmastered");
        testSession10 = new Session("Math", "Logs", "Practice 4", 100,
                100, 1959, 1959, "unmastered");
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
    }

    @Test
    void testTimeOfDayMorningBoundary() {
        assertEquals("Morning", testSession2.timeOfDay());
        assertEquals("Morning", testSession8.timeOfDay());
    }

    @Test
    void testTimeOfDayMorning() {
        assertEquals("Morning", testSession3.timeOfDay());
    }

    @Test
    void testTimeOfDayAfternoonBoundary() {
        assertEquals("Afternoon", testSession4.timeOfDay());
        assertEquals("Afternoon", testSession9.timeOfDay());
    }

    @Test
    void testTimeOfDayAfternoon() {
        assertEquals("Afternoon", testSession1.timeOfDay());
    }

    @Test
    void testTimeOfDayEveningBoundary() {
        assertEquals("Evening", testSession5.timeOfDay());
        assertEquals("Evening", testSession10.timeOfDay());
    }

    @Test
    void testTimeOfDayEvening() {
        assertEquals("Evening", testSession6.timeOfDay());

    }

    @Test
    void testTimeOfDayNight() {
        assertEquals("Night", testSession7.timeOfDay());
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