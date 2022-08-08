package com.mobileleader.android.assignment1;
import android.content.Intent;
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


    public void bindInfoItem(InfoItem infoItem){

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int pos) {
        InfoItem item = mInfoList.get(pos);

        holder.onBind(mInfoList.get(pos));



    }
/*
    @Override
    public void onBindViewHolder(@NonNull InfoList.ViewHolder holder, int position) {
        holder.onBind(mInfoList.get(position));
    }*/

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
        private InfoItem infoItem;
        private ClickCallbackListener callbackListener;


        public ViewHolder(@NonNull View itemView, ClickCallbackListener callbackListener) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.image);
//             ImageView includeImg=(ImageView) itemView.findViewById(R.id.includeImage);
            title = (TextView) itemView.findViewById(R.id.title);
            content = (TextView) itemView.findViewById(R.id.content);
            // TODO: 2022/08/04 여기가 문제인 것 같은데...

            //empty_image = (ImageView) empty_image.findViewById(R.id.one_image);

//            one_image_1.setOnClickListener(this);

            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        InfoItem item = mInfoList.get(pos);

                        int id = v.getId();
                        callbackListener.callBack(getAdapterPosition(), item.getmResourceId(),item.getmTitle(), item.getmContent());
                        //callbackListener.goDetail(getAdapterPosition(), item.getmResourceId(), item.getmTitle(), item.getmContent());
                        //imageView.setImageResource(R.drawable.);
//                         includeImg.setImageResource(R.drawable.ic_launcher_foreground);
                        //String resName = v.getContext().getResources().getResourceName(item.getmResourceId());
                        //int test = R.drawable.dice1;
                        //Drawable drawableName = v.getContext().getResources().getDrawable(item.getmResourceId());
                        // Toast.makeText(image.getContext(),  "아이템선택####"+item.getmResourceId(), Toast.LENGTH_SHORT).show();

                        //imageView.setImageResource(item.getmResourceId());
                        //imageView.setImageURI(Uri.parse(resName));
                        //image.setImageResource(R.drawable.ic_launcher_foreground);
                        //empty_image.setImageDrawable(null);
                        //empty_image.setImageResource(R.drawable.dice1);

//                        one_image_1 = (ImageView) v.findViewById(R.id.one_image_1);
                    //    one_image_1.setImageResource(R.drawable.ic_launcher_foreground);

                        //Intent intent = new Intent()


                        if(one_image_1 != null){
                            one_image_1.setImageResource(R.drawable.ic_launcher_foreground);
                        }
                        if(mListener != null){
                            mListener.onItemClick(v,pos);

                        }
                    }

                }
            });
        }

        public void onBind(InfoItem infoItem, ClickCallbackListener callbackListener) {
            image.setImageResource(infoItem.getmResourceId());
            title.setText(infoItem.getmTitle());
            //String str = infoItem.getmContent();
            //String str_sp = str.substring(0,22)+"...";
            //String str_split = infoItem.getmContent().substring(0,22) + "...";
            content.setText(infoItem.getmContent());
            this.callbackListener = callbackListener;
            //empty_image.setImageResource(infoItem.getmResourceId());
        }


        @Override
        public void onClick(View view) {
            //one_image_1.setImageResource(R.drawable.ic_launcher_foreground);
            int id = view.getId();
            callbackListener.callBack(getAdapterPosition(), item.getmResourceId(), item.getmTitle(), item.getmContent());
        }

        public void onBind(InfoItem infoItem) {
            image.setImageResource(infoItem.getmResourceId());
            title.setText(infoItem.getmTitle());
            String str_split = infoItem.getmContent().substring(0,22) + "...";
            content.setText(str_split);

        }
    }

    //싱글톤
   /*
    private static AsmListLab sAsmListLab;

    private List<AsmList> mAsmList;

    public static AsmListLab get(Context context){
        if(sAsmListLab == null){
            sAsmListLab = new AsmListLab(context);
        }
        return sAsmListLab;
    }

    private AsmListLab(Context context) {
        mAsmList = new ArrayList<>();
        for(int i=0; i<5; i++){
            AsmList asmList = new AsmList();
            asmList.setTitle("안드로이드 개발책"+i);
            mAsmList.add(asmList);
        }
    }

    public List<AsmList> getAsmList(){
        return mAsmList;
    }
    public AsmList getAsmList(UUID id){
        for(AsmList asmList : mAsmList){
            if(asmList.getId().equals(id)){
                return asmList;
            }
        }
        return null;
    }*/
}
