

public class MyString {

	//attributes
	private char [] str;

	//behaviors

	//constructor
	public MyString(char [] s) {
		str = new char[s.length];
		for(int i=0;i<s.length;i++) {
			str[i] = s[i];
		}

	}


	public int length() {
		return str.length;
	}


	public char charAt(int i) {
		return str[i];
	}


	public boolean equals(MyString s) {
		if(str.length != s.length()) {
			return false;
		}
		for(int i=0;i<str.length;i++) {
			if(str[i] != s.charAt(i)) {
				return false;
			}	
		}
		return true;
	}

	

} //class MyString
