package com.lulu.androidtestdemo.mock;


import com.lulu.androidtestdemo.mock.powerclass.CollaboratorForPartialMocking;
import com.lulu.androidtestdemo.mock.powerclass.CollaboratorWithFinalMethods;
import com.lulu.androidtestdemo.mock.powerclass.CollaboratorWithStaticMethods;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.doThrow;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.verifyNew;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;


@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.lulu.androidtestdemo.mock.powerclass.*")
//@PowerMockIgnore({"sun.security.*", "javax.net.*"})
public class TestPowerMockito {

    @Test
    public void testFinalMethods() throws Exception {
        CollaboratorWithFinalMethods mock = mock(CollaboratorWithFinalMethods.class);
        whenNew(CollaboratorWithFinalMethods.class).withNoArguments().thenReturn(mock);
        CollaboratorWithFinalMethods collaborator = new CollaboratorWithFinalMethods();
        verifyNew(CollaboratorWithFinalMethods.class).withNoArguments();
        when(collaborator.helloMethod()).thenReturn("Hello Baeldung!");
        String welcome = collaborator.helloMethod();
        Mockito.verify(collaborator).helloMethod();
        assertEquals("Hello Baeldung!", welcome);
    }

    @Test
    public void testStaticMethod() throws Exception {
        mockStatic(CollaboratorWithStaticMethods.class);

        when(CollaboratorWithStaticMethods.firstMethod(Mockito.anyString()))
                .thenReturn("Hello Baeldung!");
        when(CollaboratorWithStaticMethods.secondMethod()).thenReturn("Nothing special");

        doThrow(new RuntimeException()).when(CollaboratorWithStaticMethods.class);
        CollaboratorWithStaticMethods.thirdMethod();
        String firstWelcome = CollaboratorWithStaticMethods.firstMethod("Whoever");
        String secondWelcome = CollaboratorWithStaticMethods.firstMethod("Whatever");
        CollaboratorWithStaticMethods.firstMethod(Mockito.anyString());

        verifyStatic(CollaboratorWithStaticMethods.class, Mockito.times(3));
        CollaboratorWithStaticMethods.firstMethod(Mockito.anyString());

        verifyStatic(CollaboratorWithStaticMethods.class, Mockito.never());
        CollaboratorWithStaticMethods.secondMethod();

    }


    @Test
    public void testPartial() throws Exception {
        spy(CollaboratorForPartialMocking.class);
        when(CollaboratorForPartialMocking.staticMethod()).thenReturn("I am a static mock method.");
        String returnValue = CollaboratorForPartialMocking.staticMethod();
        verifyStatic(CollaboratorWithFinalMethods.class);
        CollaboratorForPartialMocking.staticMethod();
        assertEquals("I am a static mock method.", returnValue);
        CollaboratorForPartialMocking collaborator = new CollaboratorForPartialMocking();
        CollaboratorForPartialMocking mock = spy(collaborator);

    }
}