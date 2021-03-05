import SearchStateReducer from './SearchStateReducer.js';
import { SearchStateManager, searchQueryInitialState } from './SearchStateManager.js';
import SearchBarContainer from './SearchBarContainer.js';

function App() {
    return React.createElement(
        SearchStateManager,
        { initialState: searchQueryInitialState, reducer: SearchStateReducer },
        React.createElement(SearchBarContainer, null)
    );
}

ReactDOM.render(React.createElement(App, null), document.getElementById("searchBar"));