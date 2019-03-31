package me.btcjp.java;

import org.junit.*;
import org.mockito.Mockito;
import org.mockito.InOrder;
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

    @Test(expected = IllegalStateException.class)
    public void testMulitBehavior() {
        MyList listMock = Mockito.mock(MyList.class);
        Mockito.when(listMock.add(Mockito.anyString())).thenReturn(false).thenThrow(IllegalStateException.class);
        boolean added = listMock.add(RandomStringUtils.randomAlphabetic(5));
        Assert.assertFalse(added);

        listMock.add(Mockito.anyString());
    }

    public void testVerify() {
        MyList listMock = Mockito.mock(MyList.class);
        listMock.size();
        Mockito.verify(listMock).size();
        Mockito.verify(listMock, Mockito.times(1)).size();
        Mockito.verify(listMock, Mockito.atLeastOnce()).size();
        Mockito.verify(listMock, Mockito.atMost(10)).size();

        listMock.add("abc");
        Mockito.verify(listMock).add("abc");
    }

    public void testInteraction() {
        MyList listMock = Mockito.mock(MyList.class);
        Mockito.verifyZeroInteractions(listMock);

        listMock.size();
        listMock.add("abc");
        listMock.clear();

        InOrder inOrder = Mockito.inOrder(listMock);
        inOrder.verify(listMock).size();
        inOrder.verify(listMock).add("abc");
        inOrder.verify(listMock).clear();
    }
}
