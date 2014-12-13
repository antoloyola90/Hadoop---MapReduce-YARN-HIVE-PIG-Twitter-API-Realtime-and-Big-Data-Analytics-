/*
 * Copyright 2007 Yusuke Yamamoto
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

/**
 * Shows one single user.
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public final class GetTweetsAndSaveToFile {
    /**
     * Usage: java twitter4j.examples.user.ShowUser [screen name]
     *
     * @param args message
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Usage: java twitter4j.examples.user.ShowUser [screen name]");
            System.exit(-1);
        }
        try {
            Twitter twitter = new TwitterFactory().getInstance();
            twitter.setOAuthConsumer("men2JyLEaAsxcbfmgzOAwUnTp", "2AGN0ie9TfCDJyWeH8qhTLtMhqRvRlNBtQU3lAP2M8k3Xk1KWl");
            RequestToken requestToken = twitter.getOAuthRequestToken();
            System.out.println("Authorization URL: \n" + requestToken.getAuthorizationURL());
            
            AccessToken accessToken = new AccessToken("2811255124-zigkuv8MwDQbr5s9HdjLRSbg8aCOyxeD2gYGMfH", 
            		"D7jFABWHQa8QkTWwgYj1ISUbWP8twdfbzNgYkXI3jwySR");
            
            twitter.setOAuthAccessToken(accessToken);
            /*
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (null == accessToken) {
                System.out.println("Open the following URL and grant access to your account:");
                System.out.println(requestToken.getAuthorizationURL());
                System.out.print("Enter the PIN(if available) and hit enter after you granted access.[PIN]:");
                String pin = br.readLine();
                try {
                    if (pin.length() > 0) {
                        accessToken = twitter.getOAuthAccessToken(requestToken, pin);
                    } else {
                        accessToken = twitter.getOAuthAccessToken(requestToken);
                    }
                } catch (TwitterException te) {
                    if (401 == te.getStatusCode()) {
                        System.out.println("Unable to get the access token.");
                    } else {
                        te.printStackTrace();
                    }
                }
            }
            */
            System.out.println("Got access token.");
            System.out.println("Access token: " + accessToken.getToken());
            System.out.println("Access token secret: " + accessToken.getTokenSecret());
            
            User user = twitter.showUser(args[0]);
            if (user.getStatus() != null) {
                System.out.println("@" + user.getScreenName() + " - " + user.getStatus().getText());
            } else {
                // the user is protected
                System.out.println("@" + user.getScreenName());
            }
            
            FileWriter file = new FileWriter("./"+user.getScreenName()+"_Tweets.txt");
            List<Status> list = twitter.getHomeTimeline();
            for (Status each : list) {
            	file.write("Sent by: @" + each.getUser().getScreenName()
                 + " - " + each.getUser().getName() + "---" + each.getText()
                 + "\n");
            }

            file.close();
            System.exit(0);
        } catch (Exception te) {
            te.printStackTrace();
            System.exit(-1);
        }
    }
}
