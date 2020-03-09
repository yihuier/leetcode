package start1100;

public class Solution1108 {

    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }
}
