import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class imdbContentExtractor implements ContentExtractor {
    
    public List<Content> contentsExtractor(String json){
        JsonParser parser = new JsonParser();
        List<Map<String,String>> objectList = parser.parse(json);
        List<Content> contents = new ArrayList<>();
        
        for (Map<String,String> object : objectList) {
            String title = object.get("title").substring(0,1).toUpperCase().concat(object.get("title").substring(1));
            String urlImage = object.get("image");
            var content = new Content(title,urlImage);
            contents.add(content);
        }
        return contents;
    }
    
}
