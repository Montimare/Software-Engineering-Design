package Notification;

public class MailNotification implements INotification{
    @Override
    public void notify(String messenger) {
        System.out.println("Mail Notification sent to: " + messenger);
    }
}
