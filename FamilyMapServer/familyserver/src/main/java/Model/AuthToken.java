package Model;


public class AuthToken {

    String username;
    String authToken;
    int time;

    /**
     * Constructor contains all the information to generate a token
     * @param username username parameter
     * @param authToken authorization token parameter
     * @param time time parameter
     */
    public AuthToken(String username, String authToken, int time) {
        this.username = username;
        this.authToken = authToken;
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}


