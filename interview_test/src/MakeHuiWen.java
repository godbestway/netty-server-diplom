import java.util.Scanner;

/**
 * @Author: Chenglin Ding
 * @Date: 01.03.2021 15:03
 * @Description:
 */
public class MakeHuiWen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        String ss = sc.nextLine();
        if(ss.length() == 1){
            System.out.println("true");
            System.exit(0);
        }
        boolean isSymmtric = true;
        char first;
        char last;
        for(int m = 0; m < ss.length()/2; m++){
            first = ss.charAt(m);
            last = ss.charAt(ss.length()-m-1);
            if(first != last){
                isSymmtric = false;
            }
        }
        if(isSymmtric){
            System.out.println("true");
            System.exit(0);
        }else{
            //System.out.println("false");
            isSymmtric = true;
            StringBuilder ss_build = new StringBuilder(ss);
            char tmp;
            for(int n = 0; n< ss.length();n++){
                tmp = ss_build.charAt(n);
                ss_build.deleteCharAt(n);
                System.out.println(ss_build);
                for(int k = 0; k < ss_build.length()/2; k++){
                    first = ss_build.charAt(k);
                    last = ss_build.charAt(ss_build.length()-k-1);
                    if(first != last){
                        System.out.println(first);
                        System.out.println(last);
                        isSymmtric = false;
                        break;
                    }
                    isSymmtric = true;
                }
                if(isSymmtric){
                    System.out.println("true");
                    System.exit(0);
                }
                ss_build.insert(n, tmp);
            }
            System.out.println("false");
        }
    }
}
