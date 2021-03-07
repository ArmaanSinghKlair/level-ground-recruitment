var _slicedToArray = function () { function sliceIterator(arr, i) { var _arr = []; var _n = true; var _d = false; var _e = undefined; try { for (var _i = arr[Symbol.iterator](), _s; !(_n = (_s = _i.next()).done); _n = true) { _arr.push(_s.value); if (i && _arr.length === i) break; } } catch (err) { _d = true; _e = err; } finally { try { if (!_n && _i["return"]) _i["return"](); } finally { if (_d) throw _e; } } return _arr; } return function (arr, i) { if (Array.isArray(arr)) { return arr; } else if (Symbol.iterator in Object(arr)) { return sliceIterator(arr, i); } else { throw new TypeError("Invalid attempt to destructure non-iterable instance"); } }; }();

import CandidateApplyJob from './CandidateApplyJob.js';
import CandidateSingleJob from './CandidateSingleJob.js';

import ENV from './ENV.js';

function SearchResult(_ref) {
    var row = _ref.row,
        setSuccess = _ref.setSuccess,
        setError = _ref.setError,
        index = _ref.index;

    var _React$useState = React.useState(false),
        _React$useState2 = _slicedToArray(_React$useState, 2),
        expanded = _React$useState2[0],
        setExpanded = _React$useState2[1];

    var _React$useState3 = React.useState(null),
        _React$useState4 = _slicedToArray(_React$useState3, 2),
        curRow = _React$useState4[0],
        setCurRow = _React$useState4[1];

    React.useEffect(function () {
        if (expanded) {
            CandidateSingleJob(row.jobpostingID, function (res) {
                setCurRow(res.data);
            });
        }
    }, [expanded]);

    function applyJob() {
        CandidateApplyJob(row.jobpostingID, function (data) {
            if (data.querySuccessfull) {
                setSuccess("Applied to job");
                setError(null);
                window.scrollTo(0, 0);
            } else {
                setSuccess(null);
                var err = "";
                data.errors.forEach(function (e) {
                    err += " " + e;
                });
                setError(err);
                window.scrollTo(0, 0);
            }
        });
    }
    return React.createElement(
        'div',
        { className: 'search-result' },
        React.createElement(
            'div',
            { className: 'row' },
            React.createElement(
                'div',
                { className: 'col' },
                React.createElement(
                    'div',
                    { role: 'tablist', id: 'accordion-' + index },
                    React.createElement(
                        'div',
                        { className: 'card' },
                        React.createElement(
                            'div',
                            { className: 'card-header', role: 'tab' },
                            React.createElement(
                                'div',
                                { className: 'd-md-flex justify-content-md-between align-items-md-baseline job-header' },
                                React.createElement(
                                    'h1',
                                    { className: 'display-4' },
                                    row.jobTitle
                                ),
                                React.createElement(
                                    'p',
                                    { className: 'text-muted' },
                                    'Posted on: ',
                                    new Date(row.postDate).toDateString()
                                )
                            ),
                            React.createElement(
                                'div',
                                { className: 'd-md-flex justify-content-md-between align-items-md-baseline job-status' },
                                React.createElement(
                                    'p',
                                    { className: 'lead' },
                                    row.jobStatus
                                ),
                                React.createElement(
                                    'p',
                                    { className: 'text-muted' },
                                    'Expires on: ',
                                    row.endDate == null ? "Not specified" : new Date(row.endDate).toDateString()
                                )
                            ),
                            React.createElement(
                                'h3',
                                { className: 'd-flex justify-content-end mb-0', onClick: function onClick() {
                                        return setExpanded(true);
                                    } },
                                React.createElement('a', { 'data-bs-toggle': 'collapse', 'aria-expanded': 'true',
                                    'aria-controls': 'accordion-' + index + ' .item-1',
                                    href: '#accordion-' + index + ' .item-1',
                                    className: 'more-btn accordion-button' })
                            )
                        ),
                        React.createElement(
                            'div',
                            { className: 'collapse  item-1', role: 'tabpanel', 'data-bs-parent': '#accordion-' + index },
                            React.createElement(
                                'div',
                                { className: 'card-body' },
                                React.createElement(
                                    'div',
                                    { className: 'shadow job-post' },
                                    React.createElement('hr', null),
                                    React.createElement(
                                        'div',
                                        null,
                                        React.createElement(
                                            'h4',
                                            null,
                                            'Description'
                                        ),
                                        curRow == null ? React.createElement(
                                            'div',
                                            { className: 'empty-result' },
                                            React.createElement('img', { src: ENV.CONTEXT_PATH + "/react-inject-scripts/assets/loading.gif" })
                                        ) : React.createElement(
                                            'p',
                                            null,
                                            curRow.jobDescription
                                        ),
                                        React.createElement('br', null),
                                        React.createElement('hr', null)
                                    ),
                                    React.createElement(
                                        'div',
                                        null,
                                        React.createElement(
                                            'h4',
                                            null,
                                            'Requirements'
                                        ),
                                        curRow == null ? React.createElement(
                                            'div',
                                            { className: 'empty-result' },
                                            React.createElement('img', { src: ENV.CONTEXT_PATH + "/react-inject-scripts/assets/loading.gif" })
                                        ) : React.createElement(
                                            'p',
                                            null,
                                            curRow.requirements
                                        ),
                                        React.createElement('hr', null)
                                    ),
                                    React.createElement(
                                        'div',
                                        { className: 'row' },
                                        React.createElement(
                                            'div',
                                            { className: 'col-md-5 d-flex justify-content-between align-items-baseline' },
                                            React.createElement('i', {
                                                className: 'fas fa-location-arrow icons' }),
                                            curRow == null ? React.createElement(
                                                'div',
                                                { className: 'empty-result' },
                                                React.createElement('img', { src: ENV.CONTEXT_PATH + "/react-inject-scripts/assets/loading.gif" })
                                            ) : React.createElement(
                                                'p',
                                                null,
                                                curRow.location
                                            )
                                        ),
                                        React.createElement(
                                            'div',
                                            { className: 'col-md-5 offset-md-1 d-flex justify-content-between align-items-baseline' },
                                            React.createElement('i', { className: 'far fa-money-bill-alt icons' }),
                                            curRow == null ? React.createElement(
                                                'div',
                                                { className: 'empty-result' },
                                                React.createElement('img', { src: ENV.CONTEXT_PATH + "/react-inject-scripts/assets/loading.gif" })
                                            ) : React.createElement(
                                                'p',
                                                null,
                                                '$',
                                                curRow.wage,
                                                ' yearly'
                                            )
                                        )
                                    ),
                                    React.createElement(
                                        'div',
                                        { className: 'd-flex justify-content-end' },
                                        React.createElement(
                                            'button',
                                            { className: 'btn apply-btn', onClick: function onClick() {
                                                    return applyJob();
                                                } },
                                            'Apply Now'
                                        )
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )
    );
}

export default React.memo(SearchResult);