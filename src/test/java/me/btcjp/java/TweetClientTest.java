package me.btcjp.java;

import org.junit.*;
import static org.mockito.Mockito.*;

public class TweetClientTest {

    @Test
    public void testSendMessage() {
        TweetClient tweetClient = new TweetClient();
        ITweet iTweet = mock(ITweet.class);

        when(iTweet.getMessage()).thenReturn("using mockito");
        tweetClient.sendTweet(iTweet);
        verify(iTweet, atLeastOnce()).getMessage();
    }
}
