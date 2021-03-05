import CandidateAllJobs from './CandidateAllJobs.js'
import SearchResults from './SearchResults.js'
import SearchBar from './SearchBar.js'
import SearchContext from './SearchStateManager.js'

function SearchBarContainer() {
    const [searchState, dispatch] = React.useContext(SearchContext);

    React.useEffect(()=>{
        if(searchState.searchStart){
            CandidateAllJobs(searchState, function(res){
                setRows(res.data.data);
                setRowCount(res.data.rowCount);
                setError(null);
            })
            
        }
    },[searchState])
    const [rowCount, setRowCount] = React.useState(null);
    const [rows, setRows] = React.useState(null);
    const [error, setError] = React.useState(null);
    return (
            <div className="search-bar-container">
            {error != null ? <div className="alert alert-warning" role="alert" style={{border:"solid 1px orange"}}>&#9888; {error}</div> : null}
                <SearchBar setError={setError}/>
                <SearchResults rowCount={rowCount} rows={rows}/>
            </div>
    )
}

export default SearchBarContainer
