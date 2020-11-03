import { combineReducers, Dispatch, Reducer, Action, AnyAction } from 'redux';
import { routerReducer, RouterState } from 'react-router-redux';

//This is our top-level state object.
//This exists to declare our top-level application state object type, as well as for exporting reducers.





export const rootReducer = combineReducers<ApplicationState> ({
    layout: layoutReducer,
})