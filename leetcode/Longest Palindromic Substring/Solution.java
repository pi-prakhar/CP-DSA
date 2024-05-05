class Solution {
    public static String longestPalindrome(String s) {
        int totalLen = s.length();
        if (isPalindrome(s)) {
            return s;
        } 
        else 
        {
            for (int len = totalLen; len >= 2; len--) {
                int start = 0;
                int end = start + len;
        
                while (end <= totalLen) {
                    String subString = s.substring(start, end);
                    if (isPalindrome(subString)) {
                        return subString;
                    }
                    start++;
                    end++;
                }
            }
        }
        return ""+s.charAt(0);

    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) 
    {
        String test = "abbddbbad";
        System.out.println(longestPalindrome(test));
    }
}