var _slicedToArray = function () { function sliceIterator(arr, i) { var _arr = []; var _n = true; var _d = false; var _e = undefined; try { for (var _i = arr[Symbol.iterator](), _s; !(_n = (_s = _i.next()).done); _n = true) { _arr.push(_s.value); if (i && _arr.length === i) break; } } catch (err) { _d = true; _e = err; } finally { try { if (!_n && _i["return"]) _i["return"](); } finally { if (_d) throw _e; } } return _arr; } return function (arr, i) { if (Array.isArray(arr)) { return arr; } else if (Symbol.iterator in Object(arr)) { return sliceIterator(arr, i); } else { throw new TypeError("Invalid attempt to destructure non-iterable instance"); } }; }();

import CandidateAllJobs from './CandidateAllJobs.js';
import SearchResults from './SearchResults.js';
import SearchBar from './SearchBar.js';
import SearchContext from './SearchStateManager.js';
import { SearchStateActions } from './SearchStateReducer.js';

function SearchBarContainer() {
    var _React$useContext = React.useContext(SearchContext),
        _React$useContext2 = _slicedToArray(_React$useContext, 2),
        searchState = _React$useContext2[0],
        dispatch = _React$useContext2[1];

    React.useEffect(function () {
        if (searchState.searchStart) {
            CandidateAllJobs(searchState, function (res) {
                console.log(res);
                setRows(res.data.data);
                setRowCount(res.data.rowCount);
            });
        }
    }, [searchState]);

    var _React$useState = React.useState(null),
        _React$useState2 = _slicedToArray(_React$useState, 2),
        rowCount = _React$useState2[0],
        setRowCount = _React$useState2[1];

    var _React$useState3 = React.useState(null),
        _React$useState4 = _slicedToArray(_React$useState3, 2),
        rows = _React$useState4[0],
        setRows = _React$useState4[1];

    var _React$useState5 = React.useState(null),
        _React$useState6 = _slicedToArray(_React$useState5, 2),
        error = _React$useState6[0],
        setError = _React$useState6[1];

    return React.createElement(
        'div',
        { className: 'search-bar-container' },
        error != null ? React.createElement(
            'div',
            { className: 'alert alert-warning', role: 'alert', style: { border: "solid 1px orange" } },
            '\u26A0 ',
            error
        ) : null,
        React.createElement(SearchBar, { setError: setError }),
        React.createElement(SearchResults, { rowCount: rowCount, rows: rows })
    );
}

export default SearchBarContainer;