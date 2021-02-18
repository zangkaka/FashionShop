package rang.com.fashionshop.home;

import android.content.Context;
import android.graphics.Typeface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

import rang.com.fashionshop.helper.ChildAnimationExample;
import rang.com.fashionshop.R;
import rang.com.fashionshop.helper.SliderLayout;
import rang.com.fashionshop.home.adapter.BrandsRecyclerViewAdapter;
import rang.com.fashionshop.home.adapter.GroomingRecyclerViewAdapter;
import rang.com.fashionshop.home.adapter.TrendingRecyclerViewAdapter;
import rang.com.fashionshop.home.model.BannerDto;
import rang.com.fashionshop.home.model.BeanlistBrands;
import rang.com.fashionshop.home.model.BeanlistGrooming;
import rang.com.fashionshop.home.model.BeanlistTrending;
import rang.com.fashionshop.home.model.Datum;

public class HomeActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener,
        View.OnClickListener {
    SliderLayout mBannerSlider;

    private RecyclerView rv, rv2, rv3;
    private ArrayList<BeanlistGrooming> Bean;
    private GroomingRecyclerViewAdapter baseAdapter;
    private ArrayList<BeanlistTrending> Bean1;
    private TrendingRecyclerViewAdapter baseAdapter1;
    private ArrayList<BeanlistBrands> Bean2;
    private BrandsRecyclerViewAdapter baseAdapter2;
    private Context context;
    Typeface fonts1, fonts2, fonts3, fonts4;
    TextView eshop, shirt1, jeans1, shoes1, slippers1, goggles1, groomingproducts, trendingproducts, topbrands;
    EditText searchtext;
    LinearLayout home0, offer0, fav0, bag0, noti0;
    ImageView home, offer, fav, bag, noti;

    //    *****Grooming string*******
    private int[] IMAGEG = {R.drawable.shoppy_logo, R.drawable.shoppy_logo, R.drawable.shoppy_logo, R.drawable.shoppy_logo};
    private String[] TITLEG = {"Canvera Black Heel", "Canvera Black Heel", "Canvera Black Heel", "Canvera Black Heel"};
    private String[] DESCRIPTIONG = {"1200 Rs", "1200 Rs", "1200 Rs", "1200 Rs"};
    private String[] DATEG = {"200 Rs", "200 Rs", "200 Rs", "200 Rs"};
    private String[] DISCOUNTG = {"15%", "10%", "25%", "50%"};
    private String[] RATINGTEXTG = {"(1234)", "(2322)", "(4322)", "(1223)"};

    //    *****Trending string*******
    private int[] IMAGET = {R.drawable.shoppy_logo, R.drawable.shoppy_logo, R.drawable.shoppy_logo, R.drawable.shoppy_logo};
    private String[] TITLET = {"Canvera Black Heel", "Canvera Black Heel", "Canvera Black Heel", "Canvera Black Heel"};
    private String[] DESCRIPTIONT = {"1200 Rs", "1200 Rs", "1200 Rs", "1200 Rs"};
    private String[] DATET = {"200 Rs", "200 Rs", "200 Rs", "200 Rs"};
    private String[] DISCOUNTT = {"15%", "10%", "25%", "50%"};
    private String[] RATINGTEXTT = {"(1234)", "(2322)", "(4322)", "(1223)"};

    //    *****Brands string*******
    private int[] IMAGEB = {R.drawable.shoppy_logo, R.drawable.shoppy_logo, R.drawable.shoppy_logo};
    private String[] TEXT1 = {"Nike", "Microwaves", "Nike"};
    private String[] TEXT2 = {"Adidas", "Chimneys", "Adidas"};
    private String[] TEXT3 = {"UCB", "Gas Stoves ", "UCB"};
    private String[] TEXT4 = {"Levis", "Water Purifiers", "Levis"};
    private String[] TEXT5 = {"Kuotons", "Electric Cookers", "Kuotons"};
    private String[] TEXT6 = {"See More", "Roti Makers", "See More"};

    private HomeViewModel homeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);


