package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//<>覆盖基类方法,自定义子类替代基类
public class Adapter extends RecyclerView.Adapter<Adapter.Myholder> {
    private View view;
    private Context context;
    private List<String> list;

    public Adapter(Context context, List<String> list) {
        this.context = context;
        this.list=list;
    }

//    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //viewholder指向view的指针
        view= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        Myholder holder;
        holder=new Myholder(view);
        return holder;
        //压缩出一个view
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int j) {
        //视图里面放什么数据
        //循环一一对应
        //一个 holder 对应 一行
        //不需要for循环
        holder.textView.setText(list.get(j));


    }

    @Override
    public int getItemCount() {
        //告诉有多少行
        return list.size();

    }

    class Myholder extends RecyclerView.ViewHolder{
        private TextView textView;
        public Myholder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.text1);

        }
    }


}
