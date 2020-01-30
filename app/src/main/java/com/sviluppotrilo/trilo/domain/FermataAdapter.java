package com.sviluppotrilo.trilo.domain;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class FermataAdapter extends TypeAdapter<Fermata> {

    @Override
    public void write(JsonWriter out, Fermata value) throws IOException {
        // Questo metodo non esegue nessuna operazione perchè l'obiettivo del
        // progetto non include la serializzazione degli oggetti
    }

    @Override
    public Fermata read(JsonReader reader) throws IOException {
        Fermata fermata = new Fermata();
        reader.beginObject();
        String fieldname = null;
        JsonToken token = null;
        Stazione stazione = new Stazione();
        while (reader.hasNext()) {
            token = reader.peek();
            if(token.equals(JsonToken.NULL))
                reader.skipValue();
            else if (token.equals(JsonToken.NAME)) {
                fieldname = reader.nextName();
                if(reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                }else{
                    switch(fieldname){
                    case "stazione": String nomeStazione = reader.nextString();
                        stazione.setNome(nomeStazione); break;
                    case "id": String idStazione = reader.nextString();
                        stazione.setId(idStazione); break;
                        //Qui andrebbe cercato l'id della stazione nel db
                        //Per mantenere la coerenza
                    case "programmata":String programmata = reader.nextString();
                        fermata.setProgrammata(programmata); break;
                    case "tipoFermata": String tipoFermata = reader.nextString();
                        fermata.setTipoFermata(tipoFermata); break;
                    case "ritardo": int ritardo = reader.nextInt();
                        fermata.setRitardo(ritardo); break;
                    case "ritardoArrivo":int ritardoArrivo = reader.nextInt();
                        fermata.setRitardoArrivo(ritardoArrivo); break;
                    case "ritardoPartenza":int ritardoPartenza = reader.nextInt();
                        fermata.setRitardoPartenza(ritardoPartenza); break;
                    case "arrivoReale": String arrivoReale = reader.nextString();
                        fermata.setArrivoReale(arrivoReale); break;
                    case "partenzaReale": String partenzaReale = reader.nextString();
                        fermata.setPartenzaReale(partenzaReale); break;
                    case "arrivo_teorico": String arrivoTeorico = reader.nextString();
                        fermata.setArrivoTeorico(arrivoTeorico); break;
                    case "partenza_teorica": String partenzaTeorica = reader.nextString();
                        fermata.setPartenzaTeorica(partenzaTeorica); break;
                    case "actualFermataType": int tipoFermataAttuale = reader.nextInt();
                        fermata.setTipoFermataAttuale(tipoFermataAttuale); break;
                    default:  reader.skipValue();
                    }
                }
            }
        }
        reader.endObject();
        fermata.setStazione(stazione);
        return fermata;
    }
}