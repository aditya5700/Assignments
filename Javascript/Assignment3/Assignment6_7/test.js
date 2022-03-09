const json = '{"first":"Aditya", "last": "Yadav"}';
const name = JSON.parse(json);

document.write(name.first);
document.write(name.last)