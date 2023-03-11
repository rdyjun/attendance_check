function ck (dt) {

    fetch("http://localhost:8080/checksuccess", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            stdId : JSON.parse(dt).num,
            name : JSON.parse(dt).name
        })
    }).catch((error) => console.log(error))
        .then((response) => console.log(response));


        // .then((response) => console.log(JSON.stringify(response)));
    fetch("http://localhost:8080/result" + new URLSearchParams({
        resultTitle: "잘못된 QR코드",
        resultHeader: "QR코드가 올바르지 않습니다 !",
    }))
}
function printErr () {
    location.href="http://localhost:8080/result" + "?" +  new URLSearchParams({
        resultTitle: "잘못된 QR코드",
        resultHeader: "QR코드가 올바르지 않습니다 !"
    });
    setTimeout(location.href="http://localhost:8080/", 1000);
}

document.addEventListener("DOMContentLoaded", function() {
    var video = document.createElement("video");
    var canvasElement = document.getElementById("canvas");
    var canvas = canvasElement.getContext("2d");
    var outMessage = document.getElementById("outMessage");

    function drawLine(begin, end, color) {
        canvas.beginPath();
        canvas.moveTo(begin.x, begin.y);
        canvas.lineTo(end.x, end.y);
        canvas.lineWidth = 4;
        canvas.strokeStyle = color;
        canvas.stroke();
    }

    // 카메라 사용시
    navigator.mediaDevices.getUserMedia({ video: { facingMode: "environment" } }).then(function(stream) {

        video.srcObject = stream;
        video.setAttribute("playsinline", true);      // iOS 사용시 전체 화면을 사용하지 않음을 전달
        video.play();
        requestAnimationFrame(tick);

    });



    function tick() {
        outMessage.innerHTML = "QR코드 스캔 준비중...";
        if(video.readyState === video.HAVE_ENOUGH_DATA) {
            canvasElement.hidden = false;

            // 읽어들이는 비디오 화면의 크기
            canvasElement.height = video.videoHeight;
            canvasElement.width = video.videoWidth;

            canvas.drawImage(video, 0, 0, canvasElement.width, canvasElement.height);

            var imageData = canvas.getImageData(0, 0, canvasElement.width, canvasElement.height);
            var code = jsQR(imageData.data, imageData.width, imageData.height, {

                inversionAttempts : "dontInvert",

            });
            // QR코드 인식에 성공한 경우

            if(code) {
                // 인식한 QR코드의 영역을 감싸는 사용자에게 보여지는 테두리 생성
                drawLine(code.location.topLeftCorner, code.location.topRightCorner, "#FF0000");
                drawLine(code.location.topRightCorner, code.location.bottomRightCorner, "#FF0000");
                drawLine(code.location.bottomRightCorner, code.location.bottomLeftCorner, "#FF0000");
                drawLine(code.location.bottomLeftCorner, code.location.topLeftCorner, "#FF0000");

                try {
                    codeDataJson = JSON.parse(code.data);
                } catch (e) {
                    printErr();
                    return;
                }

                if(codeDataJson.name == "" && codeDataJson.num == ""){
                    printErr();
                    return;
                }
                // outMessage.innerHTML = code.data;
                ck(code.data);
                // return을 써서 함수를 빠져나가면 QR코드 프로그램이 종료된다.
                // return;
                return;
            }
            else {
                outMessage.innerHTML = "QR코드 인식 중....";

            }
        }
        requestAnimationFrame(tick);

    }

});

