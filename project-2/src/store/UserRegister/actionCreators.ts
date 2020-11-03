import * as actionTypes from "./actionTypes"

// This function will dispatch an action to add a user (Utilized in /store/reducer.ts)
export function addUser(user: IUser) {
    const action: UserAction = {
        type: actionTypes.ADD_USER,
        user,
    }
    //Make an axios/fetch request to add a user or something?
}
// This function will dispatch an action to delete a user (Utilized in /store/reducer.ts)
export function removeUser(user: IUser) {
    const action: UserAction = {
        type: actionTypes.REMOVE_USER,
        user,
    }
    //Make an axios/fetch request
}
