function Tag(_ref) {
  var value = _ref.value,
      onClick = _ref.onClick;

  return React.createElement(
    "div",
    { className: "tag d-flex", onClick: onClick },
    React.createElement(
      "span",
      { className: "badge bg-secondary" },
      value,
      " "
    ),
    React.createElement("button", { className: "btn-close", "aria-label": "Close" })
  );
}

export default Tag;