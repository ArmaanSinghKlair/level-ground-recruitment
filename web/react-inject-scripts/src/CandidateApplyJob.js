import ENV from './ENV.js'

export default  function CandidateApplyJob(id, doAfter){   
    console.log(id);
    if(id!=null){
        const params={
            act: "apply",
            jpi: id
        }
        console.log(params);
        axios.get(ENV.CONTEXT_PATH+"/candidate-job-posting",{
            withCredentials: true,
            params:params
        }).then(res=>{
            console.log(res);
            doAfter(res.data);
        }).catch(e=>{
            console.log(e);
        })
    }
    
} 