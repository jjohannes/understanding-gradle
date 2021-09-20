package mypproject.shared.util;

public final class EmojiEncodeUtil {

    public static String encode(String s) {
        return s.replace(":)", "\uD83D\uDE03");
    }

}
