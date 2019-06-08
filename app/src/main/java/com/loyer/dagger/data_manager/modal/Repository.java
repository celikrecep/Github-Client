package com.loyer.dagger.data_manager.modal;

import java.io.Serializable;

/**
 * Created by celikrecep on 8.06.2019.
 */
public class Repository implements Serializable {
    public long id;
    public String name;
    public String url;
    public int stargazers_count;
    public int forks_count;

    public Repository() {
    }
}
