package dagger.demo.module.component;

import android.app.Application;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Component;
import dagger.demo.App;
import dagger.demo.module.ApplicationModule;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(
        modules = ApplicationModule.class
)
public interface ApplicationComponent {

    // Field injections of any dependencies of the DemoApplication
    void inject(App application);

    // Exported for child-components.
    Application application();

    SharedPreferences sharedPreferences();
}
