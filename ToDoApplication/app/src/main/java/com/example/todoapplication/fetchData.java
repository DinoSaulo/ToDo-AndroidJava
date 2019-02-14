package com.example.todoapplication;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;

public class fetchData extends AsyncTask<Void, Void, Void> {
    String data = "";
    String dataParsed = "";
    String singleParsed = "";
    @Override
    protected Void doInBackground(Void... voids) {
        try{
            URL url = new URL("https://jsonplaceholder.typicode.com/todos/");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null ){
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONArray JA = new JSONArray(data);
            for(int i = 0; i <JA.length(); i++){
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed =  "userId: " + JO.get("userId") + "\n" +
                                "id: " + JO.get("id") + "\n" +
                                "title: " + JO.get("title") + "\n" +
                                "completed: " + JO.get("completed") + "\n"+
                                "------------------------" + "\n";

                dataParsed = dataParsed + singleParsed;
            }

        } catch (MalformedURLException e ) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    protected void onPostExecute(Void aVoid) {
       super.onPostExecute(aVoid);

       MainActivity.data.setText(this.dataParsed);
    }
}

