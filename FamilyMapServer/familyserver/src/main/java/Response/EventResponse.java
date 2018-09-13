package Response;

import Model.Event;




public class EventResponse {
    /**
     * Constructor for EventResponse
     */
    public EventResponse() {
    }

    /**
     *Success Response returns JSON Object with a "data" attribute that contain an array of Event Objects
     * @param events array of events
     */
    public void EventResponseMsg(Event[] events){

    }

    /**
     * Error Response Message
     */
    public void EventErrorMsg(){

    }
}
