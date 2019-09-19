package com.uber.rib.root.logged_out;

import com.uber.rib.core.Bundle;
import com.uber.rib.core.Interactor;
import com.uber.rib.core.RibInteractor;
import com.uber.rib.root.logged_out.LoggedOutBuilder.LoggedOutScope;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Coordinates Business Logic for {@link LoggedOutScope}.
 */
@RibInteractor
public class LoggedOutInteractor
  extends Interactor<LoggedOutInteractor.LoggedOutPresenter, LoggedOutRouter>
{

  public interface Listener {
    void login(String userName);
  }

  @Inject Listener listener;
  @Inject LoggedOutPresenter presenter;

  @Override
  protected void didBecomeActive(@Nullable Bundle savedInstanceState) {
    super.didBecomeActive(savedInstanceState);
    Disposable disposable = presenter
      .loginName()
      .subscribe(new Consumer<String>() {
        @Override
        public void accept(String name) throws Exception {
          if (!name.isEmpty()) {
            listener.login(name);
          }
        }
      });
  }

  /**
   * Presenter interface implemented by this RIB's view.
   */
  interface LoggedOutPresenter {
    Observable<String> loginName();
  }
}
