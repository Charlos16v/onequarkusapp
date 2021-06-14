var ip = 'http://localhost:8080'

var section = document.querySelector('.inventory');

function makeCards(doc){
    const card = document.createElement('div');
                card.className = 'item-card'
                card.innerHTML += `
                    <h3>${doc.name}</h3>
                    <i class="fas fa-lemon"></i>
                    <div class="properties">
                        <h4>Description: ${doc.description}</h4>
                    </div>
                    <button onclick="buyItem(this)">Buy</button>
                    <button onclick="deleteItem(this)">Delete</button>`;
                card.setAttribute("name", doc.name)
                card.setAttribute("sell_in", doc.description)
                section.appendChild(card);
}

function removeCards() {
    var e = document.querySelector(".inventory");
        e.innerHTML = "";
}

function wait(ms)
{
    var d = new Date();
    var d2 = null;
    do { d2 = new Date(); }
    while(d2-d < ms);
}

function loadItems() {
    removeCards();
    fetch(`${ip}/fruits`)
        .then(response => response.json()) //response to JSON
        .then(data => {
            if (Array.isArray(data)) {
                data.forEach(doc => {
                    makeCards(doc);
                });
            } else {
                alert(data.message)
            }
        })
        .catch(error => console.log('It was an error: ' + error.message))
}

let form = document.querySelector('.add-del-item');
form.add.addEventListener('click', addItem)

function addItem(e) {
    e.preventDefault();

    let data = {
        name: form.elements.name.value,
        description: form.elements.description.value,

    };

    if (data.name === ""|| data.description === "") {
        alert("You must fill all fields")
    } else {
        fetch(`${ip}/fruits`, {
            method: 'POST',
            body: JSON.stringify(data),
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(response => response.json())
            .then(data => {
                    alert("Fruit " + data.name + " added!")
                }
            )
            .catch((error) => {
                console.log(error);
            });
        wait(500);
        loadItems();
    }
}

form.delete.addEventListener('click', deleteItem);

function deleteItem(e) {
    e.preventDefault();

    let data = {
        name: form.elements.name.value,
        sell_in: form.elements.description.value

    };
    fetch(`${ip}/fruits/${data.name}`, {
        method: 'DELETE'
    })
        .then(response => response.json())
        .then(data => {
                alert('Deleted item' + data.name)
            }
        )
        .catch(error => console.log('It was an error: ' + error))
    wait(500);
    loadItems();
    }


let filterForm = document.querySelector('.filter-item');
filterForm.filter.addEventListener('click', filterItem);

function filterItem(e) {
    e.preventDefault();

    let property = document.getElementById("property").value;
    let value = document.getElementById("itemValue").value;

    removeCards();
    fetch(`${ip}/item/${property}/${value}`)
        .then(response => response.json())
        .then(data => {
            if (Array.isArray(data)) {
                data.forEach(doc => {
                    makeCards(doc);
                });
            } else {
                alert(data.message)
            }
        })
        .catch(error => console.log('It was an error: ' + error.message))
}

function updateQuality() {
    removeCards();
    fetch(`${ip}/update_quality`)
        .then(response => response.json())
        .then(data => {
            if (Array.isArray(data)) {
                data.forEach(doc => {
                    makeCards(doc);
                });
            } else {
                alert(data.message)
            }
        })
        .catch(error => console.log('It was an error: ' + error.message))
}

function getPersonalInventory(e) {
    e.preventDefault();
    removeCards();

    let data = {
        user_name: formPersonalInventory.elements.name.value,
        password: formPersonalInventory.elements.password.value
    };

    fetch(`${ip}/user/inventory`, {
        method: 'PUT',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => response.json())
        .then(data => {
            if (Array.isArray(data)) {
                data.forEach(doc => {
                    makeCards(doc);
                });
            } else {
                alert(data.message)
            }
        })
        .catch(error => console.log('It was an error: ' + error.message))

}

function buyItem(button){
    let item = button.parentElement;
    let user = prompt("Introduce your user name:");
    if (user===null) {
        return;
    }
    let password = prompt(`Introduce the password for the user ${user}`)
    if (password===null) {
        return;
    }

    let data = {
        user_name: user,
        password: password,
        name: item.getAttribute("name"),
        sell_in: item.getAttribute("sell_in"),
        quality: item.getAttribute("quality")
    };

    fetch(`${ip}/buy`, {
        method: 'PUT',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(response => response.json())
        .then(data => {
                alert(data.message)
            }
        )
        .catch(error => console.log('It was an error: ' + error.message))
    wait(500);
    loadItems();
}

function deleteItem(button){
    let item = button.parentElement;

    let data = {
        name: item.getAttribute("name"),
        sell_in: item.getAttribute("description")
    };

    fetch(`${ip}/fruits/${data.name}`, {
        method: 'DELETE'
    })
        .then(response => response.json())
        .then(data => {
                alert('Deleted item' + data.name)
            }
        )
        .catch(error => console.log('It was an error: ' + error))
    wait(500);
    loadItems();
}