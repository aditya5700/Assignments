var addvalue = function (a) {
    if (a === void 0) { a = 10; }
    document.write(a);
};
addvalue();
addvalue(20);
var names = ["A", "B", "C", "D", "E"];
var userFriends = function (username) {
    var friends = [];
    for (var _i = 1; _i < arguments.length; _i++) {
        friends[_i - 1] = arguments[_i];
    }
    document.write(username);
    for (var _a = 0, friends_1 = friends; _a < friends_1.length; _a++) {
        var friend = friends_1[_a];
        document.write(friend);
    }
};
var username = "Aditya";
userFriends(username, names);
var printcapitalname = function () {
    var names = [];
    for (var _i = 0; _i < arguments.length; _i++) {
        names[_i] = arguments[_i];
    }
    for (var _a = 0, names_1 = names; _a < names_1.length; _a++) {
        var name_1 = names_1[_a];
        document.write(name_1.toUpperCase());
    }
};
printcapitalname.apply(void 0, names);
