package JSON;


public class Data {
    private String asset;
    private String total;

    public Data(String asset, String total) {
        this.asset = asset;
        this.total = total;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
