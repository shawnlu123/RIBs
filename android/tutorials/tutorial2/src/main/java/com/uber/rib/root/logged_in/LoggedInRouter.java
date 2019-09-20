package com.uber.rib.root.logged_in;

import android.view.View;

import com.uber.rib.core.Router;
import com.uber.rib.root.RootView;
import com.uber.rib.root.logged_in.off_game.OffGameBuilder;
import com.uber.rib.root.logged_in.tic_tac_toe.TicTacToeBuilder;

/**
 * Adds and removes children of {@link LoggedInBuilder.LoggedInScope}.
 * <p>
 * TODO describe the possible child configurations of this scope.
 */
public class LoggedInRouter
  extends Router<LoggedInInteractor, LoggedInBuilder.Component> {

  private RootView rootView;
  private OffGameBuilder offGameBuilder;
  private TicTacToeBuilder ticTacToeBuilder;

  public LoggedInRouter(
    LoggedInInteractor interactor,
    LoggedInBuilder.Component component,
    RootView rootView,
    OffGameBuilder offGameBuilder,
    TicTacToeBuilder ticTacToeBuilder
  ) {
    super(interactor, component);
    this.rootView = rootView;
    this.offGameBuilder = offGameBuilder;
    this.ticTacToeBuilder = ticTacToeBuilder;
  }
}
