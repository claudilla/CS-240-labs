package Request;

import Model.Event;


public class singleEventRequest {

    Event event;

    /**
     * Constructor for singleEventRequest
     * @param event
     */
    public singleEventRequest(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

}
