package rang.com.fashionshop.home.adapter;


import android.content.Context;
import android.graphics.Typeface;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import rang.com.fashionshop.R;
import rang.com.fashionshop.home.model.BeanlistBrands;


public class BrandsRecyclerViewAdapter extends RecyclerView
        .Adapter<BrandsRecyclerViewAdapter
        .DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<BeanlistBrands>bean;
    private Context context;
    private static MyClickListener myClickListener;
    Typeface fonts1,fonts2,fonts3,fonts4,fonts5;



    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {

        ImageView imgbrand;
        TextView text1,text2,text3,text4,text5,text6;







        public DataObjectHolder(View itemView) {
            super(itemView);


            imgbrand = (ImageView) itemView.findViewById(R.id.imgbrand);
            text1 = (TextView) itemView.findViewById(R.id.text1);
            text2 = (TextView) itemView.findViewById(R.id.text2);
            text3 = (TextView) itemView.findViewById(R.id.text3);
            text4 = (TextView) itemView.findViewById(R.id.text4);
            text5 = (TextView) itemView.findViewById(R.id.text5);
            text6 = (TextView) itemView.findViewById(R.id.text6);







            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
     //       myClickListener.onItemClick(getAdapterPosition(), v);
        }

    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public BrandsRecyclerViewAdapter(Context context, ArrayList<BeanlistBrands> bean) {


        this.context = context;
        this.bean = bean;
    }



    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listbrands, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {

      //  holder.icon.setImageResource(mDataset.get(position).get());
        holder.imgbrand.setImageResource(bean.get(position).getImgbrand());
        holder.text1.setText(bean.get(position).getText1());
        holder.text2.setText(bean.get(position).getText2());
        holder.text3.setText(bean.get(position).getText3());
        holder.text4.setText(bean.get(position).getText4());
        holder.text5.setText(bean.get(position).getText5());
        holder.text6.setText(bean.get(position).getText6());



    }



    public void deleteItem(int index) {
        bean.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return bean.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);



    }
}