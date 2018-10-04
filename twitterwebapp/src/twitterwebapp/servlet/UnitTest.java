package twitterwebapp.servlet;

import static org.junit.Assert.assertNotNull;

import static org.junit.Assert.assertEquals;


import org.junit.Test;





public class UnitTest {
	
	//****************Viet Nguyen Code******************

	TwitterAPI twitterAPI = new TwitterAPI();

	/**
	 * Used for testing FindTweet with a string.
	 * @param searchString
	 * @return
	 */
	@Test
	public void testFindTweet() {
		String tweet = twitterAPI.findTweet("this is me");
		assertNotNull(tweet);
	}

	/**
	 * Used for testing GetFollower function
	 * @return
	 */
	@Test
	public void  testGetFollowers() {
		String follower =  twitterAPI.getFollower();
		assertNotNull(follower);
	}

	/**
	 * Used for testing the Trends of the logged in user.
	 * @return
	 */
	@Test
	public void testGetTrends() {
		String trends =  twitterAPI.getTrends();
		assertNotNull(trends);
	}

	/**
	 * Used for testing the newest tweet of logged in user.
	 * @return
	 */
	@Test
	public void  testGetTweet() {
		String tweet =  twitterAPI.getTweet();
		assertNotNull(tweet);
	}

	/**
	 * Used for testing the GetUserName function of the logged in account.
	 * @return
	 */
	@Test
	public void  testGetUserName() {
		String userName = "Username: MrJc86184176";
		String name =  twitterAPI.getUserName();
		assertEquals(name, userName);
	}

	/**
	 * Used for testing the Message function of the logged in account.
	 * @return
	 */
	@Test
	public void  testMessage() {
		String mes =  twitterAPI.message("this is a message", "MinhKNgo0710");
		assertNotNull(mes);
	}


	/**
	 * Used for testing the PostTweet function of the logged in user.
	 * @return
	 */
	@Test
	public void  testPostTweet() {
		String result = "You had posted: this is a post for testing";
		String post =  twitterAPI.postTweet("this is a post for testing");
		assertEquals(post, result);
	}  
	/**
	 * Used for testing the SetKey function.
	 * @return
	 */
	@Test
	public void testSetKey() {
		String key =  twitterAPI.setTwitterKey("IiCSqSuOMTXPxPnGLKADD1XX3", "NOIjrwCFC1qKuNDXv8FNLJJMnQTLBwvnGeTaiSJlSE9LmqTtAV", "1042911030643326976-LEel2Go2h9Ad9ikucmfATXcpHluWvu", "rzZADaxFztjD6UehRyUoQ2FYr9NbAImuvCVciDlKFgRbK");
		assertNotNull(key);
	}
}