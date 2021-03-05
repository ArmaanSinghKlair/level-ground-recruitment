
function SearchResult(_ref) {
    var row = _ref.row;

    return React.createElement(
        "div",
        { "class": "search-result" },
        React.createElement(
            "div",
            { "class": "row" },
            React.createElement("div", { "class": "col-md-10 offset-md-1" }),
            React.createElement(
                "div",
                { "class": "col" },
                React.createElement(
                    "div",
                    { role: "tablist", id: "accordion-1" },
                    React.createElement(
                        "div",
                        { "class": "card" },
                        React.createElement(
                            "div",
                            { role: "tab", "class": "card-header" },
                            React.createElement(
                                "div",
                                { "class": "d-md-flex justify-content-md-between align-items-md-baseline job-header" },
                                React.createElement(
                                    "h1",
                                    { "class": "display-4" },
                                    row.jobTitle
                                ),
                                React.createElement(
                                    "p",
                                    { "class": "text-muted" },
                                    "Posted on: ",
                                    row.postDate
                                )
                            ),
                            React.createElement(
                                "div",
                                { "class": "d-md-flex justify-content-md-between align-items-md-baseline job-status" },
                                React.createElement(
                                    "p",
                                    { "class": "lead" },
                                    row.jobStatus
                                ),
                                React.createElement(
                                    "p",
                                    { "class": "text-muted" },
                                    "Expires on: ",
                                    row.endDate == null ? 'Not specified' : row.endDate
                                )
                            ),
                            React.createElement(
                                "h3",
                                { "class": "d-flex justify-content-end mb-0" },
                                React.createElement(
                                    "a",
                                    { "data-toggle": "collapse", "aria-expanded": "true", "aria-controls": "accordion-1 .item-1", href: "#accordion-1 .item-1", "class": "more-btn" },
                                    React.createElement("i", { "class": "icon ion-android-more-horizontal" })
                                )
                            )
                        ),
                        React.createElement(
                            "div",
                            { role: "tabpanel", "data-parent": "#accordion-1", "class": "collapse item-1" },
                            React.createElement(
                                "div",
                                { "class": "card-body" },
                                React.createElement(
                                    "div",
                                    { "class": "shadow job-post" },
                                    React.createElement("hr", null),
                                    React.createElement(
                                        "div",
                                        null,
                                        React.createElement(
                                            "h4",
                                            null,
                                            "Description"
                                        ),
                                        React.createElement(
                                            "p",
                                            null,
                                            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Venenatis cras sed felis eget velit aliquet sagittis id. Diam phasellus vestibulum lorem sed risus ultricies. Sit amet dictum sit amet justo donec enim. Egestas dui id ornare arcu odio ut.",
                                            React.createElement("br", null)
                                        ),
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
                                        React.createElement(
                                            "p",
                                            null,
                                            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Venenatis cras sed felis eget velit aliquet sagittis id. Diam phasellus vestibulum lorem sed risus ultricies. Sit amet dictum sit amet justo donec enim. Egestas dui id ornare arcu odio ut.",
                                            React.createElement("br", null)
                                        ),
                                        React.createElement("hr", null)
                                    ),
                                    React.createElement(
                                        "div",
                                        { "class": "row" },
                                        React.createElement(
                                            "div",
                                            { "class": "col-md-5 d-flex justify-content-between align-items-baseline" },
                                            React.createElement("i", { "class": "fas fa-location-arrow icons" }),
                                            React.createElement(
                                                "p",
                                                null,
                                                "Location"
                                            )
                                        ),
                                        React.createElement(
                                            "div",
                                            { "class": "col-md-5 offset-md-1 d-flex justify-content-between align-items-baseline" },
                                            React.createElement("i", { "class": "far fa-money-bill-alt icons" }),
                                            React.createElement(
                                                "p",
                                                null,
                                                "$50,000 year"
                                            )
                                        )
                                    ),
                                    React.createElement(
                                        "form",
                                        { "class": "d-flex justify-content-end" },
                                        React.createElement(
                                            "button",
                                            { "class": "btn apply-btn", type: "submit" },
                                            "Apply Now"
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