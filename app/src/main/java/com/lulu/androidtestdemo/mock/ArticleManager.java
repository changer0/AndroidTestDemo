package com.lulu.androidtestdemo.mock;

/**
 * Created by zhanglulu on 2018/2/2.
 */

public class ArticleManager {
    private User user;
    private ArticleDatabase database;

    public ArticleManager() {
        super();
        //this.user = user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDatabase(ArticleDatabase database) {
        this.database = database;
    }

    public void initialize() {
        database.addListener(new ArticleListener());
    }
}
