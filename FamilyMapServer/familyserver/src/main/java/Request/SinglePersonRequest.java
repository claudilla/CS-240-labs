package Request;

import Model.User;



public class SinglePersonRequest {

    User user;

    /**
     * Constructor for SinglePersonRequest
     * @param user
     */
    public SinglePersonRequest(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
