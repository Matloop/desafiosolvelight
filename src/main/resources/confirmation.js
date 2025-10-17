window.addEventListener("DOMContentLoaded", () => {
    const list = document.getElementById('notes-list')
    list.innerHTML = '';
    const savedProducts = JSON.parse(localStorage.getItem("notes"));
    const productsList = JSON.parse(localStorage.getItem("products"))
    Object.entries(savedProducts).forEach(([note, quantity]) => {
        const item = document.createElement('li');
        if(parseInt(note) !== 3) {
            item.textContent = `Nota de R$${note}: ${quantity}x`;
        } else{
            item.textContent = `O troco é de ${quantity} centavos`;
        }

        list.appendChild(item);
    })
    Object.entries(productsList).forEach(([name, price]) => {
        const item = document.createElement('li');
        item.textContent = `Produto adicionado ${name} ${price}`
    })
})

