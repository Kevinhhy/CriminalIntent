package com.example.kevin.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by kevin on 2016/12/26.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
