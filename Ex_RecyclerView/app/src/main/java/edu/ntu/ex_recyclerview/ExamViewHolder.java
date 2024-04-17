package edu.ntu.ex_recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ExamViewHolder extends RecyclerView.ViewHolder {
    TextView tvExamName;
    TextView tvExamMessage;
    TextView tvExamDate;
    View view;
    public ExamViewHolder(@NonNull View itemView) {
        super(itemView);
        tvExamName = (TextView) itemView.findViewById(R.id.examName);
        tvExamMessage = (TextView) itemView.findViewById(R.id.examMessage);
        tvExamDate = (TextView) itemView.findViewById(R.id.examDate);
        view = itemView;
    }
}
