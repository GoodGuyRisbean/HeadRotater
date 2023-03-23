package io.github.goodguyrisbean.data;

import org.bukkit.scheduler.BukkitTask;

public class HeadRotatorPlayerData {
    private boolean start = false;
    private BukkitTask bukkitTask = null;

    public boolean isStarted() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public BukkitTask getBukkitTask() {
        return bukkitTask;
    }

    public void setBukkitTask(BukkitTask bukkitTask) {
        this.bukkitTask = bukkitTask;
    }
}
