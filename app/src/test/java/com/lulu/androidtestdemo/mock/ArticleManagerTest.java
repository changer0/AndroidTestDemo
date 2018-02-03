package com.lulu.androidtestdemo.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by zhanglulu on 2018/2/2.
 */
@RunWith(MockitoJUnitRunner.class)
public class ArticleManagerTest {
    @Mock
    ArticleCalculator calculator;
    @Mock
    ArticleDatabase database;
    @Mock
    User user;
    @InjectMocks
    private ArticleManager manager; // <= ①

    @Test
    public void shouldDoSomething() {
        //使用了一个ArticleListener实例调用了addListener
        manager.initialize();

        // 验证database调用使用了ArticleListener类型的参数调用了addListener
        verify(database).addListener(any(ArticleListener.class));
    }

}