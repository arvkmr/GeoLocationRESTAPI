package wikiinfo;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "points")
public class PointEntry {
 
	@Id
    private final String _id;
	
    @NotEmpty
    private final String title;
    private final String url;
    
    @NotEmpty
    private final String source;
    
    @NotEmpty
    @Indexed
    public String loc;

    public PointEntry(String _id, String title, String url, String source, String loc) {
    	this._id = _id;
        this.title = title;
        this.url = url;
        this.source = source;
        this.loc = loc;
    }
    
    
    public String getId() {
        return _id;
    }

    public String getTitle() {
        return title;
    }
    
    public String getUrl() {
        return url;
    }
    
    public String getSource() {
        return source;
    }
    
    public String getLoc() {
        return loc;
    }
    
    
}
