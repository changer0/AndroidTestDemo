package com.lulu.androidtestdemo.mock;


import com.lulu.androidtestdemo.mock.powerclass.CollaboratorWithFinalMethods;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.verifyNew;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;


@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.lulu.androidtestdemo.mock.powerclass.*")
//@PowerMockIgnore({"sun.security.*", "javax.net.*"})
public class TestPowerMockito {

    @Test
    public void testPowerMockito() throws Exception {
        CollaboratorWithFinalMethods mock = mock(CollaboratorWithFinalMethods.class);
        whenNew(CollaboratorWithFinalMethods.class).withNoArguments().thenReturn(mock);
        CollaboratorWithFinalMethods collaborator = new CollaboratorWithFinalMethods();
        verifyNew(CollaboratorWithFinalMethods.class).withNoArguments();
        when(collaborator.helloMethod()).thenReturn("Hello Baeldung!");
        String welcome = collaborator.helloMethod();
        Mockito.verify(collaborator).helloMethod();
        assertEquals("Hello Baeldung!", welcome);
    }
}