package com.example.java.java8.optional;

import java.util.Optional;

public class OnlineClass {
    private Long id;
    private String title;
    private boolean closed;
    private Progress progress;

    public OnlineClass(Long id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
        progress = new Progress();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isClosed() {
        return closed;
    }

    public Optional<Progress> getProgress() {
        return Optional.ofNullable(progress);
    }
}
