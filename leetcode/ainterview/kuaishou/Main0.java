package leetcode.ainterview.kuaishou;

import java.util.Scanner;

public class Main0 {

    public String islegle(String ip){
        String[] ipStr;
        int kind;
        if (ip.contains(".")){
            ipStr = ip.split(".");
            kind = 1;
        } else if (ip.contains(":")){
            ipStr = ip.split(":");
            kind = 2;
        } else {
            return "Neither";
        }
        if (kind == 1){
            for (int i = 0; i < 4; i++){
                if ("0".equals(ipStr[i].charAt(0)) && ipStr[i].length() != 1){
                    return "Neither";
                } else if ("00".equals(ipStr[i].substring(0, 2))){
                    return "Neither";
                }
                else {
                    int value = Integer.valueOf(ipStr[i]);
                    if (value < 0 || value > 255){
                        return "Neither";
                    }
                }
            }
            return "IPv4";
        } else {
            for (int i = 0; i < ipStr.length; i++) {
                String s = ipStr[i];
                if (s.length() == 0 || (s.length() == 4 && "0000".equals(s)) || s.length() >= 5) {
                    return "Neither";
                } else if (!s.matches("[0-9a-fA-F]{1,4}")){
                    return "Neither";
                }
            }
            return "IPv6";
        }

    }
    public static void main(String[] args) {
        Main0 s = new Main0();
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            String ip = sc.nextLine();
            System.out.println(s.islegle(ip));
        }
    }
}
