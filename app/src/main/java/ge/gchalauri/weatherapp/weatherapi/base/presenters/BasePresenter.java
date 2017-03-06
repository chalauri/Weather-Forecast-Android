package ge.gchalauri.weatherapp.weatherapi.base.presenters;



import ge.gchalauri.weatherapp.weatherapi.base.views.IView;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by zuluft on 10/25/16.
 */

public abstract class BasePresenter<View extends IView> implements IPresenter<View> {

    protected View mView;

    private CompositeSubscription mCompositeSubscription;

    private boolean mIsFirstAttach = true;

    @Override
    public final void attach(View view) {
        this.mView = view;
        onAttach();
        if (mIsFirstAttach) {
            onFirstAttach();
            mIsFirstAttach = false;
        }
    }

    protected void onAttach() {

    }

    protected void registerSubscription(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

    protected void onFirstAttach() {

    }

    @Override
    public final void detachView() {
        onDetach();
        if (mCompositeSubscription != null) {
            mCompositeSubscription.clear();
        }
        mView = null;
    }

    protected void onDetach() {

    }

    protected View getView() {
        return mView;
    }
}
