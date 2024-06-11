import Notification.INotification;

public class NotificationPrinter implements INotification {


    @Override
    public void notifyTelegram(String userName) {
        System.out.println("Telegram Notification sent to: " + userName);
    }

    @Override
    public void notifyDiscord(String userName) {
        System.out.println("Discord Notification sent to: " + userName);
    }
}
