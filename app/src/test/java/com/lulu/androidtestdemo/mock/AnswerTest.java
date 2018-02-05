package com.lulu.androidtestdemo.mock;

import org.junit.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.AdditionalAnswers.returnsLastArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.booleanThat;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * Created by lulu on 2018/2/3.
 */

public class AnswerTest {

    @Test
    public final void callbackTest() {
        ApiService service = mock(ApiService.class);
        when(service.login(any(Callback.class))).thenAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Callback callback = invocation.getArgument(0);
                callback.notify("Success");
                return "Test Result";
            }
        });

        String result = service.login(new Callback() {
            @Override
            public void notify(String notify) {
                System.out.println(notify);
            }
        });
        System.out.println(result);
    }

    @Test
    public final void answerTest() {
        TestObj testObj = mock(TestObj.class);
        // with doAnswer():
        doAnswer(returnsFirstArg()).when(testObj).add(anyString(), anyString());
        // with thenAnswer():
        when(testObj.add(anyString(), anyString())).thenAnswer(returnsFirstArg());
        // with then() alias:
        when(testObj.add(anyString(), anyString())).then(returnsFirstArg());
        //测试打印结果
        System.out.println(testObj.add("FirstArg", "LastArg"));
    }

    class TestObj {
        public String add(String firstArg, String lastArg) {
            return "";
        }
    }


    @Test
    public final void TestDao() {
        List<User> userMap = new ArrayList<>();
        UserDao dao = mock(UserDao.class);
        when(dao.save(any(User.class))).thenAnswer(i -> {
            User user = i.getArgument(0);
            userMap.add(user.getId(), user);
            return null;
        });
        when(dao.find(any(Integer.class))).thenAnswer(i -> {
            int id = i.getArgument(0);
            return userMap.get(id);
        });
    }

    final class FinalClass {
        public final String finalMethod() { return "something"; }
    }

    @Test
    public final void mockFinalClassTest() {
        FinalClass instance = new FinalClass();

        FinalClass mock = mock(FinalClass.class);
        when(mock.finalMethod()).thenReturn("that other thing");

        assertNotEquals(mock.finalMethod(), instance.finalMethod());
    }
}
