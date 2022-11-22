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
public class CollaboratorWithStaticMethodsTest {

    @Test(expected = RuntimeException.class)
    public void staticMethodsTest() {
        PowerMockito.mockStatic(CollaboratorWithStaticMethods.class);

        PowerMockito.when(CollaboratorWithStaticMethods.firstMethod(Mockito.anyString()))
                .thenReturn("Hello Mifort!");
        PowerMockito.when(CollaboratorWithStaticMethods.secondMethod()).thenReturn("Nothing special");

        PowerMockito.doThrow(new RuntimeException()).when(CollaboratorWithStaticMethods.class);
        try {
            CollaboratorWithStaticMethods.thirdMethod();
        } catch (RuntimeException e) {
            System.out.println("Exception was thrown!");
        }


        String firstWelcome = CollaboratorWithStaticMethods.firstMethod("Whoever");
        String secondWelcome = CollaboratorWithStaticMethods.firstMethod("Whatever");

        Assert.assertEquals("Hello Mifort!", firstWelcome);
        Assert.assertEquals("Hello Mifort!", secondWelcome);

        PowerMockito.verifyStatic(Mockito.times(2));
        CollaboratorWithStaticMethods.firstMethod(Mockito.anyString());

        PowerMockito.verifyStatic(Mockito.never());
        CollaboratorWithStaticMethods.secondMethod();
    }

}