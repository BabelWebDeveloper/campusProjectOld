const retrieveProducts = () => {
    return new Promise( (resolve, reject) => {
        fetch('http://localhost:8080/api/product')
            .then( async result => {

                const data = await result.json();
                resolve(data);

            } )
            .catch( err => {
                reject(err);
            } );
    } );
}

retrieveProducts()
    .then( products => {
        const wrapper = document.querySelector('#shopbar');
        products.forEach( product => {
            wrapper.innerHTML += `
            <article class="shopbar__item">
            <div class="shopbar__item--img">
              <img src="img/watch.jpg" class="shopbar__item--img--img" alt="">
            </div>

            <p class="shopbar__item--name">${product.name}</p>
            <p class="shopbar__item--desc">${product.description}</p>

            <div class="shopbar__item--cartPriceBar">
              <p class="shopbar__item--cartPriceBar-price">${product.price} zł</p>
              <p role="button" class="shopbar__item--cartPriceBar-button">Dodaj do koszyka</p>
            </div>
          </article>
            `
        } );
    } );