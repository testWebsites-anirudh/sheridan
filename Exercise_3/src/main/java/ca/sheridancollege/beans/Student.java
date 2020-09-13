package ca.sheridancollege.beans;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student implements java.io.Serializable {

	private static final long serialVersionUID = -1151601425008580749L;
	
	private String name;
	private int ID;
	private String c1,c2,c3,c4,c5,c6;

}
