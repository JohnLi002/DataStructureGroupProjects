package lab8Dictionary;

public class Name implements Comparable <Name>{
	private String firstName;
	private String lastName;
	
	public Name (String first, String last) {
	  firstName = first; 
             	   lastName = last;
	}

	public Name (String fullName) {
              // to implement
        }
	
	
	public String getFirst() {
		return firstName;
	}
	
	public String getLast() {
		return lastName;
	}
	
	public String toString () {
		return (firstName + " " + lastName);
	}
	public boolean equals (Object o) {
		return o.toString().equals(toString());
	}
	
	public int compareTo (Name other) {
		if( firstName.compareTo(other.firstName) != 0) {
			return (firstName.compareTo(other.firstName));
		}
		else {
			return (lastName.compareTo(other.lastName));
		}
	}
}
