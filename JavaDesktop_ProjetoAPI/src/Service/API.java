package Service;

import Model.Aluno;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class API {

    private static final String BASE_URL = "http://127.0.0.1:8000/api/alunos";
    private static final Gson gson = new Gson();

    public ArrayList<Aluno> index() throws Exception {
        URL url = new URL(BASE_URL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader sc = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder resposta = new StringBuilder();
        String entrada;

        while ((entrada = sc.readLine()) != null) {
            resposta.append(entrada);
        }

        sc.close();
        con.disconnect();

        JsonObject json = gson.fromJson(resposta.toString(), JsonObject.class);
        JsonArray jsonArray = json.getAsJsonArray("data");

        return gson.fromJson(jsonArray, new TypeToken<ArrayList<Aluno>>(){}.getType());
    }

    public Aluno store(Aluno aluno) throws Exception {
        URL url = new URL(BASE_URL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);

        con.setRequestMethod("POST");

        String al = gson.toJson(aluno);

        try (OutputStream os = con.getOutputStream()) {
            byte[] input = al.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }
        if (con.getResponseCode() != HttpURLConnection.HTTP_CREATED)
            throw new IOException("Erro ao criar aluno. Código de resposta: " + con.getResponseCode());

        BufferedReader sc = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder resposta = new StringBuilder();

        String entrada;
        while ((entrada = sc.readLine()) != null) {
            resposta.append(entrada);
        }
        sc.close();
        con.disconnect();

        return gson.fromJson(resposta.toString(), Aluno.class);
    }

    public Aluno update(Aluno aluno) throws Exception {
        URL url = new URL(BASE_URL + "/" + aluno.getId());
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);


        con.setRequestMethod("PUT");

        try (OutputStream os = con.getOutputStream()) {
            byte[] input = gson.toJson(aluno).getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        if (con.getResponseCode() != HttpURLConnection.HTTP_OK)
            throw new IOException("Erro ao editar aluno");

        BufferedReader sc = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder resposta = new StringBuilder();
        String entrada;
        while ((entrada = sc.readLine()) != null) {
            resposta.append(entrada);
        }
        sc.close();
        con.disconnect();
        return gson.fromJson(resposta.toString(), Aluno.class);
    }

    public boolean destroy(int id) throws Exception {
        URL url = new URL(BASE_URL + "/" + id);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");
        con.setRequestProperty("Accept", "application/json");
        if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
            con.disconnect();
            return true;
        } else {
            throw new IOException("Erro ao deletar aluno");
        }
    }
}