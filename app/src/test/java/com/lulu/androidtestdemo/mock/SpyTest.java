package com.lulu.androidtestdemo.mock;


import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * Created by zhanglulu on 2018/2/1.
 */

public class SpyTest {

    @Test
    public void testLinkedListSpyWrong() {
        // 让我们来模拟一个LinkedList
        List<String> list = new LinkedList<>();
        List<String> spy = spy(list);
        // 下面的代码不会执行
        // spy.get(0)将会调用真实的方法
        // 将会抛出 IndexOutOfBoundsException (list是空的)
        when(spy.get(0)).thenReturn("foo");
        assertEquals("foo", spy.get(0));
    }

    @Test
    public void testLinkedListSpyCorrect() {
        // 让我们来模拟一个LinkedList
        List<String> list = new LinkedList<>();
        List<String> spy = spy(list);
        // 必须使用doReturn来插桩
        doReturn("foo").when(spy).get(0);
        assertEquals("foo", spy.get(0));
    }
}