//


        eshop = (TextView) findViewById(R.id.eshop);
        shirt1 = (TextView) findViewById(R.id.shirt1);
        jeans1 = (TextView) findViewById(R.id.jeans1);
        shoes1 = (TextView) findViewById(R.id.shoes1);
        slippers1 = (TextView) findViewById(R.id.slippers1);
        goggles1 = (TextView) findViewById(R.id.goggles1);
        groomingproducts = (TextView) findViewById(R.id.groomingproducts);
        trendingproducts = (TextView) findViewById(R.id.trendingproducts);
        topbrands = (TextView) findViewById(R.id.topbrands);
        searchtext = (EditText) findViewById(R.id.searchtext);

//     *******BOT BAR COLOR *********
        home = (ImageView) findViewById(R.id.home);
        home0 = (LinearLayout) findViewById(R.id.home0);
        offer = (ImageView) findViewById(R.id.offer);
        offer0 = (LinearLayout) findViewById(R.id.offer0);
        fav = (ImageView) findViewById(R.id.fav);
        fav0 = (LinearLayout) findViewById(R.id.fav0);
        bag = (ImageView) findViewById(R.id.bag);
        bag0 = (LinearLayout) findViewById(R.id.bag0);
        noti = (ImageView) findViewById(R.id.noti);
        noti0 = (LinearLayout) findViewById(R.id.noti0);

//        home.setColorFilter(getResources().getColor(R.color.red), android.graphics.PorterDuff.Mode.MULTIPLY);
        home.setColorFilter(getResources().getColor(R.color.boticon), android.graphics.PorterDuff.Mode.MULTIPLY);
        offer.setColorFilter(getResources().getColor(R.color.boticon), android.graphics.PorterDuff.Mode.MULTIPLY);
        fav.setColorFilter(getResources().getColor(R.color.boticon), android.graphics.PorterDuff.Mode.MULTIPLY);
        bag.setColorFilter(getResources().getColor(R.color.boticon), android.graphics.PorterDuff.Mode.MULTIPLY);
        noti.setColorFilter(getResources().getColor(R.color.boticon), android.graphics.PorterDuff.Mode.MULTIPLY);


        home0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickb("1");

            }
        });
        offer0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickb("2");

            }
        });
        fav0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickb("3");

            }
        });
        bag0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickb("4");

            }
        });
        noti0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickb("5");

            }
        });


        fonts1 = Typeface.createFromAsset(getAssets(),
                "fonts/OpenSans-Regular.ttf");
        fonts2 = Typeface.createFromAsset(getAssets(),
                "fonts/OpenSans-Semibold.ttf");

        fonts3 = Typeface.createFromAsset(getAssets(),
                "fonts/Roboto-Medium.ttf");

        fonts4 = Typeface.createFromAsset(getAssets(),
                "fonts/Roboto-Regular.ttf");

        eshop.setTypeface(fonts1);
        searchtext.setTypeface(fonts1);
        shirt1.setTypeface(fonts4);
        jeans1.setTypeface(fonts4);
        shoes1.setTypeface(fonts4);
        slippers1.setTypeface(fonts4);
        goggles1.setTypeface(fonts4);
        groomingproducts.setTypeface(fonts2);
        trendingproducts.setTypeface(fonts2);
        topbrands.setTypeface(fonts2);

