package dagger.demo;

import android.app.Application;

import dagger.demo.module.ApplicationModule;
import dagger.demo.module.component.ApplicationComponent;
import dagger.demo.module.component.DaggerApplicationComponent;

/**
 * Created by gak on 9/25/14.
 */
public class App extends Application {

    private static App sInstance;
    private ApplicationComponent mComponent;

    public App() {
        sInstance = this;
    }

    public static App get() {
        return sInstance;
    }

    private void setupGraph() {
        mComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        mComponent.inject(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setupGraph();
    }

    public ApplicationComponent getComponent() {
        return mComponent;
    }
}
