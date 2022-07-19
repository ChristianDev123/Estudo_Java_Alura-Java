import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // Conexão http:
        String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
        URI adress = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(adress).GET().build();
        HttpResponse<String> response = client.send(request,BodyHandlers.ofString()); 
        String body = response.body();

        // Extração de dados do json:
        JsonParser parser = new JsonParser();
        List<Map<String,String>> listFilms = parser.parse(body);
        
        // Apresentação dos dados do json:
        for (Map<String,String> film : listFilms) {
            InputStream image = new URL(film.get("image")).openStream();
            String nameSticker = "sticker" + film.get("title").substring(0,1).toUpperCase().concat(film.get("title").substring(1));
            var generator = new StickerMaker();
            generator.create(image, nameSticker);
            System.out.println(film.get("title"));
            System.out.println();
        }
    }
}
