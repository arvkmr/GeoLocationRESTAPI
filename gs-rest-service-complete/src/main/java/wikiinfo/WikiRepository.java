package wikiinfo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
 
interface WikiRepository extends MongoRepository<PointEntry, String> {
 
    List<PointEntry> findByLoc();
    
}

