package ch.rusi.sandbox.lombok;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Family {
	@NonNull
	private List<Person> members;
	
	

}
