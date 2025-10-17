window.addEventListener("DOMContentLoaded", () => {
    const listNotes = document.getElementById('notes-list')
    const listProducts = document.getElementById('products-list')
    listProducts.innerHTML = '';
    listNotes.innerHTML = '';
    const savedNotes = JSON.parse(localStorage.getItem("notes"));
    const savedProductsHTML = localStorage.getItem("products") ;
    Object.entries(savedNotes).forEach(([note, quantity]) => {
        const item = document.createElement('li');
        if(parseInt(note) !== 3) {
            item.textContent = `Nota de R$${note}: ${quantity}x`;
        } else{
            quantity = quantity * 100
            item.textContent = `O troco é de ${quantity} centavos`;
        }
        listNotes.appendChild(item);
    })
    if (savedProductsHTML) {
        listProducts.innerHTML = savedProductsHTML;
    }

})

