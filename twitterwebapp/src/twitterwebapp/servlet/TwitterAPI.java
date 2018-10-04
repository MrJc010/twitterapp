package twitterwebapp.servlet;
import java.util.List;

import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.OAuth2Token;
import twitter4j.conf.ConfigurationBuilder;


//****************Hoa Nguyen Code******************
/*
 * Create new TwitterAPI object
 * then use the TwitterAPI object to call function
 * there are setTwitterKey, setStatus, getTweet, getUserName, getFollower, findTweet, postTweet, and message
 */
public class TwitterAPI {
	private ConfigurationBuilder config = new ConfigurationBuilder();
	private String consumerKey = "9BD8tvHlFXpr0pYpKa4wlilQd";
	private String consumerSecret = "jEuGObtfjDDvID3QZdDvzIxi6cfmE6JF2p7ioXF8qpRJHjD1vz";
	private String accessToken = "1038228667917262850-bxPfV7pCMKRsv8WOOoMs3ha5JAaGn9";
	private String accessTokenSecret = "3hh3d1YTVKwIHDHSuGiWnQzmDYUuVYMJJiaVXFnVWS6qr";
	private TwitterFactory tf;
	private StringBuilder consoleResult = null;
	private Twitter twitter;

	public TwitterAPI(){
		setTwitterDefaultKey();
		tf = new TwitterFactory(config.build());
		twitter = tf.getInstance();
	}

	//Set Default Twitter Key
	private void setTwitterDefaultKey(){
		config.setDebugEnabled(true);
		config.setOAuthConsumerKey(consumerKey);
		config.setOAuthConsumerSecret(consumerSecret);
		config.setOAuthAccessToken(accessToken);
		config.setOAuthAccessTokenSecret(accessTokenSecret);
	}

	//Set Twitter Key
	public String setTwitterKey(String consumerKey,String consumerSecret,String accessToken,String accessTokenSecret ){
		try{
			consoleResult = new StringBuilder("");
			config = new ConfigurationBuilder();
			config.setOAuthConsumerKey(consumerKey);
			config.setOAuthConsumerSecret(consumerSecret);
			config.setOAuthAccessToken(accessToken);
			config.setOAuthAccessTokenSecret(accessTokenSecret);
			tf = new TwitterFactory(config.build());
			twitter = tf.getInstance();
		}catch (Exception e){
			consoleResult.append(e.toString());
		}
		return consoleResult.toString();
	}

	//Get Twitter
	public Twitter getTwitter(){

		return twitter;
	}
	//Get User Name
	public String getUserName(){
		try {
			consoleResult = new StringBuilder("");
			consoleResult.append("Username: " + twitter.getScreenName().toString());
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return consoleResult.toString();
	}

	//Get Tweet
	public String getTweet() {
		try {
			consoleResult = new StringBuilder("");
			List<Status> tweets = twitter.getHomeTimeline();
			consoleResult.append(tweets.get(0).getUser().getName()+ " tweet: " +tweets.get(0).getText());
		} catch (TwitterException e) {
			consoleResult.append(e);
			e.printStackTrace();
		}

		return consoleResult.toString();
	}


	//Get Follower
	public String getFollower(){
		IDs followersList = null;
		try {
			consoleResult = new StringBuilder("");
			followersList = twitter.getFollowersIDs(twitter.getScreenName(), -1);
		} catch (IllegalStateException e1) {
			consoleResult.append(e1);
			e1.printStackTrace();
		} catch (TwitterException e1) {
			consoleResult.append(e1);
			e1.printStackTrace();
		}
		long[] ids = followersList.getIDs();
		int count = 0;

		for(long id : ids){
			User user = null;
			try {
				user = twitter.showUser(id);
				consoleResult.append(user.getName() + " ");
			} catch (TwitterException e) {
				consoleResult.append("Error");
				e.printStackTrace();
			}
			if(count >= 10){
				count = 0;
			}else{
				count++;
			}
		}

		return consoleResult.toString();
	}

	//Find Tweet
	public String findTweet(String keyword){
		Query query = new Query(keyword);
		QueryResult queryresult = null;
		try {
			consoleResult = new StringBuilder("");
			queryresult = twitter.search(query);
			consoleResult.append("Result of: " + keyword);
			for(Status tweet : queryresult.getTweets()){
				consoleResult.append(tweet.getText());
			}
		} catch (TwitterException e) {
			consoleResult.append(e);
			e.printStackTrace();
		}

		return consoleResult.toString();
	}
	//Post Tweet	
	public String postTweet(String yourtweet){
		Status tweet = null;
		try {
			consoleResult = new StringBuilder("");
			tweet = twitter.updateStatus(yourtweet);
			consoleResult.append("You had posted: " +tweet.getText());
		} catch (TwitterException e) {
			consoleResult.append(e);
			e.printStackTrace();
		}

		return consoleResult.toString();
	}
	//Message	
	public String message(String message, String person){
		DirectMessage messageTweet = null;
		try {
			consoleResult = new StringBuilder("");
			messageTweet = twitter.sendDirectMessage(person, message);
		} catch (TwitterException e) {
			consoleResult.append(e);
			e.printStackTrace();
		}
		return consoleResult.toString();
	}
	

	//****************Viet Nguyen Code******************
	//Get Trends
	public String getTrends() {
		try {
			consoleResult = new StringBuilder("");
			Trends trends = twitter.getPlaceTrends(1);
			int count = 0;
			for (Trend trend : trends.getTrends()) {
				if (count < 10) {
					consoleResult.append(trend.getName());
					count++;
				}
				consoleResult.append(System.lineSeparator());
			}
		} catch (TwitterException e) {
			consoleResult.append(e);
			e.printStackTrace();
		}

		return consoleResult.toString();
	}
}
