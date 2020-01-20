package com.sviluppotrilo.trilo;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class SoluzioneAdapter extends TypeAdapter<Soluzione> {

    @Override
    public void write(JsonWriter out, Soluzione value) throws IOException {
        // Non è necessaria la serializzazione
    }

    @Override
    public Soluzione read(JsonReader reader) throws IOException {
        Soluzione soluzione = new Soluzione();
        reader.beginObject();
        String fieldname = null;
        JsonToken token = null;
        while (reader.hasNext()) {
            token = reader.peek();
            if(token.equals(JsonToken.NULL))
                reader.skipValue();
            if (token.equals(JsonToken.NAME)) {
                fieldname = reader.nextName();
                if(reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                }else if ("durata".equals(fieldname)) {
                    String durata = reader.nextString();
                    soluzione.setDurata(durata);
                }else if("vehicles".equals(fieldname)) {
                    reader.beginArray();
                    while (reader.hasNext()){
                        TypeAdapter<Tratta> trattaAdapter = new Gson().getAdapter(Tratta.class);
                        Tratta tratta = trattaAdapter.read(reader);
                        soluzione.tratte.add(tratta);
                    }
                    reader.endArray();
                }else {
                    reader.skipValue();
                }
            }
        }
        reader.endObject();
        return soluzione;
    }
}
