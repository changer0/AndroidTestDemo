assertTrue(result instanceof String);
// error message:
java.lang.AssertionError
    at org.junit.Assert.fail(Assert.java:86)
    at org.junit.Assert.assertTrue(Assert.java:41)
    at org.junit.Assert.assertTrue(Assert.java:52)
// ...


assertEquals(String.class, result.getClass());
// error message:
java.lang.NullPointerException
    at com.vogella.hamcrest.HamcrestTest.test(HamcrestTest.java:30)
// ....


assertThat(result, instanceOf(String.class));
// error message:
java.lang.AssertionError:
Expected: an instance of java.lang.String
     but: null
    at org.hamcrest.MatcherAssert.assertThat(MatcherAssert.java:20)
    at org.hamcrest.MatcherAssert.assertThat(MatcherAssert.java:8)
// ...