package com.loyer.dagger.data_manager.modal;

import java.io.Serializable;

/**
 * Created by celikrecep on 8.06.2019.
 */
public class User implements Serializable {
    public String login;
    public long id;
    public String url;
    public String email;

    public User() {
    }
}
