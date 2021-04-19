var _slicedToArray = function () { function sliceIterator(arr, i) { var _arr = []; var _n = true; var _d = false; var _e = undefined; try { for (var _i = arr[Symbol.iterator](), _s; !(_n = (_s = _i.next()).done); _n = true) { _arr.push(_s.value); if (i && _arr.length === i) break; } } catch (err) { _d = true; _e = err; } finally { try { if (!_n && _i["return"]) _i["return"](); } finally { if (_d) throw _e; } } return _arr; } return function (arr, i) { if (Array.isArray(arr)) { return arr; } else if (Symbol.iterator in Object(arr)) { return sliceIterator(arr, i); } else { throw new TypeError("Invalid attempt to destructure non-iterable instance"); } }; }();

function _defineProperty(obj, key, value) { if (key in obj) { Object.defineProperty(obj, key, { value: value, enumerable: true, configurable: true, writable: true }); } else { obj[key] = value; } return obj; }

import ENV from "./ENV.js";
import SearchContext from "./SearchStateManager.js";
import { SearchStateActions } from "./SearchStateReducer.js";

import Tag from "./Tag.js";
function SearchBar(_ref) {
  var setError = _ref.setError;

  var _React$useContext = React.useContext(SearchContext),
      _React$useContext2 = _slicedToArray(_React$useContext, 2),
      searchState = _React$useContext2[0],
      dispatch = _React$useContext2[1];

  var handleTagClick = function handleTagClick(name) {
    var _payload;

    return dispatch({
      type: SearchStateActions.INSERT_VALUE,
      payload: (_payload = {}, _defineProperty(_payload, name, null), _defineProperty(_payload, "searchStart", false), _payload)
    });
  };
  var jobTypes = React.useMemo(function () {
    return ["Full-Time", "Internship", "Part-Time", "Contract", "Temporary", "Commission", "Volunteer", "Casual", "Permanent", "Fly-In/Fly-Out"];
  }, []);
  var ignoredTags = ["pn", "searchStart"];

  var handleSearch = React.useCallback(function () {
    var payload = {};
    if (Number(salaryRef.current.value) < 0) {
      setError("Salary cannot be negative");
      return;
    } else {
      if (salaryRef.current.value != null && salaryRef.current.value != "") payload.sal = salaryRef.current.value;
    }

    if (searchRef.current.value.trim().length > 0) {
      payload = Object.assign(_defineProperty({}, searchTypeRef.current.value, searchRef.current.value), payload);
    }

    if (jobTypes.indexOf(jobTypeRef.current.value) != -1) {
      payload.stat = jobTypeRef.current.value;
    }
    if (payload != null) {
      payload.searchStart = true;
    } else {
      payload.searchStart = false;
    }
    dispatch({
      type: SearchStateActions.INSERT_VALUE,
      payload: payload
    });
  }, []);

  var searchRef = React.useRef();
  var searchTypeRef = React.useRef();
  var jobTypeRef = React.useRef();
  var salaryRef = React.useRef();

  return React.createElement(
    "div",
    { className: "shadow-sm searchDiv" },
    React.createElement(
      "div",
      { className: "input-group searchInner" },
      React.createElement(
        "select",
        {
          name: "searchType",
          className: "form-select search-select",
          ref: searchTypeRef
        },
        React.createElement(
          "option",
          { value: "ti" },
          "Title"
        ),
        React.createElement(
          "option",
          { value: "loc" },
          "Location"
        )
      ),
      React.createElement("input", {
        type: "search",
        name: "search",
        className: "form-control",
        id: "search-input",
        placeholder: "search...",
        ref: searchRef
      }),
      React.createElement(
        "button",
        {
          className: "btn btn-primary",
          type: "button",
          onClick: function onClick() {
            return handleSearch();
          }
        },
        React.createElement("i", { className: "fas fa-search" })
      )
    ),
    React.createElement(
      "div",
      { className: "d-flex justify-content-around jobType" },
      React.createElement(
        "select",
        { name: "jobType", ref: jobTypeRef },
        React.createElement(
          "option",
          null,
          "Job Type"
        ),
        jobTypes.map(function (type, i) {
          return React.createElement(
            "option",
            { value: type, key: i },
            type
          );
        })
      ),
      React.createElement("input", {
        type: "number",
        min: "0",
        placeholder: "Salary Per year",
        ref: salaryRef
      })
    ),
    React.createElement(
      "div",
      { className: "search-bar__row tag-row" },
      Object.keys(searchState).filter(function (key) {
        return searchState[key] != null && ignoredTags.indexOf(key) == -1;
      }).map(function (key, i) {
        return React.createElement(Tag, {
          name: key,
          value: searchState[key],
          onClick: function onClick() {
            return handleTagClick(key);
          },
          key: i
        });
      })
    )
  )
  //(name)=>handleTagClick(name)
  ;
}

export default React.memo(SearchBar);