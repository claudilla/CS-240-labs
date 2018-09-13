package Response;

import Model.Person;


public class personResponse {
    /**
     * Constructor for personResponse
     */
    public personResponse() {
    }

    /**
     * Success Response Message contain a JSON object with a "data" attribute that contains an array of Person Objects
     * @param persons array of persons
     */
    public void personResponseMsg(Person[] persons){

    }

    /**
     * Error Response Message
     */
    public void personErrorMsg(){

    }
}
