import ENV from './ENV.js';

export default function CandidateAllJobs(state, doAfter) {
    var param = {};
    Object.keys(state).filter(function (key) {
        return state[key] != null;
    }).forEach(function (key) {
        param[key] = state[key];
    });

    if (Object.keys(param).length > 1) {
        axios.get(ENV.CONTEXT_PATH + "/job-search", {
            withCredentials: true,
            params: Object.assign({
                pl: 1,
                pn: state.pn
            }, param)
        }).then(function (res) {
            doAfter(res);
        }).catch(function (e) {
            console.log(e);
        });
    } else {}
}