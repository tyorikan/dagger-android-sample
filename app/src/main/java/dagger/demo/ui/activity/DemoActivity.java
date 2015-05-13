package dagger.demo.ui.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import javax.inject.Inject;

import dagger.demo.App;
import dagger.demo.R;
import dagger.demo.component.DaggerDemoActivityComponent;
import dagger.demo.component.DemoActivityComponent;
import dagger.demo.module.ActivityModule;
import dagger.demo.ui.fragment.DemoFragment;

public class DemoActivity extends Activity {

    private static final String TAG = DemoActivity.class.getSimpleName();

    @Inject
    SharedPreferences mSharedPreferences;

    private DemoActivityComponent mComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupGraph();
        Log.d(TAG, mSharedPreferences.toString());

        setContentView(R.layout.activity_demo);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new DemoFragment())
                    .commit();
        }
    }

    private void setupGraph() {
        mComponent = DaggerDemoActivityComponent.builder()
                .applicationComponent(App.get().getComponent())
                .activityModule(new ActivityModule(this))
                .build();
        mComponent.inject(this);
    }

    public DemoActivityComponent getComponent() {
        return mComponent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.demo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
