import * as React from 'react'
import { Dispatch } from 'redux'
import { useDispatch } from 'react-redux'

type Props = {
    user: IUser
    removeUser: (user: IUser) => void
}

//Function that allows you to delete a user from the list that's rendered
export const User: React.FC<Props> = ({ user, removeUser }) => {
    const dispatch: Dispatch<any> = useDispatch()

    const deleteUser = React.useCallback(
        (user: IUser) => dispatch(removeUser(user)),
        [dispatch, removeUser]
    )

    //This shows all users (Can probably modify it to display a single user's information for a profile)
    return (
        <div className = "User">
            <div>
                <h1> User #: {user.id}</h1>
                <p>{user.firstName} {user.lastName} {user.username} {user.password} {user.email}</p>
            </div>
            <button onClick={() => deleteUser(user)}>Delete User</button>
        </div>
    )
}
