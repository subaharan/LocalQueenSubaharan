package inducesmile.com.androidrecyclerviewgridview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {

    private List<ItemObject> itemList;
    private Context context;

    public RecyclerViewAdapter(Context context, List<ItemObject> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        if(position==5) {
            holder.card_view.getBackground().setAlpha(45);
            holder.countryPhoto.setBackgroundResource(R.drawable.ic_shopping_cart_black_24dp);
            holder.view2.setVisibility(View.VISIBLE);

        }else {
//        holder.countryName.setText(itemList.get(position).getName());
            holder.countryPhoto.setImageResource(itemList.get(position).getPhoto());
        }
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
