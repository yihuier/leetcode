package start1;

import java.util.Stack;

public class Solution71 {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        path += "/";

        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                if (sb.length() != 0) {
                    String str = sb.toString();
                    sb = new StringBuilder();
                    if (str.equals("..")) {
                        if (stack.isEmpty()) {
                            continue;
                        }
                        stack.pop();
                    } else if (!str.equals(".")){
                        stack.push(str);
                    }
                }
            } else {
                sb.append(path.charAt(i));
            }
        }

        if (stack.isEmpty()) return "/";

        sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }

        return sb.toString();
    }
}
