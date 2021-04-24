package com.example.mvvmpractice.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmpractice.DataHold.DataHolder;
import com.example.mvvmpractice.MainActivity;
import com.example.mvvmpractice.PojoClass.FAQEntity;
import com.example.mvvmpractice.R;

import java.util.ArrayList;
import java.util.List;

public  class RecyclerViewFAQAdapter  extends RecyclerView.Adapter<RecyclerViewFAQAdapter.ViewHolder>{

    private Context mcontext;
    private List<FAQEntity> faqEntityList=new ArrayList<>();

    public RecyclerViewFAQAdapter(Context mcontext, List<FAQEntity> faqEntityList) {
        this.mcontext = mcontext;
        this.faqEntityList = faqEntityList;
    }

    //private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

//    public void setOnItemClickListener(OnItemClickListener listener) {
//        this.listener = listener;
//    }

//    public RecyclerViewFAQAdapter(MainActivity onItemClickListener){
//        listener= (OnItemClickListener) onItemClickListener;
//    }

    public void setFAQ(List<FAQEntity>faqEntityList){
        this.faqEntityList=faqEntityList;
        DataHolder.faqEntityArrayList= (ArrayList<FAQEntity>) faqEntityList;

        notifyDataSetChanged();
    }

    public FAQEntity getFAQAT(int position){
        return faqEntityList.get(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        FAQEntity currentFAQ=faqEntityList.get(position);
        if(faqEntityList!=null){
            holder.textViewQuestionNo.setText(String.valueOf(currentFAQ.getId()));
            holder.textViewQ.setText(currentFAQ.getQuestion());
            holder.textViewA.setText(currentFAQ.getSolution());
        }
    }

    @Override
    public int getItemCount() {
        if(faqEntityList==null) {
            return 0;
        }else{
            return faqEntityList.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewQ,textViewA,textViewQuestionNo;
        LinearLayout linearLayout;
        OnItemClickListener onItemClickListener;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            textViewQuestionNo=(TextView)itemView.findViewById(R.id.questionno);
            textViewQ=(TextView)itemView.findViewById(R.id.faqquestion);
            textViewA=(TextView)itemView.findViewById(R.id.faqanswer);
            //this.onItemClickListener=onItemClickListener;
            //itemView.setOnClickListener(this);
        }

//        @Override
//        public void onClick(View view) {
//            onItemClickListener.onItemClick(getAdapterPosition());
//        }
    }

}
