export const searchQueryInitialState = {
    minSalary: null,
    location: null,
    title: null,
    status: null,
    results: null
}
const SearchContext = React.createContext(searchQueryInitialState);

export const SearchStateManager = ({initialState, reducer, children}) =>{
    return <SearchContext.Provider value={React.useReducer(reducer, initialState)}>
        {children}
    </SearchContext.Provider>
}

// Use the state directly without calling useContext in every Script
export const useSearchStateValue = () => React.useContext(SearchContext);

// export the Search Context
export default SearchContext