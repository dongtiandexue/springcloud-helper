//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 41 👎 0


package com.gorun.leetcode.offer;

public class Offer_5 {
    public static void main(String[] args) {
        Solution solution = new Offer_5().new Solution();
        System.out.println(solution.replaceSpace("h e l l o"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpace(String s) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == ' '){
                    sb.append("%20");
                }else {
                    sb.append(c);
                }
            }
            return sb.toString();
//            return s.replace(" ","%20");
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}