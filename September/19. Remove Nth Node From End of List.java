class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode t = head.next;
        
        int totalNodes = getNodes(head);
        int reqd = totalNodes - n;
        
        while(reqd != 0 && t != null){
            prev = curr;
            curr = t;
            t = t.next;
            
            reqd--;
        }
        if(prev != null) prev.next = t;
        else if(curr != null){
            return curr.next;
        }
        return head;
    }
    
    int getNodes(ListNode head){
        int count = 0;
        
        while(head != null){
            count += 1;
            head = head.next;
        }
        
        return count;
    }
}
