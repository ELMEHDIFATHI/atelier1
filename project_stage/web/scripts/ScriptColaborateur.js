  function searchTable() {

                    var input, filter, table, tr, td, i, txtValue;
                    input = document.getElementById("search_colaborateur");
                    filter = input.value.toUpperCase();
                    table = document.getElementById("table_colaborateur");
                    tr = table.getElementsByTagName("tr");
                    for (i = 0; i < tr.length; i++) {
                        td = tr[i].getElementsByTagName("td")[1];
                        if (td) {
                            txtValue = td.textContent;
                            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                                tr[i].style.display = "";
                            } else {
                                tr[i].style.display = "none";
                            }
                        }
                    }
                }
                
                 var  verifier=false;
              function clickAdd(){
                  verifier =! verifier;
                  if(verifier){
                      document.getElementById("form_add_colaborateur").style.display="flex";
                      document.getElementById("dateclose").style.display="none";
                          document.getElementById("search_colaborateur").style.display="none";       
                  }
                  else{
                       document.getElementById("form_add_colaborateur").style.display="none";
                      document.getElementById("dateclose").style.display="flex";
                         document.getElementById("search_colaborateur").style.display="flex";
                  }
              }
              
                function test(event){
                   var x = event.target;
                   var firstChild=x.parentElement.parentElement.firstElementChild;
                    document.querySelector(".cont_edit").style.display = "flex";
                    var inputs = document.querySelectorAll(".cont_edit input");
                   
                   	var v1=firstChild.innerHTML;
		var v2=firstChild.nextElementSibling.innerHTML;
		var v3=firstChild.nextElementSibling.nextElementSibling.innerHTML;
		var v4=firstChild.nextElementSibling.nextElementSibling.nextElementSibling.innerHTML;
		var v5=firstChild.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.innerHTML;
		var v6=firstChild.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.innerHTML;
		inputs[0].value=v1;
		inputs[1].value=v2;
		inputs[2].value=v3;
		inputs[3].value=v4;
		inputs[4].value=v5;
		inputs[5].value=v6;
                     
                   }
                
                
            
                function cancelEdit() {
                    document.querySelector(".cont_edit").style.display = 'none';
                }


                            
                            