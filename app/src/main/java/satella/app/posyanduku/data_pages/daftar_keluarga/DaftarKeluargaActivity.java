package satella.app.posyanduku.data_pages.daftar_keluarga;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import satella.app.posyanduku.R;
import satella.app.posyanduku.adapter.DaftarPagerAdapter;

public class DaftarKeluargaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_keluarga);


        if (getSupportActionBar() !=null){
            getSupportActionBar().setTitle("Daftar keluarga");
        }
        initView();

    }

    private void initView(){
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        ViewPager viewPager = findViewById(R.id.view_pager);
        setUpViewPager(viewPager);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager viewPager){
        DaftarPagerAdapter daftarPagerAdapter = new DaftarPagerAdapter(getSupportFragmentManager());
        daftarPagerAdapter.addFragment(new AnakFragment(), getString(R.string.anak));
        daftarPagerAdapter.addFragment(new BapakFragment(), getString(R.string.bapak));
        daftarPagerAdapter.addFragment(new IbuFargment(), getString(R.string.ibu));
        viewPager.setAdapter(daftarPagerAdapter);
    }
}
