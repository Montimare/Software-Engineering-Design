package Notification;

public class MailNotification implements INotification{
    @Override
    public void notify(String userName) {
        System.out.println("Mail Notification sent to: " + userName);
    }
}
