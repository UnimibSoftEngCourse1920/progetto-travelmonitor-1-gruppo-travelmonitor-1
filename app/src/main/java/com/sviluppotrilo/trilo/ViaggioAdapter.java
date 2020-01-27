package com.sviluppotrilo.trilo;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.sviluppotrilo.trilo.Domain.Soluzione;
import com.sviluppotrilo.trilo.Domain.SoluzioneAdapter;
import com.sviluppotrilo.trilo.Domain.Stazione;
import com.sviluppotrilo.trilo.Domain.Viaggio;

public class ViaggioAdapter extends TypeAdapter<Viaggio> {

    @Override
    public void write(JsonWriter out, Viaggio value) throws IOException {
        // Questo metodo non esegue nessuna operazione perchè l'obiettivo del
        // progetto non include la serializzazione degli oggetti
    }

    @Override
    public Viaggio read(JsonReader reader) throws IOException {
        Viaggio viaggio = new Viaggio();
        reader.beginObject();
        String fieldname = null;
        JsonToken token = null;
        while (reader.hasNext()) {
            token = reader.peek();
            if (token.equals(JsonToken.NAME)) {
                fieldname = reader.nextName();
                if(reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                }else if ("origine".equals(fieldname)) {
                    String nomeStazioneOrigine = reader.nextString();
                    //Qui andrebbe cercato il nome della stazione nel db,
                    //Perchè a questa stazione manca l'id
                    Stazione origine = new Stazione();
                    origine.setNome(nomeStazioneOrigine);
                    viaggio.setOrigine(origine);
                }else if("destinazione".equals(fieldname)) {
                    //move to next token
                    Stazione destinazione = new Stazione();
                    String nomeStazioneDestinazione = reader.nextString();
                    destinazione.setNome(nomeStazioneDestinazione);
                    //Qui andrebbe cercato il nome della stazione nel db,
                    //Perchè a questa stazione manca l'id
                    viaggio.setDestinazione(destinazione);
                }else if("soluzioni".equals(fieldname)) {
                    reader.beginArray();
                    while (reader.hasNext()){
                        Soluzione soluzione = new SoluzioneAdapter().read(reader);
                        viaggio.soluzioni.add(soluzione);
                    }
                    reader.endArray();
                }else {
                    reader.skipValue();
                }
            }
        }
        reader.endObject();
        return viaggio;
    }
}