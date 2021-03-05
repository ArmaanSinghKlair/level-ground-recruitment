export var SearchStateActions = {
    INSERT_VALUE: "insert_value"
};

export default function SearchStateReducer(state, action) {
    switch (action.type) {
        case SearchStateActions.INSERT_VALUE:

            return Object.assign({}, state, action.payload);
            break;
    }
}