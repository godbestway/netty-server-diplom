package basic.method.string;

import java.nio.charset.Charset;

/**
 * @Author: Chenglin Ding
 * @Date: 30.03.2021 20:48
 * @Description:
 */
public class IpvAddress {
    public static void main(String[] args) {
        String ipv4 = "192.168.234.2";
        String ipv6 = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        validIPAdderss(ipv6);
        validIPAdderss(ipv4);
    }

    public static String validIPAdderss(String ip){
        if(ip.split("\\.").length == 4){
            validateIPv4(ip);
            //System.out.println("this is ipv4 address");

        }
        else if(ip.split(":").length == 8){
            validateIPv6(ip);
            //System.out.println("this is ipv6 address");
        }
            return "Neither";

    }

    public static String validateIPv4(String ip){
        String[] parts = ip.split("\\.");
        for(String part: parts){
            //"1929"
            if(part.length() == 0 || part.length() > 3){
                return "Neither";
            }
            //192.002
            if(part.charAt(0) == 0 && part.length() != 1){
                return "Neither";
            }

            //only digit is allowed
            for(char ch: part.toCharArray()){
                if(!Character.isDigit(ch)){
                    return "Neither";
                }
            }
            if(Integer.parseInt(part) > 255){
                return "Neither";
            }

        }
        return "ipv4";
    }

    public static String validateIPv6(String ip){
        String [] parts = ip.split("\\.", -1);
        String hexdigits = "0123456789abcdefABCDEF";
        for(String x: parts){
            if(x.length() == 0|| x.length() > 4){
                return "Neither";
            }
            for(Character ch: x.toCharArray()){
                if(hexdigits.indexOf(ch) == -1){
                    return "Neither";
                }
            }
        }

        return "IPv6";
    }
}
