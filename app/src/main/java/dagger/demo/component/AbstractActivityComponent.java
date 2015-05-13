package dagger.demo.component;

import android.app.Activity;

import dagger.Component;
import dagger.demo.module.ActivityModule;
import dagger.demo.scope.PerActivity;

/**
 * A base component upon which fragment's components may depend.
 * Activity-level components should extend this component.
 */
@PerActivity // Subtypes of ActivityComponent should be decorated with @PerActivity.
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface AbstractActivityComponent {

    Activity activity(); // Expose the activity to sub-graphs.
}
