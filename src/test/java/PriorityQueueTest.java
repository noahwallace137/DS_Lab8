import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PriorityQueueTest
{		
		Customer cus10 = new Customer (10, 10, 9);
		Customer cus5 = new Customer (5, 5, 4);
		Customer cus20 = new Customer (20, 20, 19);
		Customer cus15 = new Customer (15, 15, 14);
		Customer twin15 = new Customer (15, 15, 12);
        Customer twin5 = new Customer (5, 5, 4);
        Customer twin20 = new Customer (20, 20, 30);


	@Test
	public void priorityQueueTest()
	{
        Customer.WorthComparator w = new Customer.WorthComparator();
		PriorityQueue<Customer> pq = new PriorityQueue<Customer>(w);

		assertThrows(QueueUnderFlowException.class, () -> pq.pop());
		pq.push(cus10);     //cus10, null
		assertEquals(false, pq.isEmpty());
		pq.push(cus5);      //cus10, cus5, null
		pq.push(cus20);     //cus20, cus10, cus5, null
		pq.push(cus15);     //cus20, cus15, cus10, cus5, null
		assertEquals(cus20, pq.pop());
		assertEquals(cus15, pq.pop());
		assertEquals(cus10, pq.pop());
		assertEquals(cus5, pq.pop());
		assertThrows(QueueUnderFlowException.class, () -> pq.pop());

		
		

	}
	@Test
		 void comparator()
	    {
	        Customer.WorthComparator w = new Customer.WorthComparator();
	        assertTrue(w.compare(cus20, cus15) > 0);
	        assertTrue(w.compare(cus5, cus15) < 0);
	        assertTrue(w.compare(cus15, twin15) == 0);
	        
	        
	        Customer.LoyaltyComparator l = new Customer.LoyaltyComparator();
	        assertTrue(l.compare(cus20, cus15) > 0);
	        assertTrue(l.compare(cus5, cus15) < 0);	    
	        assertTrue(l.compare(cus15, twin15) == 0);
	        
	        
	        Customer.WorthPoliteComparator wp = new Customer.WorthPoliteComparator();
	        assertTrue(wp.compare(cus15,twin15) > 0);
	        assertTrue(wp.compare(cus20, twin20) < 0);
	        assertTrue(wp.compare(cus5, twin5) == 0);
	        

	        
	    }
	}
	

