package com.special.IsoRunner.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.special.IsoRunner.R;
import com.special.IsoRunner.models.TrainingItem;
import com.special.IsoRunner.utils.UtilsApp;

import java.util.List;

/**
 * Created by pawel on 22/10/16.
 */

public class TrainingListRecyclerViewAdapter /* extends RecyclerView.Adapter<TrainingListRecyclerViewAdapter.ViewHolder> implements View.OnClickListener*/ {

//    List<TrainingItem> mTrainingList;
//
//    public TrainingListRecyclerViewAdapter(List<TrainingItem> trainingList) {
//        mTrainingList = trainingList;
//    }
//
//    @Override
//    public TrainingListRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.training_list_item, parent, false);
//        return new TrainingListRecyclerViewAdapter.ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(TrainingListRecyclerViewAdapter.ViewHolder holder, int position) {
//        holder.trainingDate.setText(UtilsApp.getFormattedDate(mTrainingList.get(position).date));
//        holder.trainingTitle.setText(mTrainingList.get(position).title);
//        holder.trainingDescription.setText(mTrainingList.get(position).description);
//    }
//
//    @Override
//    public int getItemCount() {
//        return mTrainingList.size();
//    }
//
//    @Override
//    public void onClick(View view) {
//
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        public final TextView trainingDate;
//        public final TextView trainingTitle;
//        public final TextView trainingDescription;
//        public ViewHolder(View itemView) {
//            super(itemView);
//            itemView.setOnClickListener(this);
//            trainingDate = (TextView) itemView.findViewById(R.id.training_date);
//            trainingTitle = (TextView) itemView.findViewById(R.id.training_title);
//            trainingDescription = (TextView) itemView.findViewById(R.id.training_description);
//        }
//
//        @Override
//        public void onClick(View v) {
//            //TODO this.getPosition()
//        }
//    }
}
