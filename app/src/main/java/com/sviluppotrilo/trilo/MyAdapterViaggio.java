package com.sviluppotrilo.trilo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sviluppotrilo.trilo.Controller.PreferitiController;
import com.sviluppotrilo.trilo.Domain.Soluzione;

import java.util.ArrayList;

public class MyAdapterViaggio extends RecyclerView.Adapter<MyCardViaggio> {

    Context context;
    ArrayList<Soluzione> datiSoluzione;
    String partenza;
    String arrivo;

    public MyAdapterViaggio(Context c, ArrayList<Soluzione> datiSoluzione, String partenza, String arrivo) {
        this.context = c;
        this.datiSoluzione = datiSoluzione;
        this.partenza = partenza;
        this.arrivo = arrivo;
    }

    @NonNull
    @Override
    public MyCardViaggio onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_viaggio, null);
        return new MyCardViaggio(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCardViaggio holder, final int i) {
        int numeroUltimTratta = datiSoluzione.get(i).getTratte().size() - 1;
        String orarioPartenza = datiSoluzione.get(i).getTratte().get(0).getOrarioPartenza();
        String orarioArrivo = datiSoluzione.get(i).getTratte().get(numeroUltimTratta).getOrarioArrivo();

        holder.oraPartenza.setText(orarioPartenza.substring((orarioPartenza.indexOf('T') + 1), orarioPartenza.indexOf(":00")));
        holder.oraArrivo.setText(orarioArrivo.substring((orarioArrivo.indexOf('T') + 1), orarioArrivo.indexOf(":00")));
        holder.stazionePartenza.setText(partenza);
        holder.stazioneArrivo.setText(arrivo);
        holder.numeroTreno.setText("Treno N: " + datiSoluzione.get(i).getTratte().get(0).getNumeroTreno());
        holder.orarioViaggio.setText(orarioPartenza.substring((orarioPartenza.indexOf('T') + 1), orarioPartenza.indexOf(":00")) + " - "
                + orarioArrivo.substring((orarioArrivo.indexOf('T') + 1), orarioArrivo.indexOf(":00")));
        //holder.statoTreno.setText(datiSoluzione.get(i).getTratte().get(0).getCorsa().getFermate().get(0).getRitardo());
        if(datiSoluzione.get(i).numeroCambi() > 1){
            holder.destinazioneTreno.setText("Numero cambi: "+datiSoluzione.get(i).numeroCambi());
        }else{
            holder.destinazioneTreno.setText("Treno per");
            //holder.destinazioneTreno.setText(datiSoluzione.get(numeroUltimTratta).getTratte().get(0).getDestinazione().getNome());
        }

        holder.preferitoSi.setVisibility(View.INVISIBLE);

        holder.preferito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMultiSelection(i);
            }
        });
    }

    public void showMultiSelection(final int i) {
        final String[] items = {"Lunedì", "Martedì", "Mercoledì", "Giovedì", "Venerdì", "Sabato", "Domenica"};
        final ArrayList<Integer> selectedList = new ArrayList<>();
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.bannerscegligiornipreferiti);

        builder.setTitle("Salva Viaggio Per:");
        builder.setMultiChoiceItems(items, null,
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            selectedList.add(which);
                        } else if (selectedList.contains(which)) {
                            selectedList.remove(which);
                        }
                    }
                });
        builder.setPositiveButton("Salva", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int k) {
                ArrayList<String> selectedStrings = new ArrayList<>();
                for (int j = 0; j < selectedList.size(); j++) {
                    selectedStrings.add(items[selectedList.get(j)]);
                }
                PreferitiController preferitiController = new PreferitiController();
                if(selectedStrings.contains("Lunedì")){
                    preferitiController.aggiungiPreferito(1, datiSoluzione.get(i));
                }
                if(selectedStrings.contains("Martedì")){
                    preferitiController.aggiungiPreferito(2, datiSoluzione.get(i));
                }
                if(selectedStrings.contains("Mercoledì")){
                    preferitiController.aggiungiPreferito(3, datiSoluzione.get(i));
                }
                if(selectedStrings.contains("Giovedì")){
                    preferitiController.aggiungiPreferito(4, datiSoluzione.get(i));
                }
                if(selectedStrings.contains("Venerdì")){
                    preferitiController.aggiungiPreferito(5, datiSoluzione.get(i));
                }
                if(selectedStrings.contains("Sabato")){
                    preferitiController.aggiungiPreferito(6, datiSoluzione.get(i));
                }
                if(selectedStrings.contains("Domenica")){
                    preferitiController.aggiungiPreferito(7, datiSoluzione.get(i));
                }
            }
        });
        builder.show();
    }
    @Override
    public int getItemCount() {
        return datiSoluzione.size();
    }
}

