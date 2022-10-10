class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1) return "";
        String s = "";
        int left = 0, right = palindrome.length() - 1;
        while(left < right){
            if(palindrome.charAt(left) != 'a'){
                String res = palindrome.substring(0, left) + "a" + palindrome.substring(left + 1);
                return res;
            }
            else{
                left++;
                right--;
            }
        }
        return palindrome.substring(0, palindrome.length() - 1) + "b";
    }
}
