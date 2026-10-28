import java.util.Comparator;

public class PriorityQueue<T> extends Queue<T>
{

   Comparator<T> compare;

   public PriorityQueue(Comparator<T> comp)
   {
      compare = comp;
   }


    //@Override
   public void push(T val)
   {
	   Node newNode = new Node(val, null);
	   
	   if (head == null) {
		   head = newNode;
		   tail = head;
	   }
	   else if(compare.compare(newNode.val, head.val) > 0) {
		   newNode.next = head;
		   head = newNode;
		   
	   }
	   else if(compare.compare(newNode.val, tail.val) <= 0) {
		   tail.next = newNode;
		   tail = newNode;
	   }
	   else {
		   Node curr = head;
		   while (curr.next != null && compare.compare(curr.next.val, newNode.val) >= 0) {
			   curr = curr.next;
			   
		   }
		   newNode.next = curr.next;
		   curr.next = newNode;
	   }
		   
	   
	   
   
   }

   
   


}
