package DataAccess;

import Model.AuthToken;
import Model.User;

/**
 * AuthTokenDao CLass
 */

public class AuthTokenDao {

    AuthToken myToken;

    /**
     * Constructor for Authorization DAO
     */
    public AuthTokenDao() {

    }

    /**
     * Creates a Token for an User
     * @param user user parameter
     */
    public void createAuthToken(User user ){

    }

    /**
     * Finds the Token attach to the User
     * Returns the Token
     * @param myToken token parameter
     * @return
     */
    AuthToken findToken(AuthToken myToken){
        return null;
    }

    /**
     * Clear all the Tokens from the Table
     */
    public void clearToken(){

    }

}



