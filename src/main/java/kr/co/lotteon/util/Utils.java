package kr.co.lotteon.util;

public class Utils {

    public String maskUid(String uid) {
        if (uid != null && uid.length() > 2) {
            String maskedUid = uid.substring(0, 2) + "**";
            return maskedUid;
        }
        return uid;
    }


}
