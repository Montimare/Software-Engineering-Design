package Notification;

public class TelegramNotification implements INotification{
    @Override
    public void notify(String userName) {
        System.out.println("Telegram Notification sent to: " + userName);
    }
}
