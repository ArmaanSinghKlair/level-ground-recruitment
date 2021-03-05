import CandidateSingleJob from './CandidateSingleJob.js'
import ENV from './ENV.js';

function SearchResult({row}) {
    const [expanded, setExpanded] = React.useState(false);
    const [curRow, setCurRow] = React.useState(null);

    React.useEffect(()=>{
        if(expanded){
            CandidateSingleJob(row.jobpostingID, function(res){
                setCurRow(res.data)
            })
            
        }
    },[expanded])
    return (
        <div className="search-result">
           <div className="row">
                <div className="col">
                    <div role="tablist" id="accordion-1">
                        <div className="card">
                            <div className="card-header" role="tab">
                                <div className="d-md-flex justify-content-md-between align-items-md-baseline job-header">
                                    <h1 className="display-4">{row.jobTitle}</h1>
                                    <p className="text-muted">Posted on: {new Date(row.postDate).toDateString()}</p>
                                </div>
                                <div className="d-md-flex justify-content-md-between align-items-md-baseline job-status">
                                    <p className="lead">{row.jobStatus}</p>
                                    <p className="text-muted">Expires on: {row.endDate==null?"Not specified":new Date(row.endDate).toDateString()}</p>
                                </div>
                                <h3 className="d-flex justify-content-end mb-0" onClick={()=>setExpanded(true)}><a data-bs-toggle="collapse" aria-expanded="true"
                                                                            aria-controls="accordion-1 .item-1"
                                                                            href="#accordion-1 .item-1"
                                                                            className="more-btn accordion-button"></a></h3>
                            </div>
                            <div className="collapse  item-1" role="tabpanel" data-bs-parent="#accordion-1">
                                <div className="card-body">
                                    <div className="shadow job-post">
                                        <hr />
                                            <div>
                                                <h4>Description</h4>
                                                    {curRow == null
                                                ?
                                                    <div className="empty-row">
                                                        <img src={ENV.CONTEXT_PATH+"/react-inject-scripts/assets/loading.gif"} />
                                                    </div>
                                                :
                                                    <p>{curRow.jobDescription}</p>
                                                    }
                                                <br />
                                                <hr />
                                            </div>
                                            <div>
                                                <h4>Requirements</h4>
                                                {curRow == null
                                                ?
                                                    <div className="empty-row">
                                                        <img src={ENV.CONTEXT_PATH+"/react-inject-scripts/assets/loading.gif"} />
                                                    </div>
                                                :
                                                    <p>{curRow.requirements}</p>
                                                    }
                                                <hr />
                                            </div>

                                            <div className="row">
                                                <div className="col-md-5 d-flex justify-content-between align-items-baseline"><i
                                                        className="fas fa-location-arrow icons"></i>
                                                    {curRow == null
                                                ?
                                                    <div className="empty-row">
                                                        <img src={ENV.CONTEXT_PATH+"/react-inject-scripts/assets/loading.gif"} />
                                                    </div>
                                                :
                                                    <p>{curRow.location}</p>
                                                    }
                                                </div>
                                                <div className="col-md-5 offset-md-1 d-flex justify-content-between align-items-baseline">
                                                    <i className="far fa-money-bill-alt icons"></i>
                                                    {curRow == null
                                                ?
                                                    <div className="empty-row">
                                                        <img src={ENV.CONTEXT_PATH+"/react-inject-scripts/assets/loading.gif"} />
                                                    </div>
                                                :
                                                    <p>${curRow.wage} yearly</p>
                                                    }
                                                </div>
                                            </div>
                                            <form className="d-flex justify-content-end">
                                                <button className="btn apply-btn" type="submit">Apply Now</button>
                                            </form>
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
