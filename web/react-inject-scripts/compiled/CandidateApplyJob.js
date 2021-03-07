import ENV from './ENV.js';

export default function CandidateApplyJob(id, doAfter) {
    console.log(id);
    if (id != null) {
        var params = {
            act: "apply",
            jpi: id
        };
        console.log(params);
        axios.get(ENV.CONTEXT_PATH + "/candidate-job-posting", {
            withCredentials: true,
            params: params
        }).then(function (res) {
            console.log(res);
            doAfter(res.data);
        }).catch(function (e) {
            console.log(e);
        });
    }
}