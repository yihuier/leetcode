package start400;

public class Solution434 {

    /**
     * 直接使用java提供的api
     */
    public int countSegments2(String s) {
        s = s.trim();

        if (s.length() == 0) return 0;

        return s.split("\\s+").length;
    }
}
