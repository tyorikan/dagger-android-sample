package dagger.demo.ui.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import dagger.demo.R;
import dagger.demo.ui.activity.DemoActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class DemoFragment extends Fragment {

    private static final String TAG = DemoFragment.class.getSimpleName();

    @Inject
    SharedPreferences mSharedPreferences;
    @Inject
    Activity mActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((DemoActivity) getActivity()).getComponent().inject(this);
        Log.d(TAG, mSharedPreferences.toString());
        Log.d(TAG, mActivity.toString());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_demo, container, false);
    }
}
