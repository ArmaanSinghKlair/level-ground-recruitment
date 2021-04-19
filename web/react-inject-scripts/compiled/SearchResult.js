var _slicedToArray = function () { function sliceIterator(arr, i) { var _arr = []; var _n = true; var _d = false; var _e = undefined; try { for (var _i = arr[Symbol.iterator](), _s; !(_n = (_s = _i.next()).done); _n = true) { _arr.push(_s.value); if (i && _arr.length === i) break; } } catch (err) { _d = true; _e = err; } finally { try { if (!_n && _i["return"]) _i["return"](); } finally { if (_d) throw _e; } } return _arr; } return function (arr, i) { if (Array.isArray(arr)) { return arr; } else if (Symbol.iterator in Object(arr)) { return sliceIterator(arr, i); } else { throw new TypeError("Invalid attempt to destructure non-iterable instance"); } }; }();

import CandidateApplyJob from "./CandidateApplyJob.js";
import CandidateSingleJob from "./CandidateSingleJob.js";

import ENV from "./ENV.js";

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
    "div",
    { className: "row" },
    React.createElement(
      "div",
      { className: "col" },
      React.createElement(
        "div",
        { role: "tablist", id: "accordion-" + index, className: "accordion" },
        React.createElement(
          "div",
          { className: "accordion-item" },
          React.createElement(
            "h2",
            { className: "card-header", role: "tab" },
            React.createElement(
              "button",
              {
                className: "accordion-button more-btn accordion-button",
                "data-bs-toggle": "collapse",
                "data-bs-target": "#accordion-" + index + " .item-" + index,
                "aria-expanded": "true",
                "aria-controls": "accordion-" + index + " .item-" + index
              },
              row.jobTitle,
              React.createElement(
                "span",
                { className: "badge rounded-pill bg-secondary job-badge" },
                row.jobStatus
              )
            )
          ),
          React.createElement(
            "div",
            {
              className: "accordion-collapse collapse show item-" + index,
              role: "tabpanel",
              "data-bs-parent": "#accordion-" + index
            },
            React.createElement(
              "div",
              { className: "card-body" },
              React.createElement(
                "div",
                { className: "shadow job-post" },
                React.createElement(
                  "div",
                  null,
                  React.createElement(
                    "h4",
                    null,
                    "Description"
                  ),
                  curRow == null ? React.createElement(
                    "div",
                    { className: "empty-result" },
                    React.createElement("img", {
                      src: ENV.CONTEXT_PATH + "/react-inject-scripts/assets/loading.gif"
                    })
                  ) : React.createElement(
                    "p",
                    null,
                    curRow.jobDescription
                  ),
                  React.createElement("br", null),
                  React.createElement("hr", null)
                ),
                React.createElement(
                  "div",
                  null,
                  React.createElement(
                    "h4",
                    null,
                    "Requirements"
                  ),
                  curRow == null ? React.createElement(
                    "div",
                    { className: "empty-result" },
                    React.createElement("img", {
                      src: ENV.CONTEXT_PATH + "/react-inject-scripts/assets/loading.gif"
                    })
                  ) : React.createElement(
                    "p",
                    null,
                    curRow.requirements
                  ),
                  React.createElement("hr", null)
                ),
                React.createElement(
                  "div",
                  { className: "row" },
                  React.createElement(
                    "div",
                    { className: "col d-flex align-self-center" },
                    React.createElement("i", { className: "fas fa-map-pin business-icon" }),
                    curRow == null ? React.createElement(
                      "div",
                      { className: "empty-result" },
                      React.createElement("img", {
                        src: ENV.CONTEXT_PATH + "/react-inject-scripts/assets/loading.gif"
                      })
                    ) : React.createElement(
                      "p",
                      { className: "lead" },
                      curRow.location
                    )
                  ),
                  React.createElement(
                    "div",
                    { className: "col d-flex align-self-center" },
                    React.createElement("i", { className: "fas fa-money-bill-alt business-icon" }),
                    curRow == null ? React.createElement(
                      "div",
                      { className: "empty-result" },
                      React.createElement("img", {
                        src: ENV.CONTEXT_PATH + "/react-inject-scripts/assets/loading.gif"
                      })
                    ) : React.createElement(
                      "p",
                      { className: "lead" },
                      "$",
                      curRow.wage,
                      " yearly"
                    )
                  )
                ),
                React.createElement(
                  "div",
                  { className: "row" },
                  React.createElement(
                    "div",
                    { "class": "col d-flex align-self-center" },
                    React.createElement("i", { "class": "fas fa-hourglass-start business-icon" }),
                    React.createElement(
                      "p",
                      { "class": "lead" },
                      "Start Date"
                    )
                  ),
                  React.createElement(
                    "div",
                    { "class": "col d-flex align-self-center" },
                    React.createElement("i", { "class": "fas fa-hourglass-end business-icon" }),
                    React.createElement(
                      "p",
                      { "class": "lead" },
                      "End Date"
                    )
                  )
                ),
                React.createElement(
                  "div",
                  { className: "d-flex justify-content-end" },
                  React.createElement(
                    "button",
                    {
                      className: "btn apply-btn",
                      onClick: function onClick() {
                        return applyJob();
                      }
                    },
                    "Apply Now"
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