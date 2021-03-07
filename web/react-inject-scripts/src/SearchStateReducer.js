export const SearchStateActions = {
    INSERT_VALUE: "insert_value"
}

export default function SearchStateReducer(state, action){
    switch(action.type){
        case SearchStateActions.INSERT_VALUE:
         
            return {
                ...state,
                ...action.payload
            }
        break;
    }
}