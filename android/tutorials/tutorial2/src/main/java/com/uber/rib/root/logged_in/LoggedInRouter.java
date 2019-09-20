package com.uber.rib.root.logged_in;

import android.view.View;

import com.uber.rib.core.Router;
import com.uber.rib.root.RootView;
import com.uber.rib.root.logged_in.off_game.OffGameBuilder;
import com.uber.rib.root.logged_in.off_game.OffGameRouter;
import com.uber.rib.root.logged_in.tic_tac_toe.TicTacToeBuilder;
import com.uber.rib.root.logged_in.tic_tac_toe.TicTacToeRouter;

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

  private OffGameRouter offGameRouter;
  private TicTacToeRouter ticTacToeRouter;

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

  void attachOffGame() {
    offGameRouter = offGameBuilder.build(rootView);
    attachChild(offGameRouter);
    rootView.addView(offGameRouter.getView());
  }

  void detachOffGame() {
    if (offGameRouter != null) {
      detachChild(offGameRouter);
      rootView.removeView(offGameRouter.getView());
      offGameRouter = null;
    }
  }

  void attachTicTacToe() {
    ticTacToeRouter = ticTacToeBuilder.build(rootView);
    attachChild(ticTacToeRouter);
    rootView.addView(ticTacToeRouter.getView());
  }

  void detachTicTacToe() {
    if (ticTacToeRouter == null) return;

    detachChild(ticTacToeRouter);
    rootView.removeView(ticTacToeRouter.getView());
    ticTacToeRouter = null;
  }
}
