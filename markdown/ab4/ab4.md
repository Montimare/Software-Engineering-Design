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

```mermaid
classDiagram
direction BT
class INotification {
<<Interface>>
  + notifyTelegram(String) void
  + notifyDiscord(String) void
  + notifyMail(String) void
  + notifyWhatsApp(String) void
  + notifySms(String) void
}
class NotificationPreference {
  - Boolean mail
  - Boolean sms
  - Boolean whatsApp
  - Boolean telegram
  - Boolean discord
  + getDiscord() Boolean
  + getTelegram() Boolean
  + getWhatsApp() Boolean
  + toString() String
  + getSms() Boolean
  + getMail() Boolean
  - parseNotification(String) void
  + addNotification(List~String~) void
}
class NotificationPrinter {
  + notifyDiscord(String) void
  + notifySms(String) void
  + notifyWhatsApp(String) void
  + notifyMail(String) void
  + notifyTelegram(String) void
}
class Subscription {
  - List~User~ users
  - Website website
  - checkForDuplicateUserAndAddUser(String, List~String~) void
  + addUser(String, List~String~) void
  + notifyAllUsers() void
  + checkForUpdate() boolean
  + toString() String
  + getWebsiteAdress() String
}
class User {
  - NotificationPreference notificationPreference
  - String name
  + getUserName() String
  + getNotificationPreference() NotificationPreference
  + toString() String
}
class Website {
  - String fetchedContent
  - String websiteAdress
  + getWebsiteAddress() String
  + fetchWebsite() String
  + getContent() String
  + setWebsiteAdress(String) void
  + setFetchedContent(String) void
}
class WebsiteMonitor {
  + main(String[]) void
}

NotificationPrinter  ..>  INotification 
Subscription "1" *--> "users *" User
Subscription "1" *--> "website 1" Website 
User "1" *--> "notificationPreference 1" NotificationPreference 
WebsiteMonitor *--> Subscription
Subscription --> INotification
```

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

# Aufgabe 4
commit to github lol

# Aufgabe 5

Dependency Inqection

Interfaces

Abstract Methods