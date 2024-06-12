package Notification;

public class SmsNotification implements INotification{
    @Override
    public void notify(String userName) {
        System.out.println("SMS Notification sent to: " + userName);
    }

    @Override
    public String toString() {
        return "SMS Notification";
    }
}
