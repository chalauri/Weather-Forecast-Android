package ge.gchalauri.weatherapp.weatherapi.base.navigation;

import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import java.util.Stack;

/**
 * Created by giodz on 12/7/2016.
 */

public class SafeFragmentTransactor implements Application.ActivityLifecycleCallbacks {
    private boolean mReadyToCommit;
    private boolean mWasViewCreated;
    private FragmentManager mFragmentManager;
    private Stack<Transition> mFragmentTransitionsStack;

    private Class<? extends Activity> mHostActivityClass;

    public void attachHostActivityClass(Class<? extends Activity> clazz) {
        mHostActivityClass = clazz;
    }

    public SafeFragmentTransactor(Application application) {
        application.registerActivityLifecycleCallbacks(this);
        mFragmentTransitionsStack = new Stack<>();
        mWasViewCreated = true;
    }

    public void registerFragmentTransition(Transition transition) {
        mFragmentTransitionsStack.push(transition);
        invokeTransactions();
    }

    private synchronized void invokeTransactions() {
        if (mWasViewCreated && mFragmentManager != null) {
            while (mReadyToCommit && mFragmentTransitionsStack.size() != 0) {
                Transition transition = mFragmentTransitionsStack.pop();
                if (transition instanceof FragmentTransitionHandler) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    ((FragmentTransitionHandler) transition)
                            .onTransitionAvailable(fragmentTransaction);
                    fragmentTransaction.commit();
                } else {
                    ((TransitionHandler) transition).onTransitionAvailable(mFragmentManager);
                }
            }
        }
    }

    private void allowTransactions(Activity activity) {
        mReadyToCommit = true;
        attach(activity.getFragmentManager());
        invokeTransactions();
    }


    private boolean wasAttachedActivityCallback(Activity activity) {
        if (activity.getClass() != mHostActivityClass) {
            return false;
        }
        return true;
    }

    private void checkActivityAndAllowTransactions(Activity activity) {
        if (wasAttachedActivityCallback(activity)) {
            allowTransactions(activity);
        }
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (wasAttachedActivityCallback(activity)) {
            mWasViewCreated = true;
            allowTransactions(activity);
        }
    }

    @Override
    public void onActivityStarted(Activity activity) {
        checkActivityAndAllowTransactions(activity);
    }

    @Override
    public void onActivityResumed(Activity activity) {
        checkActivityAndAllowTransactions(activity);
    }

    private void disallowTransactions(Activity activity) {
        mReadyToCommit = false;
        detach();
    }

    private void checkActivityAndDisallowTransactions(Activity activity) {
        if (wasAttachedActivityCallback(activity)) {
            disallowTransactions(activity);
        }
    }

    @Override
    public void onActivityPaused(Activity activity) {
        checkActivityAndDisallowTransactions(activity);
    }

    @Override
    public void onActivityStopped(Activity activity) {
        checkActivityAndDisallowTransactions(activity);
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        checkActivityAndDisallowTransactions(activity);
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        if (wasAttachedActivityCallback(activity)) {
            mWasViewCreated = false;
            disallowTransactions(activity);
        }
    }

    private void attach(FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
    }

    private void detach() {
        mFragmentManager = null;
    }

    @FunctionalInterface
    public interface FragmentTransitionHandler extends Transition {
        void onTransitionAvailable(FragmentTransaction fragmentTransaction);
    }

    @FunctionalInterface
    public interface TransitionHandler extends Transition {
        void onTransitionAvailable(FragmentManager fragmentManager);
    }

    public interface Transition {
    }
}