//*********RECYCLERVIEWS*********

        rv = (RecyclerView) findViewById(R.id.rv);
        rv2 = (RecyclerView) findViewById(R.id.rv2);
        rv3 = (RecyclerView) findViewById(R.id.rv3);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        rv.setLayoutManager(mLayoutManager);

        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        rv2.setLayoutManager(mLayoutManager1);


        RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        rv3.setLayoutManager(mLayoutManager2);


        Bean = new ArrayList<BeanlistGrooming>();

        for (int i = 0; i < TITLEG.length; i++) {

            BeanlistGrooming bean = new BeanlistGrooming(IMAGEG[i], TITLEG[i], DESCRIPTIONG[i], DATEG[i], DISCOUNTG[i], RATINGTEXTG[i]);
            Bean.add(bean);

        }


        baseAdapter = new GroomingRecyclerViewAdapter(this, HomeActivity.this, Bean) {
        };


        Bean1 = new ArrayList<BeanlistTrending>();

        for (int i = 0; i < TITLET.length; i++) {

            BeanlistTrending bean1 = new BeanlistTrending(IMAGET[i], TITLET[i], DESCRIPTIONT[i], DATET[i], DISCOUNTT[i], RATINGTEXTT[i]);
            Bean1.add(bean1);

        }


        baseAdapter1 = new TrendingRecyclerViewAdapter(this, HomeActivity.this, Bean1) {
        };


        Bean2 = new ArrayList<BeanlistBrands>();

        for (int i = 0; i < IMAGEB.length; i++) {

            BeanlistBrands bean2 = new BeanlistBrands(IMAGEB[i], TEXT1[i], TEXT2[i], TEXT3[i], TEXT4[i], TEXT5[i], TEXT6[i]);
            Bean2.add(bean2);

        }


        baseAdapter2 = new BrandsRecyclerViewAdapter(HomeActivity.this, Bean2) {
        };

        rv.setAdapter(baseAdapter);
        rv2.setAdapter(baseAdapter1);
        rv3.setAdapter(baseAdapter2);


        initBanner();

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(context, "Test", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.slider:
                Toast.makeText(context, "" + mBannerSlider.getCurrentPosition(), Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    /////Private method
    ////////////////////////////////////////////////////////////////////////////////////////////////

    private void initBanner() {
        mBannerSlider = (SliderLayout) findViewById(R.id.slider);
        mBannerSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mBannerSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mBannerSlider.setCustomAnimation(new ChildAnimationExample());
        mBannerSlider.setDuration(5000);
        mBannerSlider.addOnPageChangeListener(this);
        homeViewModel.getBanner().observe(this, new Observer<BannerDto>() {
            @Override
            public void onChanged(BannerDto banner) {
                displayBanner(banner);
            }
        });
    }

    private void displayBanner(BannerDto bannerDto) {
        HashMap<Integer, String> bannerMap = new HashMap<>();
        for (Datum item : bannerDto.getData()) {
            bannerMap.put(item.getId(), item.getMobileUrl());
        }

        for (String name : bannerMap.values()) {
            TextSliderView textSliderView = new TextSliderView(this);
            Picasso picasso = Picasso.with(this);
            textSliderView.setPicasso(picasso);
            textSliderView.image(name);
            mBannerSlider.addSlider(textSliderView);
        }
    }

    private void clickb(String s) {

        home.setColorFilter(getResources().getColor(R.color.boticon), android.graphics.PorterDuff.Mode.MULTIPLY);
        offer.setColorFilter(getResources().getColor(R.color.boticon), android.graphics.PorterDuff.Mode.MULTIPLY);
        fav.setColorFilter(getResources().getColor(R.color.boticon), android.graphics.PorterDuff.Mode.MULTIPLY);
        bag.setColorFilter(getResources().getColor(R.color.boticon), android.graphics.PorterDuff.Mode.MULTIPLY);
        noti.setColorFilter(getResources().getColor(R.color.boticon), android.graphics.PorterDuff.Mode.MULTIPLY);


        if (s.equalsIgnoreCase("1")) {

            home.setColorFilter(getResources().getColor(R.color.red), android.graphics.PorterDuff.Mode.MULTIPLY);

        } else if (s.equalsIgnoreCase("2")) {

            offer.setColorFilter(getResources().getColor(R.color.red), android.graphics.PorterDuff.Mode.MULTIPLY);

        } else if (s.equalsIgnoreCase("3")) {

            fav.setColorFilter(getResources().getColor(R.color.red), android.graphics.PorterDuff.Mode.MULTIPLY);

        } else if (s.equalsIgnoreCase("4")) {

            bag.setColorFilter(getResources().getColor(R.color.red), android.graphics.PorterDuff.Mode.MULTIPLY);

        } else if (s.equalsIgnoreCase("5")) {

            noti.setColorFilter(getResources().getColor(R.color.red), android.graphics.PorterDuff.Mode.MULTIPLY);

        }

    }

}
