import java.util.*;
import java.io.*;

public class HJ018识别有效ip地址和掩码并进行分类统计 {
        public static void main(String[] args) throws IOException{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int[] count = new int[7];
            String in;
            while ((in = bf.readLine()) != null) {
                //以~分隔
                String[] split=in.split("~");
                String ip=split[0];//获取IP地址
                String mask=split[1];//获取子网掩码

                String[] ips = ip.split("\\.");
                int num1 = 0;
                int num2 = 0;
                try{
                    num1=Integer.parseInt(ips[0]);
                    num2=Integer.parseInt(ips[1]);
                    Integer.parseInt(ips[2]);
                    Integer.parseInt(ips[3]);
                }catch(NumberFormatException e){
                    count[5]++;
                    continue;
                }


                //1、先判IP地址是否合法
                boolean isIP=isIP(ip);
                boolean isMask=isMask(mask);
                //如果IP和子网掩码都合法 就判断是哪种类型的IP地址
                if(isIP && isMask){
                    count = countIP(ip,count);
                }else if((isIP == false || isMask == false) &&num1 != 127 && num1 != 0) {
                    count[5]++;
                }
            }
            for(int i=0;i<6;i++)
                System.out.print(count[i]+" ");
            System.out.print(count[6]);
        }

        //判断IP是否合法
        public static boolean isIP(String IP){
            //1. 类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时可以忽略
            String[] IParr = IP.split("\\.");
            Boolean isTrue = true;
            for (int i = 0; i < IParr.length; i++) {
                if (IParr[i].length() < 0) {//非法判断
                    isTrue = false;
                }
            }
            return isTrue;
        }
        //判断子网掩码是否合法
        public static boolean isMask(String mask){
            String[] maskarr = mask.split("\\.");
            boolean result = false;
            //0000 0000~ 1111 1110 八位
            //子网掩码为二进制下前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
            // 注意二进制下全是1或者全是0均为非法
            int[] maskRange = {254, 252, 248, 240, 224, 192, 128, 0};
            List<Integer> list = new ArrayList();
            for(int i:maskRange)
                list.add(i);
            //255.255.255.
            if ("255".equals(maskarr[0])&&"255".equals(maskarr[1])&&"255".equals(maskarr[2])) {
                if (list.contains(Integer.parseInt(maskarr[3]))) {
                    result=true;
                }
            }
            //255.255.
            else if("255".equals(maskarr[0])&&"255".equals(maskarr[1])){
                if(list.contains(Integer.parseInt(maskarr[2]))&&"0".equals(maskarr[3])){
                    result=true;
                }
            }
            //255.
            else if("255".equals(maskarr[0])){
                if(list.contains(Integer.parseInt(maskarr[1]))&&"0".equals(maskarr[2])&&"0".equals(maskarr[3])){
                    result=true;
                }
            }else if(list.contains(Integer.parseInt(maskarr[0]))){
                if("0".equals(maskarr[1])&&"0".equals(maskarr[2])&&"0".equals(maskarr[3])){
                    result=true;
                }
            }
            return result;
        }//method end

        //私有IP判断
        /*10.0.0.0-10.255.255.255  172.16.0.0-172.31.255.255  192.168.0.0-192.168.255.255*/
        public static boolean isPrivateIP(String IP){
            String[] split = IP.split("\\.");
            //根据范围即可
            if(Integer.parseInt(split[0])==10) return true;
            else if(Integer.parseInt(split[0])==172&&(Integer.parseInt(split[1])>15&&Integer.parseInt(split[1])<32)){
                return true;
            }else if(Integer.parseInt(split[0])==192&&Integer.parseInt(split[1])==168){
                return true;
            }else{
                return false;
            }
        }
        //各类ip计数
        public static int[] countIP(String IP,int[] count){
            String[] split = IP.split("\\.");
            int first=Integer.parseInt(split[0]);
            //如果是私有ip
            if(isPrivateIP(IP)) count[6]++;

            //判断其他地址范围
/*      A类地址1.0.0.0~126.255.255.255;
        B类地址128.0.0.0~191.255.255.255;
        C类地址192.0.0.0~223.255.255.255;
        D类地址224.0.0.0~239.255.255.255；
        E类地址240.0.0.0~255.255.255.255*/
            if (first >= 1 && first <= 126)
                count[0]++;
            else if (first >= 128 && first <= 191)
                count[1]++;
            else if (first >= 192 && first <= 223)
                count[2]++;
            else if (first >= 224 && first <= 239)
                count[3]++;
            else if (first >= 240 && first <= 255)
                count[4]++;
            return count;
        }


}
