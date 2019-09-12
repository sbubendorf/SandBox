package ch.rusi.sandbox.lombok;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter @Setter
@ToString(callSuper=false,exclude= {"id","yearBirth","zip","employed"})
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {

	private static final long serialVersionUID = 5748380933216653194L;

	private Long id; // will be set when persisting
    
    private String firstName;
    private String lastName;
    private int yearBirth;
    private String street;
    private String city;
    private String zip;
    private boolean employed;
    
}
