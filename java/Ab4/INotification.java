import java.util.List;

public interface INotification {
    // Warum das hier nicht einfach von User aufrufen? waas wäre daran falsch?
    public void notifyMail(String userName);
    public void notifySms(String userName);
    public void notifyWhatsApp(String userName);
    public void notifyTelegram(String userName);
    public void notifyDiscord(String userName);
}
