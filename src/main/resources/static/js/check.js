var videoStream = document.getElementById("video");
var storedInterval = 0;

function getVideo(){
    navigator.getMedia = navigator.getUserMedia ||
    navigator.webkitGetUserMedia ||
    navigator.mozGetUserMedia ||
    navigator.msGetUserMedia;

    navigator.getMedia({video: true, audio: false},

    function(stream){
    videoStream.srcObject = stream
    videoStream.play();
    },

    function(error){
    alert("웹캠이 작동하지 않습니다.");
    });
}