package com.example.lenovo.jd_demo_ljq_text_5_10.ui.homepage.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.lenovo.jd_demo_ljq_text_5_10.R;
import com.example.lenovo.jd_demo_ljq_text_5_10.bean.AdBean;
import com.example.lenovo.jd_demo_ljq_text_5_10.inter.OnItemClickListener;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class RvRecommendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<AdBean.TuijianBean.ListBean> list;
    private LayoutInflater inflater;
    private OnItemClickListener onItemClickListener;

    public RvRecommendAdapter(Context context, List<AdBean.TuijianBean.ListBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.rvrecommend_item, parent, false);
        RecommendViewHolder recommendViewHolder = new RecommendViewHolder(view);
        return recommendViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RecommendViewHolder recommendViewHolder = (RecommendViewHolder) holder;
        AdBean.TuijianBean.ListBean listBean = list.get(position);
        String images = listBean.getImages();
        String[] split = images.split("\\|");
        String url = split.length == 0 ? images : split[0];
        recommendViewHolder.iv.setImageURI(url);
        recommendViewHolder.tv.setText(listBean.getTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RecommendViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView iv;
        private final TextView tv;

        public RecommendViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
