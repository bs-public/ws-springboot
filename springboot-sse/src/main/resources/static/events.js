let eventSource = null;

function subscribe() {
	eventSource = new EventSource("/sse");

	eventSource.onmessage = (event) => {
		const div = document.createElement("div");
		div.textContent = `Event received: ${event.data}`;
		document.getElementById("events").appendChild(div);
	};

	eventSource.onerror = (error) => {
		console.error("Error occurred:", error);
		eventSource.close();
	};

	toggleButtons();
}

function unsubscribe() {
	if (eventSource) {
		eventSource.close();
		eventSource = null;
	}

	toggleButtons();
}


function toggleButtons() {
	const subscribeButton = document.getElementById("subscribeBtn");
	const unsubscribeButton = document.getElementById("unsubscribeBtn");

	if (subscribeButton.style.display === 'none') {
		subscribeButton.style.display = 'block';
		unsubscribeButton.style.display = 'none';
	} else {
		subscribeButton.style.display = 'none';
		unsubscribeButton.style.display = 'block';
	}
}
