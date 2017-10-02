package inducesmile.com.androidrecyclerviewgridview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by subaharan on 30/9/17.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {


    private ArrayList<String> numbers;
    private  Context context;

    public DataAdapter(ArrayList<String> countries, Context context) {
        this.numbers = countries;
        this.context=context;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tv_number.setText(numbers.get(i));
    }

    @Override
    public int getItemCount() {
        return numbers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_number;
        public ViewHolder(View view) {
            super(view);

            tv_number = (TextView)view.findViewById(R.id.tv_number);

            tv_number.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    try {
                        String toNumber = tv_number.getText().toString();
                        toNumber = toNumber.replace("+", "").replace(" ", "");

                        Intent sendIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + "" + toNumber + "?body=" + ""));
                        sendIntent.putExtra(Intent.EXTRA_TEXT, "hello");
                        sendIntent.setPackage("com.whatsapp");
                        context.startActivity(sendIntent);

                    }
                    catch (Exception e){
                        Toast.makeText(context,"it may be you dont have whats app",Toast.LENGTH_LONG).show();

                    }

                }
            });
        }
    }
}
