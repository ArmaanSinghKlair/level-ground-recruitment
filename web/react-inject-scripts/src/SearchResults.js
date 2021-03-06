import SearchResult from "./SearchResult.js";
import SearchContext from "./SearchStateManager.js";
import { SearchStateActions } from "./SearchStateReducer.js";

export default function SearchResults({
  rowCount,
  rows,
  setSuccess,
  setError,
  hasMore,
}) {
  const [searchState, dispatch] = React.useContext(SearchContext);

  return (
    <div className="search-results">
      {rowCount > 0 ? (
        <div className="row result-row">
          <div className="col-md-10 offset-md-1 d-flex justify-content-center align-items-center result-column">
            <h5 className="display-4 text-center resultCount">
              Found <strong>{rowCount} </strong>match {rowCount > 1 ? "es" : ""}
            </h5>
          </div>
        </div>
      ) : null}
      {rowCount == null ? (
        <div className="empty-result">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="16"
            height="16"
            fill="currentColor"
            className="bi bi-info-circle-fill"
            viewBox="0 0 16 16"
          >
            <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412l-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z" />
          </svg>
          Jobs appear here
        </div>
      ) : rowCount > 0 && rows != null ? (
        <div>
          <div className="pagination-container">
            {searchState.pn > 1 ? (
              <button
                onClick={() =>
                  dispatch({
                    type: SearchStateActions.INSERT_VALUE,
                    payload: {
                      pn: searchState.pn - 1,
                      searchStart: true,
                    },
                  })
                }
                className="paginate-button prev"
              >
                Prev
              </button>
            ) : null}
            {hasMore ? (
              <button
                onClick={() =>
                  dispatch({
                    type: SearchStateActions.INSERT_VALUE,
                    payload: {
                      pn: searchState.pn + 1,
                      searchStart: true,
                    },
                  })
                }
                className="paginate-button next"
              >
                Next
              </button>
            ) : null}
          </div>
          {rows.map((row, i) => (
            <SearchResult
              row={row}
              key={i}
              setSuccess={setSuccess}
              setError={setError}
              index={i}
            />
          ))}
        </div>
      ) : (
        <div className="empty-result">⚠ No jobs found</div>
      )}
    </div>
  );
}
