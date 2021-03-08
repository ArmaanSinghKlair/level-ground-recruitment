var _slicedToArray = function () { function sliceIterator(arr, i) { var _arr = []; var _n = true; var _d = false; var _e = undefined; try { for (var _i = arr[Symbol.iterator](), _s; !(_n = (_s = _i.next()).done); _n = true) { _arr.push(_s.value); if (i && _arr.length === i) break; } } catch (err) { _d = true; _e = err; } finally { try { if (!_n && _i["return"]) _i["return"](); } finally { if (_d) throw _e; } } return _arr; } return function (arr, i) { if (Array.isArray(arr)) { return arr; } else if (Symbol.iterator in Object(arr)) { return sliceIterator(arr, i); } else { throw new TypeError("Invalid attempt to destructure non-iterable instance"); } }; }();

import SearchResult from './SearchResult.js';
import SearchContext from './SearchStateManager.js';
import { SearchStateActions } from './SearchStateReducer.js';

export default function SearchResults(_ref) {
    var rowCount = _ref.rowCount,
        rows = _ref.rows,
        setSuccess = _ref.setSuccess,
        setError = _ref.setError,
        hasMore = _ref.hasMore;

    var _React$useContext = React.useContext(SearchContext),
        _React$useContext2 = _slicedToArray(_React$useContext, 2),
        searchState = _React$useContext2[0],
        dispatch = _React$useContext2[1];

    return React.createElement(
        'div',
        { className: 'search-results' },
        rowCount > 0 ? React.createElement(
            'div',
            { className: 'row result-row' },
            React.createElement(
                'div',
                { className: 'col-md-10 offset-md-1 result-column' },
                React.createElement(
                    'h5',
                    { className: 'text-center text-muted' },
                    'Found ',
                    React.createElement(
                        'strong',
                        null,
                        rowCount,
                        ' '
                    ),
                    'matches'
                ),
                React.createElement(
                    'h6',
                    { className: 'text-center', style: { margin: "1vmax 0" } },
                    'Page ',
                    searchState.pn
                )
            )
        ) : null,
        rowCount == null ? React.createElement(
            'div',
            { className: 'empty-result' },
            React.createElement(
                'svg',
                { xmlns: 'http://www.w3.org/2000/svg', width: '16', height: '16', fill: 'currentColor', className: 'bi bi-info-circle-fill', viewBox: '0 0 16 16' },
                React.createElement('path', { d: 'M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412l-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z' })
            ),
            'Jobs appear here'
        ) : rowCount > 0 && rows != null ? React.createElement(
            'div',
            null,
            React.createElement(
                'div',
                { className: 'pagination-container' },
                searchState.pn > 1 ? React.createElement(
                    'button',
                    { onClick: function onClick() {
                            return dispatch({
                                type: SearchStateActions.INSERT_VALUE,
                                payload: {
                                    pn: searchState.pn - 1,
                                    searchStart: true
                                }
                            });
                        }, className: 'paginate-button prev' },
                    'Prev'
                ) : null,
                hasMore ? React.createElement(
                    'button',
                    { onClick: function onClick() {
                            return dispatch({
                                type: SearchStateActions.INSERT_VALUE,
                                payload: {
                                    pn: searchState.pn + 1,
                                    searchStart: true
                                }
                            });
                        }, className: 'paginate-button next' },
                    'Next'
                ) : null
            ),
            rows.map(function (row, i) {
                return React.createElement(SearchResult, { row: row, key: i, setSuccess: setSuccess, setError: setError, index: i });
            })
        ) : React.createElement(
            'div',
            { className: 'empty-result' },
            '\u26A0 No jobs found'
        )
    );
}