package com.uber.rib.root.LoggedOut;

//import android.support.annotation.Nullable;

import android.util.Log;

import com.uber.rib.core.Bundle;
import com.uber.rib.core.Interactor;
import com.uber.rib.core.RibInteractor;
import com.uber.rib.core.Presenter;
import com.uber.rib.core.Router;

import org.reactivestreams.Subscription;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Coordinates Business Logic for {@link LoggedOutScope}.
 * <p>
 * TODO describe the logic of this scope.
 */
@RibInteractor
public class LoggedOutInteractor
  extends Interactor<LoggedOutInteractor.LoggedOutPresenter, LoggedOutRouter> {

  @Inject LoggedOutPresenter presenter;

  private CompositeDisposable disposables = new CompositeDisposable();

  @Override
  protected void didBecomeActive(@Nullable Bundle savedInstanceState) {
    super.didBecomeActive(savedInstanceState);

    Disposable disposable = presenter
      .loginName()
      .subscribe(new Consumer<String>() {
        @Override
        public void accept(String name) throws Exception {
          Log.d("MOO", name);
        }
      });
    disposables.add(disposable);
  }

  @Override
  protected void willResignActive() {
    super.willResignActive();
    disposables.clear();

    // TODO: Perform any required clean up here, or delete this method entirely if not needed.
  }


  /**
   * Presenter interface implemented by this RIB's view.
   */
  interface LoggedOutPresenter {
    Observable<String> loginName();
  }
}
