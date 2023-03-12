let rstmr;
let qrtmr;


function resultTimer () {
    let elem = document.getElementById("bar");
    let width = 1;
    rstmr = setInterval(frame, 10);
    function frame() {
        if (width >= 100) {
            clearInterval(rstmr);
            location.href="http://localhost:8080/"
        } else {
            width = (width * 10 + 3) / 10;
            elem.style.width = width + '%';
        }
    }
}

function qrTimer () {
    let elem = document.getElementById("bar");
    let width = 1;
    qrtmr = setInterval(frame, 10);
    function frame() {
        if (width >= 100) {
            clearInterval(qrtmr);
            location.href="http://localhost:8080/"
        } else {
            width = (width * 10 + 1) / 10;
            elem.style.width = width + '%';
        }
    }
}
function stopPrgs() {
    clearInterval(qrtmr);
}