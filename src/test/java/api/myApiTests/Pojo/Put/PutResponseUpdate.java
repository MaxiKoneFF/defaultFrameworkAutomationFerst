package api.myApiTests.Pojo.Put;

public class PutResponseUpdate extends PutResponse {
    private String updatedAt;

    public PutResponseUpdate(String name, String job, String updatedAt) {
        super(name, job);
        this.updatedAt = updatedAt;
    }

    public PutResponseUpdate() {
        super(null, null);
    }
    public String getUpdatedAt() {
        return updatedAt;
    }
}