import ENV from './ENV.js';

export default function CandidateSingleJob(id, doAfter) {
    if (id != null) {
        axios.get(ENV.CONTEXT_PATH + "/job-search", {
            withCredentials: true,
            params: {
                jpi: id
            }
        }).then(function (res) {
            doAfter(res);
        }).catch(function (e) {
            console.log(e);
        });
    }
}