package com.sviluppotrilo.trilo;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class CorsaAdapter extends TypeAdapter<Corsa>{

    @Override
    public void write(JsonWriter out, Corsa value) throws IOException {
        // Questo metodo non esegue nessuna operazione perchè l'obiettivo del
        // progetto non include la serializzazione degli oggetti
    }

    @Override
    public Corsa read(JsonReader reader) throws IOException {
        Corsa corsa = new Corsa();
        reader.beginObject();
        String fieldname = null;
        JsonToken token = null;
        Stazione origine = new Stazione();
        Stazione destinazione = new Stazione();
        Stazione rilevamento = new Stazione();
        while (reader.hasNext()) {
            token = reader.peek();
            if(token.equals(JsonToken.NULL))
                reader.skipValue();
            if (token.equals(JsonToken.NAME)) {
                fieldname = reader.nextName();
                if(reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                }else if ("idOrigine".equals(fieldname)) {
                    String idStazioneOrigine = reader.nextString();
                    //qui andrebbe cercata la stazione nel db..
                    //Inoltre andrebbe controllato se l'id inizia
                    //per S0..
                    origine.setId(idStazioneOrigine);
                }else if("origine".equals(fieldname)){
                    String nomeStazioneOrigine = reader.nextString();
                    origine.setNome(nomeStazioneOrigine);
                }else if("idDestinazione".equals(fieldname)){
                    String idStazioneDestinazione = reader.nextString();
                    //qui andrebbe cercata la stazione nel db..
                    //Inoltre andrebbe controllato se l'id inizia
                    //per S0..
                    destinazione.setId(idStazioneDestinazione);
                }else if("destinazione".equals(fieldname)){
                    String nomeStazioneDestinazione = reader.nextString();
                    destinazione.setNome(nomeStazioneDestinazione);
                }else if("compOrarioPartenza".equals(fieldname)){
                    String orarioPartenza = reader.nextString();
                    corsa.setOrarioPartenza(orarioPartenza);
                }else if("compOrarioArrivo".equals(fieldname)){
                    String orarioArrivo = reader.nextString();
                    corsa.setOrarioArrivo(orarioArrivo);
                }else if("compOraUltimoRilevamento".equals(fieldname)){
                    String oraUltimoRilevamento = reader.nextString();
                    corsa.setOraUltimoRilevamento(oraUltimoRilevamento);
                }else if("stazioneUltimoRilevamento".equals(fieldname)){
                    String stazioneUltimoRilevamento = reader.nextString();
                    rilevamento.setNome(stazioneUltimoRilevamento);
                    //qui andrebbe cercata la stazione nel db..
                    corsa.setStazioneUltimoRilevamento(rilevamento);
                }else if("tipoTreno".equals(fieldname)){
                    String tipoTreno = reader.nextString();
                    //Forse qui andrebbe creato un oggetto Treno
                    // quindi aggiungere la classe al diagrqmma
                    corsa.setTipoTreno(tipoTreno);
                }else if("provvedimento".equals(fieldname)){
                    int provvedimento = reader.nextInt();
                    //Forse qui andrebbe creato un oggetto Treno
                    // quindi aggiungere la classe al diagrqmma
                    corsa.setProvvedimento(provvedimento);
                }else if("subTitle".equals(fieldname)){
                    String descrizione = reader.nextString();
                    corsa.setDescrizione(descrizione);
                }else if("codiceCliente".equals(fieldname)){
                    int codiceCliente = reader.nextInt();
                    corsa.setCodiceCliente(codiceCliente);
                }else if("dataPartenza".equals(fieldname)){
                    String dataPartenza = reader.nextString();
                    corsa.setDataPartenza(dataPartenza);
                }else if("numeroTreno".equals(fieldname)){
                    int numeroTreno = reader.nextInt();
                    corsa.setNumeroTreno(numeroTreno);
                }else if("categoria".equals(fieldname)){
                    String categoria = reader.nextString();
                    corsa.setCategoria(categoria);
                }else if("inStazione".equals(fieldname)){
                    boolean inStazione = reader.nextBoolean();
                    corsa.setInStazione(inStazione);
                }else if("nonPartito".equals(fieldname)){
                    boolean nonPartito = reader.nextBoolean();
                    corsa.setPartito(!nonPartito);
                }else if("fermate".equals(fieldname)) {
                    reader.beginArray();
                    while (reader.hasNext()){
                        TypeAdapter<Fermata> fermataAdapter = new Gson().getAdapter(Fermata.class);
                        Fermata fermata = fermataAdapter.read(reader);
                        corsa.fermate.add(fermata);
                    }
                    reader.endArray();
                }else{
                    reader.skipValue();
                }
            }
        }
        reader.endObject();
        corsa.setOrigine(origine);
        corsa.setDestinazione(destinazione);
        return corsa;
    }

}
