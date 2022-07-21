class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
       
        if(left == right) return head;
        ListNode curr = head;
        
        int i = 0;
        ListNode prev = null;
        ListNode l = null;
        ListNode r = null;
        
        
        while(curr != null){
            i++;
            
            if(i == left) break;
            l = curr;
            curr = curr.next;
        }
        ListNode node = curr;
        while(curr != null){
           
            
            if(i == right) break;
            i++;
            curr = curr.next;
        }
        r = curr.next;
        curr.next = null;
        node = reverse(node);
        
        if(l == null) {
            head = node;
        }
        else{
            l.next = node;
        }
        while(node.next != null) node = node.next;
        node.next = r;
    
        return head;
        
    }
    ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        
        ListNode p = reverse(head.next);
        
        head.next.next = head;
        head.next = null;
        return p;
    }
    
}
