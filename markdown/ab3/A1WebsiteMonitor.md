# Aufgabe 1
## website monitor

```mermaid
classDiagram
    class System{
    a["-List<User<String>>"]
    +registration(String uRL, List<> notificationPreferences) void 
    }
    class User{
    -List<String> websiteSubscriptions
    +modifySub()
    +cancelSub()
    }
    class Website{
    
    }
```
```plantuml
@startuml
skinparam classAttributeIconSize 0
    class System{
        -List<User> users
        +registration(User user, String uRL, List<NotificationPreferences> notificationPreferences) : void 
        +checkForWebsiteUpdates() : String
        +notifyUser(String updatedWebsite, List<User> users) : void
    }
    class NotificationPreferenceBean{
        -String frequency
        -String preferredCommunicationChannel
        +NotificationPreference()
        +getFrequency() : String
        +setFrequency() : void
        +getPreferredCommunicationChannel() : String
        +setPreferredCommunicationChannel() : void
    }
    class User{
        -List<String> websiteSubscriptions
        -NotificationPreferenceBean notificationPreferenceBean
        +modifySubscription(String subscription, String newSubscription) : void
        +cancelSubscription(String subscription) : void
        +addSubscription()???
    }
    class Website{
        -String lastVersion
    }

    User "1"*--"1" NotificationPreferenceBean : has
    System "1"--"*" User : contains
    System -- Website
@enduml
```
### Locaizyc
```plantuml
@startuml
skinparam classAttributeIconSize 0
class WebsiteMonitor{
    -users : List<User>
    ENTWEDER ODER
    -subs : List<Subscription>
    +run()
}
class Subscription
class User
class Notification
class WebsiteHistory
class Website

WebsiteMonitor -- User
WebsiteMonitor -right- Subscription
Subscription -right- Notification
Subscription -- WebsiteHistory
WebsiteHistory -- Website
@enduml
```


# KLAUSURRELEVANT

Aggregation:

Leere Raute, das Teil kann auch ohne dem Ganzen existieren z.B. Auto ohne Reifen.


Composition:

Gefüllte Raute, das Teil kann NICHT ohne dem Ganzen existieren z.B. Arm ohne Körper.


# Aufgabe 2 KLAUSURRELEVANT

## GRASP THEROIES KLAUSURRELEVANT

### 1. Controller Principle: KLAUSURRELEVANT
Make 1 Class responsible for the given Service (Notification, Programm, Payment)<br>
(low coupling)

Problem: <br>
Who should be responsible for handling an input
system event?

Solution: <br>
Assign the responsibility for receiving or handling
a system event message to a class representing
the overall system, device, or subsystem (facade
controller) or a use case scenario within which the
system event occurs (use case controller)
### 2. Creator Principle: KLAUSURRELEVANT
Conditions of when a Class should create objects of other Classes<br>
(intuitively the controller)

Assign class B responsibility of creating instance
of class A if
- B aggregates A objects
- B contains A objects
- B records instances of A objects
- B closely uses A objects
- B has the initializing data for creating A objects

When there is a choice, prefer
- B aggregates or contains A objects

Key idea: Creator needs to keep reference
anyway and will frequently use the created object
### 3. Information Expert Principle: KLAUSURRELEVANT
Problem: What is a general principle of assigning
responsibilities to objects?

Solution: Assign a responsibility to the
information expert, the class that has the
information necessary to fulfill the
responsibility

Start assigning responsibilities by clearly stating
responsibilities!

Typically follows common intuition

Design Classes (Software Classes) instead of
Conceptual Classes
- If Design Classes do not yet exist, look in Domain Model
for fitting abstractions (-> low representational gap)

# Aufgabe 3
create crc in markdown table

| aasdasd | b                  |
| ------- | ------------------ |
|         | asdlashdlashdjkash |
|         |                    |

tabelle komisch habs in google gemacht