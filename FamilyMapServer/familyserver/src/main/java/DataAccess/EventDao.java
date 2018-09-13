package DataAccess;

import Model.Event;


public class EventDao {

    Event event;

    public EventDao() {
    }

    /**
     * Finds an Event in the Database
     * Returns an Event Object
     * @param event event object
     * @return
     */
    Event findEvent(Event event){
        return null;
    }

    /**
     * Adds an Event to the Database
      * @param event event object
     */
    public void addEvent(Event event){

    }

    /**
     * Updates an Event from the Database
     * @param infoEvent information Event String
     */
    public void updateEvent(String infoEvent){

    }

    /**
     * Deletes an Event from the Database
     * @param eventID ID of event
     */
    public void deleteEvent(String eventID){

    }

    /**
     * Clear all the event from the Table
     */
    public void clearEvent(){

    }
}
