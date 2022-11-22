package org.mifort.power_mock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "org.mifort.power_mock.*")
public class CollaboratorWithFinalMethodsTest {

    @Test
    void mockFinalMethodAndConstructorTest() throws Exception {
        CollaboratorWithFinalMethods mock = PowerMockito.mock(CollaboratorWithFinalMethods.class);

        PowerMockito.whenNew(CollaboratorWithFinalMethods.class).withNoArguments().thenReturn(mock);

        CollaboratorWithFinalMethods collaborator = new CollaboratorWithFinalMethods();
        PowerMockito.verifyNew(CollaboratorWithFinalMethods.class).withNoArguments();

        PowerMockito.when(collaborator.helloMethod()).thenReturn("Hello Mifort!");
        String welcome = collaborator.helloMethod();

        Mockito.verify(collaborator).helloMethod();
        Assert.assertEquals("Hello Mifort!", welcome);
    }

}