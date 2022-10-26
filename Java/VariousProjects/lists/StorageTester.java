import java.util.Random;


public class StorageTester {



	public static void main(String [] args) {

		int size=5000;
		long start, stop;
		Random rdm = new Random();
		SLinkedList slist = new SLinkedList();
		DLinkedList dlist = new DLinkedList();
		String [] ary = new String[size];
		
		start = System.currentTimeMillis();
		for (int i=0;i<size;i++) {
			ary[i] = WordMaker.makeRandomWord();
		}
		stop = System.currentTimeMillis();
		System.out.println("Added " + size + " words to array in " + (stop-start) + " ms");


		start = System.currentTimeMillis();
		for (int i=0;i<size;i++) {
			slist.addLast(WordMaker.makeRandomWord());
		}
		stop = System.currentTimeMillis();
		System.out.println("Added " + size + " words to slist in " + (stop-start) + " ms");


		start = System.currentTimeMillis();
		for (int i=0;i<size;i++) {
			dlist.addLast(WordMaker.makeRandomWord());
		}
		stop = System.currentTimeMillis();
		System.out.println("Added " + size + " words to dlist in " + (stop-start) + " ms");


		String s;
		start = System.currentTimeMillis();
		for (int i=0;i<size;i++) {
			s=ary[rdm.nextInt(ary.length-1)];
		}
		stop = System.currentTimeMillis();
		System.out.println("Accessed " + size + " rdm words in array in " + (stop-start) + " ms");


		
		start = System.currentTimeMillis();
		for (int i=0;i<size;i++) {
			s=slist.elementAt(rdm.nextInt(slist.size()-1));
		}
		stop = System.currentTimeMillis();
		System.out.println("Accessed " + size + " rdm words in slist in " + (stop-start) + " ms");

		start = System.currentTimeMillis();
		for (int i=0;i<size;i++) {
			s=dlist.elementAt(rdm.nextInt(dlist.size()-1));
		}
		stop = System.currentTimeMillis();
		System.out.println("Accessed " + size + " rdm words in dlist in " + (stop-start) + " ms");




	}

}
