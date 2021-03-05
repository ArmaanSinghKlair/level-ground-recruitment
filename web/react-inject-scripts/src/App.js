import SearchBar from './SearchBar.js'
import SearchStateReducer from './SearchStateReducer.js'
import SearchResults from './SearchResults.js'

function App() {

    return (
        <div className="search-bar">
            Hello
            <SearchBar/>
            <SearchResults />
        </div>
    )
}

ReactDOM.render(<App/>, document.getElementById("searchBar"));