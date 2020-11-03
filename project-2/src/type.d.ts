
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

interface IPost {
    postId: number
    author: string
    title: string
    body: string
}
type PostState = {
    posts: IPost[]
}
type PostAction = {
    type: string
    post: IPost
}
type DispatchType = (args: PostAction) => PostAction
//-------------------------------------------------------------------------
