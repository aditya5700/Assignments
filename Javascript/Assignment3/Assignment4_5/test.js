class Person
{
    constructor(first,middle,last)
    {
        this.first = first;
        this.middle = middle;
        this.last = last;
    }
    
}

var per1 = new Person("Aditya");
per1.middle = "Chandrashekhar";
per1.last = "Yadav"
document.write(per1.first + " " + per1.middle + " " + per1.last);