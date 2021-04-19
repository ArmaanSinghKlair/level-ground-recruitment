import CandidateApplyJob from "./CandidateApplyJob.js";
import CandidateSingleJob from "./CandidateSingleJob.js";

import ENV from "./ENV.js";

function SearchResult({ row, setSuccess, setError, index }) {
  const [expanded, setExpanded] = React.useState(false);
  const [curRow, setCurRow] = React.useState(null);

  React.useEffect(() => {
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
        let err = "";
        data.errors.forEach((e) => {
          err += " " + e;
        });
        setError(err);
        window.scrollTo(0, 0);
      }
    });
  }
  return (
    <div className="row">
      <div className="col">
        <div role="tablist" id={`accordion-${index}`} className="accordion">
          <div className="accordion-item">
            <h2 className="card-header" role="tab">
              <button
                className="accordion-button more-btn accordion-button"
                data-bs-toggle="collapse"
                data-bs-target={`#accordion-${index} .item-${index}`}
                aria-expanded="true"
                aria-controls={`accordion-${index} .item-${index}`}
              >
                {row.jobTitle}
                <span className="badge rounded-pill bg-secondary job-badge">
                  {row.jobStatus}
                </span>
              </button>

               <div className="d-md-flex justify-content-md-between align-items-md-baseline job-header">
                <h1 className="display-4">{row.jobTitle}</h1>
                <p className="text-muted">
                  Posted on: {new Date(row.postDate).toDateString()}
                </p>
              </div>
              <div className="d-md-flex justify-content-md-between align-items-md-baseline job-status">
                <p className="lead">{row.jobStatus}</p>
                <p className="text-muted">
                  Expires on:{" "}
                  {row.endDate == null
                    ? "Not specified"
                    : new Date(row.endDate).toDateString()}
                </p>
              </div>
              <h3
                className="d-flex justify-content-end mb-0"
                onClick={() => setExpanded(true)}
              >
                <a
                  data-bs-toggle="collapse"
                  aria-expanded="true"
                  aria-controls={`accordion-${index} .item-1`}
                  href={`#accordion-${index} .item-1`}
                  className="more-btn accordion-button"
                ></a>
              </h3> 
            </h2>
            <div
              className={`accordion-collapse collapse show item-${index}`}
              role="tabpanel"
              data-bs-parent={`#accordion-${index}`}
            >
              <div className="card-body">
                <div className="shadow job-post">
                  <div>
                    <h4>Description</h4>
                    {curRow == null ? (
                      <div className="empty-result">
                        <img
                          src={
                            ENV.CONTEXT_PATH +
                            "/react-inject-scripts/assets/loading.gif"
                          }
                        />
                      </div>
                    ) : (
                      <p>{curRow.jobDescription}</p>
                    )}
                    <br />
                    <hr />
                  </div>
                  <div>
                    <h4>Requirements</h4>
                    {curRow == null ? (
                      <div className="empty-result">
                        <img
                          src={
                            ENV.CONTEXT_PATH +
                            "/react-inject-scripts/assets/loading.gif"
                          }
                        />
                      </div>
                    ) : (
                      <p>{curRow.requirements}</p>
                    )}
                    <hr />
                  </div>

                  <div className="row">
                    <div className="col d-flex align-self-center">
                      <i className="fas fa-map-pin business-icon"></i>
                      {curRow == null ? (
                        <div className="empty-result">
                          <img
                            src={
                              ENV.CONTEXT_PATH +
                              "/react-inject-scripts/assets/loading.gif"
                            }
                          />
                        </div>
                      ) : (
                        <p className="lead">{curRow.location}</p>
                      )}
                    </div>
                    <div className="col d-flex align-self-center">
                      <i className="fas fa-money-bill-alt business-icon"></i>
                      {curRow == null ? (
                        <div className="empty-result">
                          <img
                            src={
                              ENV.CONTEXT_PATH +
                              "/react-inject-scripts/assets/loading.gif"
                            }
                          />
                        </div>
                      ) : (
                        <p className="lead">${curRow.wage} yearly</p>
                      )}
                    </div>
                  </div>
                  <div className="row">
                    <div className="col d-flex align-self-center">
                      <i className="fas fa-hourglass-start business-icon"></i>
                      <p className="lead">{curRow!=null?new Date(curRow.startDate).toDateString():"Not specified"}</p>
                    </div>
                    <div className="col d-flex align-self-center">
                      <i className="fas fa-hourglass-end business-icon"></i>
                      <p className="lead">{curRow!=null?new Date(curRow.endDate).toDateString():"Not specified"}</p>
                    </div>
                  </div>
                  <div className="d-flex justify-content-end">
                    <button
                      className="btn apply-btn"
                      onClick={() => applyJob()}
                    >
                      Apply Now
                    </button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default React.memo(SearchResult);