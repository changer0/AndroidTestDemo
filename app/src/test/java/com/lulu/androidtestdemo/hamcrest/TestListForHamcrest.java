package com.lulu.androidtestdemo.hamcrest;

import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


/**
 * Created by lulu on 2018/3/17.
 */
public class TestListForHamcrest {
    @Test
    public void testHamcrest() throws Exception {
        List<Integer> list = Arrays.asList(5, 2, 4);
        // 表示该list含有item为3
        assertThat(list, hasSize(3));
        // 表示包含5, 2, 4三个item,并且断言其魂虚
        assertThat(list, contains(5, 2, 4));
        // 表示包含2, 4, 5三个item,但是忽略顺序
        assertThat(list, containsInAnyOrder(2, 4, 5));
        // 表示list中每一个数都比1大
        assertThat(list, everyItem(greaterThan(1)));
        // 表示list中每一个数都比6小
        assertThat(list, everyItem(lessThan(6)));


        // Check that a list of objects has a property race and
// that the value is not ORC


    }

    @Test
    public void testProperty() throws Exception {
        List<People> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            People people = new People("张三" + i);
            list.add(people);
        }
        assertThat(list,
                everyItem(hasProperty("name", containsString("张三"))));

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



    @Test
    public void hasSizeOf3() {
        List<Integer> list = Arrays.asList(5, 2, 4);

        assertThat(list, hasSize(3));
    }
    @Test
    public void containsNumbersInAnyOrder() {
        List<Integer> list = Arrays.asList(5, 2, 4);

        assertThat(list, containsInAnyOrder(2, 4, 5));
    }
    @Test
    public void everyItemGreaterThan1() {
        List<Integer> list = Arrays.asList(5, 2, 4);

        assertThat(list, everyItem(greaterThan(1)));
    }




    Integer[] ints = new Integer[] {7, 5, 12, 16};

    @Test
    public void arrayHasSizeOf4() {
        Integer[] ints = new Integer[] { 7, 5, 12, 16 };

        assertThat(ints, arrayWithSize(4));
    }
    @Test
    public void arrayContainsNumbersInGivenOrder() {
        Integer[] ints = new Integer[] { 7, 5, 12, 16 };

        assertThat(ints, arrayContaining(7, 5, 12, 16));
    }

    @Test
    public void objectHasSummaryProperty () {

        Todo todo = new Todo(1, "Learn Hamcrest", "Important");

        assertThat(todo, hasProperty("summary"));
    }
    @Test
    public void objectHasCorrectSummaryValue () {

        Todo todo = new Todo(1, "Learn Hamcrest", "Important");

        assertThat(todo, hasProperty("summary", equalTo("Learn Hamcrest")));
    }
    @Test
    public void objectHasSameProperties () {

        Todo todo1 = new Todo(1, "Learn Hamcrest", "Important");
        Todo todo2 = new Todo(1, "Learn Hamcrest", "Important");

        assertThat(todo1, samePropertyValuesAs(todo2));
    }

    @Test
    public void isStringEmpty() {
        String stringToTest = "";
        assertThat(stringToTest, isEmptyString());
    }

    @Test
    public void isStringEmptyOfNull() {
        String stringToTest = "";
        assertThat(stringToTest, isEmptyOrNullString());
    }


    @Test
    public void fellowShipOfTheRingShouldContainer7() {
        assertThat("Gandalf", length(is(8)));
    }


    public static Matcher<String> length(Matcher<? super Integer> matcher) {
        return new FeatureMatcher<String, Integer>(matcher,
                "a String of length that", "length") {
            @Override
            protected Integer featureValueOf(String actual) {
                return actual.length();
            }
        };
    }


    @Test
    public void testRegularExpressionMatcher() throws Exception {
        String s ="aaabbbaaaa";
        assertThat(s, RegexMatcher.matchesRegex("a*b*a*"));
    }

}
