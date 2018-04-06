package com.lulu.androidtestdemo.hamcrest;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNotEquals;


/**
 * Created by lulu on 2018/3/17.
 */
public class TestHamcrest {
    boolean a;
    boolean b;
    boolean expected;
    boolean actual;
    @Test
    public void testHamcrest() throws Exception {
        //下面语句的测试目的是一致的
        assertThat(a, equalTo(b));
        assertThat(a, is(equalTo(b)));
        assertThat(a, is(b));


        // JUnit 4 for equals check
        assertEquals(expected, actual);
        // Hamcrest for equals check
        assertThat(actual, is(equalTo(expected)));

        // JUnit 4 for not equals check
        assertNotEquals(expected, actual);
        // Hamcrest for not equals check
        assertThat(actual, is(not(equalTo(expected))));

        assertThat("test",
                anyOf(is("testing"), containsString("est")));


//        assertThat(Long.valueOf(1), instanceOf(Integer.class));
        // shortcut for instanceOf
        assertThat(Integer.valueOf(1), isA(Integer.class));


        assertThat(0.02, closeTo(0.03, 0.001));
    }

    public class People {
        private String name;
        public People(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
