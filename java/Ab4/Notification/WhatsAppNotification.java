package Notification;

public class WhatsAppNotification implements INotification{
    @Override
    public void notify(String userName) {
        System.out.println("WhatsApp Notification sent to: " + userName);
    }
}
