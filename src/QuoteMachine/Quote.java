package QuoteMachine;

public class Quote {
    private String quote;
    private String source;

    public Quote(String quote, String source)
    {
        this.quote = quote;
        this.source = source;
    }

    public String getQuote() {
        return quote;
    }

    public String getSource() {
        return source;
    }
}
