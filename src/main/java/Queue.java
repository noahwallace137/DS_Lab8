public class Queue<T>
{
    //be sure that your attributes are protected, so subclasses can use them

	public int size;
	public Node head;
	public Node tail;
	
   public class Node
   {
	   T val = null;
	   Node next = null;
	   public Node(T val, T next) {
		   this.val = val;
		   next = null;
		   
	   }
	   
	   
   
   }
   public Queue()
   {
	   head = null;
	   tail = null;
	   size = 0;
   }

    /**Adds val to the end of the queue
     */
   public void push(T val)
   {
	   if (head == null) {
		   head = new Node(val, null);
		   tail = head;
		   
	   }
	   else {
		   tail.next = new Node(val, null);
		   tail = tail.next;
		   
	   }
		   
	   
   
   }


    /**
       removes and returns the oldest value in the queue
       throws QueueUnderFlowException if the queue is empty
     */
   public T pop()
   {
	   if(head == null) {
		   throw new QueueUnderFlowException();
		   
	   }
	   if (head == tail) {
		   T temp = head.val;
		   head = null;
		   tail = null;
		   return temp;
	   }
	   else {
		   T temp = head.val;
		   head = head.next;
		   return temp;
		   
	   }
   }    


    /**
      returns true if the queue is empty
     */

   public boolean isEmpty()
   {
       return (head == null);
   }




}
