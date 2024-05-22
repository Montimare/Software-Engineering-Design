# Aufgabe 1
## This is a Microservice Architecture
```plantuml
@startuml

database Integration {
    component DigitalEmployeeFile
    component OfficesAndDepartmentsTimeTables
    component Salaries
}

node Backend {
    component CalculateSalaries
}

node Frontend {
    component GUI
}

node API {
    component TalkToBank
}

node Bank


actor User

Frontend -up- User
Backend -up- Frontend
Integration -up- Backend
API -right- Bank
API -left- Integration

@enduml
```
# Aufgabe 2

## Introducing Peer to Peer Architecture in Gaming

Monolithic Structure is too expensive and too much data has to be sent

Peer to Peer Network: <br>
Every Node(Player) only has a small subset of the Data. Just as much as it is needed and a bit more for redundancy.

# Aufgabe 3
## Ticket machine used by passengers at a railway station

Views:
1. Logical view <=> Class Diagram
```mermaid
classDiagram
    class TicketMachine{
    -Ticket myTicket
    +chooseTicket(int ticketChoice) boolean
    +choosePaymentOption(int paymentChoice) boolean
    +sendDataToDB(string data) boolean
    }
    class Ticket{
    -double ticketPrice
    -double date
    }
    class PaymentServer{
    -string bankData
    +requestTransactionFromBank() boolean
    +verifyTransaction() boolean
    }
    class API{
    +sendDataToDatabase(string data) boolean
    }
    class DBServer{
    +saveData(string data) boolean
    }
    class TrainSchedule
    class TicketInterface

    TicketInterface -- TicketMachine
    TicketMachine -- TrainSchedule
    TicketMachine -- PaymentServer
    TicketMachine -- API
    TicketMachine -- Ticket
    API -- DBServer
```
2. Process view <=> Sequence Diagram
```mermaid
sequenceDiagram
actor user
participant ticketMachine
participant paymentServer
participant aPI
participant dBServer

user ->> ticketMachine: Choose Payment Option
activate ticketMachine

alt Cash
    user -> ticketMachine: Insert coins
else Card
    ticketMachine ->> paymentServer: Initiate Card Purchase
    activate paymentServer
    alt Payment unsuccessful
        paymentServer -->> ticketMachine: Abort
        ticketMachine -->> user: ERROR
    else Payment successful
        paymentServer -->> ticketMachine: Payment successful
    end
    
    deactivate paymentServer

end
ticketMachine ->> aPI: Submit Purchase Data
activate aPI
aPI ->> dBServer: Save Statistics
aPI -->> ticketMachine: Save successful
deactivate aPI

ticketMachine -->> user: Dispense Ticket
deactivate ticketMachine
```
### 3. Development view <=> packages?

### This Diagram is supposed to show us which parts or the programm are connected closely together. For example Authentication is a "package"(not subsystem) that has multiple classes that ensure authentication
```plantuml
@startuml
package "Subsystem 1" <<subsystem>> {
    folder "Folder 1"
    folder "Folder 2"
}

package "Subsystem 2" <<subsystem>> {
    folder "Folder 3"
    folder "Folder 4"
}

package "Subsystem 3" <<subsystem>> {
    folder "Folder 5"
    folder "Folder 6"
}
@enduml
```
### 4. Physical/Deployment view <=> darstellung der distribution?

### This Diagram is supposed to show us on which servers and how our program is deployed/implemented 
```plantuml
@startuml
actor Customer

node GUIClient {
    component "Kauf GUI"
    component Cash
    component Card
}
"Kauf GUI" ..>> Cash
"Kauf GUI" ..>> Card

node DBServer {
    component CalendarDB
    component SalesDB
}

node PaymentServer {
    component GuestUser
}

node API

DBServer "1" -- "*" PaymentServer
DBServer -- API

PaymentServer "1" -- "*" GUIClient
GuestUser <<.. Card

GUIClient <.. Customer
GUIClient -up- API


@enduml
```

# Aufgabe 4
1. Event Based - publish subscriber (wer will kann es sehen)
2. Distributed System - Peer to Peer / Client Server
3. Event Based - Broker