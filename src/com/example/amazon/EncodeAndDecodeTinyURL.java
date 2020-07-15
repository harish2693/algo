//TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl
//and it returns a short URL such as http://tinyurl.com/4e9iAk.
//
//Design the encode and decode methods for the TinyURL service. There is no restriction on how your
//encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL
//and the tiny URL can be decoded to the original URL.

package com.example.amazon;

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyURL {

    private static Map<String, String> values = new HashMap<>();
    private static final String characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static int count = 1;

    public static void main(String[] args) {
        String tinyUrl = encode("https://leetcode.com/problems/design-tinyurl");
        String tinyUrl1 = encode("https://leetcode.com/problems/design-tinyurl1");
        String tinyUrl2 = encode("https://leetcode.com/problems/design-tinyurl2");
        String tinyUrl3 = encode("https://leetcode.com/problems/design-tinyurl3");
        String tinyUrl4 = encode("https://leetcode.com/problems/design-tinyurl4");
        String tinyUrl5 = encode("https://leetcode.com/problems/design-tinyurl5");

        System.out.println(tinyUrl);
        System.out.println(tinyUrl1);
        System.out.println(tinyUrl2);
        System.out.println(tinyUrl3);
        System.out.println(tinyUrl4);
        System.out.println(tinyUrl5);

        System.out.println(decode(tinyUrl));
        System.out.println(decode(tinyUrl1));
        System.out.println(decode(tinyUrl2));
        System.out.println(decode(tinyUrl3));
        System.out.println(decode(tinyUrl4));
        System.out.println(decode(tinyUrl5));
    }

    public static String getKey() {
        String key = "";
        while(count > 0) {
            count--;
            key += characters.charAt(count);
            count /= characters.length();
        }

        return key;
    }

    public static String encode(String longUrl) {
        String key = getKey();
        values.put(key, longUrl);
        count++;

        return "http://tinyurl.com/" + key;
    }

    public static String decode(String shortUrl) {
        return values.get(shortUrl.replace("http://tinyurl.com/", ""));
    }
}
