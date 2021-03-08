import ENV from './ENV.js'

export default  function CandidateAllJobs(state, doAfter){
    let param = {}
    Object.keys(state).filter(key=>state[key]!=null).forEach(key=>{
       param[key] = state[key]
    })
    
    if(Object.keys(param).length >1){
        axios.get(ENV.CONTEXT_PATH+"/job-search",{
            withCredentials: true,
            params:{
                pl:1,
                pn: state.pn,
                ...param
            }
        }).then(res=>{
            doAfter(res);
        }).catch(e=>{
            console.log(e);
        })
    }else{
        
    }
    
} 