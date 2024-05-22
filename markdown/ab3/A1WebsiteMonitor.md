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

Aggregation:

Leere Raute, das Teil kann auch ohne dem Ganzen existieren z.B. Auto ohne Reifen.


Composition:

Gefüllte Raute, das Teil kann NICHT ohne dem Ganzen existieren z.B. Arm ohne Körper.


# Aufgabe 2

# Aufgabe 3
create crc in markdown table

| aasdasd | b                  |
| ------- | ------------------ |
|         | asdlashdlashdjkash |
|         |                    |

tabelle komisch habs in google gemacht