package ge.gchalauri.weatherapp.weatherapi.domain.usecases.base;

import ge.gchalauri.weatherapp.weatherapi.domain.repositories.Repository;

/**
 * Created by giodz on 3/6/2017.
 */

public abstract class UseCaseWithRepository<Result, Argument>
        implements IUseCase<Result, Argument> {

    protected Repository mRepository;

    public UseCaseWithRepository(Repository repository) {
        this.mRepository = repository;
    }
}
