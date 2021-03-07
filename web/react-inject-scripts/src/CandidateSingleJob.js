import ENV from './ENV.js'

export default  function CandidateSingleJob(id, doAfter){
    if(id!=null){
        axios.get(ENV.CONTEXT_PATH+"/job-search",{
            withCredentials: true,
            params:{
               jpi: id
            }
        }).then(res=>{
            doAfter(res);
        }).catch(e=>{
            console.log(e);
        })
    }
    
} 