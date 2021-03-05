import SearchBar from './SearchBar.js';
import SearchStateReducer from './SearchStateReducer.js';
import SearchResults from './SearchResults.js';

function App() {

    return React.createElement(
        'div',
        { className: 'search-bar' },
        'Hello',
        React.createElement(SearchBar, null),
        React.createElement(SearchResults, null)
    );
}

ReactDOM.render(React.createElement(App, null), document.getElementById("searchBar"));