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
    public ToDo todos[] = new ToDo[512];
    Object ToDo2[][] = new Object[512][4];

    public ToDo[] getTodos() {
        return todos;
    }

    public Object[][] getToDo2() {
        return ToDo2;
    }

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
                singleParsed =  "User ID: " + JO.get("userId") + "\n" +
                                "ID: " + JO.get("id") + "\n" +
                                "Title: " + JO.get("title") + "\n" +
                                "Completed: " + JO.get("completed") + "\n"+
                                "-------------------------------" + "\n";
                ToDo2[i][0] = JO.get("userId");
                ToDo2[i][1] = JO.get("id");
                ToDo2[i][2] = JO.get("title");
                ToDo2[i][3] = JO.get("completed");

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
       //SearchActivity.data.setText(this.dataParsed);
    }
}

