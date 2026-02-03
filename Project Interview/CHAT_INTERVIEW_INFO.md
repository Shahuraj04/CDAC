# Interview Explanation: Real-Time Messaging Architecture

## 1. How does the real-time functionality work?
We use the **STOMP (Simple Text Oriented Messaging Protocol)** over **WebSockets**. WebSockets provide a full-duplex communication channel over a single TCP connection, allowing the server to push messages to the client without the client having to poll.

## 2. Why use STOMP instead of raw WebSockets?
STOMP provides a messaging layer on top of raw WebSockets. It defines a set of frames (CONNECT, SEND, SUBSCRIBE, MESSAGE) that makes it easier to:
- Route messages to specific destinations.
- Handle user-specific "private" queues.
- Manage subscriptions and message filtering.

## 3. How is message privacy ensured?
We use the **User Destination** feature in Spring. When a user subscribes to `/user/queue/messages`, Spring internally maps this to a unique queue for that specific authenticated session. Only the intended recipient can receive messages sent to their private queue.

## 4. How does the Typing Indicator work?
When a user types, we send a lightweight payload containing `{ isTyping: true }` via the `/app/chat.typing` endpoint. The server then forwards this to the recipient's private `/user/{id}/queue/typing` destination. We use a 3-second debounce on the frontend to automatically send `{ isTyping: false }` when the user stops typing.

## 5. How are messages persisted?
Messages are intercepted by the `@MessageMapping` controller, saved to the database using JPA before being dispatched to the messaging template. This ensures that history can be reloaded even after a page refresh or reconnection.

## 6. What happens if the connection drops?
The STOMP client is configured with a `reconnectDelay`. If the connection is lost, it will automatically attempt to reconnect. Upon reconnection, the client re-subscribes to its queues, ensuring a seamless experience.

## 7. Performance Considerations
- **Broker**: Currently using an In-Memory Simple Broker. For production scalability, we can easily swap this with a dedicated message broker like **RabbitMQ** or **ActiveMQ**.
- **Indexing**: Database columns like `sender_id`, `recipient_id`, and `timestamp` are indexed to ensure fast retrieval of conversation history.
- **Payloads**: DTOs are used to transfer only necessary data, keeping the frame size small.
- **Lazy Loading**: (Future refinement) Message history can be paginated to avoid loading thousands of messages at once.
