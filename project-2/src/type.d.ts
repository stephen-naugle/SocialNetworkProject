
//------------------- Global types / function parameters / etc for Users -------------
interface IUser {
    id: number
    username: string
    password: string
    firstName: string
    lastName: string
    email: string
}
type UserState = {
    users: IUser[]
}
type UserAction = {
    type: string
    user: IUser
}
type DispatchType = (args: UserAction) => UserAction
//-------------------------------------------------------------------------------------