package com.example.babytear;
import android.os.AsyncTask;
import java.net.InetAddress;
import java.net.Socket;
import java.io.DataOutputStream;
import android.util.Log;
import java.io.IOException;


public class NetworkTask extends AsyncTask<Void, byte[], Boolean> {
    public int port = 5560;

    public InetAddress getInet() {
        InetAddress ip;
        try {
            return InetAddress.getByName("172.22.210.157");
        } catch(Exception e)  {
            System.out.println(e);
            return null;
        }
    }
    Socket socket; //Network Socket
    DataOutputStream dout;


    @Override
    protected void onPreExecute() {
        Log.i("AsyncTask", "onPreExecute");
    }

    @Override
    protected Boolean doInBackground(Void... params) { //This runs on a different thread
        boolean result = false;
        try {
            Log.i("AsyncTask", "doInBackground: Creating socket");
            socket = new Socket(getInet(), port);
            if (socket.isConnected()) {
                dout = new DataOutputStream(socket.getOutputStream());
                Log.i("AsyncTask", "doInBackground: Socket created, streams assigned");
                Log.i("AsyncTask", "doInBackground: Waiting for inital data...");
                }
            } catch(IOException e) {
                e.printStackTrace();
                Log.i("AsyncTask", "doInBackground: IOException");
                result = true;
            } catch (Exception e) {
                e.printStackTrace();
                Log.i("AsyncTask", "doInBackground: Exception");
                result = true;
            } finally {
                try {
                    dout.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            Log.i("AsyncTask", "doInBackground: Finished");
        }
        return result;
    }

    public void SendDataToNetwork(String cmd) { //You run this from the main thread.
        try {
            if (socket.isConnected()) {
                Log.i("AsyncTask", "SendDataToNetwork: Writing received message to socket");
                dout.writeUTF("PLAY");
                dout.flush();
                dout.close();
                socket.close();
            } else {
                Log.i("AsyncTask", "SendDataToNetwork: Cannot send message. Socket is closed");
            }
        } catch (Exception e) {
            Log.i("AsyncTask", "SendDataToNetwork: Message send failed. Caught an exception");
        }
    }

    @Override
    protected void onProgressUpdate(byte[]... values) {
        if (values.length > 0) {
            Log.i("AsyncTask", "onProgressUpdate: " + values[0].length + " bytes received.");
        }
    }
    @Override
    protected void onCancelled() {
        Log.i("AsyncTask", "Cancelled.");
    }
    @Override
    protected void onPostExecute(Boolean result) {
        if (result) {
            Log.i("AsyncTask", "onPostExecute: Completed with an Error.");
        } else {
            Log.i("AsyncTask", "onPostExecute: Completed.");
        }
    }
}
