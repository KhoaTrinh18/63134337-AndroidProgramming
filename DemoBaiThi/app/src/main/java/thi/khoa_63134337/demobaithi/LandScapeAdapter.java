package thi.khoa_63134337.demobaithi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LandScapeAdapter extends RecyclerView.Adapter<LandScapeAdapter.ItemLandHolder> {
    Context context;
    ArrayList<LandScape> lData;


    public LandScapeAdapter(Context context, ArrayList<LandScape> lData) {
        this.context = context;
        this.lData = lData;
    }

    @NonNull
    @Override
    public ItemLandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater cai_bom = LayoutInflater.from(context);
        View view = cai_bom.inflate(R.layout.landscape_item, parent, false);
        return new ItemLandHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandHolder holder, int position) {
        //Lấy đổi tượng hiển thị
        LandScape landScapeShow = lData.get(position);
        //Trích thông tin
        String name = landScapeShow.getLandName();
        String image = landScapeShow.getLandImage();
        //Đặt vào các trường thông tin của holder
        holder.tvLandScapeName.setText(name);
        String packageName = holder.itemView.getContext().getPackageName();
        int imageID = holder.itemView.getResources().getIdentifier(image,"mipmap", packageName);
        holder.ivLandScapeImage.setImageResource(imageID);
    }

    @Override
    public int getItemCount() {
        return lData.size();
    }

    class ItemLandHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvLandScapeName;
        ImageView ivLandScapeImage;

        public ItemLandHolder(@NonNull View itemView) {
            super(itemView);
            tvLandScapeName = itemView.findViewById(R.id.landScapeName);
            ivLandScapeImage = itemView.findViewById(R.id.landScapeImage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            LandScape landScape = lData.get(position);
            String nameLand = landScape.getLandName();
            String str = "Bạn vừa click vào: " + nameLand;
            Toast.makeText(v.getContext(), str, Toast.LENGTH_SHORT).show();
        }
    }

}
