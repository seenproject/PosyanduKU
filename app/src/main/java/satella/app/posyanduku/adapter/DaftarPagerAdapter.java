package satella.app.posyanduku.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class DaftarPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragment = new ArrayList<>();
    private List<String> mTitleFragment = new ArrayList<>();


    public DaftarPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }

    public void addFragment(Fragment fragment, String title){
        mFragment.add(fragment);
        mTitleFragment.add(title);
    }
    @Override
    public CharSequence getPageTitle(int position){
        return mTitleFragment.get(position);
    }
}
