package ge.gchalauri.weatherapp.weatherapi.presentation.home;

import android.app.ProgressDialog;
import android.os.Bundle;

import ge.gchalauri.weatherapp.weatherapi.R;
import ge.gchalauri.weatherapp.weatherapi.application.AppComponent;
import ge.gchalauri.weatherapp.weatherapi.base.activities.BaseActivity;
import ge.gchalauri.weatherapp.weatherapi.base.annotations.LayoutResourceId;
import ge.gchalauri.weatherapp.weatherapi.base.di.api.HasComponent;
import ge.gchalauri.weatherapp.weatherapi.base.di.scopes.PerActivity;

@PerActivity
@LayoutResourceId(R.layout.activity_home)
public class HomeScreenActivity
        extends
        BaseActivity<HomeScreenComponent, HomeScreenPresenter>
        implements
        HomeScreenView {

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    protected void renderView(Bundle savedInstanceState) {

    }

    @Override
    protected void onInjectionFinished(Bundle savedInstanceState) {
        mPresenter.attach(this);
    }

    @Override
    public HomeScreenComponent provideComponent() {
        HasComponent<AppComponent> hasComponent =
                (HasComponent<AppComponent>) getApplication();
        return DaggerHomeScreenComponent
                .builder()
                .appComponent(hasComponent.getComponent())
                .build();
    }

    @Override
    public void showLoader() {
        mProgressDialog = ProgressDialog.show(this,
                getString(R.string.loading),
                getString(R.string.please_wait));
    }

    @Override
    public void hideLoader() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }
}
