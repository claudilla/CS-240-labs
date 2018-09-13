package Request;

import Model.Event;
import Model.Person;
import Model.User;



public class LoadRequest {

    User[] arrayUserObj;
    Person[] arrayPersonObj;
    Event[] arrayEventObj;

    /**
     * Constructor contains all the information to Load a Request
     * @param arrayUserObj
     * @param arrayPersonObj
     * @param arrayEventObj
     */
    public LoadRequest(User[] arrayUserObj, Person[] arrayPersonObj, Event[] arrayEventObj) {
        this.arrayUserObj = arrayUserObj;
        this.arrayPersonObj = arrayPersonObj;
        this.arrayEventObj = arrayEventObj;
    }

    public User[] getArrayUserObj() {
        return arrayUserObj;
    }

    public void setArrayUserObj(User[] arrayUserObj) {
        this.arrayUserObj = arrayUserObj;
    }

    public Person[] getArrayPersonObj() {
        return arrayPersonObj;
    }

    public void setArrayPersonObj(Person[] arrayPersonObj) {
        this.arrayPersonObj = arrayPersonObj;
    }

    public Event[] getArrayEventObj() {
        return arrayEventObj;
    }

    public void setArrayEventObj(Event[] arrayEventObj) {
        this.arrayEventObj = arrayEventObj;
    }

}
