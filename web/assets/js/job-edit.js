/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function openJobEdit(id) {
    let hiddenButtons = document.getElementById("hiddenButtons");
    let editButton = document.getElementById("editButton");
    let input = document.getElementsByName(id);


    for (let i = 0; i < input.length; i++) {
        input[i].disabled = false;
    }

    hiddenButtons.style.visibility = "visible";
    editButton.style.visibility = "hidden";
}

function cancelJobEdit(id) {
    let x = document.getElementById("hiddenButtons");
    let y = document.getElementById("editButton");
    let z = document.getElementsByName(id);

    for (let i = 0; i < z.length; i++) {
        z[i].disabled = true;
    }

    hiddenButtons.style.visibility = "hidden";
    editButton.style.visibility = "visible";
}

function revertChanges() 
{
    let forms = document.getElementsByClassName("job-forms");

    for (let i = 0; i < forms.length; i++) {
        forms[i].reset();
        for (let j = 0; j < forms[i].elements.length; j++) {
            forms[i].elements[j].disabled = true;
        }
    }

    let hiddenButtons = document.getElementById("hiddenButtons");
    let editButton = document.getElementById("editButton");
    hiddenButtons.style.visibility = "hidden";
    editButton.style.visibility = "visible";

    document.getElementsByName("jobEditBtns").forEach(element => {

        element.removeAttribute("disabled");
    });
}


