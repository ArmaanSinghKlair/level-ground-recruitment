import SearchStateReducer from './SearchStateReducer.js'
import {SearchStateManager,searchQueryInitialState} from './SearchStateManager.js'
import SearchBarContainer from './SearchBarContainer.js'

function App() {    
    return (
        <SearchStateManager initialState={searchQueryInitialState} reducer={SearchStateReducer}>
            <SearchBarContainer />
        </SearchStateManager>
    )
}

ReactDOM.render(<App/>, document.getElementById("searchBar"));