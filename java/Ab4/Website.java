import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;

public class Website extends Subject{
    private String websiteAdress;
    private String fetchedContent;

    public Website(String url) {
        this.websiteAdress = url;
    }

    public void fetchWebsite() {
        try {
            StringBuilder result = new StringBuilder();
            URI uri = new URI(websiteAdress);
            HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();
            conn.setRequestMethod("GET");
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()))) {
                for (String line; (line = reader.readLine()) != null; ) {
                    result.append(line);
                }
            }
            if (!result.toString().equals(fetchedContent)){
                notifyObservers();
                setFetchedContent(result.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getContent() {
        return fetchedContent;
    }
    public String getWebsiteAddress() {
        return websiteAdress;
    }
    public void setWebsiteAdress(String websiteAdress) {
        this.websiteAdress = websiteAdress;
    }
    public void setFetchedContent(String fetchedContent) {
        this.fetchedContent = fetchedContent;
    }
}
