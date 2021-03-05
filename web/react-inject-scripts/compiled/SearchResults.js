import SearchResult from './SearchResult.js';

export default function SearchResults(_ref) {
    var rowCount = _ref.rowCount,
        rows = _ref.rows;

    return React.createElement(
        "div",
        { className: "search-results" },
        rowCount > 0 ? React.createElement(
            "div",
            { className: "row result-row" },
            React.createElement(
                "div",
                { className: "col-md-10 offset-md-1 result-column" },
                React.createElement(
                    "h5",
                    { className: "text-center text-muted" },
                    "Found ",
                    React.createElement(
                        "strong",
                        null,
                        rowCount,
                        " "
                    ),
                    "matches"
                )
            )
        ) : null,
        rowCount == null ? React.createElement(
            "div",
            { className: "empty-result" },
            React.createElement(
                "svg",
                { xmlns: "http://www.w3.org/2000/svg", width: "16", height: "16", fill: "currentColor", className: "bi bi-info-circle-fill", viewBox: "0 0 16 16" },
                React.createElement("path", { d: "M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412l-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z" })
            ),
            "Jobs appear here"
        ) : rowCount > 0 && rows != null ? rows.map(function (row, i) {
            return React.createElement(SearchResult, { row: row, key: i });
        }) : React.createElement(
            "div",
            { className: "empty-result" },
            "\u26A0 No jobs found"
        )
    );
}