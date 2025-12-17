public class MergeNodesInBetweenZero {

    public static void main(String[] args) {

    }
    public ListNode mergeNodes(ListNode head) {
        if(head==null) return null;
        ListNode temp=head;

        ListNode head2=new ListNode();
        ListNode temp2=head2;
        int sum=0;
        boolean flag=true;

        while(temp!=null){
            if(temp.val>0){
                sum+=temp.val;
            }else if(!flag) {
                ListNode res=new ListNode(sum);
                temp2.next=res;
                temp2=temp2.next;
                sum=0;
            }else {
                sum=0;
                flag=false;
            }
            temp=temp.next;
        }

        return head2.next;

    }

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(){}
        public ListNode(int data){
            this.val=data;
        }
        public ListNode(int data,ListNode next){
            this.val=data;
            this.next=next;
        }
    }
}
