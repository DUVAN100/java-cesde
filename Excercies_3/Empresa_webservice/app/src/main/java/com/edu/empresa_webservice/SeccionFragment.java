package com.edu.empresa_webservice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ResponseDelivery;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonRequest;

import org.json.JSONObject;

public class SeccionFragment extends Fragment  implements Response.Listener<JSONObject>, Response.ErrorListener {
    EditText jetclave, jetcorreo;
    Button jbtingresar;
    TextView jtvregistrar;
    RequestQueue rq;
    JsonRequest jrq;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_seccion,container,false);
        jetcorreo = vista.findViewById(R.id.etcorreo);
        jetclave = vista.findViewById(R.id.etclave);
        jbtingresar = vista.findViewById(R.id.btingresar);
        jtvregistrar=vista.findViewById(R.id.tvregistrar);
        jbtingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return vista;
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

    }
}