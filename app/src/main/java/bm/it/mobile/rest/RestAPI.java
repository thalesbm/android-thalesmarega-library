package bm.it.mobile.rest;

import android.util.Log;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import bm.it.mobile.entity.RestAPIResponse;

public class RestAPI {
    private final String TAG = RestAPI.class.getSimpleName();

    public RestAPIResponse post(String sBody, String sUrl) throws IOException {
        HttpURLConnection connection = null;
        StringBuilder sb = null;
        try {
            URL url = new URL(sUrl);

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Basic cG1jY2FiZTpxd2VydDIz");
            connection.setConnectTimeout(10000);

            connection.setDoOutput(true);

            byte[] body = sBody.getBytes();

            connection.getOutputStream().write(body);
            connection.getOutputStream().flush();
            connection.getOutputStream().close();

            Log.d(TAG, "HTTP URL: " + sUrl);
            Log.d(TAG, "HTTP response code: " + connection.getResponseCode());
            Log.d(TAG, "HTTP response message: " + connection.getResponseMessage());

            String line;
            sb = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return createRestResponse(connection.getResponseCode(), connection.getResponseMessage(), sb.toString(), sUrl);
    }

    public RestAPIResponse get(String sUrl) throws IOException {
        HttpURLConnection connection = null;
        StringBuilder sb = null;
        try {
            URL url = new URL(sUrl);

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setConnectTimeout(10000);

            Log.d(TAG, "HTTP URL: " + sUrl);
            Log.d(TAG, "HTTP response code: " + connection.getResponseCode());
            Log.d(TAG, "HTTP response message: " + connection.getResponseMessage());

            String line;
            sb = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return createRestResponse(connection.getResponseCode(), connection.getResponseMessage(), sb.toString(), sUrl);
    }


    public RestAPIResponse postVideo(String videoPath, String urlPath) throws IOException {
        HttpURLConnection connection = null;
        StringBuilder sb = null;
        try {

            FileInputStream fileInputStream = new FileInputStream(new File(videoPath));
            URL url = new URL(urlPath);

            connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("Content-Type", "application/octet-stream");

            DataOutputStream dos = new DataOutputStream(connection.getOutputStream());

            int bytesAvailable = fileInputStream.available();
            int maxBufferSize = 1000;
            byte[] buffer = new byte[bytesAvailable];
            int bytesRead = fileInputStream.read(buffer, 0, bytesAvailable);

            while (bytesRead > 0) {
                dos.write(buffer, 0, bytesAvailable);
                bytesAvailable = fileInputStream.available();
                bytesAvailable = Math.min(bytesAvailable, maxBufferSize);
                bytesRead = fileInputStream.read(buffer, 0, bytesAvailable);
            }

            fileInputStream.close();
            dos.flush();
            dos.close();

            Log.d(TAG, "HTTP URL: " + urlPath);
            Log.d(TAG, "HTTP response code: " + connection.getResponseCode());
            Log.d(TAG, "HTTP response message: " + connection.getResponseMessage());

            String line;
            sb = new StringBuilder();
            DataInputStream inStream = new DataInputStream(connection.getInputStream());
            while ((line = inStream.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return createRestResponse(connection.getResponseCode(), connection.getResponseMessage(), sb.toString(), urlPath);
    }

    private RestAPIResponse createRestResponse(int responseCode, String responseMessage, String json, String url) {
        RestAPIResponse rest = new RestAPIResponse();
        rest.setCode(responseCode);
        rest.setMessage(responseMessage);
        rest.setJson(json);
        rest.setUrl(url);
        return rest;
    }
}