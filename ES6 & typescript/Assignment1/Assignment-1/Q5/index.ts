export{}
let addvalue=function(a=10){
    console.log(a);
};
addvalue();
addvalue(20);
var names=["A","B","C","D","E"];
let userFriends=function(username: any,...friends: any)
{
    console.log(username)
    for(let friend of friends){
        console.log(friend);
    } 
}
var username="Aditya";
userFriends(username,names);

let printcapitalname=function(...names:any){
    for(let name of names){
        console.log(name.toUpperCase());
    }
}
printcapitalname(...names);