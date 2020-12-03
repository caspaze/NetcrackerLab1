package Repository.Validate;

import Users.User;

public class Message {
    Status status;
    String comment;

    public Message(Status status, String comment) {
        this.status = status;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Message{" +
                "status=" + status +
                ", comment='" + comment + '\'' +
                '}';
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
