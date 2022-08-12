


function sumFibonacci() {

    let a:number=0;
    let b:number=1;
    let c:number;

    let sum:number=a+b;
    console.log(a);
    console.log(b);
    for(let i=0;i<10;i++){
        c=a+b;
        console.log(c)
        sum+=c;
        a=b;
        b=c;
    }
    console.log("Tong la: " + sum);
}

sumFibonacci();
