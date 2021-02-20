/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function openJobEdit(id) {
    let hiddenButtons = document.getElementById("hiddenButtons" + id);
    let editButtons = document.getElementById("editButtons" + id);
    let input = document.getElementsByName(id);


    for (let i = 0; i < input.length; i++) {
        input[i].disabled = false;
    }

    hiddenButtons.style.display = "block";
    editButtons.style.display = "none";
}

function cancelJobEdit(id) {
    let hiddenButtons = document.getElementById("hiddenButtons" + id);
    let editButtons = document.getElementById("editButtons" + id);
    let input = document.getElementsByName(id);

    for (let i = 0; i < input.length; i++) {
        input[i].disabled = true;
    }

    hiddenButtons.style.display = "none";
    editButtons.style.display = "block";
}

function revertChanges()
{
    let forms = document.getElementsByClassName("job-forms");

    for (let i = 0; i < forms.length; i++) {
        forms[i].reset();

        //runs for elements length -2 because the last 2 are the submit/cancel buttons
        for (let j = 0; j < forms[i].elements.length - 2; j++) {
            forms[i].elements[j].disabled = true;
        }
    }

    let hiddenButtons = document.getElementsByName("hiddenButtons");
    let editButtons = document.getElementsByName("editButtons");

    hiddenButtons.forEach(element =>
    {
        element.style.display = "none";
    });

    editButtons.forEach(element =>
    {
        element.style.display = "block";
    });

}

function confirmDelete(id)
{
    swal({
        title: "Delete Job Posting ID: " + id,
        text: "Are you sure you want to delete this job?",
        icon: "warning",
        buttons: ["Cancel", "Delete"],
        dangerMode: true,
    })
            .then((willDelete) => {
                if (willDelete) {
                    swal("Job deleted", {
                        icon: "success",
                    }).then(function () 
                    {
                        window.location = "BusinessClientTestServlet?deleteID="+id;
                    });
                    
                } else {
                    swal("Job was not deleted");
                }
            });
}


