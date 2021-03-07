import CandidateAllJobs from './CandidateAllJobs.js'
import SearchResults from './SearchResults.js'
import SearchBar from './SearchBar.js'
import SearchContext from './SearchStateManager.js'
import {SearchStateActions} from './SearchStateReducer.js';

function SearchBarContainer() {
    const [searchState, dispatch] = React.useContext(SearchContext);

    React.useEffect(()=>{
        if(searchState.searchStart){
            CandidateAllJobs(searchState, function(res){
                console.log(res.data)
                setRows(res.data.data);
                setRowCount(res.data.rowCount);
                setError(null);
                setHasMore(res.data.hasMore);
            })
            
        }
    },[searchState])
    const [rowCount, setRowCount] = React.useState(null);
    const [rows, setRows] = React.useState(null);
    const [error, setError] = React.useState(null);
    const [success, setSuccess] = React.useState(null);
    const [hasMore, setHasMore] = React.useState(false);
    return (
            <div className="search-bar-container">
            {error != null ? <div className="alert alert-warning" role="alert" style={{border:"solid 1px orange"}}>&#9888; {error}</div> : null}
            {success != null ? <div class="alert alert-success" role="alert"><span>{success}</span></div> : null}
                <SearchBar setError={setError}/>
                <SearchResults rowCount={rowCount} rows={rows} setSuccess={setSuccess} setError={setError} hasMore={hasMore}/>
            </div>
    )
}

export default SearchBarContainer
