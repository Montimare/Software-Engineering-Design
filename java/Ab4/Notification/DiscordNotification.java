package Notification;

public class DiscordNotification implements INotification{
    @Override
    public void notify(String userName) {
        System.out.println("Discord Notification sent to: " + userName);
    }
}
