function getVideo(){
    let videoStream = document.getElementById('video')

    navigator.getMedia =
        navigator.getUserMedia ||
        navigator.webkitGetUserMedia ||
        navigator.mozGetUserMedia ||
        navigator.msGetUserMedia;
    navigator.getMedia({video: true, audio: false},

        function(stream) {
            try{
                videoStream.srcObject = stream
                videoStream.play();
            } catch {

            }

        },

        function(error) {
            alert('웹캠이 정상작동하지 않습니다 !');
        });
}
  
  