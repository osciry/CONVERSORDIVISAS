package ConexionApi;
import DivisasDisponibles.Monedas;
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class conexionApi {
    private static final String ApiKey = "bd7e00b023eeb50e18fe2caa";
    private static final String DireccionApi = "https://v6.exchangerate-api.com/v6/" + ApiKey + "/pair/";

    public static Monedas getCambioDivisas(String monedaBase, String monedaDeCambio) {
        URI direccion = URI.create(DireccionApi + monedaBase + "/" + monedaDeCambio);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Monedas.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré la Moneda", e);
        }
    }
}

