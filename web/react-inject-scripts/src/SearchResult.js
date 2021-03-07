import CandidateApplyJob from './CandidateApplyJob.js';
import CandidateSingleJob from './CandidateSingleJob.js'

import ENV from './ENV.js';

function SearchResult({row, setSuccess, setError, index}) {
    const [expanded, setExpanded] = React.useState(false);
    const [curRow, setCurRow] = React.useState(null);
    
    React.useEffect(()=>{
        if(expanded){
            CandidateSingleJob(row.jobpostingID, function(res){
                setCurRow(res.data)
            })
            
        }
    },[expanded])

    function applyJob(){
        CandidateApplyJob(row.jobpostingID, function(data){
            if(data.querySuccessfull){
                setSuccess("Applied to job")
                setError(null)
                window.scrollTo(0,0)
            }else{
                setSuccess(null)
                let err =""
                data.errors.forEach(e=>{
                    err +=" "+e
                })
                setError(err)
                window.scrollTo(0,0)
            }
        })
    }
    return (
        <div className="search-result">
           <div className="row">
                <div className="col">
                    <div role="tablist" id={`accordion-${index}`}>
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
                                                                            aria-controls={`accordion-${index} .item-1`}
                                                                            href={`#accordion-${index} .item-1`}
                                                                            className="more-btn accordion-button"></a></h3>
                            </div>
                            <div className="collapse  item-1" role="tabpanel" data-bs-parent={`#accordion-${index}`}>
                                <div className="card-body">
                                    <div className="shadow job-post">
                                        <hr />
                                            <div>
                                                <h4>Description</h4>
                                                    {curRow == null
                                                ?
                                                    <div className="empty-result">
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
                                                    <div className="empty-result">
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
                                                    <div className="empty-result">
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
                                                    <div className="empty-result">
                                                        <img src={ENV.CONTEXT_PATH+"/react-inject-scripts/assets/loading.gif"} />
                                                    </div>
                                                :
                                                    <p>${curRow.wage} yearly</p>
                                                    }
                                                </div>
                                            </div>
                                            <div className="d-flex justify-content-end">
                                                <button className="btn apply-btn" onClick={()=>applyJob()}>Apply Now</button>
                                            </div>
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
