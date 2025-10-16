document.addEventListener('DOMContentLoaded', () => {
  const productForm = document.getElementById('product-form');
  const productNameInput = document.getElementById('product-name');
  const productPriceInput = document.getElementById('product-price');
  const cartCount = document.getElementById('cart-count');
  const productList = document.getElementById('product-list');
  let totalPrice = 0.0;
  const notesList = new Map()

  let numberOfProducts = 0;

  document.getElementById('add-product').addEventListener('click', () => {
    const name = productNameInput.value;
    const price = parseFloat(productPriceInput.value);
    const product = {
        name: name,
        price: price
    };
    async function saveProduct(product){
        try{
            const response = await fetch('http://localhost:8080/product', {
                method: 'POST',
                headers: {'Content-Type': 'application/json'} ,
                body: JSON.stringify(product)
            });
        } catch(error){
            console.log('Erro ao adicionar produto')
        }

    }
    if(numberOfProducts < 10){
        saveProduct(product)
        numberOfProducts++;
        cartCount.textContent = numberOfProducts;
        console.log(productPriceInput)
        console.log(price)
        totalPrice = price + totalPrice
        console.log(totalPrice)
        const listItem = document.createElement('li');
        listItem.textContent = `${name} - R$ ${price}`;
        productList.appendChild(listItem);

        productNameInput.value = '';
        productPriceInput.value = '';
    } else {

    }
    
  });

  document.getElementById('complete-order').addEventListener('click', () => {
    async function getNotes(total){
        const baseUrl = 'http://localhost:8080/total';
        const completeUrl = `${baseUrl}/${total}`
        
        try{
            const response= await fetch(completeUrl);

            if (!response.ok) {
                throw new Error(`Erro na requisição: ${resposta.status}`);
            }

            const data = await response.json();
            const list = document.getElementById('notes-list');
            list.innerHTML = ''; 

            Object.entries(data).forEach(([note, quantity]) => {
            const item = document.createElement('li');
            item.textContent = `Nota de R$${note}: ${quantity}x`;
            list.appendChild(item);
            });
            return data
            

        } catch(error){
            console.error('Ocorreu erro')
        }
    }
    notesList = getNotes(totalPrice)
    
    });
    
});


