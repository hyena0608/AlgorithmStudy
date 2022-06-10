package 프로그래머스.카카오2019.오픈채팅방;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    class Chat {
        String userId;
        String command;

        public Chat(String userId, String command) {
            this.userId = userId;
            this.command = command;
        }
    }

    static Map<String, String> userMap = new HashMap<>();
    static Queue<Chat> chatQ = new LinkedList<>();
    static final String ENTER = "Enter";
    static final String LEAVE = "Leave";
    static final String CHANGE = "Change";

    public String[] solution(String[] record) {

        for (String message : record) {
            String[] context = splitMessage(message);
            String command = context[0];
            String userId = context[1];

            if (command.equals(ENTER)) {
                String username = context[2];
                enter(command, userId, username);
            }

            if (command.equals(LEAVE)) {
                leave(command, userId);
            }

            if (command.equals(CHANGE)) {
                String username = context[2];
                change(command, userId, username);
            }
        }

        return createChatStringArr();
    }

    private String[] splitMessage(String message) {
        return message.split(" ");
    }

    private void enter(String command, String userId, String username) {
        if (userMap.containsKey(userId)) {
            userMap.replace(userId, username);
        } else if (!userMap.containsKey(userId)) {
            userMap.put(userId, username);
        }
        chatQ.offer(new Chat(userId, command));
    }

    private void leave(String command, String userId) {
        chatQ.offer(new Chat(userId, command));
    }

    private void change(String command, String userId, String username) {
        userMap.replace(userId, username);
    }

    private String[] createChatStringArr() {
        String[] answer = new String[chatQ.size()];
        int idx = 0;
        while (!chatQ.isEmpty()) {
            Chat chat = chatQ.poll();

            if (chat.command.equals(ENTER)) {
                answer[idx++] = userMap.get(chat.userId) + "님이 들어왔습니다.";
            }
            if (chat.command.equals(LEAVE)) {
                answer[idx++] = userMap.get(chat.userId) + "님이 나갔습니다.";
            }
        }
        return answer;
    }

}