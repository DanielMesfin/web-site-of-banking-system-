const formValidation=document.querySelector('form');
formValidation.addEventListener('submit',e=>{
    if(!formValidation.checkValidity()){
        e.preventDefault();
    }
    formValidation.classList.add("was-validated");
})