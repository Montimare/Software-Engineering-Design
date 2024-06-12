package WebsiteComparison;

public class ContentSizeWebsiteComparison implements IWebsiteComparison{
    @Override
    public boolean compare(String old, String current) {
        /**
         * @returns true if equivalent
         */
        return old.length() == current.length();
    }
}
