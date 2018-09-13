package Request;

import Model.User;



public class EventRequest {

    User user;

    /**
     * Constructor for EventRequest Class
     * @param user user object
     */
    public EventRequest(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
