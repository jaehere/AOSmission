package com.mobileleader.android.assignment1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class InfoList extends RecyclerView.Adapter<InfoList.ViewHolder> {
    //Adapter 구현
    private ArrayList<InfoItem> mInfoList;
    public ImageView one_image_1;
    private ClickCallbackListener callbackListener;
    private InfoItem item;

    @NonNull
    @Override
    public InfoList.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_recycler,parent,false);

        return new ViewHolder(view, callbackListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int pos) {
        //InfoItem item = mInfoList.get(pos);

        holder.onBind(mInfoList.get(pos));



    }

    @Override
    public int getItemCount() {
        return mInfoList.size();
    }


    public void setmInfoList(ArrayList<InfoItem> mInfoList) {
        this.mInfoList = mInfoList;
    }

    public void setCallbackListener(ClickCallbackListener callbackListner) {
        this.callbackListener = callbackListner;
    }


    public interface OnItemClickListener{
        void onItemClick(View v, int pos);
    }

    private OnItemClickListener mListener = null;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView title;
        TextView content;
        private ClickCallbackListener callbackListener;


        public ViewHolder(@NonNull View itemView, ClickCallbackListener callbackListener) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
            content = (TextView) itemView.findViewById(R.id.content);

            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        InfoItem item = mInfoList.get(pos);

                        int id = v.getId();
                        callbackListener.callBack(getAdapterPosition(), item.getmResourceId(),item.getmTitle(), item.getmContent());


                    }

                }
            });
        }

        public void onBind(InfoItem infoItem, ClickCallbackListener callbackListener) {
            image.setImageResource(infoItem.getmResourceId());
            title.setText(infoItem.getmTitle());
            content.setText(infoItem.getmContent());
            this.callbackListener = callbackListener;
        }


        @Override
        public void onClick(View view) {
            callbackListener.callBack(getAdapterPosition(), item.getmResourceId(), item.getmTitle(), item.getmContent());
        }

        public void onBind(InfoItem infoItem) {
            image.setImageResource(infoItem.getmResourceId());
            title.setText(infoItem.getmTitle());
            String str_split = infoItem.getmContent().substring(0,22) + "...";
            content.setText(str_split);

        }
    }
}
