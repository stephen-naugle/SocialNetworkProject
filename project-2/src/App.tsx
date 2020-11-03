import * as React from 'react';
import { useSelector, shallowEqual, useDispatch } from 'react-redux'
import logo from './logo.svg';
import './App.css';

import { User } from './components/ShowUsers'
import { AddUser } from './components/AddUser'
import { addUser, removeUser } from './store/UserRegister/actionCreators'
import { Dispatch } from 'redux'

//This pulls the information from the store to be rendered (I think)
const App: React.FC = () => {
  const users: readonly IUser[] = useSelector(
    (state: UserState) => state.users,
    shallowEqual
  )
  const dispatch: Dispatch<any> = useDispatch()

  const saveUser = React.useCallback(
    (user: IUser) => dispatch(addUser(user)),
    [dispatch]
  )

  //Renders all user profiles
  return(
    <main>
      <h1> Register New User </h1>
      <AddUser saveUser={saveUser} />
      {users.map((user: IUser) => (
        <User
        key = {user.id}
        user = {user}
        removeUser = {removeUser}
        />
      ))}
    </main>
  )
}

export default App
