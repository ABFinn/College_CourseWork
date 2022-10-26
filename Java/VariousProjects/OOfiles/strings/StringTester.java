

public class StringTester {

	public static void main(String [] args) {

		char [] w = {'a','p','p','l','e'};

		char [] p = new char[5];
		p[0]='a';
		p[1]='p';
		p[2]='p';
		p[3]='l';
		p[4]='e';

		MyString wString = new MyString(w);
		MyString pString = new MyString(p);
		System.out.println(wString.charAt(0));
		w[0]='q';
		System.out.println(wString.charAt(0));		
		System.out.println(wString.equals(pString));

	}

}
