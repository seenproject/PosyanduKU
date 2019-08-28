package satella.app.posyanduku.posyandu;

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

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import satella.app.posyanduku.Anak_Package.note.NoteActivity;
import satella.app.posyanduku.MainActivity;
import satella.app.posyanduku.R;
import satella.app.posyanduku.adapter.SliderPagerAdapter;
import satella.app.posyanduku.data_pages.DataBalitaActivity;
import satella.app.posyanduku.models.Slider;
import satella.app.posyanduku.posyandu.data.DataBayiActivity;
import satella.app.posyanduku.posyandu.profil.ProfilPosyanduActivity;
import satella.app.posyanduku.posyandu.timbang.TimbangActivity;
import satella.app.posyanduku.profile.data_profile;

public class PosyanduMainActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager sliderPager;
    private TabLayout tbLayout;
    private List<Slider> lstSlide;
    private FloatingActionButton fab;

    private ImageView imgData, imgTimbang, imgProfil, imgCalender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_posyandu_main);

        sliderPager = findViewById(R.id.slider_pager);
        tbLayout = findViewById(R.id.indicator);
        fab = findViewById(R.id.fab);
        imgTimbang = findViewById(R.id.img_timbang);
        imgCalender = findViewById(R.id.img_calender);
        imgData = findViewById(R.id.img_data);
        imgProfil = findViewById(R.id.img_profil);

        imgProfil.setOnClickListener(this);
        imgTimbang.setOnClickListener(this);
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
        timer.scheduleAtFixedRate(new PosyanduMainActivity.SliderTimer(),4000,5000);
    }

    @Override
    public void onClick(View v) {
        if (v == imgData){
            Intent intent = new Intent(PosyanduMainActivity.this, DataBayiActivity.class);
            startActivity(intent);
        }
        else if (v == imgTimbang){
            Intent intent = new Intent(PosyanduMainActivity.this, TimbangActivity.class);
            startActivity(intent);
        } else if (v == imgProfil) {
            Intent intent = new Intent(PosyanduMainActivity.this, ProfilPosyanduActivity.class);
            startActivity(intent);
        }
        else if (v == imgCalender) {
            Intent intent = new Intent(PosyanduMainActivity.this, TimbangActivity.class);
            startActivity(intent);
        }
    }

    class SliderTimer extends TimerTask {
        @Override
        public void run() {
            PosyanduMainActivity.this.runOnUiThread(new Runnable() {
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
