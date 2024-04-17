package edu.ntu.ex_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ImageGalleryAdapter2 extends RecyclerView.Adapter<ExamViewHolder> {
    ArrayList<ExamData> list = new ArrayList<>();
    Context context;
    ClickListener listener;

    public ImageGalleryAdapter2(ArrayList<ExamData> list, Context context, ClickListener listener) {
        this.list = list;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ExamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View photoView = layoutInflater.inflate(R.layout.exam_card, parent, false);
        return new ExamViewHolder(photoView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamViewHolder holder, int position) {
        int index = holder.getAdapterPosition();
        holder.tvExamName.setText(list.get(position).name);
        holder.tvExamMessage.setText(list.get(position).name);
        holder.tvExamDate.setText(list.get(position).date);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                listener.click(index);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
