var ws = null;
var wsProtocol = (window.location.protocol === "https:" ? "wss" : "ws");
var target =  wsProtocol + "://" + window.location.host + "/dwrdemo/echo";
if ("WebSocket" in window) {
	ws = new WebSocket(target);
} else if ("MozWebSocket" in window) {
	ws = new MozWebSocket(target);
} else {
	alert('WebSocket is not supported by this browser.');
}

ws.onopen = function() {
	console.log("WebSocket has been opened!");
};

ws.onmessage = function(message) {
	document.getElementById("chatlog").textContent += message.data + "\n";
};

ws.onerror = function() {
	console.log("WebSocket connection has error!");
}

ws.onclose = function() {
	console.log("WebSocket is closed.");
}

function postToServer() {
	ws.send(document.getElementById("msg").value);
	document.getElementById("msg").value = "";
}

function closeConnect() {
	ws.close();
}