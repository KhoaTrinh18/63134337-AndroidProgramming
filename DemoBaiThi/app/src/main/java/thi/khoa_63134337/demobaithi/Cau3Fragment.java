package thi.khoa_63134337.demobaithi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Cau3Fragment extends Fragment {
    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> recyclerViewData;
    RecyclerView recyclerViewLandScape;

    public Cau3Fragment() {
        // Required empty public constructor
    }

    public static Cau3Fragment newInstance(String param1, String param2) {
        Cau3Fragment fragment = new Cau3Fragment();
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
        View viewCau3 = inflater.inflate(R.layout.fragment_cau3, container, false);
        recyclerViewData = getDataForRecycleView();
        recyclerViewLandScape = viewCau3.findViewById(R.id.recyclerLand);
        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(viewCau3.getContext());
        recyclerViewLandScape.setLayoutManager(layoutLinear);
        landScapeAdapter = new LandScapeAdapter(viewCau3.getContext(), recyclerViewData);
        recyclerViewLandScape.setAdapter(landScapeAdapter);
        return viewCau3;
    }

    ArrayList<LandScape> getDataForRecycleView() {
        ArrayList<LandScape> lData = new ArrayList<>();
        lData.add(new LandScape("ha_long_bay", "Vịnh Hạ Long"));
        lData.add(new LandScape("leaning_tower_of_pisa", "Tháp nghiêng Pisa"));
        lData.add(new LandScape("pyramid", "Kim Tự Tháp"));
        lData.add(new LandScape("statue_of_liberty", "Tượng Nữ thần Tự do"));
        lData.add(new LandScape("venice_city", "Thành phố Venice"));
        return lData;
    }
}