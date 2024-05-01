package globals;

import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class User {
    private static final User INSTANCE = new User();

    private String id;
    private String name;
    private Integer number;
    private Response response;

    public static User getInstance() {
        return INSTANCE;
    }

    public void reset() {
        this.id = null;
        this.name = null;
        this.number = null;
        this.response = null;
    }
}