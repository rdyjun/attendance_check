

function buttonhover(){
    document.getElementById("atdc").style.opacity = 0;
    document.getElementById("atdc2").style.opacity = 1;
    document.getElementById("atdc2").style.zIndex = 1;
    document.getElementById("atdc").style.zIndex = 0;
}
function buttonout(){
    document.getElementById("atdc").style.opacity = 1;
    document.getElementById("atdc2").style.opacity = 0;
    document.getElementById("atdc").style.zIndex = 1;
    document.getElementById("atdc2").style.zIndex = 0;
}

