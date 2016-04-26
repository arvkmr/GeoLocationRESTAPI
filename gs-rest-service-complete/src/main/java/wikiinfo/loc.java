package wikiinfo;

import java.util.Map;

import org.hibernate.validator.constraints.NotEmpty;

public class loc {
	 	@NotEmpty
	    private final String type;
	 	
	    @NotEmpty
	    private final Map<String,String> coordinates;;
	    
	    
	    public loc(String type, Map<String,String> Coordinates)
	    {
	    	this.type = type; 
	    	this.coordinates = Coordinates;
	    }
	    
	    public String getType() {
	        return type;
	    }
	    
	    public Map<String,String> getCoor() {
	        return coordinates;
	    }

}
