/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

const N = parseInt(readline());

puissances=[]
for (let i = 0; i < N; i++) {
    const pi = parseInt(readline())
    puissances.push(pi)
}
puissances=puissances.sort((a, b)=>{return a - b})
//console.log(puissances)

let diff=999999999999999
for(let i=0; i < puissances.length-1; i++) {
    let p1 = puissances[i]
    let p2 = puissances[i+1]
    diff = Math.min(diff, Math.abs(p2-p1))
}
console.log(diff);
