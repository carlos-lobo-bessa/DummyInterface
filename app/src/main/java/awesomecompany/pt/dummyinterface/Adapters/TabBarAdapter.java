package awesomecompany.pt.dummyinterface.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import awesomecompany.pt.dummyinterface.Fragments.PickFoodFragment;
import awesomecompany.pt.dummyinterface.R;

public class TabBarAdapter  extends FragmentPagerAdapter {

    private Context context;

    public TabBarAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;

    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return PickFoodFragment.newInstance(true);
            case 1:
            default:
                return PickFoodFragment.newInstance(false);
        }
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return  context.getString(R.string.first_tab);
            case 1:
            default:
                return context.getString(R.string.second_tab);
        }
    }
}
