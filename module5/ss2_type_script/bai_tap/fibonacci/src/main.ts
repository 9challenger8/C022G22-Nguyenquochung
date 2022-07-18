


function sumFibonacci() {

    let a:number=0;
    let b:number=1;
    let c:number;

    console.log(a);
    console.log(b);
    for(let i=0;i<10;i++){
        c=a+b;
        console.log(c)
        a=b;
        b=c;
    }

    a=0;
    b=1;

    let sum:number=a+b;

    for(let i=0;i<10;i++){
        c=a+b;
        sum += c;
        a=b;
        b=c;
    }

    console.log("Tong la: " + sum);
}

sumFibonacci();