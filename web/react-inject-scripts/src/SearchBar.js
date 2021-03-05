import ENV from './ENV.js'
import SearchContext from './SearchStateManager.js';
import {SearchStateActions} from './SearchStateReducer.js';

import Tag from './Tag.js';
function SearchBar({setError}) {
    const [searchState, dispatch] = React.useContext(SearchContext);
    const handleTagClick = (name)=>{
        return dispatch({
            type:SearchStateActions.INSERT_VALUE,
            payload: {
                [name]: null,
                searchStart: false
            } 
        })
    }
    const jobTypes = React.useMemo(()=>[
        'Full-Time','Internship','Part-Time','Contract','Temporary','Commission','Volunteer','Casual','Permanent','Fly-In/Fly-Out'
    ],[]);
    const ignoredTags = ['pn','searchStart']

    const handleSearch = React.useCallback(()=>{
        let payload = {};
        if(Number(salaryRef.current.value) < 0){
            setError("Salary cannot be negative");
            return;
        } else{
            if(salaryRef.current.value != null && salaryRef.current.value != "")
                payload.sal= salaryRef.current.value
            
        }

        if(searchRef.current.value.trim().length>0){
           payload = {
            [searchTypeRef.current.value]: searchRef.current.value,
            ...payload
           }
        }

        if(jobTypes.indexOf(jobTypeRef.current.value) != -1){
            payload.stat= jobTypeRef.current.value;
        }
        if(payload != null){
            payload.searchStart = true;
        }else{
            payload.searchStart = false;
        }
        dispatch({
            type: SearchStateActions.INSERT_VALUE,
            payload: payload
        })
    },[]);

    const searchRef = React.useRef();
    const searchTypeRef = React.useRef();
    const jobTypeRef = React.useRef();
    const salaryRef = React.useRef();

    return (
        <div className="search-bar">
            <div className="row">
            <select name="searchType" ref={searchTypeRef}>
                <option value="ti">Title</option>
                <option value="loc">Location</option>
            </select>
            <input type="text" name="search" id="search-input" placeholder="Job title or location" ref={searchRef} />
            <div className="search-bar__button" onClick={()=>handleSearch()}><img src={ENV.CONTEXT_PATH+"/react-inject-scripts/assets/search.svg"} /></div>
            </div>

            <div className="row">
                <select name="jobType" ref={jobTypeRef}>
                    <option>Job Type</option>
                    {
                        jobTypes.map((type,i)=><option value={type} key={i}>{type}</option>)
                    }
                    
                </select>
                <input type="number" min="0" placeholder="Salary Per year" ref={salaryRef}/>
            </div>

            <div className="row tag-row">
                {
                    Object.keys(searchState).filter(key=>searchState[key] != null && ignoredTags.indexOf(key)==-1).map((key,i)=>{
                        return <Tag name={key} value={searchState[key]} onClick={()=>handleTagClick(key)} key={i} />
                    })
                }
            </div>
        </div>
        //(name)=>handleTagClick(name)
    )
}

export default React.memo(SearchBar)
