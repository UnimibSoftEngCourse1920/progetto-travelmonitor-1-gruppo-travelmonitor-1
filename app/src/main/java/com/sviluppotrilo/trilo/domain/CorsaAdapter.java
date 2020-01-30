package com.sviluppotrilo.trilo.domain;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;

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
            if (token.equals(JsonToken.NAME)) {
                fieldname = reader.nextName();
                if(reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                }else {
                    switch (fieldname){
                        case "idOrigine":
                            String idStazioneOrigine = reader.nextString();
                            //qui andrebbe cercata la stazione nel db..
                            //Inoltre andrebbe controllato se l'id inizia
                            //per S0..
                            origine.setId(idStazioneOrigine); break;
                        case "idDestinazione":
                            String idStazioneDestinazione = reader.nextString();
                            //qui andrebbe cercata la stazione nel db..
                            //Inoltre andrebbe controllato se l'id inizia
                            //per S0..
                            destinazione.setId(idStazioneDestinazione); break;
                        case "origine":
                            String nomeStazioneOrigine = reader.nextString();
                            origine.setNome(nomeStazioneOrigine); break;
                        case "destinazione":
                            String nomeStazioneDestinazione = reader.nextString();
                            destinazione.setNome(nomeStazioneDestinazione); break;
                        case "compOrarioPartenza":
                            String orarioPartenza = reader.nextString();
                            corsa.setOrarioPartenza(orarioPartenza); break;
                        case "compOrarioArrivo":
                            String orarioArrivo = reader.nextString();
                            corsa.setOrarioArrivo(orarioArrivo); break;
                        case "compOraUltimoRilevamento":
                            String oraUltimoRilevamento = reader.nextString();
                            corsa.setOraUltimoRilevamento(oraUltimoRilevamento); break;
                        case "stazioneUltimoRilevamento":
                            String stazioneUltimoRilevamento = reader.nextString();
                            rilevamento.setNome(stazioneUltimoRilevamento);
                            //qui andrebbe cercata la stazione nel db..
                            corsa.setStazioneUltimoRilevamento(rilevamento); break;
                        case "tipoTreno":
                            String tipoTreno = reader.nextString();
                            //Forse qui andrebbe creato un oggetto Treno
                            // quindi aggiungere la classe al diagrqmma
                            corsa.setTipoTreno(tipoTreno); break;
                        case "provvedimento":
                            int provvedimento = reader.nextInt();
                            //Forse qui andrebbe creato un oggetto Treno
                            // quindi aggiungere la classe al diagrqmma
                            corsa.setProvvedimento(provvedimento); break;
                        case "codiceCliente":
                            int codiceCliente = reader.nextInt();
                            corsa.setCodiceCliente(codiceCliente); break;
                        case "dataPartenza":
                            String dataPartenza = reader.nextString();
                            corsa.setDataPartenza(dataPartenza); break;
                        case "numeroTreno":
                            int numeroTreno = reader.nextInt();
                            corsa.setNumeroTreno(numeroTreno); break;
                        case "categoria":
                            String categoria = reader.nextString();
                            corsa.setCategoria(categoria); break;
                        case "inStazione":
                            boolean inStazione = reader.nextBoolean();
                            corsa.setInStazione(inStazione); break;
                        case "nonPartito":
                            boolean nonPartito = reader.nextBoolean();
                            corsa.setPartito(!nonPartito); break;
                        case "fermate":
                            corsa.setFermate(readFermate(reader));
                            break;
                        default: reader.skipValue();
                    }
                }
            }
        }
        reader.endObject();
        corsa.setOrigine(origine);
        corsa.setDestinazione(destinazione);
        return corsa;
    }

    private ArrayList<Fermata> readFermate(JsonReader reader) throws IOException{
        ArrayList<Fermata> fermate = new ArrayList<>();
        reader.beginArray();
        while (reader.hasNext()){
            Fermata fermata = new FermataAdapter().read(reader);
            fermate.add(fermata);
        }
        reader.endArray();
        return fermate;
    }
}
