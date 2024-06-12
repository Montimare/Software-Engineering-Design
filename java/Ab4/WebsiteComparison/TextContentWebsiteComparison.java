package WebsiteComparison;

import org.jsoup.Jsoup;

public class TextContentWebsiteComparison implements IWebsiteComparison{
    @Override
    public boolean compare(String old, String current) {
        return Jsoup.parse(old).text().equals(Jsoup.parse(current).text());
    }
}
