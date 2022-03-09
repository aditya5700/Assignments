export{}
let order={
    id:1,
    title:"Cake",
    price:400,
    printorder : function( ){
        return (this.id);
    },
    getPrice : function(){
        return (this.price);
    }
};

let order2=Object.assign({},order);
console.log(order);
console.log(order2);