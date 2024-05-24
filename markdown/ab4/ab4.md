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

# Aufgabe 1
um website zu bekommen "curl"

# Aufgabe 2
Afferent (incoming) coupling (AC): number of classes outside a module that depend on classes within that module

Efferent (outgoing) coupling (EC): number of classes withing a module that depend on classes outside of our module

Instability: 1 = Unstable; 0 = Stable

$$
I =\frac{EC}{EC+AC}
$$

warum wird unser programm weniger instabil wenn mehr classen auf unser modul zugreifen?

# Aufgabe 3
Package für Notification Interface<br>
Instability = 0

Package für User + NotificationPreferenceBean<br>
Instability = 0

Package für System<br>
Instability = 1

Package für Website<br>
Instability = 0

# Aufgabe 5

Dependency Inqection

Interfaces

Abstract Methods