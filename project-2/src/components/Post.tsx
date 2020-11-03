import React from 'react';
import { Dispatch } from 'redux'
import { useDispatch } from 'react-redux'

type Props = {
    post: IPost
    removePost: (post: IPost) => void
}
