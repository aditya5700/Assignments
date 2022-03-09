export{}
var arrow = (names: string[] )=> {
    let out = [];
    for(let color of names ){
        var row : any= {

        };
        row.name = color;
        row.length = color.length;
        out.push(row);
    }
    return out;
};

let names =  ["Aditya", "Gauri", "Pratik"];
console.log(arrow(names));