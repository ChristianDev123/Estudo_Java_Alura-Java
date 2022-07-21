import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // Conexão http:
        
        // String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
        // ContentExtractor extractor = new imdbContentExtractor();
        
        // String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-07-18";
        // ContentExtractor extractor = new nasaContentExtractor();
        
        String url = "http://localhost:8080/get-languages";
        ContentExtractor extractor =  new imdbContentExtractor();

        ClientHttp http = new ClientHttp();
        String json = http.getData(url);
        // Exibir e manipular dados:
        List<Content> contents = extractor.contentsExtractor(json);
        // Apresentação dos dados do json:
        for (Content content : contents) {
            var generator = new StickerMaker();
            String nameArchive = "sticker" + content.getTitle();
            InputStream image = new URL(content.getUrlImage()).openStream();
            generator.create(image, nameArchive);
            System.out.println(content.getTitle());
            System.out.println();
        }
    }
}
