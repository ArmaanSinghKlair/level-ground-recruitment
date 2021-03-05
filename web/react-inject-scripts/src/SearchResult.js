
function SearchResult({row}) {
    return (
        <div class="search-result">
            <div class="row">
                <div class="col-md-10 offset-md-1"></div>
                <div class="col">
                    <div role="tablist" id="accordion-1">
                        <div class="card">
                            <div role="tab" class="card-header">
                                <div class="d-md-flex justify-content-md-between align-items-md-baseline job-header">
                                    <h1 class="display-4">{row.jobTitle}</h1>
                                    <p class="text-muted">Posted on: {row.postDate}</p>
                                </div>
                                <div class="d-md-flex justify-content-md-between align-items-md-baseline job-status">
                                    <p class="lead">{row.jobStatus}</p>
                                    <p class="text-muted">Expires on: {row.endDate == null ? 'Not specified': row.endDate}</p>
                                </div>
                                <h3 class="d-flex justify-content-end mb-0"><a data-toggle="collapse" aria-expanded="true" aria-controls="accordion-1 .item-1" href="#accordion-1 .item-1" class="more-btn"><i class="icon ion-android-more-horizontal"></i></a></h3>
                            </div>
                            <div role="tabpanel" data-parent="#accordion-1" class="collapse item-1">
                                <div class="card-body">
                                    <div class="shadow job-post">
                                        <hr />
                                        <div>
                                            <h4>Description</h4>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Venenatis cras sed felis eget velit aliquet sagittis id. Diam phasellus vestibulum lorem sed risus ultricies. Sit amet dictum sit amet justo donec enim. Egestas dui id ornare arcu odio ut.<br /></p>
                                            <hr />
                                        </div>
                                        <div>
                                            <h4>Requirements</h4>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Venenatis cras sed felis eget velit aliquet sagittis id. Diam phasellus vestibulum lorem sed risus ultricies. Sit amet dictum sit amet justo donec enim. Egestas dui id ornare arcu odio ut.<br /></p>
                                            <hr />
                                        </div>
                                        <div class="row">
                                            <div class="col-md-5 d-flex justify-content-between align-items-baseline"><i class="fas fa-location-arrow icons"></i>
                                                <p>Location</p>
                                            </div>
                                            <div class="col-md-5 offset-md-1 d-flex justify-content-between align-items-baseline"><i class="far fa-money-bill-alt icons"></i>
                                                <p>$50,000 year</p>
                                            </div>
                                        </div>
                                        <form class="d-flex justify-content-end"><button class="btn apply-btn" type="submit">Apply Now</button></form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default React.memo(SearchResult) 
