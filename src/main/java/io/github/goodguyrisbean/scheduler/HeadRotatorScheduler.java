package io.github.goodguyrisbean.scheduler;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class HeadRotatorScheduler extends BukkitRunnable {
    private Player player;

    public HeadRotatorScheduler(Player player) {
        this.player = player;
    }

    @Override
    public void run() {
        Location location = player.getLocation();
        location.setYaw(player.getLocation().getYaw() + 1F);
        player.teleport(location);
    }
}
