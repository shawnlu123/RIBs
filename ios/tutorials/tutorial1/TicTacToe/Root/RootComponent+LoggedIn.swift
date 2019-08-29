import RIBs

/// The dependencies needed from the parent scope of Root to provide for the LoggedOut scope.
// TODO: Update RootDependency protocol to inherit this protocol.
protocol RootDependencyLoggedIn: Dependency {

  // TODO: Declare dependencies needed from the parent scope of Root to provide dependencies
  // for the LoggedOut scope.
}

extension RootComponent: LoggedInDependency {
  var loggedInViewController: LoggedInViewControllable {
    return rootViewController
  }
}
