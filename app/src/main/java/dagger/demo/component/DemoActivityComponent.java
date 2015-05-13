package dagger.demo.component;

import dagger.Component;
import dagger.demo.module.ActivityModule;
import dagger.demo.scope.PerActivity;
import dagger.demo.ui.activity.DemoActivity;
import dagger.demo.ui.fragment.DemoFragment;

/**
 * Created by gak on 9/25/14.
 */
@PerActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules = ActivityModule.class
)
public interface DemoActivityComponent extends AbstractActivityComponent {

    void inject(DemoActivity activity);

    void inject(DemoFragment fragment);
}
