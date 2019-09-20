package com.uber.rib.root.logged_in;

import com.uber.rib.core.Bundle;
import com.uber.rib.core.EmptyPresenter;
import com.uber.rib.core.Interactor;
import com.uber.rib.core.RibInteractor;
import com.uber.rib.core.Router;
import com.uber.rib.root.logged_in.off_game.OffGameInteractor;

import javax.inject.Inject;

import androidx.annotation.Nullable;

/**
 * Coordinates Business Logic for {@link LoggedInScope}.
 *
 * TODO describe the logic of this scope.
 */
@RibInteractor
public class LoggedInInteractor extends Interactor<EmptyPresenter, LoggedInRouter> {

  @Override
  protected void didBecomeActive(@Nullable Bundle savedInstanceState) {
    super.didBecomeActive(savedInstanceState);

    getRouter().attachOffGame();
  }

  @Override
  protected void willResignActive() {
    super.willResignActive();

    // TODO: Perform any required clean up here, or delete this method entirely if not needed.
  }

  class OffGameListener implements OffGameInteractor.Listener {

    @Override
    public void onStartGame() {
      getRouter().detachOffGame();
      getRouter().attachTicTacToe();
    }
  }
}
