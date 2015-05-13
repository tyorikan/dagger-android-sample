package dagger.demo.module;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import dagger.demo.scope.PerActivity;

/**
 * A module to wrap the Activity state and expose it to the graph.
 */
@Module
public final class ActivityModule {

    private final Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides
    @PerActivity
    Activity provideActivity() {
        return mActivity;
    }
}
