package io.github.goodguyrisbean.listener;

import io.github.goodguyrisbean.repository.HeadRotatorRepository;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class HeadRotatorListener implements Listener {
    private HeadRotatorRepository repository;

    public HeadRotatorListener(HeadRotatorRepository repository) {
        this.repository = repository;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        repository.registerPlayerData(event.getPlayer());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        repository.removePlayerData(event.getPlayer());
    }
}
