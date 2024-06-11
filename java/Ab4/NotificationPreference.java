import java.util.List;

public class NotificationPreference {
    private boolean mail;
    private boolean sms;
    private boolean whatsApp;
    private boolean telegram;
    private boolean discord;

    public NotificationPreference(){
        this.mail = false;
        this.sms = false;
        this.whatsApp = false;
        this.telegram = false;
        this.discord = false;
    }

    public void addNotification(List<String> notification) {
        for (String s : notification) {
            parseNotification(s);
        }
    }

    private void parseNotification(String notification) {
        switch (notification) {
            case "mail":
                mail = true;
                break;
            case "sms":
                sms = true;
                break;
            case "whatsApp":
                whatsApp = true;
                break;
            case "telegram":
                telegram = true;
                break;
            case "discord":
                discord = true;
                break;
        }
    }

    public boolean getMail() {
        return mail;
    }

    public boolean getSms() {
        return sms;
    }

    public boolean getWhatsApp() {
        return whatsApp;
    }

    public boolean getTelegram() {
        return telegram;
    }

    public boolean getDiscord() {
        return discord;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (mail) {
            sb.append("mail, ");
        }
        if (sms) {
            sb.append("sms, ");
        }
        if (whatsApp) {
            sb.append("whatsApp, ");
        }
        if (telegram) {
            sb.append("telegram, ");
        }
        if (discord) {
            sb.append("discord");
        }
        return sb.toString();
    }
}