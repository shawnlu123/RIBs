//
//  OffGameInteractor.swift
//  TicTacToe
//
//  Created by Shawn Lu on 8/28/19.
//  Copyright © 2019 Uber. All rights reserved.
//

import RIBs
import RxSwift

protocol OffGameRouting: ViewableRouting {
  // TODO: Declare methods the interactor can invoke to manage sub-tree via the router.
}

protocol OffGamePresentable: Presentable {
  var listener: OffGamePresentableListener? { get set }
  // TODO: Declare methods the interactor can invoke the presenter to present data.
}

protocol OffGameListener: class {
  func startTicTacToe()
}

final class OffGameInteractor:
  PresentableInteractor<OffGamePresentable>,
  OffGameInteractable,
  OffGamePresentableListener
{
  weak var router: OffGameRouting?
  weak var listener: OffGameListener?

  // TODO: Add additional dependencies to constructor. Do not perform any logic
  // in constructor.
  override init(presenter: OffGamePresentable) {
    super.init(presenter: presenter)
    presenter.listener = self
  }

  override func didBecomeActive() {
    super.didBecomeActive()
    // TODO: Implement business logic here.
  }

  override func willResignActive() {
    super.willResignActive()
    // TODO: Pause any business logic.
  }

  func didTapStartGame() {
    listener?.startTicTacToe()
  }
}
