


var verifier = false;
function clickAdd() {
    verifier = !verifier;
    if (verifier) {
        document.getElementById("form_add_categorie_materiel").style.display = "flex";
        document.getElementById("dateclose").style.display = "none";
        document.getElementById("search_categorie_materiel").style.display = "none";
    }
    else {
        document.getElementById("form_add_categorie_materiel").style.display = "none";
        document.getElementById("dateclose").style.display = "flex";
        document.getElementById("search_categorie_materiel").style.display = "flex";
    }
}
function test(event) {
    var x = event.target;
    var firstChild = x.parentElement.parentElement.firstElementChild;
    document.querySelector(".cont_edit").style.display = "flex";
    var inputs = document.querySelectorAll(".cont_edit input");

    var v1 = firstChild.innerHTML;
    var v2 = firstChild.nextElementSibling.innerHTML;
    inputs[0].value = v1;
    inputs[1].value = v2;
}



function cancelEdit() {
    document.querySelector(".cont_edit").style.display = 'none';
}

           function sup(){
              Alert("dslmfkmlqds");
                 return confirm('voulez vous vraiment supprimer je message ???');
            }

