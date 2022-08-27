function sumFibonacci() {
    var a = 0;
    var b = 1;
    var c;
    console.log(a);
    console.log(b);
    for (var i = 0; i < 10; i++) {
        c = a + b;
        console.log(c);
        a = b;
        b = c;
    }
    a = 0;
    b = 1;
    var sum = a + b;
    for (var i = 0; i < 10; i++) {
        c = a + b;
        sum += c;
        a = b;
        b = c;
    }
    console.log("Tong la: " + sum);
}
sumFibonacci();
