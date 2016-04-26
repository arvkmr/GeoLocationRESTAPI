package wikiinfo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/api/wiki")
final class PointController {
 
 
	public PointController() {

    }
 
 
    @RequestMapping(value = "add", method = RequestMethod.GET)
    String create(@RequestParam(value = "Title", required = true) String title, @RequestParam(value = "url", required = false) String URL, @RequestParam(value = "lat", required = true) String lat , @RequestParam(value = "log", required = true) String log){
    
    //	 "loc" : { "type" : "Point", "coordinates" : [ -80.845771, 35.225674 ] } }

    	String loc1= "{ \"title\" : \""+title+"\""+ ", "
    			+ "\"url\" : \""+URL+"\", \"loc\" : { \"type\": "
    			+ "\"Point\", \"coordinates\" : ["+log+", " +lat+"]}}";
    	
    	System.out.println(loc1);
    	Application.mongoOperation.insert(loc1, "points");
    	
    	return "[\"success\"]";
     }
 
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    PointEntry delete(@RequestParam(value = "id", required = true) String id) {
    	Application.mongoOperation.remove(id);
        return null;
    }
 
    @RequestMapping(value = {"loc"}, method = RequestMethod.GET)
    List<PointEntry> findAll( @RequestParam(value = "lat", required = true) String lat , 
    		@RequestParam(value = "log", required = true) String log, 
    		@RequestParam(value = "max", required = true) String max) {
    	BasicQuery query1 = new BasicQuery("{ \"loc\" "
    			+ ": { $near : { $geometry : { type : \"point\" ,"
    			+ " coordinates : [ "+log+", "+lat+" ] } "
    					+ ",$maxDistance : " + max + " } } }");
    	//NearQuery qu = new;
    	List<PointEntry> list = Application.mongoOperation.find(query1, PointEntry.class);

    	System.out.println("YEEEY");
        return list;
    }
 
    @RequestMapping(value = "id", method = RequestMethod.GET)
    PointEntry findById(@RequestParam(value = "id", required = true) String id) {
    	PointEntry entry = Application.mongoOperation.findById(id, PointEntry.class);
        return entry;
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    PointEntry update(@RequestBody @Valid PointEntry todoEntry) {
        return null;
    }
 
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(NotFoundException ex) {
    }
}