public class NotificationPrinter implements INotification{
    @Override
    public void notifyMail(String userName) {
        System.out.println("Mail Notification sent to: " + userName);
    }

    @Override
    public void notifySms(String userName) {
        System.out.println("SMS Notification sent to: " + userName);
    }

    @Override
    public void notifyWhatsApp(String userName) {
        System.out.println("WhatsApp Notification sent to: " + userName);
    }

    @Override
    public void notifyTelegram(String userName) {
        System.out.println("Telegram Notification sent to: " + userName);
    }

    @Override
    public void notifyDiscord(String userName) {
        System.out.println("Discord Notification sent to: " + userName);
    }
}
