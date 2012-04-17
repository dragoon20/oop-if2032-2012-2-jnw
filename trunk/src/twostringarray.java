
package tubes2.oop;

public class twostringarray {

	private String [] arr ;
	
	public twostringarray () {
		arr = new String[2] ;
		arr[0] = null;
		arr[1] = null;
	}
	
	public twostringarray (String s1, String s2) {
		arr = new String[2] ;
		arr[0] = s1;
		arr[1] = s2;
	}
	
	public String getarti () {
		return arr[0];
	}
	
	public String gettype () {
		return arr[1];
	}
	
	public void setarti (String s) {
		arr[0] = s;
	}
	
	public void settype (String s) {
		arr[1] = s;
	}
}