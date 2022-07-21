import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClientHttp {
    
    public String getData(String url){
        try{
            URI adress = URI.create(url);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(adress).GET().build();
            HttpResponse<String> response = client.send(request,BodyHandlers.ofString()); 
            return response.body();
        }catch(IOException | InterruptedException error){
            throw new RuntimeException(error);
        }
    }

}
