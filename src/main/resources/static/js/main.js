
setTimeout(() => off(), 600);
function on () {
    document.getElementById("touch-hint").style.opacity = 1;
    setTimeout(() => off(), 600);
}

function off () {
    document.getElementById("touch-hint").style.opacity = 0;
    setTimeout(() => on(), 600);
}

