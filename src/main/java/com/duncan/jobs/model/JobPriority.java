package com.duncan.jobs.model;

public enum JobPriority {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    private final int level;

    JobPriority(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}


