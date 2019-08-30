//
//  LoggedInRouter.swift
//  TicTacToe
//
//  Created by Shawn Lu on 8/28/19.
//  Copyright © 2019 Uber. All rights reserved.
//

import RIBs

protocol LoggedInInteractable: Interactable, OffGameListener, TicTacToeListener {
  var router: LoggedInRouting? { get set }
  var listener: LoggedInListener? { get set }
}

protocol LoggedInViewControllable: ViewControllable {
  func present(viewController: ViewControllable)
  func dismiss(viewController: ViewControllable)
}

final class LoggedInRouter: Router<LoggedInInteractable>, LoggedInRouting {

  // TODO: Constructor inject child builder protocols to allow building children.
  init(
    interactor: LoggedInInteractable,
    viewController: LoggedInViewControllable,
    offGameBuilder: OffGameBuildable,
    ticTacToeBuilder: TicTacToeBuildable
  ) {
    self.viewController = viewController
    self.offGameBuilder = offGameBuilder
    self.ticTacToeBuilder = ticTacToeBuilder
    super.init(interactor: interactor)
    interactor.router = self
  }

  func cleanupViews() {
    if let currentChild = currentChild {
      viewController.dismiss(viewController: currentChild.viewControllable)
    }
  }

  override func didLoad() {
    super.didLoad()
    attachOffGame()
  }

  // MARK: - Private

  private let viewController: LoggedInViewControllable
  private var currentChild: ViewableRouting?

  private let offGameBuilder: OffGameBuildable
  private var offGame: ViewableRouting?

  private let ticTacToeBuilder: TicTacToeBuildable
  private var ticTacToe: ViewableRouting?

  private func attachOffGame() {
    let offGame = offGameBuilder.build(withListener: interactor)
    self.offGame = offGame

    self.currentChild = offGame
    attachChild(offGame)
    viewController.present(viewController: offGame.viewControllable)
  }

  func routeToTicTacToe() {
    if let offGame = offGame {
      detachChild(offGame)
      viewController.dismiss(viewController: offGame.viewControllable)
      self.offGame = nil
    }

    let ticTacToe = ticTacToeBuilder.build(withListener: interactor)
    self.ticTacToe = ticTacToe
    attachChild(ticTacToe)
  }
}
