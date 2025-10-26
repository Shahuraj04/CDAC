function displayDropDown(data) {
    let str = "<select id='userid'>";
    for (let v of data) {
        str += `<option value='${v.id}'>${v.id}</option>`;

    }
    str += "</select>";
    document.getElementById("mydiv").innerHTML = str;
}
function diplayText(data){
    var str="USERId : "+data.userId+"<br/>";
    str+="Id : "+data.id+"<br/>";
    str+="Title : "+data.title+"<br/>";
    str+="Body: "+data.body+"<br/>";

    document.getElementById("mydiv1").innerHTML=str;


}
// function diplayText(data){
//     var str="<h1 id='text'>";
//     for(let v of data){
//         str+=`'${v.title}'<br/>`;

//     }
//     str+="</h2>";
//     document.getElementById("mydiv1").innerHTML=str;
    


// }
async function getDetailsInDrop() {
    const response = await fetch("https://jsonplaceholder.typicode.com/posts");
    if (response.ok) {
        const data = await response.json();
        displayDropDown(data);
        diplayText(data);
    } else {
        console.error("Failed to fetch data:", response.status);
    }
}
