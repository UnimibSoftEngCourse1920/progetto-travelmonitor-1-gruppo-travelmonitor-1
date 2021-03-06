package com.sviluppotrilo.trilo.domain;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

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
                        Tratta tratta = new TrattaAdapter().read(reader);
                        soluzione.getTratte().add(tratta);
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
