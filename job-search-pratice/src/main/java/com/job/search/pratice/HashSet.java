package com.job.search.pratice;

import java.util.Random;

class ListNodeForSet {
	Integer data;
	ListNodeForSet next;
	
	ListNodeForSet() {
		
	}
	ListNodeForSet(Integer data)  {
		this.data = data;
	}	
}
public class HashSet {
	
	private ListNodeForSet[] buckets;
	private int size;
	private static final int THRESHOLD = 10;
	
	public HashSet() {
		buckets = new ListNodeForSet[11];
		System.out.print("constructor "   + buckets.length);
		for(int i = 0; i < buckets.length; ++i)
			buckets[i] = new ListNodeForSet();
		size = 0;
	}
	private void rehash() {
		ListNodeForSet[] buckets_new = new ListNodeForSet[2*buckets.length];
		for(int i = 0; i < buckets_new.length; ++i)
			buckets_new[i] = new ListNodeForSet();

		ListNodeForSet tmp;
 		for(int i = 0; i < buckets.length; ++i) {
			for(ListNodeForSet current = buckets[i].next; current != null; current = tmp) {
				int bind = current.data.hashCode() % buckets_new.length;
				tmp = current.next;
				current.next = buckets_new[bind].next;
				buckets_new[bind].next = current;
			}
		}		
		buckets = buckets_new;
	}
	//O(1) am
	public boolean add(Integer e) {
		//check if element e already exist in set
		if(contains(e)) return false;
		//verify whether rehash required or not
		float avgsize = size / buckets.length;
		System.out.println(" bucket len"   + buckets.length);
		if(avgsize > THRESHOLD) {
			rehash();
		}	
		//add the element at start of bucket
		int bind = e.hashCode() % buckets.length;
		ListNodeForSet tmp = new ListNodeForSet(e);
		tmp.next = buckets[bind].next;
		buckets[bind].next = tmp;
		++size;
		return true;
	}

	//O(1)
	public boolean contains(Integer e) {
		int bind = e.hashCode() % buckets.length;
		for(ListNodeForSet current = buckets[bind].next; current != null; current = current.next) {
			if(current.data.equals(e))
				return true;
		}
		return false;
	}

	//O(1)
	public boolean remove(Integer e) {
		int bind = e.hashCode() % buckets.length;
		for(ListNodeForSet current = buckets[bind]; current.next != null; current = current.next) {
			if(current.next.data.equals(e)) {
				current.next = current.next.next;
				--size;
				return true;
			}
		}
		return false;
	}

	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	//O(n)
	public void display() {
		for(int i = 0; i < buckets.length; ++i) {
			System.out.print("Bucket-" +i+":" );
			for(ListNodeForSet current = buckets[i].next; current != null; current = current.next) {
				System.out.print(current.data+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Random r = new Random();
		HashSet set = new HashSet(); 
		for(int i = 0; i < n; ++i) {
			int tmp = r.nextInt(n)+1;
			set.add(tmp);
		}
		System.out.println("\n size of set " + set.size());
		set.display();
	}

}
