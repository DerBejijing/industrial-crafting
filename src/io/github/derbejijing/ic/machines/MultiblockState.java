package io.github.derbejijing.ic.machines;

public enum MultiblockState {
    IDLE(0),
    RUNNING(1),
    NO_POWER(2),
    BROKEN(3);

    public final int id;

    private MultiblockState(int id) {
        this.id = id;
    }
}