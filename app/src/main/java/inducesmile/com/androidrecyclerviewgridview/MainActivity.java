package inducesmile.com.androidrecyclerviewgridview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private ArrayList numbers;
    private GridLayoutManager lLayout,gLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(null);

        Toolbar topToolBar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(topToolBar);
        topToolBar.setLogo(R.drawable.logo);
        topToolBar.setLogoDescription(getResources().getString(R.string.logo_desc));


    /*    DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

        View myView = findViewById(R.id.imgright);
        int imgWidth = myView.getWidth();
        int imgHeight = (int)(imgWidth * 1.5f);
        ViewGroup.LayoutParams lp = myView.getLayoutParams();
        lp.width = myView.getWidth();
        lp.height = imgHeight ;
        myView.setLayoutParams(lp);*/
//        myView.getLayoutParams().width = displaymetrics.widthPixels * 1.5f;

        List<ItemObject> menuRowListItem=getMenuItemList();
        gLayout=new GridLayoutManager(MainActivity.this,2);


        RecyclerView rViewMenu = (RecyclerView)findViewById(R.id.card_recycler_grid);
        rViewMenu.setHasFixedSize(true);
        rViewMenu.setLayoutManager(gLayout);

        RecyclerViewMenuAdapter rcAdapterMenu = new RecyclerViewMenuAdapter(MainActivity.this, menuRowListItem);
        rViewMenu.setAdapter(rcAdapterMenu);




        List<ItemObject> rowListItem = getAllItemList();
        lLayout = new GridLayoutManager(MainActivity.this, 3);

        RecyclerView rView = (RecyclerView)findViewById(R.id.recycler_view);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(MainActivity.this, rowListItem);
        rView.setAdapter(rcAdapter);






        initViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if(id == R.id.action_refresh){
            Toast.makeText(MainActivity.this, "Refresh App", Toast.LENGTH_LONG).show();
        }
        if(id == R.id.action_new){
            Toast.makeText(MainActivity.this, "Create Text", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    private List<ItemObject> getAllItemList(){

        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("United States", R.drawable.one));
        allItems.add(new ItemObject("Canada", R.drawable.two));
        allItems.add(new ItemObject("United Kingdom", R.drawable.three));
        allItems.add(new ItemObject("Germany", R.drawable.four));
        allItems.add(new ItemObject("Germany", R.drawable.five));
        allItems.add(new ItemObject("Germany", R.drawable.six));


        return allItems;
    }

    private List<ItemObject> getMenuItemList(){

        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("Products to Sale", R.drawable.ic_monetization_on_black_24dp));
        allItems.add(new ItemObject("My Products", R.drawable.ic_accessibility_black_24dp));

        allItems.add(new ItemObject("Browse Shops", R.drawable.ic_shopping_basket_black_24dp));
        allItems.add(new ItemObject("Find Buyers", R.drawable.ic_shopping_cart_black_24dp));

        return allItems;
    }



    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        numbers = new ArrayList<>();
        numbers.add("9901188849");
        numbers.add("8220251562");
        numbers.add("1234567890");
        numbers.add("8220251562");
        numbers.add("9901188849");
        RecyclerView.Adapter adapter = new DataAdapter(numbers, MainActivity.this);
        recyclerView.setAdapter(adapter);

    }
}
