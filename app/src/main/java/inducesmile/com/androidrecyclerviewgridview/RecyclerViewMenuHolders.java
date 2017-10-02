package inducesmile.com.androidrecyclerviewgridview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by subaharan on 2/10/17.
 */

public class RecyclerViewMenuHolders extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView countryName;
    public ImageView countryPhoto;

    public RecyclerViewMenuHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        countryName = (TextView)itemView.findViewById(R.id.name);
        countryPhoto = (ImageView)itemView.findViewById(R.id.country_photo);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Clicked Country Position = " + getPosition(), Toast.LENGTH_SHORT).show();
    }
}