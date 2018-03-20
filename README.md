# jmocktest

We are testing part of a *login service* using the
[jMock](http://jmock.org/) framework. We are using a combination of
stub and mock classes.

We will be mocking the \texttt{UserDAO} class. A **DAO** (Data
  Access Object) is a class that fetches some data from a store (such
  as a database) and converts into one or more objects in our application.
  
  
  We provide an implementation of `LoginService` but there is no implementation of
  `UserDAO`. \\

   As we're doing TDD, there are two tests, neither of which pass.

## Exercise

  You need to change the
  `login` method in `LoginService` to do the following:

+ hash the password,
+ call the `loadByUsernameAndPassword` method on `userDAO`, then
+ return `true` if the user name and password match the hard-coded values.  

Finally, complete the second test case `testLoginFailsIfUserNotKnown`.
