const userUrl = 'http://localhost:8080/api/currentUser';


function getUserPage() {
    fetch(userUrl).then(response => response.json()).then(user =>
        getInformationAboutUser(user))
}

function getInformationAboutUser(user) {

    let result = '';
    result =
        `<tr>
    <td>${user.id}</td>
    <td>${user.name}</td>
    <td>${user.surname}</td>
    <td>${user.department}</td>
    <td>${user.salary}</td>
    <td>${user.userName}</td>
    <td id=${'role' + user.id}>${user.role.map(r => r.role.substring(5)).join(', ')}</td>
</tr>`
    document.getElementById('userTableBody').innerHTML = result;
}

getUserPage();
