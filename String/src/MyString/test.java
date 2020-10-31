package MyString;


import java.util.Scanner;

public class test {
        //真实的账号密码
        private static String userName = "simon";
        private static String password = "1234";

        public static void main(String[] args) {
            System.out.println("请输入用户名和密码");
            Scanner sc = new Scanner(System.in);
            String name = sc.next();
            String word = sc.next();
        try {
            login(name, word);
        } catch (UserError userError) {
            userError.printStackTrace();
        } catch (PasswordError passwordError) {
            passwordError.printStackTrace();
        }
    }

    static class UserError extends Exception {
        public UserError(String message) {
            super(message);
        }
    }
    static class PasswordError extends Exception {
        public PasswordError(String message) {
            super(message);
        }
    }

    public static void login(String userName, String password) throws UserError,
            PasswordError {
        if (!test.userName.equals(userName)) {
            throw new UserError("用户名错误");
        }
        if (!test.password.equals(password)) {
            throw new PasswordError("密码错误");
        }
        System.out.println("登陆成功");
    }

}


//实现方法 compareTo, 能够实现按照字典序比较字符串大小
//    public static void main(String[] args) {
//        String str = "abcdef";
//        System.out.println(compareTo(str, "abcdefg"));
//    }
//    public static int compareTo(String s1,String s2) {
//        int l1 = s1.length(), l2 = s2.length();
//        int l = Math.min(l1,l2);
//        char[] a1 = s1.toCharArray();
//        char[] a2 = s1.toCharArray();
//        int k = 0;
//        //用二者间较小的一个作为循环次数
//        while (k < l) {
//            if (a1[k] != a2[k]){
//                //二者不相等，相减，正数前者大，负数后者大
//                return a1[k] - a2[k];
//            }
//            k++;
//        }
//        //循环结束，即为二者间小的一个是另一个子串。继续判断二者是否一样，如果返回0，则二者相等，
//        //如果为 正数前者大，负数后者大
//        return l1 - l2;
//    }

//
//    //实现方法 contains, 能够判定字符串中是否包含子串
//    public static void main(String[] args) {
//        String str = "abcdef";
//        System.out.println(contains(str, "bcd"));
//    }
//
//    public static boolean contains(String str, String find) {
//        if (str.length() == 0 && find.length() == 0) {
//            return true;
//        }
//        char[] old = str.toCharArray();
//        char[] tofind = find.toCharArray();
//        int index = 0;
//        //遍历原数组
//        for (int i = 0; i < old.length; i++) {
//            //如果找到了与 要找的字符串的第一个字符 相等的位置，开始判断
//            if (old[i] == tofind[index]) {
//                //如果匹配成功 find 字符串最后一位，则返回 true
//                if (index == tofind.length - 1) {
//                    return true;
//                }
//                // 继续向 find 后边遍历
//                index++;
//            } else {
//                //如果当前位置与 要找的字符串的第一个字符不相等，且剩余元素不够要找的字符串长度，直接终止循环
//                if (old.length - i < tofind.length) {
//                    break;
//                }
//                //从头开始重新匹配
//                index = 0;
//            }
//        }
//        return false;
//    }

//    // 实现方法 indexOf, 能够找出字符串子串存在的位置
//    public static void main(String[] args) {
//        String str = "abcdef";
//        System.out.println(str);
//        System.out.println(indexof(str,"def"));
//    }
//    public static int indexof(String str, String s) {
//        if(!str.contains(s))return -1;
//        int i = 0;
//        while (i < str.length()){
//            if(str.charAt(i) == s.charAt(0)){
//                return i;
//            }else i++;
//        }
//        return i;
//    }

//    //实现方法 replace, 能够替换字符串中的某个部分
//    public static void main(String[] args) {
//        String str = "abc def";
//        System.out.println(str);
//        String s1 = replace(str," ","xx");
//        System.out.println(s1);
//    }
//    public static String replace(String str, String old, String result) {
//        if (!str.contains(old)) return null;
//        int index = str.indexOf(old);
//        String s1 = str.substring(0,index);
//        String s2 = str.substring(index + old.length() ,str.length());
//        return s1 + result + s2;
//    }

//
//    //实现方法 split, 能够指定分割符将字符串拆分成字符串数组
//    public static void main(String[] args) {
//        String str = "abc def";
//        System.out.println(str);
//        String[] s = split(str, " ");
//        for (String s1 : s) {
//            System.out.println(s1);
//        }
//    }
//    public static String[] split(String str,String flg){
//        ArrayList<String> list = new ArrayList<>();
//        while(str.contains(flg)){
//            int index = str.indexOf(flg);
//            String tmp = str.substring(0,index);
//            list.add(tmp);
//            str = str.substring(index+flg.length());
//        }
//        list.add(str);
//        String[] arr = new String[list.size()];
//        for(int i = 0;i < list.size();i++){
//            arr[i] = list.get(i);
//        }
//        return arr;
//    }