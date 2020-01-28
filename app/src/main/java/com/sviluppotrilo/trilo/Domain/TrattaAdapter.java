package com.sviluppotrilo.trilo.Domain;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class TrattaAdapter extends TypeAdapter<Tratta> {

    @Override
    public void write(JsonWriter out, Tratta value) throws IOException {
        // Questo metodo non esegue nessuna operazione perchè l'obiettivo del
        // progetto non include la serializzazione degli oggetti
    }

    @Override
    public Tratta read(JsonReader reader) throws IOException {
        Tratta tratta = new Tratta();
        reader.beginObject();
        String fieldname = null;
        JsonToken token = null;
        while (reader.hasNext()) {
            token = reader.peek();
            if(token.equals(JsonToken.NULL))
                reader.skipValue();
            if (token.equals(JsonToken.NAME)) {
                fieldname = reader.nextName();
                if ("origine".equals(fieldname)) {
                    Stazione origine = new Stazione();
                    String nomeStazioneOrigine = reader.nextString();
                    origine.setNome(nomeStazioneOrigine);
                    //Qui andrebbe cercato il nome della stazione nel db,
                    //Perchè a questa stazione manca l'id
                    tratta.setOrigine(origine);
                }else if("destinazione".equals(fieldname)){
                    Stazione destinazione = new Stazione();
                    String nomeStazioneDestinazione = reader.nextString();
                    destinazione.setNome(nomeStazioneDestinazione);
                    //Qui andrebbe cercato il nome della stazione nel db,
                    //Perchè a questa stazione manca l'id
                    tratta.setDestinazione(destinazione);
                }else if("orarioPartenza".equals(fieldname)){
                    String orarioPartenza = reader.nextString();
                    tratta.setOrarioPartenza(orarioPartenza);
                }else if("orarioArrivo".equals(fieldname)){
                    String orarioArrivo = reader.nextString();
                    tratta.setOrarioArrivo(orarioArrivo);
                }else if("categoria".equals(fieldname)){
                    int categoria = reader.nextInt();
                    tratta.setCategoria(categoria);
                }else if("categoriaDescrizione".equals(fieldname)){
                    String categoriaDescrizione = reader.nextString();
                    tratta.setCategoriaDescrizione(categoriaDescrizione);
                }else if("numeroTreno".equals(fieldname)){
                    String numeroTreno = reader.nextString();
                    tratta.setNumeroTreno(numeroTreno);
                }else{
                    reader.skipValue();
                }
            }
        }
        reader.endObject();
        return tratta;
    }

}
