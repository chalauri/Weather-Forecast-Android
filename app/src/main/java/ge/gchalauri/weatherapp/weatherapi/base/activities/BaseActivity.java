package ge.gchalauri.weatherapp.weatherapi.base.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;



import javax.inject.Inject;

import ge.gchalauri.weatherapp.weatherapi.base.annotations.LayoutResourceId;
import ge.gchalauri.weatherapp.weatherapi.base.api.HasPresenter;
import ge.gchalauri.weatherapp.weatherapi.base.di.api.HasComponent;
import ge.gchalauri.weatherapp.weatherapi.base.di.base.BasePresentationComponent;
import ge.gchalauri.weatherapp.weatherapi.base.navigation.SafeFragmentTransactor;
import ge.gchalauri.weatherapp.weatherapi.base.presenters.BasePresenter;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


/**
 * Created by zuluft on 11/27/16.
 */
public abstract class BaseActivity<Component extends BasePresentationComponent,
        Presenter extends BasePresenter>
        extends AppCompatActivity
        implements HasComponent<Component>, HasPresenter<Presenter> {

    //Presenter Reference, which is going to be injected when ComponentLoader finishes work
    protected Presenter mPresenter;

    //Component which is created by Loader
    private Component mComponent;

    //SafeFragmentTransactor reference
    protected SafeFragmentTransactor mSafeFragmentTransactor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //creates SafeFragmentTransactor;
        createSafeFragmentTransactor();
        //gets LayoutResourceId Annotation from the actual class
        LayoutResourceId layoutResourceId = this.getClass().getAnnotation(LayoutResourceId.class);
        //if Annotation found, its argument passed to setContentView method
        if (layoutResourceId != null) {
            setContentView(layoutResourceId.value());
        }
        //invokes renderView abstract method
        renderView(savedInstanceState);
        mComponent = provideComponent();
        //injects actual activity's instance to Component ObjectGraph
        mComponent.inject(this);
        onInjectionFinished(savedInstanceState);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    //initializes SafeFragmentTransactor
    private void createSafeFragmentTransactor() {
        mSafeFragmentTransactor = new SafeFragmentTransactor(getApplication());
        mSafeFragmentTransactor.attachHostActivityClass(this.getClass());
    }

    //invoked exactly after setContentView
    protected abstract void renderView(Bundle savedInstanceState);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //detaches activity object from presenter, to avoid memory leaks
        mPresenter.detachView();
    }

    //invoked by Dagger2 Component
    @Override
    @Inject
    public void injectPresenter(Presenter presenter) {
        mPresenter = presenter;
    }

    //invoked by onPostCreate lifecycle method, when Component loader had already finished his job
    protected abstract void onInjectionFinished(Bundle savedInstanceState);

    @Override
    public Component getComponent() {
        return mComponent;
    }
}
