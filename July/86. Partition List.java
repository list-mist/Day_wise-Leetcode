class Solution {
    public ListNode partition(ListNode head, int x) {
        
        if(head == null || head.next == null) return head;
        ListNode a = new ListNode(head.val);
        ListNode p = head.next;
        ListNode b = a;
        while(p != null) {
            b.next = new ListNode(p.val);
            b = b.next;
            p = p.next;
        }
        
        ListNode greater = partGreater(head,x);
        ListNode small = partSmall(a,x);
        
        
        ListNode curr = small;
        if(curr == null) return greater;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = greater;
       
        return small;
    }
    
    ListNode partSmall(ListNode head, int x){
        if(head == null) return head;
        if(head.next == null) {
            if(head.val >= x) {

                return null;
            }
            return head;
        }
        
        ListNode greater = partSmall(head.next,x);
        if(head.val < x) {
            head.next = greater;
            return head;
        }
        
        return greater;
    }
    ListNode partGreater(ListNode head, int x){
        if(head == null) return head;
        if(head.next == null) {
         
            if(head.val < x) {
                //System.out.println(head.val);
                return null;
            }
            return head;
        }
        
        ListNode greater = partGreater(head.next,x);
        if(head.val >= x) {
            head.next = greater;
            return head;
        }
        
        return greater;
        
    }
}
