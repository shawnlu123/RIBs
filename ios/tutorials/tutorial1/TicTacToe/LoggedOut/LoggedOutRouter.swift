//
//  LoggedOutRouter.swift
//  TicTacToe
//
//  Created by Shawn Lu on 8/28/19.
//  Copyright © 2019 Uber. All rights reserved.
//

import RIBs

protocol LoggedOutInteractable: Interactable {
  var router: LoggedOutRouting? { get set }
  var listener: LoggedOutListener? { get set }
}

protocol LoggedOutViewControllable: ViewControllable {
  // TODO: Declare methods the router invokes to manipulate the view hierarchy.
}

final class LoggedOutRouter:
  ViewableRouter<LoggedOutInteractable, LoggedOutViewControllable>,
  LoggedOutRouting
{

  // TODO: Constructor inject child builder protocols to allow building children.
  override init(interactor: LoggedOutInteractable, viewController: LoggedOutViewControllable) {
    super.init(interactor: interactor, viewController: viewController)
    interactor.router = self
  }
}
