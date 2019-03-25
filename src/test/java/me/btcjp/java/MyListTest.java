package me.btcjp.java;

import org.junit.*;
import org.mockito.Mockito;
import org.apache.commons.lang3.RandomStringUtils;

public class MyListTest {

    @Test
    public void testReturen() {
        MyList listMock = Mockito.mock(MyList.class);

        Mockito.when(listMock.add(Mockito.anyString())).thenReturn(false);

        boolean added = listMock.add(RandomStringUtils.randomAlphabetic(6));
        Assert.assertFalse(added);

        Mockito.doReturn(true).when(listMock).add(Mockito.anyString());

        added = listMock.add(RandomStringUtils.randomAlphabetic(5));
        Assert.assertTrue(added);
    }

    @Test(expected = IllegalStateException.class)
    public void testThrowException() {
        MyList listMock = Mockito.mock(MyList.class);
        Mockito.when(listMock.add(Mockito.anyString())).thenThrow(IllegalStateException.class);
        listMock.add(RandomStringUtils.randomAlphabetic(6));
    }
}
