package ge.gchalauri.weatherapp.weatherapi.base.di.base;


import ge.gchalauri.weatherapp.weatherapi.base.di.api.HasComponent;

/**
 * Created by zuluft on 11/27/16.
 */
public interface BasePresentationComponent<ComponentProvider extends HasComponent> extends BaseComponent {
    void inject(ComponentProvider destination);
}
