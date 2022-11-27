# Study Session App

### Background
As university students, studying is integral to our success. As such, it must be that we keep close track of our study 
sessions, including factors such as their length, efficiency, and time, in order to consistently keep track of our 
study habits. The study habits that we build in the early years of university form the basis of how we learn for the 
rest of our lives, and thus, we should see that the foundation is built strong through rigorous tracking of key
metrics, along with documented resources for posterity in order to optimize our time accordingly.

I want to create software that will allow me and my university classmates to document each one of their study 
sessions and keep a log of all of their sessions with key information about each one.

### Project Information

This project will be a Java GUI where a user can create their own personal study session log.
Each session will be filled out using user-specific responses to a series of generated prompts regarding
details such as topic of study, start and end times, resources used as well as if they feel they've mastered
the material. They can then view all their previous sessions inclusive as well as see their personal efficiency in each 
session, and their overall mastery rate. Once they are satisfied in adding new sessions, they can view a complete
summarized history of their sessions in hierarchical order. 


### *User Stories*

- As a user, I want to be able to add a new session to my log of sessions
- As a user, I want to be able to view my overall mastery rate
- As a user, I want to be able to view a summary of my completed sessions
- As a user, I want to be able to view the efficiency of my topic study for each study session
- As a user, I want to be able to save a log of my sessions to file
- As a user, I want to be able to load my log of sessions from file

### *Phase 4: Task 2*
*Sample of events printed to console following program run:* \
Sun Mar 27 14:06:24 PDT 2022 \
A new Mathematics session was added to SessionList \
Sun Mar 27 14:06:38 PDT 2022 \
A new Science session was added to SessionList \
Sun Mar 27 14:08:40 PDT 2022 \
A new Finance session was added to SessionList  
Sun Mar 27 14:08:43 PDT 2022  
Session Efficiency of SessionList was calculated. \
Sun Mar 27 14:08:43 PDT 2022  
Session Efficiency of SessionList was calculated. \
Sun Mar 27 14:08:48 PDT 2022 \
Mastery Rate of SessionList was calculated. \
Sun Mar 27 14:08:48 PDT 2022 \
Mastery Rate of SessionList was calculated. \
Sun Mar 27 14:08:52 PDT 2022  
Summary of SessionList was created. \
Sun Mar 27 14:08:52 PDT 2022 \
Summary of SessionList was created. \
Sun Mar 27 14:08:52 PDT 2022 \
Summary of SessionList was created. 

Process finished with exit code 1

### *Phase 4: Task 3*
- As part of their implementation in the user interface the ViewEfficiencyFrame and ViewMasteryRate classes 
had a plethora of similarities between them. I would thus create instead an abstract class related to key performance
tracking and then extended the respective classes to the general abstract class. 
- To make navigation of the UI package easier, I would add the ButtonPanel, InputFields, and Title classes' components
directly inside the MainApp class. Having each in the same class allows for easier access to these similar aspects of 
the user interface and more intuitive understanding of how the components work together, drawing parallels to the
console-based implementation in the StudySessionApp class.
- I would also remove any implementations of switch statements such as in the StudySessionApp class as switch
statements can be difficult to maintain and debug as a project develops over time.


