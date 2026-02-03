# Real-Time Messaging System Setup Guide

This project implements a complete real-time messaging system using Spring Boot (WebSocket/STOMP) and React.

## Backend Setup (Spring Boot)

1. **Database**: Ensure your database is running. The `chat_messages` table will be automatically created by Hibernate (assuming `ddl-auto: update`).
2. **Dependencies**: The following dependency was added to `pom.xml`:
   ```xml
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-websocket</artifactId>
   </dependency>
   ```
3. **Execution**: Run the Spring Boot application. The WebSocket endpoint is registered at `/ws`.

## Frontend Setup (React)

1. **Install Dependencies**:
   ```bash
   npm install sockjs-client @stomp/stompjs @heroicons/react
   ```
2. **Configuration**: The chat service connects to `http://localhost:8080/ws` by default.
3. **Usage**:
   - Access the chat by clicking "Messages" in the sidebar or navigating to `/chat`.
   - The system automatically detects your identity from `localStorage.getItem('user')`.

## Key Features

- ✅ **Real-Time messaging**: Instant delivery using STOMP protocol.
- ✅ **Private Queues**: Messages are routed to specific users using `/user/{userId}/queue/messages`.
- ✅ **Typing Indicators**: Real-time "Typing..." status updates.
- ✅ **Persistence**: All messages are saved to the database.
- ✅ **Unread Counts**: Automatic tracking of unread messages per conversation.
- ✅ **Search**: Filter conversations by colleague name.
- ✅ **Responsive UI**: Built with Tailwind CSS and Slate/Indigo theme.

## Troubleshooting

- **CORS Errors**: If you encounter CORS issues, ensure `SecurityConfiguration.java` and `WebSocketConfig.java` include your frontend URL (e.g., `http://localhost:5173`).
- **Connection Failures**: Check if the backend is running and the port corresponds to the one in `chatService.js`.
