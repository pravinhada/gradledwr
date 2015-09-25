var wsclock = null;
var wsProtocol = (window.location.protocol === "https:" ? "wss" : "ws");
var wstarget = wsProtocol + "://" + window.location.host + "/dwrdemo/clock";
if ("WebSocket" in window) {
	wsclock = new WebSocket(wstarget);
} else if ("MozWebSocket" in window) {
	wsclock = new MozWebSocket(wstarget);
} else {
	alert('WebSocket is not supported by this browser.');
}
wsclock.onopen = function() {
	console.log("WebSocket connection has established!");
	document.getElementById("messageGoesHere").textContent = "Connected to Server clock";
};

wsclock.onmessage = function(event) {
	console.log("WebSocket connection sending message.");
	document.getElementById("messageGoesHere").textContent = event.data;
};

wsclock.onerror = function(event) {
	console.log("WebSocket connection has error!");
	document.getElementById("messageGoesHere").innerHTML = "Error in clock";
};

wsclock.onclose = function() {
	console.log("WebSocket is closed.");
}
