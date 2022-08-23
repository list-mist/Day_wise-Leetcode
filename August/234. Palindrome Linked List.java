class Solution {
    public boolean isPalindrome(ListNode head) { 

        List<Integer> arr = new ArrayList<>();
        
        while(head != null) {
            arr.add(head.val);
            head = head.next;
        }

        int i = 0, j = arr.size() - 1;
   
        while(i < j){
            if(arr.get(i) != arr.get(j)) return false;
            else{
                i++;
                j--;
            }
        }
    
        return true;            
    }
    
  
}
