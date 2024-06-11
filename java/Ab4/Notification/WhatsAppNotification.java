package Notification;

public class WhatsAppNotification implements INotification{
    @Override
    public void notify(String messenger) {
        System.out.println("WhatsApp Notification sent to: " + messenger);
    }
}
