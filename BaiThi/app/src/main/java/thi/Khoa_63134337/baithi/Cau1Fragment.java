package thi.khoa_63134337.baithi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cau1Fragment extends Fragment {
    EditText edtMet;
    EditText edtKm;
    Button btnChuyen;
    public Cau1Fragment() {
        // Required empty public constructor
    }
    public static Cau1Fragment newInstance(String param1, String param2) {
        Cau1Fragment fragment = new Cau1Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewCau1 = inflater.inflate(R.layout.fragment_cau1, container, false);
        edtMet = (EditText) viewCau1.findViewById(R.id.edtMet);
        edtKm = (EditText) viewCau1.findViewById(R.id.edtKm);
        btnChuyen = (Button) viewCau1.findViewById(R.id.btnChuyen);
        btnChuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strMet = edtMet.getText().toString();
                String strKm = edtKm.getText().toString();
                if(!strMet.isEmpty()){
                    Toast.makeText(viewCau1.getContext(), "m->km", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(viewCau1.getContext(), "km->m", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return viewCau1;
    }
}