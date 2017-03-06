package ge.gchalauri.weatherapp.weatherapi.base.di.api;


import ge.gchalauri.weatherapp.weatherapi.base.di.base.BaseComponent;

/**
 * Created by zuluft on 11/27/16.
 */
public interface HasComponent<Component extends BaseComponent> {
    Component provideComponent();

    Component getComponent();
}
