package com.sviluppotrilo.trilo.Domain;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

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
            if (token.equals(JsonToken.NAME)) {
                fieldname = reader.nextName();
                if(reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                }else if ("stazione".equals(fieldname)) {
                    String nomeStazione = reader.nextString();
                    stazione.setNome(nomeStazione);
                }else if("id".equals(fieldname)){
                    String idStazione = reader.nextString();
                    stazione.setId(idStazione);
                    //Qui andrebbe cercato l'id della stazione nel db
                    //Per mantenere la coerenza ??
                }else if("programmata".equals(fieldname)){
                    String programmata = reader.nextString();
                    fermata.setProgrammata(programmata);
                }else if("tipoFermata".equals(fieldname)){
                    String tipoFermata = reader.nextString();
                    fermata.setTipoFermata(tipoFermata);
                }else if("ritardo".equals(fieldname)){
                    int ritardo = reader.nextInt();
                    fermata.setRitardo(ritardo);
                }else if("ritardoArrivo".equals(fieldname)){
                    int ritardoArrivo = reader.nextInt();
                    fermata.setRitardoArrivo(ritardoArrivo);
                }else if("ritardoPartenza".equals(fieldname)){
                    int ritardoPartenza = reader.nextInt();
                    fermata.setRitardoPartenza(ritardoPartenza);
                }else if("arrivoReale".equals(fieldname)){
                    String arrivoReale = reader.nextString();
                    fermata.setArrivoReale(arrivoReale);
                }else if("partenzaReale".equals(fieldname)){
                    String partenzaReale = reader.nextString();
                    fermata.setPartenzaReale(partenzaReale);
                }else if("arrivo_teorico".equals(fieldname)){
                    String arrivoTeorico = reader.nextString();
                    fermata.setArrivoTeorico(arrivoTeorico);
                }else if("partenza_teorica".equals(fieldname)){
                    String partenzaTeorica = reader.nextString();
                    fermata.setPartenzaTeorica(partenzaTeorica);
                }else if("actualFermataType".equals(fieldname)){
                    int tipoFermataAttuale = reader.nextInt();
                    fermata.setTipoFermataAttuale(tipoFermataAttuale);
                }else{
                    reader.skipValue();
                }
            }
        }
        reader.endObject();
        fermata.setStazione(stazione);
        return fermata;
    }

}