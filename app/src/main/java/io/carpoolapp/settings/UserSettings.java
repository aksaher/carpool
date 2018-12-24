package io.carpoolapp.settings;

import io.carpoolapp.models.User;

/**
 * Created by akshay on 11-12-2018.
 */

public interface UserSettings {

    boolean isUserLoggedIn();

    void  setUserLoggedIn(boolean isUserLoggedIn);

    User getAppUser();
}
