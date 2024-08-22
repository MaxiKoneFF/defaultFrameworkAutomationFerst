package api.myApiTests.Pojo.Put;

public class PutResponse {
    private String name;
    private String job;

    public PutResponse(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }
    public String getJob() {
        return job;
    }
}