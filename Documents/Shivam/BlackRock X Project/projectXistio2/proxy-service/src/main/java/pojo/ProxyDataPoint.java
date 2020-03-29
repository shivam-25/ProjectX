package pojo;

public class ProxyDataPoint {
    private String symbol;
    private Double open,close;

    public ProxyDataPoint(String symbol, Double open, Double close) {
        this.symbol = symbol;
        this.open = open;
        this.close = close;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }
}
