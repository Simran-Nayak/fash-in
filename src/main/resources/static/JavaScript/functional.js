function homePage(){
    const nextBtn = document.querySelector('.next-btn');
    const prevBtn = document.querySelector('.pre-btn');
    const productContainer = document.querySelector('.product-container');

    nextBtn.addEventListener('click', () => {
        productContainer.scrollBy({ left: 300, behavior: 'smooth' });
    });
    prevBtn.addEventListener('click', () => {
        productContainer.scrollBy({ left: -300, behavior: 'smooth' });
    });
}
homePage();


document.addEventListener("DOMContentLoaded", () =>{
    function admin() {
        let editbtn = document.getElementById("editbutton1");
        let delbtn = document.getElementById("deletebutton");
        let frm = document.getElementById("form");
        let btn = document.getElementById("btn1")
    
        editbtn.addEventListener('click', () => {
            frm.style.display = "block";
        });
    }
    admin();
    });


// document.addEventListener("DOMContentLoaded", function () {
//     let swipebutton = document.getElementById("parentbtn");
//     let container = document.getElementById("child");
//     let searchbtn=document.getElementById("subbtn");

//     swipebutton.addEventListener("click", () => {
//         container.classList.toggle("active");
//     })
// });





