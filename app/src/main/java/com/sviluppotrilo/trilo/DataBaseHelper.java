package com.sviluppotrilo.trilo;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.CheckForNull;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static String databasename = "Stazioni.db";
    private static String tablestazioni = "stazioni";
    private static String databasepath = "";
    private Context mContext;
    private String[] arrData;
    private InputStream myInput;
    private OutputStream myOutput;
    @CheckForNull
    private Cursor cursor = null;

    public DataBaseHelper(Context context) {
        super(context, databasename, null, 1);
        databasepath = context.getApplicationInfo().dataDir + "/databases/";
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Il metodo non è necessario, ma è necessaria la sua definizione
    }


    private boolean checkDatabase() {
        SQLiteDatabase db;
        try {
            String path = databasepath + databasename;
            db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        } catch (SQLException e) {
            return false;
        }
        db.close();
        return true;
    }

    private void copyDatabase() throws IOException {
        try {
            myInput = mContext.getAssets().open(databasename);
            String outputFileName = databasepath + databasename;
            myOutput = new FileOutputStream(outputFileName);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
        } catch (IOException e) {
            myOutput.flush();
            myOutput.close();
            myInput.close();
        }
    }

    public void createDatabase() {
        if(!checkDatabase()){
            this.getReadableDatabase();
            try {
                copyDatabase();
            }catch (IOException e){
                e.fillInStackTrace();
            }
        }
    }

    public String[] selectAllData() {
        SQLiteDatabase db;
        try {
            db = this.getReadableDatabase();
            String strSQL = "SELECT nome FROM " + tablestazioni;
            cursor = db.rawQuery(strSQL, null);
            if (cursor.moveToFirst()) {
                arrData = new String[cursor.getCount()];
                int i = 0;
                do {
                    arrData[i] = cursor.getString(0);
                    i++;
                } while (cursor.moveToNext());
            }
        } finally {
            cursor.close();
        }
        return arrData;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Il metodo non è necessario, ma è necessaria la sua definizione
    }

}