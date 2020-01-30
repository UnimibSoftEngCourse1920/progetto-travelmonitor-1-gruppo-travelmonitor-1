package com.sviluppotrilo.trilo.data;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlLoader {
    private String urlResponse;

    public UrlLoader(String url){
        urlResponse = readUrl(url);
    }

    private String readUrl(String urlString) {
        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader(new URL(urlString).openStream()));) {
            StringBuilder buffer = new StringBuilder();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);
            return buffer.toString();
        } catch (Exception e) {
            Log.e("Errore: ", e.toString());
            return null;
        }
    }

    public String getUrlResponse() {
        return urlResponse;
    }
}
