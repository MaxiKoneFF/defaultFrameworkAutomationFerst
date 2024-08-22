package api.myApiTests.Pojo.Post;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class PostResponse {
    private String id;
    private String name;
    private String job;

    public void setValue() {
        this.id = id;
        this.name = name;
        this.job = job;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getJob() {
        return job;
    }
}