/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function registerCandidate()
{
    let firstName = document.getElementById("candidateFirstName");
    let lastName = document.getElementById("candidateLastName");
    let company = document.getElementById("businessCompany");

    firstName.disabled = false;
    lastName.disabled = false;
    company.disabled = true;

    firstName.style.display = "block";
    lastName.style.display = "block";
    company.style.display = "none";
}

function registerBusinessClient()
{
    let firstName = document.getElementById("candidateFirstName");
    let lastName = document.getElementById("candidateLastName");
    let company = document.getElementById("businessCompany");

    firstName.disabled = true;
    lastName.disabled = true;
    company.disabled = false;

    firstName.style.display = "none";
    lastName.style.display = "none";
    company.style.display = "block";
}

