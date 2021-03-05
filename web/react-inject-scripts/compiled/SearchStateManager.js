export var searchQueryInitialState = {
    sal: null,
    loc: null,
    ti: null,
    stat: null,
    pn: 1,
    searchStart: false
};
var SearchContext = React.createContext(searchQueryInitialState);

export var SearchStateManager = function SearchStateManager(_ref) {
    var initialState = _ref.initialState,
        reducer = _ref.reducer,
        children = _ref.children;

    return React.createElement(
        SearchContext.Provider,
        { value: React.useReducer(reducer, initialState) },
        children
    );
};

// Use the state directly without calling useContext in every Script
export var useSearchStateValue = function useSearchStateValue() {
    return React.useContext(SearchContext);
};

// export the Search Context
export default SearchContext;