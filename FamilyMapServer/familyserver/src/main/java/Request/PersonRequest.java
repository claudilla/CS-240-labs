package Request;

import Model.User;



public class PersonRequest {

    User user;

    /**
     * Constructor for the PersonRequest
     * @param user
     */
    public PersonRequest(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
