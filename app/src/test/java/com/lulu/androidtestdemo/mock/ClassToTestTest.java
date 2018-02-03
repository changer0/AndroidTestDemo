package com.lulu.androidtestdemo.mock;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

/**
 * Created by zhanglulu on 2018/1/31.
 */
public class ClassToTestTest {
    @Mock
    MyDatabase databaseMock;// 1
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();// 2
    @Test
    public void query() throws Exception {
        ClassToTest t  = new ClassToTest(databaseMock);// 3
        boolean check = t.query("* from t");// 4
        assertTrue(check);// 5
        verify(databaseMock).query("* from t");// 6
    }
}