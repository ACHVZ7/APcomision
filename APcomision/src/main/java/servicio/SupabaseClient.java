package servicio;

import com.google.gson.Gson;
import modelos.Casa;
import okhttp3.*;

import java.io.IOException;

public class SupabaseClient {
    private static final String SUPABASE_URL = "https://hzzzeeewqukmgsqvzzyr.supabase.co";
    private static final String SUPABASE_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Imh6enplZWV3cXVrbWdzcXZ6enlyIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NTQyNDc4NTgsImV4cCI6MjA2OTgyMzg1OH0.3ufljRI0M8DcVeMOP9_sReCfVSoloKdJE9LgmZkfETM";
    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();

    public void insertarCasa(Casa casa) throws IOException {
        String json = gson.toJson(casa);
        RequestBody body = RequestBody.create(json, MediaType.get("application/json"));

        Request request = new Request.Builder()
                .url(SUPABASE_URL + "/rest/v1/casas")
                .post(body)
                .addHeader("apikey", SUPABASE_KEY)
                .addHeader("Content-Type", "application/json")
                .addHeader("Prefer", "return=minimal")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Error: " + response);
            System.out.println("✅ Casa insertada: " + casa.getNombre());
        }
    }
}