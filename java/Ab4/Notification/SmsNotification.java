package Notification;

public class SmsNotification implements INotification{
    @Override
    public void notify(String messenger) {
        System.out.println("SMS Notification sent to: " + messenger);
    }
}
