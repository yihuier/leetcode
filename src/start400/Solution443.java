package start400;

public class Solution443 {

    public int compress(char[] chars) {
        int write = 0;
        int count = 0;

        for (int read = 0; read < chars.length; read++) {
            count++;

            // 满足条件进行压缩
            if (read == chars.length - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read];

                if (count > 1) {
                    // 将数字转成字符串再转成char数组
                    for (char ch : ("" + count).toCharArray()) {
                        chars[write++] = ch;
                    }
                }
                // 每次压缩完成之后，要把计数置为0，重新计数
                count = 0;
            }
        }

        return write;
    }
}
