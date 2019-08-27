package satella.app.posyanduku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import satella.app.posyanduku.adapter.SliderPagerAdapter;
import satella.app.posyanduku.data_pages.DataBalitaActivity;
import satella.app.posyanduku.models.Slider;
import satella.app.posyanduku.note.NoteActivity;
import satella.app.posyanduku.posyandu.read_profile;
import satella.app.posyanduku.profile.data_profile;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager sliderPager;
    private TabLayout tbLayout;
    private List<Slider> lstSlide;
    private FloatingActionButton fab;

    private ImageView imgData, imgAbout, imgProfil, imgCalender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        sliderPager = findViewById(R.id.slider_pager);
        tbLayout = findViewById(R.id.indicator);
        fab = findViewById(R.id.fab);
        imgAbout = findViewById(R.id.img_about);
        imgCalender = findViewById(R.id.img_calender);
        imgData = findViewById(R.id.img_data);
        imgProfil = findViewById(R.id.img_profil);

        fab.setOnClickListener(this);
        imgProfil.setOnClickListener(this);
        imgData.setOnClickListener(this);
        imgCalender.setOnClickListener(this);
        imgData.setOnClickListener(this);

        lstSlide = new ArrayList<>();
        lstSlide.add(new Slider(R.drawable.header1,""));
        lstSlide.add(new Slider(R.drawable.header2,""));
        lstSlide.add(new Slider(R.drawable.header3,""));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this, lstSlide);
        sliderPager.setAdapter(adapter);
        tbLayout.setupWithViewPager(sliderPager,false);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MainActivity.SliderTimer(),4000,5000);
    }

    @Override
    public void onClick(View v) {
        if (v == fab){
            Intent intent = new Intent(MainActivity.this, NoteActivity.class);
            startActivity(intent);
        }
        else if (v == imgData){
            Intent intent = new Intent(MainActivity.this, DataBalitaActivity.class);
            startActivity(intent);
        } else if (v == imgProfil) {
            Intent intent = new Intent(MainActivity.this, data_profile.class);
            startActivity(intent);
        }
        else if (v == imgCalender) {
            Intent intent = new Intent(MainActivity.this, read_profile.class);
            startActivity(intent);
        }
    }

    class SliderTimer extends TimerTask{
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderPager.getCurrentItem() < lstSlide.size()-1){
                        sliderPager.setCurrentItem(sliderPager.getCurrentItem()+1);
                    }
                    else
                        sliderPager.setCurrentItem(0);
                }
            });
        }
    }
}
